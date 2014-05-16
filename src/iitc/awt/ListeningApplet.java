package iitc.awt;

import java.applet.Applet;
import java.awt.*;

/**
 * ListeningApplet
 *
 * @author Ian
 * @version 1.0
 */
public class ListeningApplet extends Applet {

    protected Component parent;

    public void listen(Component component) {
        this.parent = component;
    }

    @Override
    public Dimension getPreferredSize() {
        return getSize();
    }

    @Override
    public int getWidth() {
        return parent != null ? parent.getWidth() : super.getWidth();
    }

    @Override
    public int getHeight() {
        return parent != null ? parent.getHeight() : super.getHeight();
    }

    @Override
    public Dimension getMinimumSize() {
        return parent != null ? parent.getMinimumSize() : super.getMinimumSize();
    }

    @Override
    public Dimension getMaximumSize() {
        return parent != null ? parent.getMaximumSize() : super.getMaximumSize();
    }

    @Override
    public Dimension getSize() {
        return parent != null ? parent.getSize() : super.getSize();
    }
}
