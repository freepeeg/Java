package iitc.event;

import iitc.im.ListOperations;
import iitc.im.NullRestrictiveArrayList;

import java.awt.*;
import java.awt.event.*;
import java.util.Collections;
import java.util.List;

/**
 * InputHandler
 *
 * @author Ian
 * @version 1.0
 */
public class InputHandler extends MouseAdapter implements KeyListener, FocusListener {
    protected final Component component;
    private final List<MouseListener> mouseListeners;
    private final List<MouseMotionListener> mouseMotionListeners;
    private final List<MouseWheelListener> mouseWheelListeners;
    private final List<KeyListener> keyListeners;
    private final List<FocusListener> focusListeners;
    private final MouseListener[] orig_mouse;
    private final MouseMotionListener[] orig_mouse_motion;
    private final MouseWheelListener[] orig_mouse_wheel;
    private final KeyListener[] orig_key;
    private final FocusListener[] orig_focus;

    public InputHandler(Component component) {
        this.component = component;
        this.focusListeners = new NullRestrictiveArrayList<>();
        this.keyListeners = new NullRestrictiveArrayList<>();
        this.mouseWheelListeners = new NullRestrictiveArrayList<>();
        this.mouseMotionListeners = new NullRestrictiveArrayList<>();
        this.mouseListeners = new NullRestrictiveArrayList<>();
        this.orig_mouse = component.getMouseListeners();
        this.orig_mouse_motion = component.getMouseMotionListeners();
        this.orig_mouse_wheel = component.getMouseWheelListeners();
        this.orig_key = component.getKeyListeners();
        this.orig_focus = component.getFocusListeners();
        for (MouseListener l : orig_mouse)
            component.removeMouseListener(l);
        for (MouseMotionListener l : orig_mouse_motion)
            component.removeMouseMotionListener(l);
        for (MouseWheelListener l : orig_mouse_wheel)
            component.removeMouseWheelListener(l);
        for (KeyListener k : orig_key)
            component.removeKeyListener(k);
        for (FocusListener f : orig_focus)
            component.removeFocusListener(f);
        Collections.addAll(mouseListeners, orig_mouse);
        Collections.addAll(mouseMotionListeners, orig_mouse_motion);
        Collections.addAll(mouseWheelListeners, orig_mouse_wheel);
        Collections.addAll(keyListeners, orig_key);
        Collections.addAll(focusListeners, orig_focus);
        component.addMouseListener(this);
        component.addMouseMotionListener(this);
        component.addMouseWheelListener(this);
        component.addKeyListener(this);
        component.addFocusListener(this);
    }

    public void stopListening() {
        component.removeMouseListener(this);
        component.removeMouseMotionListener(this);
        component.removeMouseWheelListener(this);
        component.removeKeyListener(this);
        component.removeFocusListener(this);
        for (MouseListener l : orig_mouse)
            component.addMouseListener(l);
        for (MouseMotionListener l : orig_mouse_motion)
            component.addMouseMotionListener(l);
        for (MouseWheelListener l : orig_mouse_wheel)
            component.addMouseWheelListener(l);
        for (KeyListener k : orig_key)
            component.addKeyListener(k);
        for (FocusListener f : orig_focus)
            component.addFocusListener(f);

    }

    public synchronized boolean addAll(MouseListener... listeners) {
        return Collections.addAll(this.mouseListeners, listeners);
    }

    public synchronized boolean addAll(MouseMotionListener... listeners) {
        return Collections.addAll(this.mouseMotionListeners, listeners);
    }

    public synchronized boolean addAll(MouseWheelListener... listeners) {
        return Collections.addAll(this.mouseWheelListeners, listeners);
    }

    public synchronized boolean addAll(KeyListener... listeners) {
        return Collections.addAll(this.keyListeners, listeners);
    }

    public synchronized boolean addAll(FocusListener... listeners) {
        return Collections.addAll(this.focusListeners, listeners);
    }

    public synchronized boolean removeAll(MouseListener... listeners) {
        return ListOperations.removeAll(this.mouseListeners, listeners);
    }

    public synchronized boolean removeAll(MouseMotionListener... listeners) {
        return ListOperations.removeAll(this.mouseMotionListeners, listeners);
    }

    public synchronized boolean removeAll(MouseWheelListener... listeners) {
        return ListOperations.removeAll(this.mouseWheelListeners, listeners);
    }

    public synchronized boolean removeAll(KeyListener... listeners) {
        return ListOperations.removeAll(this.keyListeners, listeners);
    }

    public synchronized boolean removeAll(FocusListener... listeners) {
        return ListOperations.removeAll(this.focusListeners, listeners);
    }

    public Component getComponent() {
        return component;
    }

    public void mouseClicked(MouseEvent e) {
        for (MouseListener listener : mouseListeners)
            listener.mouseClicked(e);
    }

    public void mousePressed(MouseEvent e) {
        for (MouseListener listener : mouseListeners)
            listener.mousePressed(e);
    }

    public void mouseReleased(MouseEvent e) {
        for (MouseListener listener : mouseListeners)
            listener.mouseReleased(e);
    }

    public void mouseEntered(MouseEvent e) {
        for (MouseListener listener : mouseListeners)
            listener.mouseEntered(e);
    }

    public void mouseExited(MouseEvent e) {
        for (final MouseListener listener : mouseListeners) {
            try {
                listener.mouseExited(e);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public void mouseWheelMoved(MouseWheelEvent e) {
        for (MouseWheelListener listener : mouseWheelListeners)
            listener.mouseWheelMoved(e);
    }

    public void mouseDragged(MouseEvent e) {
        for (MouseMotionListener listener : mouseMotionListeners)
            listener.mouseDragged(e);
    }

    public void mouseMoved(MouseEvent e) {
        for (MouseMotionListener listener : mouseMotionListeners)
            listener.mouseMoved(e);
    }

    @Override
    public void focusGained(FocusEvent e) {
        for (FocusListener f : focusListeners)
            f.focusGained(e);
    }

    @Override
    public void focusLost(FocusEvent e) {
        for (FocusListener f : focusListeners)
            f.focusLost(e);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        for (KeyListener k : keyListeners)
            k.keyTyped(e);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        for (KeyListener k : keyListeners)
            k.keyPressed(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        for (KeyListener k : keyListeners)
            k.keyReleased(e);
    }
}
