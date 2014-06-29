package iitc.asm.tools;

import iitc.asm.BranchNode;
import iitc.im.Precondition;

import java.util.List;

/**
 * NodeTool
 *
 * @author Ian
 * @version 1.0
 */
public interface NodeTool extends Precondition<BranchNode>, Tool<BranchNode> {
    public String logString(BranchNode node);

    public String failureString(BranchNode node);

    public List<NodeTool> getChildren();

    public boolean passed();

    public void setPassed(boolean passed);

    public BranchNode current();

    public void setCurrent(BranchNode node);

}
