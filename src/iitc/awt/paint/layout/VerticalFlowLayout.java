package iitc.awt.paint.layout;

import iitc.awt.paint.RObject;

import java.awt.*;
import java.awt.geom.RectangularShape;

/**
 * VerticalFlowLayout
 *
 * @author Ian
 * @version 1.0
 */
public class VerticalFlowLayout extends AbstractLayout {
    private int align;
    private int hgap;
    private int vgap;
    /**
     * This value indicates that each column of components
     * should be top-justified.
     */
    public static final int TOP = 0;

    /**
     * This value indicates that each column of components
     * should be centered.
     */
    public static final int CENTER = 1;

    /**
     * This value indicates that each column of components
     * should be bottom-justified.
     */
    public static final int BOTTOM = 2;

    public VerticalFlowLayout() {
        this(CENTER, 5, 5);
    }

    public VerticalFlowLayout(int alignment, int hgap, int vgap) {
        this.align = alignment;
        this.hgap = hgap;
        this.vgap = vgap;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Dimension preferredLayout(RObject object, Graphics graphics) {
        Dimension dim = new Dimension(0, 0);
        boolean noTopNeighbor = true;
        for (RObject c : object.getObjects()) {
            if (c.isVisible()) {
                RectangularShape shape = c.getPreferredShape(graphics);
                dim.height = Math.max(dim.height, (int) shape.getHeight());
                if (noTopNeighbor)
                    noTopNeighbor = false;
                else
                    dim.height += vgap;
                dim.width += shape.getHeight();
            }
        }
        Insets insets = object.getInsets();
        dim.width += insets.left + insets.right + hgap * 2;
        dim.height += insets.top + insets.bottom + vgap * 2;
        return dim;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Dimension minimumLayout(RObject object, Graphics graphics) {
        Dimension dim = new Dimension(0, 0);
        boolean noTopNeighbor = true;
        for (RObject c : object.getObjects()) {
            if (c.isVisible()) {
                RectangularShape shape = c.getMinimumShape(graphics);
                dim.height = Math.max(dim.height, (int) shape.getHeight());
                if (noTopNeighbor)
                    noTopNeighbor = false;
                else
                    dim.height += vgap;
                dim.width += shape.getWidth();
            }
        }
        Insets insets = object.getInsets();
        dim.width += insets.left + insets.right + hgap * 2;
        dim.height += insets.top + insets.bottom + vgap * 2;
        return dim;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Dimension layout(RObject object, Graphics graphics) {
        Dimension dim = new Dimension(0, 0);
        boolean noTopNeighbor = true;
        for (RObject c : object.getObjects()) {
            if (c.isVisible()) {
                RectangularShape shape = c.getShape(graphics);
                dim.height = Math.max(dim.height, (int) shape.getHeight());
                if (noTopNeighbor)
                    noTopNeighbor = false;
                else
                    dim.height += vgap;
                dim.width += shape.getHeight();
            }
        }
        Insets insets = object.getInsets();
        dim.width += insets.left + insets.right + hgap * 2;
        dim.height += insets.top + insets.bottom + vgap * 2;
        return dim;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void doLayout(RObject object, Graphics graphics) {
        //TODO:Implement multi-column support for oversized child objects
        Insets insets = object.getInsets();
        Dimension uptake = layout(object, graphics);
        //strip irrelevant gaps to get proper size
        uptake.setSize(uptake.width - (insets.left + insets.right + hgap * 2), uptake.height - (insets.top + insets.bottom + vgap * 2));
        int leftX = insets.right;
        int topY = 0;
        switch (align) {
            case TOP:
                topY += insets.top;
                break;
            case CENTER:
                topY += ((object.getHeight() - uptake.height) / 2);
                break;
            case BOTTOM:
                topY += (object.getHeight() - uptake.height - insets.bottom);
                break;
        }
        for (RObject child : object.getObjects()) {
            child.setOffset(leftX, topY);
            leftX += child.getWidth();
            topY -= child.getHeight();
        }
    }
}
