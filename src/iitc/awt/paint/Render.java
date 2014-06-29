package iitc.awt.paint;

import java.awt.*;

/**
 * Render
 *
 * @author Ian
 * @version 1.0
 */
public interface Render {
    /**
     * Uses the graphics context to perform any UI action
     *
     * @param graphics the context for rendering
     */
    public void repaint(Graphics graphics);
}
