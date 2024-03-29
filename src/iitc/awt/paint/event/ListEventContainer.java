package iitc.awt.paint.event;

import iitc.awt.paint.EventContainer;
import iitc.im.ListOperations;

import java.awt.event.ComponentListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * ListEventContainer
 *
 * @author Ian
 * @version 1.0
 */
public class ListEventContainer implements EventContainer {
    private final List<MouseListener> mouseListeners;
    private final List<MouseMotionListener> mouseMotionListeners;
    private final List<MouseWheelListener> mouseWheelListeners;
    private final List<ComponentListener> componentListeners;

    public ListEventContainer() {
        this.mouseListeners = new ArrayList<>();
        this.mouseMotionListeners = new ArrayList<>();
        this.mouseWheelListeners = new ArrayList<>();
        this.componentListeners = new ArrayList<>();
    }

    public ListEventContainer(MouseListener[] mouseListeners, MouseMotionListener[] mouseMotionListeners, MouseWheelListener[] mouseWheelListeners, ComponentListener[] componentListeners) {
        this();
        addMouseListeners(mouseListeners);
        addMouseMotionListeners(mouseMotionListeners);
        addMouseWheelListeners(mouseWheelListeners);
        addComponentListeners(componentListeners);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MouseListener[] getMouseListeners() {
        return mouseListeners.toArray(new MouseListener[mouseListeners.size()]);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addMouseListeners(MouseListener... listeners) {
        Collections.addAll(mouseListeners, listeners);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void removeMouseListeners(MouseListener... listeners) {
        ListOperations.removeAll(mouseListeners, listeners);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MouseMotionListener[] getMouseMotionListeners() {
        return mouseMotionListeners.toArray(new MouseMotionListener[mouseMotionListeners.size()]);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addMouseMotionListeners(MouseMotionListener... listeners) {
        Collections.addAll(mouseMotionListeners, listeners);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void removeMouseMotionListeners(MouseMotionListener... listeners) {
        ListOperations.removeAll(mouseMotionListeners, listeners);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MouseWheelListener[] getMouseWheelListeners() {
        return mouseWheelListeners.toArray(new MouseWheelListener[mouseWheelListeners.size()]);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addMouseWheelListeners(MouseWheelListener... listeners) {
        Collections.addAll(mouseWheelListeners, listeners);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void removeMouseWheelListeners(MouseWheelListener... listeners) {
        ListOperations.removeAll(mouseWheelListeners, listeners);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ComponentListener[] getComponentListeners() {
        return componentListeners.toArray(new ComponentListener[componentListeners.size()]);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addComponentListeners(ComponentListener... listeners) {
        Collections.addAll(componentListeners, listeners);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void removeComponentListeners(ComponentListener... listeners) {
        ListOperations.removeAll(componentListeners, listeners);
    }
}
