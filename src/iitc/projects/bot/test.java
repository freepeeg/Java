package iitc.projects.bot;

import iitc.projects.bot.input.Manager;
import iitc.projects.bot.input.StateBasedInputHandler;

import java.applet.Applet;
import java.awt.*;
import java.io.IOException;

/**
 * test
 *
 * @author Ian
 * @version 1.0
 */
public class test {
    public static void main(String... args) throws IOException {
        BDesktop desktop = new BDesktop("New Desktop");
        desktop.setBackground(Color.black);
        desktop.setPreferredSize(500, 500);
        desktop.pack();
        desktop.center();
        desktop.setVisible(true);
        BPanel<Applet, Manager, BFrame<Manager>> instance = new BPanel<Applet, Manager, BFrame<Manager>>() {
            @Override
            protected void load(BFrame parent) {
                System.out.println("Loading bot instance.");
                Applet applet = new Applet();
                applet.setPreferredSize(new Dimension(400, 400));
                applet.setBackground(Color.blue);
                setComponent(applet);
            }

            @Override
            public Manager getManager() {
                return new Manager(new StateBasedInputHandler(this));
            }
        };
        instance.setPreferredSize(new Dimension(500, 200));
        BFrame<Manager> b = new BFrame<>("Bot Tab 1", instance);
        desktop.add(b);
    }
}
