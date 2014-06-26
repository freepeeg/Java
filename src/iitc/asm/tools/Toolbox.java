package iitc.asm.tools;

import iitc.asm.BranchNode;
import iitc.asm.loader.InjectorTreeLoader;

import java.util.List;

/**
 * Toolbox
 *
 * @author Ian
 * @version 1.0
 */
public class Toolbox<T extends InjectorTreeLoader> implements Tool<T> {
    private final List<NodeTool> tools;

    public Toolbox(List<NodeTool> tools) {
        this.tools = tools;
    }

    @Override
    public boolean work(T user) {
        boolean passed = true;
        for (NodeTool tool : tools) {
            BranchNode node = user.getTree().get(tool);
            if (node != null) {
                if (tool.work(node))
                    tool.onLeave(node);
                else {
                    tool.onFailure(node);
                    passed = false;
                }
            }
        }
        return passed;
    }
}
