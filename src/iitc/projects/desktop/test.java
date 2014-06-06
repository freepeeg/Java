package iitc.projects.desktop;

import iitc.projects.desktop.input.Manager;
import iitc.projects.desktop.input.StateBasedInputHandler;
import iitc.projects.desktop.input.toolbar.BasicInputControlToolBar;

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
        BPanel<Applet, Manager, BasicInputControlToolBar<Manager>, BFrame<Manager, BasicInputControlToolBar<Manager>>> instance = new BPanel<Applet, Manager, BasicInputControlToolBar<Manager>, BFrame<Manager, BasicInputControlToolBar<Manager>>>() {
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
        BFrame<Manager, BasicInputControlToolBar<Manager>> b = new
                BFrame<Manager, BasicInputControlToolBar<Manager>>("Bot Tab 1", instance) {
                    @Override
                    public BasicInputControlToolBar<Manager> getToolBar() {
                        return new BasicInputControlToolBar<>(FlowLayout.CENTER, 5, 5);
                    }
                };
        desktop.add(b);
    }
}
