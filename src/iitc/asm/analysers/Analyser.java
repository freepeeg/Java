package iitc.asm.analysers;

import iitc.asm.InjectingClassLoader;

/**
 * Analyser
 *
 * @author Ian
 * @version 1.0
 */
public class Analyser {
    private final String name;
    protected InjectingClassLoader loader;
    private long time;

    protected Analyser(InjectingClassLoader loader, String name) {
        this.loader = loader;
        this.name = name;
    }

    public String name() {
        return name;
    }

    public void onStart() {
        time = System.nanoTime();
    }

    public void onFinish() {
        time = System.nanoTime() - time;
    }

    public final long getTime() {
        return time;
    }

    @Override
    public String toString() {
        return name;
    }
}
