package iitc.asm.tools;

import iitc.asm.BranchNode;

import java.util.Arrays;
import java.util.List;

/**
 * AbstractNodeTool
 *
 * @author Ian
 * @version 1.0
 */
public abstract class AbstractNodeTool implements NodeTool {
    private final List<NodeTool> children;

    public AbstractNodeTool(NodeTool... children) {
        this(Arrays.asList(children));
    }

    public AbstractNodeTool(List<NodeTool> children) {
        this.children = children;
    }

    protected abstract String logString(BranchNode node);

    protected abstract String failureString(BranchNode node);

    @Override
    public boolean work(BranchNode node) {
        boolean passed = true;
        for (NodeTool tool : children)
            if (tool.condition(node)) {
                if (tool.work(node))
                    tool.onLeave(node);
            } else {
                tool.onFailure(node);
                passed = false;
            }
        return passed;
    }

    @Override
    public void onFailure(BranchNode node) {
        System.out.println(failureString(node));
    }

    @Override
    public void onLeave(BranchNode node) {
        System.out.println(logString(node));
    }
}
