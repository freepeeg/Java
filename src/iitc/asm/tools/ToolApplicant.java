package iitc.asm.tools;

import iitc.asm.BranchNode;
import iitc.asm.loader.InjectorTreeLoader;

import java.util.Arrays;
import java.util.List;

/**
 * Toolbox
 *
 * @author Ian
 * @version 1.0
 */
public class ToolApplicant<T extends InjectorTreeLoader> implements Tool<T> {
    private final List<NodeTool> tools;

    public ToolApplicant(NodeTool... tools) {
        this(Arrays.asList(tools));
    }

    public ToolApplicant(List<NodeTool> tools) {
        this.tools = tools;
    }

    @Override
    public boolean work(T user) {
        for (NodeTool tool : tools) {
            BranchNode node = user.getTree().get(tool);
            if (node != null) {
                tool.setCurrent(node);
                node.setModifications(tool);
                node.inject();
            } else {
                tool.setPassed(false);
            }
        }
        return true;
    }
}
