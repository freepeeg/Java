package iitc.awt.paint.layout;

import iitc.awt.paint.LayoutManager;
import iitc.awt.paint.RObject;

import java.awt.*;

/**
 * AbstractLayout
 *
 * @author Ian
 * @version 1.0
 */
public abstract class AbstractLayout implements LayoutManager {
    @Override
    public void revalidate(RObject object, Graphics graphics) {
        doLayout(object, graphics);
    }

    @Override
    public void addLayoutComponent(RObject object, Object constraints) {

    }

    @Override
    public void removeLayoutComponent(RObject object) {

    }

    @Override
    public void removeLayoutComponent(Object constraint) {

    }

}
