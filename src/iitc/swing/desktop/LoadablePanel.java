package iitc.swing.desktop;

import iitc.swing.desktop.input.Manager;

import javax.swing.*;
import java.awt.*;

/**
 * BPanel
 *
 * @author Ian
 * @version 1.0
 */
public abstract class LoadablePanel<C extends Component, B extends Manager, B1 extends Toolbar<B>, B2 extends ReloadableFrame<B, B1>> extends JPanel implements LoadListener<B, B1, B2> {
    private C component;
    protected Component loading;

    public LoadablePanel() {
    }

    public LoadablePanel(Component loading) {
        this.loading = loading;
        add(loading);
    }

    protected abstract void load(B2 parent);

    public C getComponent() {
        return component;
    }

    protected void update(B2 parent) {
        parent.update(getManager());
    }

    public void setComponent(C component) {
        this.component = component;
    }

    public abstract B getManager();

    @Override
    public boolean onLoad(B2 parent) {
        C component = getComponent();
        if (component != null) {
            if (loading != null)
                remove(loading);
            add(component);
            parent.pack();
            update(parent);
            return true;
        }
        return false;
    }
}
