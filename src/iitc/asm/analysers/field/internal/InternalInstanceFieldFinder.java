package iitc.asm.analysers.field.internal;

import iitc.asm.InjectingClassLoader;
import iitc.asm.analysers.field.FieldFinder;
import iitc.asm.NodeInjector;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.FieldNode;

/**
 * InternalInstanceFieldFinder
 *
 * @author Ian
 * @version 1.0
 */
public abstract class InternalInstanceFieldFinder extends FieldFinder {
    public InternalInstanceFieldFinder(InjectingClassLoader loader, String name) {
        super(loader, name);
    }

    @Override
    public void onFind(ClassNode node, FieldNode field) {
        Object multi = multi(node, field);
        NodeInjector.addGetter(node, field, descriptor(), name(), multi);
        loader.storeMethod(node.name, name(), field.name, multi);
    }
}
