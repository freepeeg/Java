package iitc.awt.paint.layout;

import iitc.awt.paint.RObject;

import java.awt.*;

/**
 * FlowLayout
 *
 * @author Ian
 * @version 1.0
 */
public class FlowLayout extends AbstractLayout {
    private int align;
    private int hgap;
    private int vgap;
    /**
     * This value indicates that each row of components
     * should be left-justified.
     */
    public static final int LEFT = 0;

    /**
     * This value indicates that each row of components
     * should be centered.
     */
    public static final int CENTER = 1;

    /**
     * This value indicates that each row of components
     * should be right-justified.
     */
    public static final int RIGHT = 2;

    public FlowLayout() {
        this(CENTER, 5, 5);
    }

    public FlowLayout(int alignment, int hgap, int vgap) {
        this.align = alignment;
        this.hgap = hgap;
        this.vgap = vgap;
    }

    @Override
    public Dimension preferredLayout(RObject object, Graphics graphics) {
        Dimension dim = new Dimension(0, 0);
        boolean noLeftNeighbor = true;
        for (RObject c : object.getObjects()) {
            if (c.isVisible()) {
                Dimension d = c.getPreferredShape(graphics);
                dim.height = Math.max(dim.height, d.height);
                if (noLeftNeighbor)
                    noLeftNeighbor = false;
                else
                    dim.width += hgap;
                dim.width += d.width;
            }
        }
        Insets insets = object.getInsets();
        dim.width += insets.left + insets.right + hgap * 2;
        dim.height += insets.top + insets.bottom + vgap * 2;
        return dim;
    }

    @Override
    public Dimension minimumLayout(RObject object, Graphics graphics) {
        Dimension dim = new Dimension(0, 0);
        boolean noLeftNeighbor = true;
        for (RObject c : object.getObjects())
            if (c.isVisible()) {
                Dimension d = c.getMinimumShape(graphics);
                dim.height = Math.max(dim.height, d.height);
                if (noLeftNeighbor)
                    noLeftNeighbor = false;
                else
                    dim.width += hgap;
                dim.width += d.width;
            }
        Insets insets = object.getInsets();
        dim.width += insets.left + insets.right + hgap * 2;
        dim.height += insets.top + insets.bottom + vgap * 2;
        return dim;
    }

    @Override
    public Dimension layout(RObject object, Graphics graphics) {
        Dimension dim = new Dimension(0, 0);
        boolean noLeftNeighbor = true;
        for (RObject c : object.getObjects())
            if (c.isVisible()) {
                Dimension d = c.getShape(graphics);
                dim.height = Math.max(dim.height, d.height);
                if (noLeftNeighbor)
                    noLeftNeighbor = false;
                else
                    dim.width += hgap;
                dim.width += d.width;
            }
        Insets insets = object.getInsets();
        dim.width += insets.left + insets.right + hgap * 2;
        dim.height += insets.top + insets.bottom + vgap * 2;
        return dim;
    }

    @Override
    public void doLayout(RObject object, Graphics graphics) {
        //TODO:Implement multi-row support for oversized child objects
        Insets insets = object.getInsets();
        Dimension size = object.getShape(graphics);
        Dimension uptake = layout(object, graphics);
        //strip irrelevant gaps to get proper size
        uptake.setSize(uptake.width - (insets.left + insets.right + hgap * 2), uptake.height - (insets.top + insets.bottom + vgap * 2));
        int leftX = 0;
        switch (align) {
            case LEFT:
                leftX += insets.left;
                break;
            case CENTER:
                leftX += ((size.width - uptake.width) / 2);
                break;
            case RIGHT:
                leftX += (size.width - insets.right - uptake.width);
                break;
        }
        int topY = insets.top;
        for (RObject child : object.getObjects()) {
            child.setOffset(leftX, topY);
            leftX += child.getWidth();
            topY += child.getHeight();
        }

    }
}
