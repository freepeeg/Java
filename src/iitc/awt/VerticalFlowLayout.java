package iitc.awt;

import java.awt.*;

/**
 * VerticalFlowLayout
 * <p/>
 * <p >This is meant to be a direct representation of FlowLayout, just with the axes flipped.</p>
 *
 * @author Ian
 *         Original Authors of FlowLayout
 * @author Arthur van Hoff
 * @author Sami Shaio
 * @version 1.0
 */
public class VerticalFlowLayout implements LayoutManager {
    public static final int TOP = 0;
    public static final int CENTER = 1;
    public static final int BOTTOM = 2;
    private int align;
    private int hgap;
    private int vgap;

    public VerticalFlowLayout() {
        this(CENTER, 5, 5);
    }

    public VerticalFlowLayout(int align) {
        this(align, 5, 5);
    }

    public VerticalFlowLayout(int align, int hgap, int vgap) {
        this.align = align;
        this.hgap = hgap;
        this.vgap = vgap;
    }

    public int getAlignment() {
        return align;
    }

    public void setAlignment(int align) {
        this.align = align;
    }

    public int getHgap() {
        return hgap;
    }

    public void setHgap(int hgap) {
        this.hgap = hgap;
    }

    public int getVgap() {
        return vgap;
    }

    public void setVgap(int vgap) {
        this.vgap = vgap;
    }

    public void addLayoutComponent(String name, Component comp) {
    }

    public void removeLayoutComponent(Component comp) {
    }

    public Dimension preferredLayoutSize(Container target) {
        return layoutSize(target, target.getPreferredSize());
    }

    private Dimension layoutSize(Container target, Dimension targetDimension) {
        synchronized (target.getTreeLock()) {
            Dimension dim = new Dimension(0, 0);
            int members = target.getComponentCount();
            boolean firstVisibleComponent = true;
            for (int i = 0; i < members; i++) {
                Component m = target.getComponent(i);
                if (m.isVisible()) {
                    dim.width = Math.max(dim.width, targetDimension.width);
                    if (firstVisibleComponent)
                        firstVisibleComponent = false;
                    else
                        dim.height += vgap;
                    dim.height += targetDimension.height;
                }
            }
            Insets insets = target.getInsets();
            dim.width += insets.left + insets.right + hgap * 2;
            dim.height += insets.top + insets.bottom + vgap * 2;
            return dim;
        }
    }

    public Dimension minimumLayoutSize(Container target) {
        return layoutSize(target, target.getMinimumSize());
    }

    public void layoutContainer(Container target) {
        synchronized (target.getTreeLock()) {
            Insets insets = target.getInsets();
            int maxHeight = target.getSize().height - (insets.top + insets.bottom + vgap * 2);
            int nmembers = target.getComponentCount();
            int x = insets.left + hgap;
            int y = 0;
            int columnWidth = 0;
            int start = 0;
            boolean ttb = target.getComponentOrientation().isLeftToRight();
            for (int i = 0; i < nmembers; i++) {
                Component m = target.getComponent(i);
                if (m.isVisible()) {
                    Dimension d = m.getPreferredSize();
                    m.setSize(d.width, d.height);
                    if ((y == 0) || ((y + d.height) <= maxHeight)) {
                        if (y > 0)
                            y += vgap;
                        y += d.height;
                        columnWidth = Math.max(columnWidth, d.width);
                    } else {
                        moveComponents(target, x, insets.top + vgap, columnWidth, maxHeight - y, start, i, ttb);
                        y = d.height;
                        x += hgap + columnWidth;
                        columnWidth = d.width;
                        start = i;
                    }
                }
            }
            moveComponents(target, x, insets.top + vgap, columnWidth, maxHeight - y, start, nmembers, ttb);
        }
    }

    private void moveComponents(
            Container target, int x, int y, int width, int height, int columnStart, int columnEnd, boolean ttb) {
        switch (align) {
            case TOP:
                y += ttb ? 0 : height;
                break;
            case CENTER:
                y += height / 2;
                break;
            case BOTTOM:
                y += ttb ? height : 0;
                break;
        }

        for (int i = columnStart; i < columnEnd; i++) {
            Component m = target.getComponent(i);
            if (m.isVisible()) {
                int cx;
                cx = x + (width - m.getSize().width) / 2;
                if (ttb)
                    m.setLocation(cx, y);
                else
                    m.setLocation(cx, target.getSize().height - y - m.getSize().height);
                y += m.getSize().height + vgap;
            }
        }
    }

    public String toString() {
        StringBuilder str = new StringBuilder(getClass().getName() + "[hgap=" + hgap + ",vgap=" + vgap + ",align=");
        switch (align) {
            case TOP:
                str.append("top");
                break;
            case CENTER:
                str.append("center");
                break;
            case BOTTOM:
                str.append("bottom");
                break;
        }
        return str.append("]").toString();
    }
}