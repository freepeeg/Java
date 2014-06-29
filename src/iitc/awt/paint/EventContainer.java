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
    public MouseListener[] getMouseListeners();

    public void addMouseListeners(MouseListener... listeners);

    public void removeMouseListeners(MouseListener... listeners);

    public MouseMotionListener[] getMouseMotionListeners();

    public void addMouseMotionListeners(MouseMotionListener... listeners);

    public void removeMouseMotionListeners(MouseMotionListener... listeners);

    public MouseWheelListener[] getMouseWheelListeners();

    public void addMouseWheelListeners(MouseWheelListener... listeners);

    public void removeMouseWheelListeners(MouseWheelListener... listeners);

    public ComponentListener[] getComponentListeners();

    public void addComponentListeners(ComponentListener... listeners);

    public void removeComponentListeners(ComponentListener... listeners);
}
