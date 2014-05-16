package iitc.swing;


import iitc.util.Time;

import javax.swing.*;

/**
 * Log
 *
 * @author Ian
 * @version 1.0
 */
public class Log extends JList<String> {
    private static DefaultListModel<String> model = new DefaultListModel<>();

    public Log() {
        this(6);
    }

    public Log(String... beginningStatements) {
        this(6, beginningStatements);
    }

    public Log(int visibleLogs, String... beginningStatements) {
        super(model);
        setVisibleRowCount(visibleLogs);
        for (String string : beginningStatements)
            log(string);
    }

    public Log(int visibleLogs) {
        super(model);
        setVisibleRowCount(visibleLogs);
    }

    public static void setModel(DefaultListModel<String> model) {
        Log.model = model;
    }

    public void log(String text) {
        model.addElement(Time.formatDate(System.currentTimeMillis()) + " | " + text);
        int goal = model.size() - 1;
        if (model.capacity() > goal)
            ensureIndexIsVisible(goal);

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
