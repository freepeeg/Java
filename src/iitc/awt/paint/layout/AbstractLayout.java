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
    /**
     * {@inheritDoc}
     */
    @Override
    public void revalidate(RObject object, Graphics graphics) {
        doLayout(object, graphics);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addLayoutComponent(RObject object, Object constraints) {

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void removeLayoutComponent(RObject object) {

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void removeLayoutComponent(Object constraint) {

    }

}
