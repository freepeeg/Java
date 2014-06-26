package iitc.asm;

/**
 * RootNode
 * <p/>
 * A BranchNode that does not take ownership of it's children.
 *
 * @author Ian
 * @version 1.0
 */
public class RootNode extends BranchNode {
    public RootNode() {
    }

    @Override
    public boolean adopt(BranchNode node) {
        return children.add(node);
    }

    @Override
    public void setParent(BranchNode node) {
    }
}
