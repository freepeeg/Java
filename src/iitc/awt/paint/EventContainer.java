package iitc.awt.paint;

import java.awt.event.ComponentListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelListener;

/**
 * EventContainer
 *
 * @author Ian
 * @version 1.0
 */
public interface EventContainer {
    /**
     * Returns an array of all the mouse listeners
     * registered on this container.
     *
     * @return all of this container's <code>MouseListener</code>s
     * or an empty array if no mouse
     * listeners are currently registered
     * @see #addMouseListeners
     * @see #removeMouseListeners
     */
    public MouseListener[] getMouseListeners();

    /**
     * Adds the specified mouse listeners to receive mouse
     * events from this container.
     *
     * @param listeners the mouse listeners
     * @see #removeMouseListeners
     * @see #getMouseListeners
     */
    public void addMouseListeners(MouseListener... listeners);

    /**
     * Removes the specified mouse listeners from this container.
     *
     * @param listeners the mouse listeners
     * @see #addMouseListeners
     * @see #getMouseListeners
     */
    public void removeMouseListeners(MouseListener... listeners);

    /**
     * Returns an array of all the mouse motion listeners
     * registered on this container.
     *
     * @return all of this container's <code>MouseMotionListener</code>s
     * or an empty array if no mouse
     * listeners are currently registered
     * @see #addMouseMotionListeners
     * @see #removeMouseMotionListeners
     */
    public MouseMotionListener[] getMouseMotionListeners();

    /**
     * Adds the specified mouse motion listeners to receive mouse motion
     * events from this container.
     *
     * @param listeners the mouse motion listeners
     * @see #removeMouseMotionListeners
     * @see #getMouseMotionListeners
     */
    public void addMouseMotionListeners(MouseMotionListener... listeners);

    /**
     * Removes the specified mouse motion listeners from this container.
     *
     * @param listeners the mouse motion listeners
     * @see #addMouseMotionListeners
     * @see #getMouseMotionListeners
     */
    public void removeMouseMotionListeners(MouseMotionListener... listeners);

    /**
     * Returns an array of all the mouse wheel listeners
     * registered on this container.
     *
     * @return all of this container's <code>MouseWheelListener</code>s
     * or an empty array if no mouse
     * listeners are currently registered
     * @see #addMouseWheelListeners
     * @see #removeMouseWheelListeners
     */
    public MouseWheelListener[] getMouseWheelListeners();

    /**
     * Adds the specified mouse wheel listeners to receive mouse wheel
     * events from this container.
     *
     * @param listeners the mouse wheel listeners
     * @see #removeMouseWheelListeners
     * @see #getMouseWheelListeners
     */
    public void addMouseWheelListeners(MouseWheelListener... listeners);

    /**
     * Removes the specified mouse wheel listeners from this container.
     *
     * @param listeners the mouse wheel listeners
     * @see #addMouseWheelListeners
     * @see #getMouseWheelListeners
     */
    public void removeMouseWheelListeners(MouseWheelListener... listeners);

    /**
     * Returns an array of all the component listeners
     * registered on this container.
     *
     * @return all of this container's <code>ComponentListener</code>s
     * or an empty array if no mouse
     * listeners are currently registered
     * @see #addComponentListeners
     * @see #removeComponentListeners
     */
    public ComponentListener[] getComponentListeners();

    /**
     * Adds the specified component listeners to receive component
     * events from this container.
     *
     * @param listeners the component listeners
     * @see #removeComponentListeners
     * @see #getComponentListeners
     */
    public void addComponentListeners(ComponentListener... listeners);

    /**
     * Removes the specified component listeners from this container.
     *
     * @param listeners the component listeners
     * @see #addComponentListeners
     * @see #getComponentListeners
     */
    public void removeComponentListeners(ComponentListener... listeners);
}
