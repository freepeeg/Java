package iitc.awt.paint.layout;

import iitc.awt.paint.RObject;

import java.awt.*;

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
    private static final Dimension ZERO = new Dimension(0, 0);

    @Override
    public Dimension preferredLayout(RObject object, Graphics graphics) {
        Dimension north = this.north == null ? ZERO : this.north.getPreferredSize(graphics);
        Dimension south = this.south == null ? ZERO : this.south.getPreferredSize(graphics);
        Dimension east = this.east == null ? ZERO : this.east.getPreferredSize(graphics);
        Dimension west = this.west == null ? ZERO : this.west.getPreferredSize(graphics);
        Dimension center = this.center == null ? ZERO : this.center.getPreferredSize(graphics);
        int maxX = Math.max(Math.max(north.width, south.width), east.width + west.width + center.width);
        int maxY = north.height + south.height + Math.max(Math.max(west.height, east.height), center.height);
        return new Dimension(maxX, maxY);
    }

    @Override
    public Dimension minimumLayout(RObject object, Graphics graphics) {
        Dimension north = this.north == null ? ZERO : this.north.getMinimumSize(graphics);
        Dimension south = this.south == null ? ZERO : this.south.getMinimumSize(graphics);
        Dimension east = this.east == null ? ZERO : this.east.getMinimumSize(graphics);
        Dimension west = this.west == null ? ZERO : this.west.getMinimumSize(graphics);
        Dimension center = this.center == null ? ZERO : this.center.getMinimumSize(graphics);
        int maxX = Math.max(Math.max(north.width, south.width), east.width + west.width + center.width);
        int maxY = north.height + south.height + Math.max(Math.max(west.height, east.height), center.height);
        return new Dimension(maxX, maxY);
    }

    @Override
    public Dimension layout(RObject object, Graphics graphics) {
        Dimension north = this.north == null ? ZERO : this.north.getSize(graphics);
        Dimension south = this.south == null ? ZERO : this.south.getSize(graphics);
        Dimension east = this.east == null ? ZERO : this.east.getSize(graphics);
        Dimension west = this.west == null ? ZERO : this.west.getSize(graphics);
        Dimension center = this.center == null ? ZERO : this.center.getSize(graphics);
        int maxX = Math.max(Math.max(north.width, south.width), east.width + west.width + center.width);
        int maxY = north.height + south.height + Math.max(Math.max(west.height, east.height), center.height);
        return new Dimension(maxX, maxY);
    }


    @Override
    public void doLayout(RObject object, Graphics graphics) {
        //TODO:Object resizing to fill each section with dynamic resizing with non visible/existant sections
    }

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

    @Override
    public void removeLayoutComponent(Object constraint) {
        setByConstraint(constraint, null);
    }

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

    @Override
    public void addLayoutComponent(RObject object, Object constraint) {
        setByConstraint(constraint, object);
    }
}
