package iitc.asm;

import org.objectweb.asm.tree.ClassNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * BranchNode
 *
 * @author Ian
 * @version 1.0
 */
public class BranchNode extends ClassNode {
    protected final List<BranchNode> children;
    private BranchNode parent;

    public BranchNode() {
        this.children = new ArrayList<>();
    }

    public BranchNode(int api) {
        super(api);
        this.children = new ArrayList<>();
    }

    public void setParent(BranchNode node) {
        if (node == this)
            return;
        this.parent = node;
    }

    protected List<BranchNode> getChildren() {
        return children;
    }

    public BranchNode getParent() {
        return parent;
    }

    public boolean adopt(BranchNode node) {
        if (node == this || equals(node.parent))
            return false;
        if (children.add(node)) {
            node.setParent(this);
            return true;
        }
        return false;
    }

    public boolean release(BranchNode node) {
        if (node == this)
            return false;
        if (children.remove(node)) {
            node.setParent(null);
            return true;
        }
        return false;
    }

    public int size() {
        return size(true);
    }

    public void organize() {
        Collections.sort(children, new Comparator<BranchNode>() {
            @Override
            public int compare(BranchNode o1, BranchNode o2) {
                return o1.name.compareTo(o2.name);
            }
        });
        for (BranchNode child : children)
            child.organize();
    }

    public int size(boolean includeChildren) {
        if (!includeChildren)
            return children.size();
        int count = 0;
        for (BranchNode node : children)
            count += 1 + node.size(true);
        return count;
    }

    public boolean hasParent() {
        return parent != null;
    }

    public boolean isParent() {
        return children.isEmpty();
    }

    private String toString(int indent) {
        StringBuilder builder = new StringBuilder("");
        for (int i = 0; i < indent; i++)
            builder.append('\t');
        builder.append(String.format("BranchNode[name=\"%s\", super=\"%s\", parent=\"%s\"]", name, superName, parent == null ? null : parent.name)).append('\n');
        for (BranchNode child : children)
            builder.append(child.toString(indent + 1));
        return builder.toString();
    }

    @Override
    public String toString() {
        return toString(0);
    }
}
