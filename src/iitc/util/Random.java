package iitc.util;

/**
 * Random
 *
 * @author Ian
 * @version 1.0
 */
public class Random extends java.util.Random {
    private static Random ourInstance = new Random();

    private Random() {
    }

    public static Random getInstance() {
        return ourInstance;
    }

    public static int nextInt(int min, int max) {
        return min + (max == min ? 0 : getInstance().nextInt(max < min ? min - max : max - min));
    }

    public static double nextDouble(final double min, final double max) {
        return min + getInstance().nextDouble() * (max - min);
    }

    public static int nextGaussian(final int min, final int max, final int sd) {
        return nextGaussian(min, max, min + (max - min) / 2, sd);
    }

    public static int nextGaussian(final int min, final int max, final int mean, final int sd) {
        if (min == max)
            return min;
        int rand;
        do
            rand = (int) (getInstance().nextGaussian() * sd + mean);
        while (rand < min || rand >= max);
        return rand;
    }
}
