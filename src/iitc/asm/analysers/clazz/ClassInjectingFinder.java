package iitc.asm.analysers.clazz;

import iitc.asm.ClassUtils;
import iitc.asm.InjectingClassLoader;
import iitc.asm.NodeInjector;
import org.objectweb.asm.tree.ClassNode;

/**
 * ClassInjectingFinder
 *
 * @author Ian
 * @version 1.0
 */
public abstract class ClassInjectingFinder extends ClassFinder {

    public ClassInjectingFinder(InjectingClassLoader loader, Class<?> iface) {
        super(loader, ClassUtils.getPathTo(iface));
    }

    @Override
    protected void onFind(ClassNode node) {
        NodeInjector.injectInterface(node, name());
        loader.storeHook(name(), node);
    }
}
