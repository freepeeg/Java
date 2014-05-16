package iitc.util;

/**
 * Timer
 *
 * @author Ian
 * @version 1.0
 */
public class Timer {
    private long start;
    private long period;
    private long end;

    public Timer(long period) {
        this.period = period;
        init();
    }

    private void init() {
        end = (start = System.currentTimeMillis()) + period;
    }

    public long getElapsed() {
        return System.currentTimeMillis() - start;
    }

    public long getRemaining() {
        return isRunning() ? end - System.currentTimeMillis() : 0;
    }

    public boolean isRunning() {
        return System.currentTimeMillis() < end;
    }

    public void reset() {
        init();
    }

    public void setEndIn(long remaining) {
        end = System.currentTimeMillis() + remaining;
    }

    @Override
    public String toString() {
        return Time.format(getElapsed());
    }

    public String toRemainingString() {
        return Time.format(getRemaining());
    }
}