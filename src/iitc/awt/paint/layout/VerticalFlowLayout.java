package iitc.awt.paint.layout;

import iitc.awt.paint.RObject;

import java.awt.*;

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

    @Override
    public Dimension preferredLayout(RObject object, Graphics graphics) {
        Dimension dim = new Dimension(0, 0);
        boolean noTopNeighbor = true;
        for (RObject c : object.getObjects()) {
            if (c.isVisible()) {
                Dimension d = c.getPreferredSize(graphics);
                dim.height = Math.max(dim.height, d.height);
                if (noTopNeighbor)
                    noTopNeighbor = false;
                else
                    dim.height += vgap;
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
        boolean noTopNeighbor = true;
        for (RObject c : object.getObjects()) {
            if (c.isVisible()) {
                Dimension d = c.getMinimumSize(graphics);
                dim.height = Math.max(dim.height, d.height);
                if (noTopNeighbor)
                    noTopNeighbor = false;
                else
                    dim.height += vgap;
                dim.width += d.width;
            }
        }
        Insets insets = object.getInsets();
        dim.width += insets.left + insets.right + hgap * 2;
        dim.height += insets.top + insets.bottom + vgap * 2;
        return dim;
    }

    @Override
    public Dimension layout(RObject object, Graphics graphics) {
        Dimension dim = new Dimension(0, 0);
        boolean noTopNeighbor = true;
        for (RObject c : object.getObjects()) {
            if (c.isVisible()) {
                Dimension d = c.getSize(graphics);
                dim.height = Math.max(dim.height, d.height);
                if (noTopNeighbor)
                    noTopNeighbor = false;
                else
                    dim.height += vgap;
                dim.width += d.width;
            }
        }
        Insets insets = object.getInsets();
        dim.width += insets.left + insets.right + hgap * 2;
        dim.height += insets.top + insets.bottom + vgap * 2;
        return dim;
    }

    @Override
    public void doLayout(RObject object, Graphics graphics) {
        Insets insets = object.getInsets();
        Dimension size = object.getSize(graphics);
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
                topY += ((size.height - uptake.height) / 2);
                break;
            case BOTTOM:
                topY += (size.height - uptake.height - insets.bottom);
                break;
        }
        for (RObject child : object.getObjects()) {
            child.setLocation(leftX, topY);
            leftX += child.getWidth();
            topY -= child.getHeight();
        }

    }
}
