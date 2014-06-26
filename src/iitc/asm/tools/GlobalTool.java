package iitc.asm.tools;

import iitc.asm.BranchNode;
import iitc.asm.Tree;
import iitc.asm.loader.InjectorTreeLoader;

/**
 * GlobalTool
 *
 * @author Ian
 * @version 1.0
 */
public abstract class GlobalTool<T extends InjectorTreeLoader> implements Tool<T> {

    @Override
    public boolean work(T user) {
        boolean passed = true;
        final Tree tree = user.getTree();
        for (BranchNode node : tree)
            if (!work(tree, node))
                passed = false;
        return passed;
    }

    public abstract boolean work(Tree tree, BranchNode node);
}
