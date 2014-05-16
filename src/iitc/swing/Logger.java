package iitc.swing;

import javax.swing.*;

/**
 * Logger
 *
 * @author Ian
 * @version 1.0
 */
public class Logger extends JScrollPane {
    private static Log log;
    private static volatile int warnings;
    long lastEntry;

    public Logger(Log log) {
        super((Logger.log = log), VERTICAL_SCROLLBAR_ALWAYS, HORIZONTAL_SCROLLBAR_ALWAYS);
        reset();
    }

    public static void reset() {
        warnings = 0;
    }

    public synchronized void log(final String text) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                long current = System.currentTimeMillis();
                long diff = current - lastEntry;
                if (warnings < 5) {
                    if (diff < 20)
                        warnings++;
                    log.log(text);
                } else if (warnings == 5) {
                    log.log("Logging has been restricted as logging more frequent than 20 ms will force freeze of the application. All log output will be redirected to stdout. Restart the application to reset your warnings.");
                    warnings++;
                } else {
                    System.out.println(text);
                }
                lastEntry = System.currentTimeMillis();
            }
        });
    }

    public void log(int i) {
        log(String.valueOf(i));
    }

    public void log(double d) {
        log(String.valueOf(d));
    }

    public void log(long l) {
        log(String.valueOf(l));
    }

    public void log(float f) {
        log(String.valueOf(f));
    }

    public void log(Object object) {
        log(object.toString());
    }
}
