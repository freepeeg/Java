package iitc.swing.desktop;

import javax.swing.*;
import java.awt.*;

/**
 * LoadableFrame
 *
 * @author Ian
 * @version 1.0
 */
public class LoadableFrame extends JInternalFrame {
    public LoadableFrame(String title) {
        super(title, true, true, true, true);
        setLayout(new BorderLayout(0, 0));
    }

    public void load() {
        pack();
        setVisible(true);
    }
}
