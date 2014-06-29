package iitc.awt.paint.layout;

import iitc.awt.paint.RObject;

import java.awt.*;

/**
 * FreestyleLayout
 * <p/>
 * Draws all child components at their preset position. FreestyleLayout does not layout any components to any specific constraints. They are simply clipped within the parent object
 *
 * @author Ian
 * @version 1.0
 */
public class FreestyleLayout extends AbstractLayout {
    @Override
    public Dimension preferredLayout(RObject object, Graphics graphics) {
        return null;
    }

    @Override
    public Dimension minimumLayout(RObject object, Graphics graphics) {
        return null;
    }

    @Override
    public Dimension layout(RObject object, Graphics graphics) {
        return null;
    }

    @Override
    public void doLayout(RObject object, Graphics graphics) {

    }
}
