package iitc.asm;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.tree.ClassNode;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.JarURLConnection;
import java.net.URL;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * JarClassLoader
 *
 * @author Ian
 * @version 1.0
 */
public class JarClassLoader extends ASMClassLoader {
    public JarClassLoader(String url) throws IOException {
        this(new URL("jar:" + url + "!/"));
    }

    public JarClassLoader(URL url) throws IOException {
        this(((JarURLConnection) url.openConnection()).getJarFile());
    }

    public JarClassLoader(File file) throws IOException {
        this(new JarFile(file));
    }

    public JarClassLoader(JarFile file) throws IOException {
        super();
        Enumeration<JarEntry> entries = file.entries();
        JarEntry entry;
        while (entries.hasMoreElements() && (entry = entries.nextElement()) != null)
            if (isClassFile(entry))
                add(getNode(file, entry));
    }

    protected boolean isClassFile(JarEntry entry) {
        return validate(entry.getName());
    }

    protected ClassNode getNode(JarFile file, JarEntry entry) throws IOException {
        return getNode(file, entry, ClassReader.SKIP_DEBUG);
    }

    protected ClassNode getNode(JarFile file, JarEntry entry, int flags) throws IOException {
        return getNode(file.getInputStream(entry), flags);
    }

    protected ClassNode getNode(InputStream stream) throws IOException {
        return getNode(stream, ClassReader.SKIP_DEBUG);
    }

    protected ClassNode getNode(byte[] bytes) throws IOException {
        final ClassReader cr = new ClassReader(bytes);
        final ClassNode cn = new ClassNode();
        cr.accept(cn, ClassReader.SKIP_DEBUG);
        return cn;
    }

    protected ClassNode getNode(InputStream stream, int flags) throws IOException {
        final ClassReader cr = new ClassReader(stream);
        final ClassNode cn = new ClassNode();
        cr.accept(cn, flags);
        return cn;
    }
}
