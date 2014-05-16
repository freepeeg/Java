package iitc.swing;

import javax.swing.*;
import java.awt.*;

/**
 * DrawReadyPanel
 *
 * @author Ian
 * @version 1.0
 */
public abstract class DrawReadyPanel extends JPanel {
    /**
     * Creates a new JPanel with the specified layout manager and buffering
     * strategy.
     *
     * @param layout           the LayoutManager to use
     * @param isDoubleBuffered a boolean, true for double-buffering, which
     *                         uses additional memory space to achieve fast, flicker-free
     *                         updates
     */
    protected DrawReadyPanel(LayoutManager layout, boolean isDoubleBuffered) {
        super(layout, isDoubleBuffered);
    }

    /**
     * Create a new buffered JPanel with the specified layout manager
     *
     * @param layout the LayoutManager to use
     */
    protected DrawReadyPanel(LayoutManager layout) {
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
    protected DrawReadyPanel(boolean isDoubleBuffered) {
        super(isDoubleBuffered);
    }

    /**
     * Creates a new <code>JPanel</code> with a double buffer
     * and a flow layout.
     */
    protected DrawReadyPanel() {
    }

    public abstract void draw(Graphics g);

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }
}
