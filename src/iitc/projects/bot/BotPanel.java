package iitc.projects.bot;

import iitc.projects.bot.input.BotController;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;

/**
 * BotPanel
 *
 * @author Ian
 * @version 1.0
 */
public class BotPanel<B extends BotInstance> extends JInternalFrame {
    private final java.util.List<LoadListener> listeners;
    private final B instance;
    private BotController controller;

    public BotPanel(B instance) {
        this("", instance);
    }

    public BotPanel(String title, B instance) {
        super(title, true, true, true, true);
        this.listeners = new ArrayList<>();
        this.instance = instance;
        listen(instance);
        add(instance);
        pack();
        setVisible(true);
        //TODO:setup frame with controller buttons
    }

    public BotController getController() {
        return controller;
    }

    public void listen(LoadListener... listeners) {
        Collections.addAll(this.listeners, listeners);
    }

    public void load() {
        instance.load(this);
        for (LoadListener listener : listeners)
            listener.onLoad(this);
    }

    public void update(BotController controller) {
        this.controller = controller;
    }
}
