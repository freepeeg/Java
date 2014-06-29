package iitc.awt.paint;

import java.awt.*;
import java.awt.geom.RectangularShape;

/**
 * RObject
 *
 * @author Ian
 * @version 1.0
 */
public interface RObject extends EventContainer, Render {
    public static class Alignment {
        /**
         * Ease-of-use constant for <code>getAlignmentY()</code>.
         * Specifies an alignment to the top of the component.
         *
         * @see #getAlignmentY
         */
        public static final float TOP_ALIGNMENT = 0.0f;

        /**
         * Ease-of-use constant for <code>getAlignmentY</code> and
         * <code>getAlignmentX</code>. Specifies an alignment to
         * the center of the component
         *
         * @see #getAlignmentX
         * @see #getAlignmentY
         */
        public static final float CENTER_ALIGNMENT = 0.5f;

        /**
         * Ease-of-use constant for <code>getAlignmentY</code>.
         * Specifies an alignment to the bottom of the component.
         *
         * @see #getAlignmentY
         */
        public static final float BOTTOM_ALIGNMENT = 1.0f;

        /**
         * Ease-of-use constant for <code>getAlignmentX</code>.
         * Specifies an alignment to the left side of the component.
         *
         * @see #getAlignmentX
         */
        public static final float LEFT_ALIGNMENT = 0.0f;

        /**
         * Ease-of-use constant for <code>getAlignmentX</code>.
         * Specifies an alignment to the right side of the component.
         *
         * @see #getAlignmentX
         */
        public static final float RIGHT_ALIGNMENT = 1.0f;

    }

    public void add(RObject object);

    public void add(RObject object, Object constraints);

    public void remove(RObject object);

    public void remove(int index);

    public float getAlignmentX();

    public float getAlignmentY();

    public void setAlignmentX(float alignment);

    public void setAlignmentY(float alignment);

    public LayoutManager getLayout();

    public void setLayout(LayoutManager manager);

    public RectangularShape getShape(Graphics graphics);

    public void resizeCurrentShape(Dimension size);

    public void setShape(RectangularShape shape);

    public RectangularShape getPreferredShape(Graphics graphics);

    public void resizedPreferredShape(Graphics graphics, Dimension size);

    public void setPreferredShape(RectangularShape shape);

    public void resizeMinimumShape(Graphics graphics, Dimension size);

    public void setMinimumShape(RectangularShape shape);

    public RectangularShape getMinimumShape(Graphics graphics);

    public void resizeMaximumShape(Graphics graphics, Dimension size);

    public void setMaximumShape(RectangularShape shape);

    public RectangularShape getMaximumShape(Graphics graphics);

    public int getLocalX();

    public int getLocalY();

    public int getRealX();

    public int getRealY();

    public int getWidth();

    public int getHeight();

    public Point getOffset();

    public void setOffset(Point p);

    public void setOffset(int x, int y);

    public void setOffsetRelativeTo(RObject object);

    public RObject getParent();

    public void setParent(RObject parent);

    public RObject[] getObjects();

    public int getObjectCount();

    public RObject getObjectAt(Point p);

    public RObject getObjectAt(int x, int y);

    public boolean contains(Point p);

    public boolean contains(int x, int y);

    public Insets getInsets();

    public void setInsets(Insets insets);

    public Color getBackground();

    public void setBackground(Color color);

    public Color getColor();

    public void setColor(Color color);

    public boolean isClosed();

    public void setClosed(boolean closed);

    public boolean isClosable();

    public void setClosable(boolean closable);

    public void pack();

    public boolean isVisible();

    public void setVisible(boolean visible);
}
