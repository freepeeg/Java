package iitc.asm;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.tree.ClassNode;

import java.security.AllPermission;
import java.security.CodeSource;
import java.security.Permissions;
import java.security.ProtectionDomain;
import java.security.cert.Certificate;
import java.util.HashMap;
import java.util.Map;

/**
 * ASMClassLoader
 *
 * @author Ian
 * @version 1.0
 */
public class ASMClassLoader extends ClassLoader {
    protected final HashMap<String, ClassNode> nodes;
    protected final HashMap<String, Class<?>> classes;
    private final ProtectionDomain domain;
    private final Permissions permissions;

    public ASMClassLoader(ClassNode... nodes) {
        this.nodes = new HashMap<>(nodes.length);
        this.classes = new HashMap<>();
        Permissions permissions = new Permissions();
        permissions.add(new AllPermission());
        this.permissions = permissions;
        domain = new ProtectionDomain(new CodeSource(null, (Certificate[]) null), this.permissions);
    }

    public Map<String, ClassNode> getNodes() {
        return nodes;
    }

    public Map<String, Class<?>> getClasses() {
        return classes;
    }

    protected boolean validate(ClassNode node) {
        return validate(node.name);
    }

    protected boolean validate(String name) {
        return name.endsWith(".class");
    }

    protected ClassNode add(ClassNode node) {
        return nodes.put(node.name, node);
    }

    protected ClassNode remove(ClassNode node) {
        return nodes.remove(node.name);
    }

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        return findClass(name);
    }

    @Override
    public Class<?> findClass(String name) throws ClassNotFoundException {
        try {
            return getSystemClassLoader().loadClass(name);
        } catch (Exception e) {
            String key = name.replace('.', '/');
            if (classes.containsKey(key))
                return classes.get(key);
            else if (nodes.containsKey(key)) {
                ClassNode node = nodes.get(key);
                if (node != null) {
                    Class<?> c = nodeToClass(node);
                    classes.put(key, c);
                    return c;
                }
            }
            return null;
        }
    }

    protected byte[] nodeToBytes(ClassNode node) {
        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_MAXS);
        node.accept(cw);
        return cw.toByteArray();
    }

    public Class<?> nodeToClass(ClassNode node) {
        byte[] b = nodeToBytes(node);
        return defineClass(node.name.replace('/', '.'), b, 0, b.length,
                getDomain());
    }

    protected ProtectionDomain getDomain() {
        return domain;
    }

    protected Permissions getPermissions() {
        return permissions;
    }
}
