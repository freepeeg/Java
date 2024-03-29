package iitc.asm;

import iitc.im.Precondition;
import org.objectweb.asm.ClassReader;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * Tree
 *
 * @author Ian
 * @version 1.0
 */
public class Tree implements Iterable<BranchNode> {
    private BranchNode root;

    public Tree(JarFile file) throws IOException {
        this(collect(file));
    }

    public Tree(BranchNode... nodes) {
        this(conform(nodes));
    }

    public Tree(Map<String, BranchNode> nodes) {
        interconnect(nodes);
        this.root = new RootNode();
        if (nodes == null || nodes.size() == 0)
            return;
        for (BranchNode branch : nodes.values())
            if (!branch.hasParent() || nodes.get(branch.superName) == null)
                addToBase(branch);
    }

    public void organize() {
        root.organize();
    }

    public int size() {
        return root.size();
    }

    public boolean addToBase(BranchNode node) {
        return root.adopt(node);
    }

    public boolean add(BranchNode node) {
        return adopt(root, node);
    }

    private boolean adopt(BranchNode parent, BranchNode node) {
        if (parent == null || node.getParent() == null)
            return false;
        if (node.superName.equals(parent.name)) {
            return parent.adopt(node);
        } else {
            return adopt(parent.getChildren(), node);
        }
    }

    private boolean adopt(List<BranchNode> parents, BranchNode node) {
        if (parents == null || parents.isEmpty())
            return false;
        for (BranchNode parent : parents)
            if (adopt(parent, node))
                return true;
        return false;
    }

    public BranchNode get(final String name) {
        return get(new Precondition<BranchNode>() {
            @Override
            public boolean condition(BranchNode branchNode) {
                return branchNode != null && branchNode.name != null && branchNode.name.equals(name);
            }
        });
    }

    public BranchNode get(Precondition<BranchNode> precondition) {
        for (BranchNode node : this)
            if (precondition.condition(node))
                return node;
        return null;
    }

    @Override
    public String toString() {
        return "Tree [" + (root == null ? "empty" : root) + "]";
    }

    private static Map<String, BranchNode> conform(BranchNode... nodes) {
        Map<String, BranchNode> mapping = new HashMap<>();
        if (nodes == null || nodes.length == 0)
            return mapping;
        for (BranchNode node : nodes)
            if (node != null) mapping.put(node.name, node);
        return mapping;
    }

    private static void interconnect(Map<String, BranchNode> collection) {
        boolean adoptedAny = false;
        for (Map.Entry<String, BranchNode> stringBranchNodeEntry : collection.entrySet()) {
            BranchNode node = stringBranchNodeEntry.getValue();
            BranchNode parent = collection.get(node.superName);
            if (parent != null && parent.adopt(node)) {
                adoptedAny = true;
            }
        }
        if (adoptedAny)
            interconnect(collection);
    }

    private static Tree generate(Tree tree, Map<String, BranchNode> collection) {
        if (collection == null || collection.size() == 0)
            return tree;
        for (BranchNode branch : collection.values()) {
            if (!branch.hasParent() || collection.get(branch.superName) == null)
                tree.addToBase(branch);
        }
        return tree;
    }

    protected static Map<String, BranchNode> collect(JarFile file) throws IOException {
        Map<String, BranchNode> nodes = new HashMap<>();
        Enumeration<JarEntry> entries = file.entries();
        JarEntry entry;
        while (entries.hasMoreElements() && (entry = entries.nextElement()) != null)
            if (entry.getName().endsWith(".class")) {
                BranchNode node = createNode(file, entry);
                nodes.put(node.name, node);
            }
        return nodes;
    }

    protected static BranchNode createNode(JarFile file, JarEntry entry) throws IOException {
        return createNode(file, entry, ClassReader.SKIP_DEBUG);
    }

    protected static BranchNode createNode(JarFile file, JarEntry entry, int flags) throws IOException {
        return createNode(file.getInputStream(entry), flags);
    }

    protected static BranchNode createNode(InputStream stream) throws IOException {
        return createNode(stream, ClassReader.SKIP_DEBUG);
    }

    protected static BranchNode createNode(byte[] bytes) throws IOException {
        final ClassReader cr = new ClassReader(bytes);
        final BranchNode cn = new BranchNode();
        cr.accept(cn, ClassReader.SKIP_DEBUG);
        return cn;
    }

    protected static BranchNode createNode(InputStream stream, int flags) throws IOException {
        final ClassReader cr = new ClassReader(stream);
        final BranchNode cn = new BranchNode();
        cr.accept(cn, flags);
        return cn;
    }

    /**
     * Returns an iterator over a set of elements of type T.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<BranchNode> iterator() {
        final Deque<BranchNode> nodes = new ArrayDeque<>();
        for (BranchNode node : root.children)
            nodes.push(node);
        return new Iterator<BranchNode>() {
            @Override
            public boolean hasNext() {
                return !nodes.isEmpty();
            }

            @Override
            public BranchNode next() {
                BranchNode node = nodes.pop();
                for (BranchNode child : node.children)
                    nodes.push(child);
                return node;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }
}
