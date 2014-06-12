package iitc.swing.desktop;

import iitc.event.StateListener;
import iitc.swing.desktop.input.Manager;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

/**
 * BFrame
 *
 * @author Ian
 * @version 1.0
 */
public abstract class ReloadableFrame<B extends Manager, B2 extends Toolbar<B>> extends LoadableFrame {
    private final java.util.List<LoadListener<B, B2, ReloadableFrame<B, B2>>> listeners;
    private final LoadablePanel<?, B, B2, ReloadableFrame<B, B2>> instance;
    private B manager;
    private B2 toolbar;

    public ReloadableFrame(LoadablePanel<?, B, B2, ReloadableFrame<B, B2>> instance) {
        this(null, instance);
    }

    public ReloadableFrame(String title, LoadablePanel<?, B, B2, ReloadableFrame<B, B2>> instance) {
        super(title);
        this.listeners = new ArrayList<>();
        this.instance = instance;
        this.toolbar = getToolBar();
        listen(instance);
        add(instance, BorderLayout.CENTER);
        if (toolbar != null)
            add(toolbar, BorderLayout.SOUTH);
        pack();
        setVisible(true);
    }

    public B getManager() {
        return manager;
    }

    protected abstract B2 getToolBar();

    @SafeVarargs
    public final void listen(LoadListener<B, B2, ReloadableFrame<B, B2>>... listeners) {
        Collections.addAll(this.listeners, listeners);
    }

    @Override
    public void load() {
        super.load();
        instance.load(this);
        for (LoadListener<B, B2, ReloadableFrame<B, B2>> listener : listeners)
            listener.onLoad(this);
    }

    public void update(B manager) {
        this.manager = manager;
        if (toolbar != null) {
            toolbar.renew(manager);
            if (toolbar instanceof StateListener)
                this.manager.addStateListeners((StateListener) toolbar);
        }
    }
}
