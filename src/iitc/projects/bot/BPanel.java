package iitc.projects.bot;

import iitc.projects.bot.input.Manager;

import javax.swing.*;
import java.awt.*;

/**
 * BPanel
 *
 * @author Ian
 * @version 1.0
 */
public abstract class BPanel<C extends Component, B extends Manager, B2 extends BFrame<B>> extends JPanel implements LoadListener<BPanel<C, B, B2>, B, B2> {
    private C component;
    private Component loading;

    public BPanel() {
    }

    public BPanel(Component loading) {
        this.loading = loading;
        add(loading);
    }

    protected abstract void load(BFrame parent);

    public C getComponent() {
        return component;
    }

    public void setComponent(C component) {
        this.component = component;
    }

    public abstract B getManager();

    @Override
    public void onLoad(B2 parent) {
        C component = getComponent();
        if (component != null) {
            if (loading != null)
                remove(loading);
            add(component);
            parent.update(getManager());
            parent.pack();
        } else
            throw new Error("Failure to load.");
    }
}
