package iitc.awt;

import javax.swing.*;
import java.awt.*;

/**
 * ListeningPanel
 *
 * @author Ian
 * @version 1.0
 */
public class ListeningPanel extends JPanel {
    protected Component parent;

    /**
     * Creates a new <code>JPanel</code> with a double buffer
     * and a flow layout.
     */
    public ListeningPanel() {
    }

    /**
     * Creates a new JPanel with the specified layout manager and buffering
     * strategy.
     *
     * @param layout           the LayoutManager to use
     * @param isDoubleBuffered a boolean, true for double-buffering, which
     *                         uses additional memory space to achieve fast, flicker-free
     *                         updates
     */
    public ListeningPanel(LayoutManager layout, boolean isDoubleBuffered) {
        super(layout, isDoubleBuffered);
    }

    /**
     * Create a new buffered JPanel with the specified layout manager
     *
     * @param layout the LayoutManager to use
     */
    public ListeningPanel(LayoutManager layout) {
        super(layout);
    }

    /**
     * Creates a new <code>JPanel</code> with <code>FlowLayout</code>
     * and the specified buffering strategy.
     * If <code>isDoubleBuffered</code> is true, the <code>JPanel</code>
     * will use a double buffer.
     *
     * @param isDoubleBuffered a boolean, true for double-buffering, which
     *                         uses additional memory space to achieve fast, flicker-free
     *                         updates
     */
    public ListeningPanel(boolean isDoubleBuffered) {
        super(isDoubleBuffered);
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
