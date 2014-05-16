package iitc.projects.twentyfourtyeight;

import iitc.event.Key;

import javax.swing.*;
import java.awt.event.KeyEvent;

public enum Bind {
    UP(Key.getKeyStroke(KeyEvent.VK_UP), Shift.UP),
    LEFT(Key.getKeyStroke(KeyEvent.VK_LEFT), Shift.LEFT),
    DOWN(Key.getKeyStroke(KeyEvent.VK_DOWN), Shift.DOWN),
    RIGHT(Key.getKeyStroke(KeyEvent.VK_RIGHT), Shift.RIGHT),
    W(UP.keystroke, UP.shift),
    A(LEFT.keystroke, LEFT.shift),
    S(DOWN.keystroke, DOWN.shift),
    D(RIGHT.keystroke, RIGHT.shift);
    protected KeyStroke keystroke;
    protected Shift shift;

    Bind(KeyStroke keystroke, Shift shift) {
        this.keystroke = keystroke;
        this.shift = shift;
    }

    public Shift getShift() {
        return shift;
    }

    public KeyStroke getKeyStroke() {
        return keystroke;
    }
}