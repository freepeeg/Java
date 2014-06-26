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
    private boolean passed = true;

    public AbstractNodeTool(NodeTool... children) {
        this(Arrays.asList(children));
    }

    public AbstractNodeTool(List<NodeTool> children) {
        this.children = children;
    }

    @Override
    public boolean work(BranchNode node) {
        this.passed = true;
        for (NodeTool tool : children)
            if (!tool.condition(node) || !tool.work(node))
                passed = false;
        return passed;
    }

    @Override
    public List<NodeTool> getChildren() {
        return children;
    }

    @Override
    public boolean passed() {
        return passed;
    }
}
