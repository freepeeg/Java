package iitc.awt.paint.layout;

import iitc.awt.paint.RObject;

import java.awt.*;
import java.awt.geom.RectangularShape;

/**
 * BorderLayout
 *
 * @author Ian
 * @version 1.0
 */
public class BorderLayout extends AbstractLayout {
    private RObject north;
    private RObject south;
    private RObject center;
    private RObject west;
    private RObject east;
    public static int NORTH = 0;
    public static int SOUTH = 1;
    public static int EAST = 2;
    public static int WEST = 3;
    public static int CENTER = 4;
    private static final Rectangle ZERO = new Rectangle(0, 0);

    /**
     * {@inheritDoc}
     */
    @Override
    public Dimension preferredLayout(RObject object, Graphics graphics) {
        RectangularShape north = this.north == null ? ZERO : this.north.getPreferredShape(graphics);
        RectangularShape south = this.south == null ? ZERO : this.south.getPreferredShape(graphics);
        RectangularShape east = this.east == null ? ZERO : this.east.getPreferredShape(graphics);
        RectangularShape west = this.west == null ? ZERO : this.west.getPreferredShape(graphics);
        RectangularShape center = this.center == null ? ZERO : this.center.getPreferredShape(graphics);
        int maxX = (int) Math.max(Math.max(north.getWidth(), south.getWidth()), east.getWidth() + west.getWidth() + center.getWidth());
        int maxY = (int) (north.getHeight() + south.getHeight() + Math.max(Math.max(west.getHeight(), east.getHeight()), center.getHeight()));
        return new Dimension(maxX, maxY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Dimension minimumLayout(RObject object, Graphics graphics) {
        RectangularShape north = this.north == null ? ZERO : this.north.getMinimumShape(graphics);
        RectangularShape south = this.south == null ? ZERO : this.south.getMinimumShape(graphics);
        RectangularShape east = this.east == null ? ZERO : this.east.getMinimumShape(graphics);
        RectangularShape west = this.west == null ? ZERO : this.west.getMinimumShape(graphics);
        RectangularShape center = this.center == null ? ZERO : this.center.getMinimumShape(graphics);
        int maxX = (int) Math.max(Math.max(north.getWidth(), south.getWidth()), east.getWidth() + west.getWidth() + center.getWidth());
        int maxY = (int) (north.getHeight() + south.getHeight() + Math.max(Math.max(west.getHeight(), east.getHeight()), center.getHeight()));
        return new Dimension(maxX, maxY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Dimension layout(RObject object, Graphics graphics) {
        RectangularShape north = this.north == null ? ZERO : this.north.getShape(graphics);
        RectangularShape south = this.south == null ? ZERO : this.south.getShape(graphics);
        RectangularShape east = this.east == null ? ZERO : this.east.getShape(graphics);
        RectangularShape west = this.west == null ? ZERO : this.west.getShape(graphics);
        RectangularShape center = this.center == null ? ZERO : this.center.getShape(graphics);
        int maxX = (int) Math.max(Math.max(north.getWidth(), south.getWidth()), east.getWidth() + west.getWidth() + center.getWidth());
        int maxY = (int) (north.getHeight() + south.getHeight() + Math.max(Math.max(west.getHeight(), east.getHeight()), center.getHeight()));
        return new Dimension(maxX, maxY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void doLayout(RObject object, Graphics graphics) {
        //TODO:Object resizing to fill each section with dynamic resizing with non visible/existant sections
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void removeLayoutComponent(RObject object) {
        if (object == null)
            return;
        if (object.equals(north))
            north = null;
        if (object.equals(south))
            south = null;
        if (object.equals(east))
            east = null;
        if (object.equals(west))
            west = null;
        if (object.equals(center))
            center = null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void removeLayoutComponent(Object constraint) {
        setByConstraint(constraint, null);
    }

    /**
     * Retrieves the object corresponding to the given <code>constraint</code> and assigns it to <code>newValue</code>.
     */
    private void setByConstraint(Object constraint, RObject newValue) {
        if (constraint instanceof Integer) {
            int i = (int) constraint;
            switch (i) {
                case 0:
                    north = newValue;
                    break;
                case 1:
                    south = newValue;
                    break;
                case 2:
                    east = newValue;
                    break;
                case 3:
                    west = newValue;
                    break;
                default:
                    center = newValue;
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addLayoutComponent(RObject object, Object constraint) {
        setByConstraint(constraint, object);
    }
}
