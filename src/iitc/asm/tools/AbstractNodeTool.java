package iitc.asm.tools;

import iitc.asm.BranchNode;
import iitc.asm.loader.InjectorTreeLoader;
import iitc.im.ListOperations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * AbstractNodeTool
 *
 * @author Ian
 * @version 1.0
 */
public abstract class AbstractNodeTool implements NodeTool {
    private final List<NodeTool> children;
    protected boolean passed = true;
    protected final InjectorTreeLoader loader;
    private BranchNode current;

    public AbstractNodeTool(InjectorTreeLoader loader) {
        this.loader = loader;
        this.children = new ArrayList<>();
    }

    public boolean add(NodeTool... tools) {
        return Collections.addAll(this.children, tools);
    }

    public boolean remove(NodeTool... tools) {
        return ListOperations.removeAll(this.children, tools);
    }

    @Override
    public boolean work(BranchNode node) {
        for (NodeTool tool : children) {
            tool.setCurrent(current());
            if (!tool.condition(node) || !tool.work(node))
                tool.setPassed(false);
        }
        return true;
    }

    @Override
    public List<NodeTool> getChildren() {
        return children;
    }

    @Override
    public boolean passed() {
        return passed;
    }

    @Override
    public void setPassed(boolean passed) {
        this.passed = passed;
        setCurrent(null);
    }

    @Override
    public BranchNode current() {
        return current;
    }

    @Override
    public void setCurrent(BranchNode node) {
        this.current = node;
    }

}
