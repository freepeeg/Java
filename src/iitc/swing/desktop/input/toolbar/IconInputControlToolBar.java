package iitc.swing.desktop.input.toolbar;

import iitc.event.StateBasedInputHandler;
import iitc.swing.desktop.input.Manager;

import javax.swing.*;

/**
 * IconInputControlToolbar
 *
 * @author Ian
 * @version 1.0
 */
public class IconInputControlToolbar<M extends Manager> extends TextInputControlToolbar<M> {
    private final Icon mouseActive;
    private final Icon mouseInactive;
    private final Icon keyActive;
    private final Icon keyInactive;

    public IconInputControlToolbar(Icon mouseActive, Icon mouseInactive, Icon keyActive, Icon keyInactive, int alignment, int hgap, int vgap) {
        this(mouseActive, mouseInactive, keyActive, keyInactive, null, alignment, hgap, vgap);
    }

    public IconInputControlToolbar(Icon mouseActive, Icon mouseInactive, Icon keyActive, Icon keyInactive, String name, int alignment, int hgap, int vgap) {
        this(new JButton(), new JButton(), mouseActive, mouseInactive, keyActive, keyInactive, name, alignment, hgap, vgap);
    }

    public IconInputControlToolbar(JButton mouse, JButton keyboard, Icon mouseActive, Icon mouseInactive, Icon keyActive, Icon keyInactive, int alignment, int hgap, int vgap) {
        this(mouse, keyboard, mouseActive, mouseInactive, keyActive, keyInactive, null, alignment, hgap, vgap);
    }

    public IconInputControlToolbar(JButton mouse, JButton keyboard, Icon mouseActive, Icon mouseInactive, Icon keyActive, Icon keyInactive, String name, int alignment, int hgap, int vgap) {
        super(mouse, keyboard, name, alignment, hgap, vgap);
        this.mouseActive = mouseActive;
        this.mouseInactive = mouseInactive;
        this.keyActive = keyActive;
        this.keyInactive = keyInactive;
        mouse.setIcon(mouseActive);
        keyboard.setIcon(keyActive);
    }

    @Override
    public void onStateChange(StateBasedInputHandler.State state) {
        switch (state) {
            case ALL:
                mouse.setIcon(mouseActive);
                keyboard.setIcon(keyActive);
                break;
            case MOUSE:
                mouse.setIcon(mouseActive);
                keyboard.setIcon(keyInactive);
                break;
            case KEY:
                mouse.setIcon(mouseInactive);
                keyboard.setIcon(keyActive);
                break;
            case NONE:
                mouse.setIcon(mouseInactive);
                keyboard.setIcon(keyInactive);
                break;
        }
    }
}
