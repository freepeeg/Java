package iitc.asm.analysers.clazz;

import iitc.asm.InjectingClassLoader;
import org.objectweb.asm.tree.ClassNode;

/**
 * PassiveClassFinder
 *
 * @author Ian
 * @version 1.0
 */
public abstract class PassiveClassFinder extends ClassFinder {
    protected PassiveClassFinder(InjectingClassLoader loader) {
        super(loader, "N/A");
    }

    @Override
    protected void onFind(ClassNode node) {
    }
}
