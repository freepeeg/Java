package iitc.asm.analysers.field.internal;

import iitc.asm.InjectingClassLoader;
import iitc.asm.analysers.field.FieldFinder;
import iitc.asm.NodeInjector;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.FieldNode;

/**
 * InternalStaticFieldFinder
 *
 * @author Ian
 * @version 1.0
 */
public abstract class InternalStaticFieldFinder extends FieldFinder {
    protected InternalStaticFieldFinder(InjectingClassLoader loader, String name) {
        super(loader, name);
    }

    @Override
    protected void onFind(ClassNode node, FieldNode field) {
        Object multi = multi(node, field);
        NodeInjector.addStaticFieldAccessor(node, node, descriptor(), field, name(), multi);
        loader.storeMethod(node.name, name(), field.name, multi);
    }
}
