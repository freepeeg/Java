package iitc.asm.loader;

import iitc.asm.BranchNode;
import iitc.asm.Tree;
import org.objectweb.asm.ClassWriter;

import java.security.AllPermission;
import java.security.CodeSource;
import java.security.Permissions;
import java.security.ProtectionDomain;
import java.security.cert.Certificate;
import java.util.HashMap;
import java.util.Map;

/**
 * TreeLoader
 *
 * @author Ian
 * @version 1.0
 */
public class TreeLoader extends ClassLoader {
    private final Tree tree;
    private final Map<String, Class<?>> loaded;
    private final ProtectionDomain domain;
    private final Permissions permissions;

    public TreeLoader(Tree tree) {
        this.tree = tree;
        this.loaded = new HashMap<>();
        Permissions permissions = new Permissions();
        permissions.add(new AllPermission());
        this.permissions = permissions;
        domain = new ProtectionDomain(new CodeSource(null, (Certificate[]) null), this.permissions);
    }

    protected byte[] nodeToBytes(BranchNode node) {
        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_MAXS);
        node.accept(cw);
        return cw.toByteArray();
    }

    protected Class<?> nodeToClass(BranchNode node) {
        byte[] b = nodeToBytes(node);
        return defineClass(node.name.replace('/', '.'), b, 0, b.length,
                getDomain());
    }

    public Tree getTree() {
        return tree;
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
            if (loaded.containsKey(key)) {
                return loaded.get(key);
            }
            else {
                BranchNode node = tree.get(key);
                if (node != null) {
                    Class<?> c = nodeToClass(node);
                    loaded.put(key, c);
                    return c;
                }
            }
            return null;
        }
    }

    protected ProtectionDomain getDomain() {
        return domain;
    }

    protected Permissions getPermissions() {
        return permissions;
    }
}
