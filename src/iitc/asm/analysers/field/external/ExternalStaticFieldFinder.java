package iitc.asm.analysers.field.external;

import iitc.asm.InjectingClassLoader;
import iitc.asm.analysers.field.FieldFinder;
import iitc.asm.NodeInjector;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.FieldNode;

/**
 * ExternalStaticFieldFinder
 *
 * @author Ian
 * @version 1.0
 */
public abstract class ExternalStaticFieldFinder extends FieldFinder implements ExternalFieldFinder {
    protected ClassNode parent;

    protected ExternalStaticFieldFinder(InjectingClassLoader loader, String name) {
        super(loader, name);
    }

    protected abstract ClassNode parent();

    public ClassNode getParent() {
        if (parent == null)
            parent = parent();
        return parent;
    }

    @Override
    protected void onFind(ClassNode node, FieldNode field) {
        ClassNode parent = getParent();
        Object multi = multi(node, field);
        NodeInjector.addStaticFieldAccessor(parent, node, descriptor(), field, name(), multi);
        loader.storeMethod(parent.name, node.name, name(), field.name, multi);
    }
}
