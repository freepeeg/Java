package iitc.swing.desktop.input.toolbar;

import iitc.event.StateListener;
import iitc.swing.desktop.Toolbar;
import iitc.swing.desktop.input.Manager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * InputControlToolbar
 *
 * @author Ian
 * @version 1.0
 */
public abstract class InputControlToolbar<M extends Manager> extends Toolbar<M> implements StateListener {
    protected final JButton mouse;
    protected final JButton keyboard;

    public InputControlToolbar(int alignment, int hgap, int vgap) {
        this(new JButton("Mouse"), new JButton("Keyboard"), alignment, hgap, vgap);
    }

    public InputControlToolbar(String name, int alignment, int hgap, int vgap) {
        this(new JButton("Mouse"), new JButton("Keyboard"), name, alignment, hgap, vgap);
    }

    public InputControlToolbar(JButton mouse, JButton keyboard, int alignment, int hgap, int vgap) {
        this(mouse, keyboard, null, alignment, hgap, vgap);
    }

    public InputControlToolbar(final JButton mouse, final JButton keyboard, String name, int alignment, int hgap, int vgap) {
        super(name, alignment, hgap, vgap);
        this.mouse = mouse;
        this.keyboard = keyboard;
        mouse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onMouseChange();
            }
        });
        add(mouse);
        keyboard.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onKeyboardChange();
            }
        });
        add(keyboard);
    }

    protected abstract void onMouseChange();

    protected abstract void onKeyboardChange();
}
