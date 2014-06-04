package iitc.projects.bot;

import iitc.projects.bot.input.BotManager;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;

/**
 * BotPanel
 *
 * @author Ian
 * @version 1.0
 */
public class BotPanel<B extends BotInstance, B2 extends BotManager> extends JInternalFrame {
    private final java.util.List<LoadListener<B, B2, BotPanel<B, B2>>> listeners;
    private final B instance;
    private B2 manager;

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
        //TODO:setup frame with manager buttons
    }

    public B2 getManager() {
        return manager;
    }

    @SafeVarargs
    public final void listen(LoadListener<B, B2, BotPanel<B, B2>>... listeners) {
        Collections.addAll(this.listeners, listeners);
    }

    public void load() {
        instance.load(this);
        for (LoadListener<B, B2, BotPanel<B, B2>> listener : listeners)
            listener.onLoad(this);
    }

    public void update(B2 manager) {
        this.manager = manager;
    }
}
