package iitc.projects.desktop;

import iitc.projects.desktop.input.Manager;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

/**
 * BFrame
 *
 * @author Ian
 * @version 1.0
 */
public abstract class BFrame<B extends Manager, B2 extends BToolBar<B>> extends JInternalFrame {
    private final java.util.List<LoadListener<B, B2, BFrame<B, B2>>> listeners;
    private final BPanel instance;
    private B manager;

    public BFrame(BPanel instance) {
        this("", instance);
    }

    public BFrame(String title, BPanel instance) {
        super(title, true, true, true, true);
        setLayout(new BorderLayout(0,0));
        this.listeners = new ArrayList<>();
        this.instance = instance;
        listen(instance);
        add(instance,BorderLayout.CENTER);
        add(getToolBar(),BorderLayout.SOUTH);
        pack();
        setVisible(true);
    }

    public B getManager() {
        return manager;
    }

    public abstract B2 getToolBar();

    @SafeVarargs
    public final void listen(LoadListener<B, B2, BFrame<B, B2>>... listeners) {
        Collections.addAll(this.listeners, listeners);
    }

    public void load() {
        instance.load(this);
        for (LoadListener<B, B2, BFrame<B, B2>> listener : listeners)
            listener.onLoad(this);
    }

    public void update(B manager) {
        this.manager = manager;
    }
}