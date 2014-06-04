package iitc.projects.bot;

import iitc.projects.bot.input.BotController;
import iitc.projects.bot.input.BotInputHandler;

import javax.swing.*;
import java.applet.Applet;
import java.awt.*;

/**
 * BotInstance
 *
 * @author Ian
 * @version 1.0
 */
public abstract class BotInstance extends JPanel implements LoadListener {
    private Applet applet;
    private Component loading;

    public BotInstance() {
    }

    public BotInstance(Component loading) {
        this.loading = loading;
        add(loading);
    }

    protected abstract void load(BotPanel parent);

    public Applet getApplet() {
        return applet;
    }

    public void setApplet(Applet applet) {
        this.applet = applet;
    }

    @Override
    public void onLoad(BotPanel parent) {
        Applet applet = getApplet();
        if (applet != null) {
            if (loading != null)
                remove(loading);
            add(applet);
            parent.update(new BotController(new BotInputHandler(this)));
            parent.pack();
        } else
            throw new Error("Failure to load.");
    }
}
