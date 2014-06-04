package iitc.projects.bot;

import iitc.swing.Desktop;

/**
 * BotFrame
 *
 * @author Ian
 * @version 1.0
 */
public class BotFrame<B extends BotPanel> extends Desktop<B> {
    public BotFrame() {
    }

    public BotFrame(String title) {
        super(title);
    }

    @Override
    public void add(B panel) {
        super.add(panel);
        panel.load();
    }
}
