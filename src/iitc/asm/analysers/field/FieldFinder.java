package iitc.asm.analysers.field;

import iitc.asm.InjectingClassLoader;
import iitc.asm.analysers.Analyser;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.FieldNode;

/**
 * FieldFinder
 *
 * @author Ian
 * @version 1.0
 */
public abstract class FieldFinder extends Analyser {
    protected FieldFinder(InjectingClassLoader loader, String name) {
        super(loader, name);
    }

    protected abstract String descriptor();

    protected abstract FieldNode find(ClassNode node);

    protected abstract void onFind(ClassNode node, FieldNode field);

    protected Object multi(ClassNode node, FieldNode field) {
        return null;
    }

    public boolean locate(ClassNode node) {
        FieldNode field = find(node);
        if (field != null) {
            onFind(node, field);
            return true;
        }
        return false;
    }
}
