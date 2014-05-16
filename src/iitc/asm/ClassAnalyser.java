package iitc.asm;

import iitc.asm.Analyser;
import iitc.asm.InjectingClassLoader;
import org.objectweb.asm.tree.ClassNode;

/**
 * ClassAnalyser
 *
 * @author Ian
 * @version 1.0
 */
public abstract class ClassAnalyser implements Analyser {
    protected final InjectingClassLoader loader;
    private long time;

    public ClassAnalyser(InjectingClassLoader loader) {
        this.loader = loader;
    }

    public abstract boolean analyse(ClassNode node);

    public void onStart() {
        time = System.nanoTime();
    }

    public void onFinish() {
        time = System.nanoTime() - time;
    }

    public long getTime() {
        return time;
    }

    @Override
    public boolean perform() {
        boolean failed = false;
        for (ClassNode node : loader.getNodes().values())
            if (!analyse(node))
                failed = true;

        return !failed;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
}
