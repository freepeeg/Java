package iitc.projects.bot;

import iitc.projects.bot.input.BotManager;

import javax.swing.*;
import java.awt.*;

/**
 * BotInstance
 *
 * @author Ian
 * @version 1.0
 */
public abstract class BotInstance<C extends Component, B extends BotManager, B2 extends BotPanel<BotInstance<C, B, B2>, B>> extends JPanel implements LoadListener<BotInstance<C, B, B2>, B, B2> {
    private C component;
    private Component loading;

    public BotInstance() {
    }

    public BotInstance(Component loading) {
        this.loading = loading;
        add(loading);
    }

    protected abstract void load(BotPanel parent);

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
