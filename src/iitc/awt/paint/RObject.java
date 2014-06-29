package iitc.awt.paint;

import java.awt.*;
import java.awt.event.ComponentListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelListener;

/**
 * RObject
 *
 * @author Ian
 * @version 1.0
 */
public interface RObject extends Render {
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

    public void add(RObject object, float alignment);

    public void remove(RObject object);

    public void remove(int index);

    public float getAlignmentX();

    public float getAlignmentY();

    public void setAlignmentX(float alignment);

    public void setAlignmentY(float alignment);

    public LayoutManager getLayout();

    public void setLayout(LayoutManager manager);

    public Dimension getSize(Graphics graphics);

    public void setSize(Dimension dimension);

    public Dimension getPreferredSize(Graphics graphics);

    public void setPreferredSize(Graphics graphics, Dimension dimension);

    public int getX();

    public int getY();

    public int getWidth();

    public int getHeight();

    public Point getLocation();

    public void setLocation(Point p);

    public void setLocation(int x, int y);

    public void setLocationRelativeTo(RObject object);

    public RObject[] getObjects();

    public int getRObjectCount();

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

    public MouseListener[] getMouseListeners();

    public MouseMotionListener[] getMouseMotionListeners();

    public MouseWheelListener[] getMouseWheelListeners();

    public ComponentListener[] getComponentListeners();
}
