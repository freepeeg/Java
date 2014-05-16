package iitc.swing;

import javax.swing.*;
import java.awt.*;

/**
 * LoadablePanel
 *
 * @author Ian
 * @version 1.0
 */
public class LoadablePanel<T extends Component, T1 extends Component> extends JPanel {
    private T splashScreen;
    private T1 mainComponent;

    public LoadablePanel(T splashScreen, T1 mainComponent) {
        this.splashScreen = splashScreen;
        this.mainComponent = mainComponent;
        add(splashScreen);
    }

    protected T getSplashScreen() {
        return splashScreen;
    }

    protected T1 getMainComponent() {
        return mainComponent;
    }

    public void load() {
        remove(getSplashScreen());
        add(getMainComponent());
        revalidate();
    }
}
