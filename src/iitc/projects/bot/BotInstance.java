package iitc.projects.bot;

import iitc.projects.bot.input.BotInputHandler;
import iitc.projects.bot.input.BotManager;

import javax.swing.*;
import java.applet.Applet;
import java.awt.*;

/**
 * BotInstance
 *
 * @author Ian
 * @version 1.0
 */
public abstract class BotInstance<B2 extends BotManager, B3 extends BotPanel<BotInstance<B2, B3>, B2>> extends JPanel implements LoadListener<BotInstance<B2, B3>, B2, B3> {
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

    public abstract B2 getManager();

    @Override
    public void onLoad(B3 parent) {
        Applet applet = getApplet();
        if (applet != null) {
            if (loading != null)
                remove(loading);
            add(applet);
            parent.update(getManager());
            BotInputHandler handler = parent.getManager().getHandler();
            System.out.println(handler.getInputState());
            handler.setState(BotInputHandler.State.KEY);
            parent.pack();
        } else
            throw new Error("Failure to load.");
    }
}
