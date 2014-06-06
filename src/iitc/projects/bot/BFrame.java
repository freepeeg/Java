package iitc.projects.bot;

import iitc.projects.bot.input.Manager;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;

/**
 * BFrame
 *
 * @author Ian
 * @version 1.0
 */
public class BFrame<B2 extends Manager> extends JInternalFrame {
    private final java.util.List<LoadListener<BPanel, B2, BFrame<B2>>> listeners;
    private final BPanel instance;
    private B2 manager;

    public BFrame(BPanel instance) {
        this("", instance);
    }

    public BFrame(String title, BPanel instance) {
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
    public final void listen(LoadListener<BPanel, B2, BFrame<B2>>... listeners) {
        Collections.addAll(this.listeners, listeners);
    }

    public void load() {
        instance.load(this);
        for (LoadListener<BPanel, B2, BFrame<B2>> listener : listeners)
            listener.onLoad(this);
    }

    public void update(B2 manager) {
        this.manager = manager;
    }
}
