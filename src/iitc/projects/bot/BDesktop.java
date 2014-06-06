package iitc.projects.bot;

import iitc.swing.Desktop;

/**
 * BDesktop
 *
 * @author Ian
 * @version 1.0
 */
public class BDesktop<B extends BFrame> extends Desktop<B> {
    public BDesktop() {
    }

    public BDesktop(String title) {
        super(title);
    }

    @Override
    public void add(B panel) {
        super.add(panel);
        panel.load();
    }
}
