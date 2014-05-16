package iitc.awt;

import java.awt.*;

/**
 * Colors
 *
 * @author Ian
 * @version 1.0
 */

public class Colors {
    private static final double FACTOR = 0.7;

    public static Color decode(int r, int g, int b) {
        float[] hsb = new float[3];
        Color.RGBtoHSB(r, g, b, hsb);
        return Color.getHSBColor(hsb[0], hsb[1], hsb[2]);
    }

    public static Color grayscale(int r, int g, int b) {
        int avg = (r + g + b) / 3;
        return new Color(avg, avg, avg);
    }

    public static Color brighter(int rgb) {
        int r = getRed(rgb);
        int g = getGreen(rgb);
        int b = getBlue(rgb);
        int alpha = getAlpha(rgb);
        int i = (int) (1.0 / (1.0 - FACTOR));
        if (r == 0 && g == 0 && b == 0)
            return new Color(i, i, i, alpha);
        if (r > 0 && r < i) r = i;
        if (g > 0 && g < i) g = i;
        if (b > 0 && b < i) b = i;
        return new Color(Math.min((int) (r / FACTOR), 255),
                Math.min((int) (g / FACTOR), 255),
                Math.min((int) (b / FACTOR), 255),
                alpha);
    }

    public static Color darker(int rgb) {
        return new Color(Math.max((int) (getRed(rgb) * FACTOR), 0),
                Math.max((int) (getGreen(rgb) * FACTOR), 0),
                Math.max((int) (getBlue(rgb) * FACTOR), 0),
                getAlpha(rgb));
    }

    public static int getRGB(int r, int g, int b) {
        return getRGB(r, g, b, 255);
    }

    public static int getRGB(int r, int g, int b, int a) {
        return ((a & 0xFF) << 24) |
                ((r & 0xFF) << 16) |
                ((g & 0xFF) << 8) |
                ((b & 0xFF));
    }

    public static int getRed(int rgb) {
        return (rgb >> 16) & 0xFF;
    }

    public static int getGreen(int rgb) {
        return (rgb >> 8) & 0xFF;
    }

    public static int getBlue(int rgb) {
        return (rgb) & 0xFF;
    }

    public static int getAlpha(int rgb) {
        return (rgb >> 24) & 0xff;
    }
}
