package iitc.asm.analysers.clazz;

import iitc.asm.InjectingClassLoader;
import iitc.asm.analysers.Analyser;
import iitc.asm.analysers.field.FieldFinder;
import org.objectweb.asm.tree.ClassNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * ClassFinder
 *
 * @author Ian
 * @version 1.0
 */
public abstract class ClassFinder extends Analyser {
    private List<FieldFinder> fields;
    private long fieldTime;
    private ClassNode target;
    private List<FieldFinder> failed;

    protected ClassFinder(InjectingClassLoader loader, String name) {
        super(loader, name);
        this.fields = new ArrayList<>();
        this.failed = new ArrayList<>();
    }

    public boolean add(FieldFinder... finders) {
        return Collections.addAll(fields, finders);
    }

    protected abstract ClassNode find();

    protected abstract void onFind(ClassNode node);

    public long getFieldTime() {
        return fieldTime;
    }

    public int fieldCount() {
        return fields.size();
    }

    public List<FieldFinder> getFailed() {
        return failed;
    }

    public boolean locateFields() {
        if (fieldTime > 0 || target == null)
            return false;
        boolean passed = true;
        for (FieldFinder finder : fields) {
            finder.onStart();
            if (!finder.locate(target)) {
                passed = false;
                failed.add(finder);
            }
            finder.onFinish();
            fieldTime += finder.getTime();
        }
        return passed;
    }

    public boolean locate() {
        if (target != null)
            return false;
        ClassNode node = find();
        if (node != null) {
            onFind(node);
            target = node;
            return true;
        }
        return false;
    }
}
