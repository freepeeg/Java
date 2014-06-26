package iitc.asm.tools;

import iitc.asm.BranchNode;
import iitc.im.Precondition;

/**
 * NodeTool
 *
 * @author Ian
 * @version 1.0
 */
public interface NodeTool extends Precondition<BranchNode>, Tool<BranchNode> {
    public void onLeave(BranchNode node);

    public void onFailure(BranchNode node);
}
