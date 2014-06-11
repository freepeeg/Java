package iitc.event;

import iitc.im.ListOperations;
import iitc.swing.desktop.input.events.FocusEventCopy;
import iitc.swing.desktop.input.events.KeyEventCopy;
import iitc.swing.desktop.input.events.MouseEventCopy;
import iitc.swing.desktop.input.events.MouseWheelEventCopy;
import iitc.util.Random;
import iitc.util.Time;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Collections;

/**
 * StateBasedInputHandler
 *
 * @author Ian
 * @version 1.0
 */
public class StateBasedInputHandler extends InputHandler {
    private static final Point OFF_SCREEN = new Point(-1, -1);
    private State state;
    private Point mouse;
    private final java.util.List<StateListener> listeners;

    public StateBasedInputHandler(Component component) {
        this(component, State.ALL);
    }

    public StateBasedInputHandler(Component component, State original) {
        super(component);
        this.listeners = new ArrayList<>();
        state = original;
        this.mouse = component.getMousePosition();
    }

    public boolean addStateListeners(StateListener... listeners) {
        return Collections.addAll(this.listeners, listeners);
    }

    public boolean removeStateListeners(StateListener... listeners) {
        return ListOperations.removeAll(this.listeners, listeners);
    }

    public State getInputState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
        for (StateListener listener : listeners)
            listener.onStateChange(state);
    }

    public Point getMousePosition() {
        return mouse == null ? OFF_SCREEN : mouse;
    }

    private void updateMouse(MouseEvent e) {
        Point p = e.getPoint();
        if (component.contains(p))
            mouse = p;
    }

    public boolean press(char keyChar) {
        KeyEvent pressed = new KeyEventCopy(component, KeyEvent.KEY_PRESSED, System.currentTimeMillis(),
                0, keyChar, keyChar, KeyEvent.KEY_LOCATION_STANDARD);
        keyPressed(pressed);
        return true;
    }

    public boolean type(char keyChar) {
        return type(keyChar, 22, 57);
    }

    public boolean type(char keyChar, int min_delay, int max_delay) {
        return press(keyChar) && Time.sleep(Random.nextInt(min_delay, max_delay)) && release(keyChar);
    }

    public boolean release(char keyChar) {
        KeyEvent released = new KeyEventCopy(component, KeyEvent.KEY_RELEASED, System.currentTimeMillis(),
                0, keyChar, keyChar, KeyEvent.KEY_LOCATION_STANDARD);
        keyReleased(released);
        keyTyped(released);
        return true;
    }

    public boolean press(boolean left) {
        MouseEvent pressed = new MouseEventCopy(component, MouseEvent.MOUSE_PRESSED,
                System.currentTimeMillis(), left ? 0 : InputEvent.BUTTON3_MASK,
                (int) getMousePosition().getX(), (int) getMousePosition().getY(), 1, false);
        mousePressed(pressed);
        return true;
    }

    public boolean release(boolean left) {
        MouseEvent released = new MouseEventCopy(component, MouseEvent.MOUSE_PRESSED,
                System.currentTimeMillis(), left ? 0 : InputEvent.BUTTON3_MASK,
                (int) getMousePosition().getX(), (int) getMousePosition().getY(), 1, false);
        mouseReleased(released);
        mouseClicked(released);
        return true;
    }

    public boolean click() {
        return click(true);
    }

    public boolean click(boolean left) {
        return click(left, 73, 321);
    }

    public boolean click(int min_delay, int max_delay) {
        return click(true, min_delay, max_delay);
    }

    public boolean click(boolean left, int min_delay, int max_delay) {
        return press(left) && Time.sleep(min_delay, max_delay) && release(left);
    }

    public boolean scroll(int amount) {
        MouseWheelEvent scroll = new MouseWheelEventCopy(component, MouseEvent.MOUSE_WHEEL,
                System.currentTimeMillis(), MouseEvent.MOUSE_WHEEL,
                (int) getMousePosition().getX(), (int) getMousePosition().getY(),
                (int) getMousePosition().getX(), (int) getMousePosition().getY(),
                1, false, MouseWheelEvent.WHEEL_BLOCK_SCROLL, amount, 1);
        mouseWheelMoved(scroll);
        return true;
    }

    public boolean hop(final int x, final int y) {
        final MouseEvent me = new MouseEventCopy(component, MouseEvent.MOUSE_MOVED,
                System.currentTimeMillis(), 0, x, y, 0, false);
        mouseMoved(me);
        return true;
    }

    public void mouseClicked(MouseEvent e) {
        if (e instanceof MouseEventCopy || (state == State.ALL || state == State.MOUSE)) {
            super.mouseClicked(e);
            updateMouse(e);
        }
    }

    public void mousePressed(MouseEvent e) {
        if (e instanceof MouseEventCopy || (state == State.ALL || state == State.MOUSE)) {
            super.mousePressed(e);
            updateMouse(e);
        }
    }

    public void mouseReleased(MouseEvent e) {
        if (e instanceof MouseEventCopy || (state == State.ALL || state == State.MOUSE)) {
            super.mouseReleased(e);
            updateMouse(e);
        }
    }

    public void mouseEntered(MouseEvent e) {
        if (e instanceof MouseEventCopy || (state == State.ALL || state == State.MOUSE)) {
            super.mouseEntered(e);
            updateMouse(e);
        }
    }

    public void mouseExited(MouseEvent e) {
        if (e instanceof MouseEventCopy || (state == State.ALL || state == State.MOUSE)) {
            super.mouseExited(e);
        }
    }

    public void mouseWheelMoved(MouseWheelEvent e) {
        if (e instanceof MouseWheelEventCopy || (state == State.ALL || state == State.MOUSE))
            super.mouseWheelMoved(e);
    }

    public void mouseDragged(MouseEvent e) {
        if (e instanceof MouseEventCopy || (state == State.ALL || state == State.MOUSE)) {
            super.mouseDragged(e);
            updateMouse(e);
        }
    }

    public void mouseMoved(MouseEvent e) {
        if (e instanceof MouseEventCopy || (state == State.ALL || state == State.MOUSE)) {
            super.mouseMoved(e);
            updateMouse(e);
        }
    }

    @Override
    public void focusGained(FocusEvent e) {
        if (e instanceof FocusEventCopy || (state == State.ALL || state == State.MOUSE))
            super.focusGained(e);
    }

    @Override
    public void focusLost(FocusEvent e) {
        if (e instanceof FocusEventCopy || (state == State.ALL || state == State.MOUSE))
            super.focusLost(e);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if (e instanceof KeyEventCopy || (state == State.ALL || state == State.KEY))
            super.keyTyped(e);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e instanceof KeyEventCopy || (state == State.ALL || state == State.KEY))
            super.keyPressed(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e instanceof KeyEventCopy || (state == State.ALL || state == State.KEY))
            super.keyReleased(e);
    }

    public enum State {
        NONE, MOUSE, KEY, ALL;

        @Override
        public String toString() {
            return name().charAt(0) + name().substring(1).toLowerCase();
        }
    }
}
