package iitc.swing.desktop;

import iitc.swing.desktop.input.Manager;

import javax.swing.*;
import java.awt.*;

/**
 * BToolBar
 *
 * @author Ian
 * @version 1.0
 */
public class Toolbar<M extends Manager> extends JToolBar {
    protected M manager;

    public Toolbar(int alignment, int hgap, int vgap) {
        this(null, alignment, hgap, vgap);
    }

    public Toolbar(String name, int alignment, int hgap, int vgap) {
        super(name);
        setLayout(new FlowLayout(alignment, hgap, vgap));
        setFloatable(false);
    }

    public void renew(M manager) {
        this.manager = manager;
    }
}
