package iitc.asm;

/**
 * Analyser
 *
 * @author Ian
 * @version 1.0
 */
public interface Analyser {
    public void onStart();

    public void onFinish();

    public boolean perform();

    public long getTime();
}
