package iitc.swing;

/**
 * SystemLogger
 *
 * @author Ian
 * @version 1.0
 */
public class SystemLogger extends Logger {
    public SystemLogger(Log log) {
        super(log);
    }

    public SystemLogger(SystemLog log) {
        super(log);
        new Thread(log).start();
    }
}
