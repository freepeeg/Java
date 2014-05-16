package iitc.swing;

import iitc.im.Factory;

import java.awt.*;

/**
 * LazyLoadablePanel
 *
 * @author Ian
 * @version 1.0
 */
public class LazyLoadablePanel<T extends Component, T1 extends Factory<T2>, T2 extends Component> extends LoadablePanel<T, T2> {
    private T1 factory;

    public LazyLoadablePanel(T splashScreen, T1 factory) {
        super(splashScreen, null);
        this.factory = factory;
    }

    @Override
    public T2 getMainComponent() {
        return factory.generate();
    }
}
