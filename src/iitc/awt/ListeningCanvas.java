package iitc.awt;

import java.awt.*;

/**
 * ListeningCanvas
 *
 * @author Ian
 * @version 1.0
 */
public class ListeningCanvas extends Canvas {
    protected Component parent;

    /**
     * Constructs a new Canvas.
     */
    public ListeningCanvas() {
    }

    /**
     * Constructs a new Canvas given a GraphicsConfiguration object.
     *
     * @param config a reference to a GraphicsConfiguration object.
     * @see java.awt.GraphicsConfiguration
     */
    public ListeningCanvas(GraphicsConfiguration config) {
        super(config);
    }

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
