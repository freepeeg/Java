package iitc.swing.desktop;

import iitc.swing.Desktop;

/**
 * BDesktop
 *
 * @author Ian
 * @version 1.0
 */
public class BDesktop extends Desktop<BFrame> {
    public BDesktop() {
    }

    public BDesktop(String title) {
        super(title);
    }

    @Override
    public void add(BFrame panel) {
        super.add(panel);
        panel.load();
    }
}
