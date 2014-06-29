package iitc.awt.paint;

import java.awt.*;

/**
 * LayoutManager
 *
 * @author Ian
 * @version 1.0
 */
public interface LayoutManager {
    /**
     * Calculates the preferred size dimensions for the specified
     * container, given the components it contains.
     *
     * @param object   the container to be laid out
     * @param graphics the graphics context
     */
    public Dimension preferredLayout(RObject object, Graphics graphics);

    /**
     * Calculates the minimum size dimensions for the specified
     * container, given the components it contains.
     *
     * @param object   the container to be laid out
     * @param graphics the graphics context
     */
    public Dimension minimumLayout(RObject object, Graphics graphics);

    /**
     * Calculates the current size dimensions for the specified
     * container, given the components it contains.
     *
     * @param object   the container to be laid out
     * @param graphics the graphics context
     */
    public Dimension layout(RObject object, Graphics graphics);

    /**
     * Calls for the object to be laid out according to it's current size
     *
     * @param object   the container to be laid out
     * @param graphics the graphics context
     * @see #layout(RObject, java.awt.Graphics)
     */
    public void revalidate(RObject object, Graphics graphics);

    /**
     * Lays out the specified container.
     *
     * @param object   the container to be laid out
     * @param graphics the graphics context
     */
    public void doLayout(RObject object, Graphics graphics);

    /**
     * Adds the object at the specified constraint to the layout.
     *
     * @param object     the component to be added
     * @param constraint the constraint at which to add the object
     */
    public void addLayoutComponent(RObject object, Object constraint);

    /**
     * Removes the specified component from the layout.
     *
     * @param object the component to be removed
     */
    public void removeLayoutComponent(RObject object);

    /**
     * Removes the object at the specified constraint from the layout.
     *
     * @param constraint the constraint at which to remove it's object
     */
    public void removeLayoutComponent(Object constraint);
}
