package iitc.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * Time
 *
 * @author Ian
 * @version 1.0
 */
public class Time {

    public static boolean sleep(int time) {
        try {
            Thread.sleep(time);
            return true;
        } catch (final InterruptedException ignored) {
            //Failed to sleep full time due to the exception
            return false;
        }
    }

    public static boolean sleep(int min, int max) {
        return sleep(Random.nextInt(min, max));
    }

    public static String formatDate(final long time) {
        return formatDate(time, Format.TWELVE);
    }

    public static String formatDate(final long time, Format format) {
        return format.getFormat().format(time);
    }

    public static String format(final long time) {
        final StringBuilder t = new StringBuilder();
        final long total_secs = time / 1000;
        final long total_mins = total_secs / 60;
        final long total_hrs = total_mins / 60;
        final int secs = (int) total_secs % 60;
        final int mins = (int) total_mins % 60;
        final int hrs = (int) total_hrs % 60;
        return (t.append(hrs < 10 ? "0" : "").append(hrs).append(":").append(mins < 10 ? "0" : "").append(mins).append(":").append(secs < 10 ? "0" : "").append(secs)).toString();
    }

    public enum Format {
        TWELVE(new SimpleDateFormat("hh:mm:ss")), TWENTYFOUR(new SimpleDateFormat("HH:mm:ss"));
        private final DateFormat format;

        Format(DateFormat format) {
            this.format = format;
        }

        public DateFormat getFormat() {
            return format;
        }
    }
}