package iitc.asm.analysers.field.external;

import iitc.asm.InjectingClassLoader;
import iitc.asm.analysers.field.FieldFinder;
import iitc.asm.NodeInjector;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.FieldNode;

/**
 * ExternalInstanceFieldFinder
 *
 * @author Ian
 * @version 1.0
 */
public abstract class ExternalInstanceFieldFinder extends FieldFinder implements ExternalFieldFinder {
    protected ClassNode parent;

    protected ExternalInstanceFieldFinder(InjectingClassLoader loader, String name) {
        super(loader, name);
    }

    protected abstract ClassNode parent();

    public ClassNode getParent() {
        if (parent == null)
            parent = parent();
        return parent;
    }

    @Override
    public void onFind(ClassNode node, FieldNode field) {
        ClassNode parent = getParent();
        Object multi = multi(node, field);
        NodeInjector.addGetter(parent, field, descriptor(), name(), multi);
        loader.storeMethod(parent.name, name(), field.name, multi);
    }
}
