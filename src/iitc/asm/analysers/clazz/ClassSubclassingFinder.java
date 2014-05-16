package iitc.asm.analysers.clazz;

import iitc.asm.ClassUtils;
import iitc.asm.InjectingClassLoader;
import iitc.asm.NodeInjector;
import org.objectweb.asm.tree.ClassNode;

/**
 * ClassSubclassingFinder
 *
 * @author Ian
 * @version 1.0
 */
public abstract class ClassSubclassingFinder extends ClassFinder {

    public ClassSubclassingFinder(InjectingClassLoader loader, Class<?> iface) {
        super(loader, ClassUtils.getPathTo(iface));
    }

    @Override
    protected void onFind(ClassNode node) {
        NodeInjector.setSuper(node, name());
    }
}
