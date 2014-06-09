package iitc.swing.desktop.input.toolbar;

import iitc.swing.desktop.BToolBar;
import iitc.swing.desktop.input.Manager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * InputControlToolBar
 *
 * @author Ian
 * @version 1.0
 */
public abstract class InputControlToolBar<M extends Manager> extends BToolBar<M> {
    public InputControlToolBar(int alignment, int hgap, int vgap) {
        this(new JButton("Mouse"), new JButton("Keyboard"), alignment, hgap, vgap);
    }

    public InputControlToolBar(String name, int alignment, int hgap, int vgap) {
        this(new JButton("Mouse"), new JButton("Keyboard"), name, alignment, hgap, vgap);
    }

    public InputControlToolBar(JButton mouse, JButton keyboard, int alignment, int hgap, int vgap) {
        this(mouse, keyboard, null, alignment, hgap, vgap);
    }

    public InputControlToolBar(final JButton mouse, final JButton keyboard, String name, int alignment, int hgap, int vgap) {
        super(name, alignment, hgap, vgap);
        mouse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onMouseChange(mouse);
            }
        });
        add(mouse);
        keyboard.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onKeyboardChange(keyboard);
            }
        });
        add(keyboard);
    }

    protected abstract void onMouseChange(JButton button);

    protected abstract void onKeyboardChange(JButton button);
}
