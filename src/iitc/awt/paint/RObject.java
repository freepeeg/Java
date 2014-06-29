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
         * Specifies an alignment to the top of the object.
         *
         * @see #getAlignmentY
         */
        public static final float TOP_ALIGNMENT = 0.0f;

        /**
         * Ease-of-use constant for <code>getAlignmentY</code> and
         * <code>getAlignmentX</code>. Specifies an alignment to
         * the center of the object
         *
         * @see #getAlignmentX
         * @see #getAlignmentY
         */
        public static final float CENTER_ALIGNMENT = 0.5f;

        /**
         * Ease-of-use constant for <code>getAlignmentY</code>.
         * Specifies an alignment to the bottom of the object.
         *
         * @see #getAlignmentY
         */
        public static final float BOTTOM_ALIGNMENT = 1.0f;

        /**
         * Ease-of-use constant for <code>getAlignmentX</code>.
         * Specifies an alignment to the left side of the object.
         *
         * @see #getAlignmentX
         */
        public static final float LEFT_ALIGNMENT = 0.0f;

        /**
         * Ease-of-use constant for <code>getAlignmentX</code>.
         * Specifies an alignment to the right side of the object.
         *
         * @see #getAlignmentX
         */
        public static final float RIGHT_ALIGNMENT = 1.0f;

    }

    /**
     * Appends the specified object to the end of this container.
     *
     * @param object the object to be added
     */
    public void add(RObject object);

    /**
     * Adds the specified object to the end of this container.
     * Also notifies the layout manager to add the object to
     * this container's layout using the specified constraints object.
     *
     * @param object      the object to be added
     * @param constraints an object expressing
     *                    layout contraints for this object
     * @see LayoutManager
     */
    public void add(RObject object, Object constraints);

    /**
     * Removes the specified object from this container.
     * This method also notifies the layout manager to remove the
     * object from this container's layout via the
     * <code>removeLayoutComponent</code> method.
     *
     * @param object the object to be removed
     * @see #add
     */
    public void remove(RObject object);

    /**
     * Removes the object, specified by <code>index</code>,
     * from this container.
     * This method also notifies the layout manager to remove the
     * object from this container's layout via the
     * <code>removeLayoutObject</code> method.
     *
     * @param index the index of the object to be removed
     * @throws ArrayIndexOutOfBoundsException if {@code index} is not in
     *                                        range {@code [0, getObjectCount()-1]}
     * @see #add
     * @see #getObjectCount
     * @see #remove(iitc.awt.paint.RObject)
     */
    public void remove(int index);

    /**
     * Returns the alignment along the x axis.  This specifies how
     * the object would like to be aligned relative to other
     * objects.  The value should be a number between 0 and 1
     * where 0 represents alignment along the origin, 1 is aligned
     * the furthest away from the origin, 0.5 is centered, etc.
     */
    public float getAlignmentX();

    /**
     * Returns the alignment along the y axis.  This specifies how
     * the object would like to be aligned relative to other
     * objects.  The value should be a number between 0 and 1
     * where 0 represents alignment along the origin, 1 is aligned
     * the furthest away from the origin, 0.5 is centered, etc.
     */
    public float getAlignmentY();

    /**
     * Sets the the vertical alignment.
     *
     * @param alignment the new vertical alignment
     * @see #getAlignmentX
     */
    public void setAlignmentX(float alignment);

    /**
     * Sets the the horizontal alignment.
     *
     * @param alignment the new horizontal alignment
     * @see #getAlignmentY
     */
    public void setAlignmentY(float alignment);

    /**
     * Gets the layout manager for this container.
     *
     * @see #setLayout
     */
    public LayoutManager getLayout();

    /**
     * Sets the layout manager for this object.
     *
     * @param manager the specified layout manager
     * @see #getLayout
     */
    public void setLayout(LayoutManager manager);

    /**
     * Returns the current size of the object, reliant of the graphics context
     *
     * @param graphics the context for rendering
     * @return the current shape set for rendering
     * @see #setShape
     */
    public RectangularShape getShape(Graphics graphics);

    /**
     * Resizes the shape to a desired constant size. If the shape
     * is null, a default shape will be rendered and then sized.
     *
     * @param size the desired size of the shape
     * @see #getShape
     */
    public void resizeCurrentShape(Dimension size);

    /**
     * Sets the preferred shape of this object to a constant
     * object. Setting the preferred shape to <code>null</code>
     * results in no action being performed
     *
     * @param shape a desired <code>RectangularShape</code>
     */
    public void setShape(RectangularShape shape);

    /**
     * If the <code>preferredShape</code> has been set to a
     * non-<code>null</code> value it just returns it.
     * If the LayoutManager's <code>preferredLayout</code>
     * method returns a non <code>null</code> value then return that.
     *
     * @param graphics the context for rendering
     * @return the value of the <code>preferredShape</code>
     * @see #setPreferredShape
     */
    public RectangularShape getPreferredShape(Graphics graphics);

    /**
     * Resizes the preferred shape to a desired constant size. If the preferred shape
     * is null, a default shape will be rendered and then sized.
     *
     * @param graphics the context for rendering
     * @param size     the desired size of the preferred shape
     * @see #getPreferredShape
     */
    public void resizePreferredShape(Graphics graphics, Dimension size);

    /**
     * Sets the preferred shape of this object to a constant
     * object. Setting the preferred shape to <code>null</code>
     * restores the default behavior. Calling <code>pack()</code>
     * will subsequently call this method.
     *
     * @param shape a <code>RectangularShape</code> depicting the preferred shape
     * @see #pack()
     */
    public void setPreferredShape(RectangularShape shape);

    /**
     * Resizes the minimum shape to a desired constant size. If the minimum shape
     * is null, a default shape will be rendered and then sized.
     *
     * @param graphics the context for rendering
     * @param size     the desired size of the minimum shape
     * @see #getMinimumShape
     */
    public void resizeMinimumShape(Graphics graphics, Dimension size);

    /**
     * Sets the minimum shape of this object to a constant
     * object.  Setting the minimum shape to <code>null</code>
     * restores the default behavior.
     *
     * @param shape a <code>RectangularShape</code> depicting the minimum shape
     */
    public void setMinimumShape(RectangularShape shape);

    /**
     * If the minimum size has been set to a non-<code>null</code> value
     * just returns it.  If the LayoutManager's <code>minimumLayout</code>
     * method returns a non-<code>null</code> value then return that.
     *
     * @param graphics the context for rendering
     * @return the minimum renderable size
     * @see #setMinimumShape
     */
    public RectangularShape getMinimumShape(Graphics graphics);

    /**
     * Resizes the maximum shape to a desired constant size. If the maximum shape
     * is null, a default shape will be rendered and then sized.
     *
     * @param graphics the context for rendering
     * @param size     the desired size of the maximum shape
     * @see #getMaximumShape
     */
    public void resizeMaximumShape(Graphics graphics, Dimension size);

    /**
     * Sets the maximum shape of this object to a constant
     * object.  Setting the maximum shape to <code>null</code>
     * restores the default behavior.
     *
     * @param shape a <code>RectangularShape</code> depicting the maximum shape
     */
    public void setMaximumShape(RectangularShape shape);

    /**
     * If the <code>maximumShape</code> has been set to a
     * non-<code>null</code> value it just returns it.
     *
     * @param graphics the context for rendering
     * @return the value of the <code>maximumShape</code>
     * @see #setMaximumShape
     */
    public RectangularShape getMaximumShape(Graphics graphics);

    /**
     * Returns the X coordinate of the upper-left corner of
     * the framing rectangle.
     *
     * @return the X coordinate of the upper-left corner of
     * the framing rectangle.
     */
    public int getLocalX();

    /**
     * Returns the Y coordinate of the upper-left corner of
     * the framing rectangle.
     *
     * @return the Y coordinate of the upper-left corner of
     * the framing rectangle.
     */
    public int getLocalY();

    /**
     * Returns the X coordinate of the upper-left corner of
     * the uppermost parent framing rectangle.
     *
     * @return the X coordinate of the upper-left corner of
     * the framing rectangle.
     */
    public int getRealX();

    /**
     * Returns the Y coordinate of the upper-left corner of
     * the uppermost parent framing rectangle.
     *
     * @return the Y coordinate of the upper-left corner of
     * the framing rectangle.
     */
    public int getRealY();

    /**
     * Returns the width of the framing rectangle.
     *
     * @return the width of the framing rectangle.
     */
    public int getWidth();

    /**
     * Returns the height of the framing rectangle.
     *
     * @return the height of the framing rectangle.
     */
    public int getHeight();

    /**
     * Gets the location of this object in the form of a
     * point specifying the object's top-left corner.
     * The location will be relative to the parent's coordinate space.
     * <p/>
     *
     * @return an instance of <code>Point</code> representing
     * the top-left corner of the object's bounds in
     * the coordinate space of the object's parent
     */
    public Point getOffset();

    /**
     * Moves this object to a new location. The top-left corner of
     * the new location is specified by point <code>p</code>. Point
     * <code>p</code> is given in the parent's coordinate space.
     * <p/>
     * This method changes layout-related information, and therefore,
     * invalidates the object hierarchy.
     *
     * @param p the point defining the top-left corner
     *          of the new location, given in the coordinate space of this
     *          object's parent
     */
    public void setOffset(Point p);

    /**
     * Moves this object to a new location. The top-left corner of
     * the new location is specified by the <code>x</code> and <code>y</code>
     * parameters in the coordinate space of this object's parent.
     *
     * @param x the <i>x</i>-coordinate of the new location's
     *          top-left corner in the parent's coordinate space
     * @param y the <i>y</i>-coordinate of the new location's
     *          top-left corner in the parent's coordinate space
     */
    public void setOffset(int x, int y);

    /**
     * Sets the location of the object relative to the specified
     * object.
     *
     * @param object the object in relation to which the window's location
     *               is determined, if <code>null</code>, it will set it's
     *               offset relative to it's oldest relative
     */
    public void setOffsetRelativeTo(RObject object);

    /**
     * Gets the parent of this object.
     *
     * @return the parent container of this object
     */
    public RObject getParent();

    /**
     * Sets the parent of the object to the specified <code>RObject</code>.
     *
     * @param parent the desired new parent of this object
     */
    public void setParent(RObject parent);

    /**
     * Gets all the objects in this container.
     *
     * @return an array of all the objects in this container.
     */
    public RObject[] getObjects();

    /**
     * Gets the number of objects in this panel.
     *
     * @return the number of objects in this panel.
     */
    public int getObjectCount();

    /**
     * Gets the object that contains the specified point.
     *
     * @param p the point.
     * @return returns the object that contains the point,
     * or <code>null</code> if the object does
     * not contain the point.
     */
    public RObject getObjectAt(Point p);

    /**
     * Locates the object that contains the x,y position.  The
     * top-most child object is returned in the case where there
     * is overlap in the objects.  This is determined by finding
     * the object closest to the index <code>getObjectCount() - 1</code> that claims to contain
     * the given point.
     *
     * @param x the <i>x</i> coordinate
     * @param y the <i>y</i> coordinate
     * @return null if the object does not contain the position.
     * If there is no child object at the requested point and the
     * point is within the bounds of the container the container itself
     * is returned; otherwise the top-most child is returned.
     */
    public RObject getObjectAt(int x, int y);

    /**
     * Tests if a specified <code>Point</code> is inside the boundary
     * of the <code>RObject</code>.
     *
     * @param p the specified <code>Point</code> to be tested
     * @return <code>true</code> if the specified <code>Point</code> is
     * inside the boundary of the <code>RObject</code>;
     * <code>false</code> otherwise.
     */
    public boolean contains(Point p);

    /**
     * Tests if the specified coordinates are inside the boundary of the
     * <code>RObject</code>.
     *
     * @param x the specified X coordinate to be tested
     * @param y the specified Y coordinate to be tested
     * @return <code>true</code> if the specified coordinates are inside
     * the <code>RObject</code>; <code>false</code>
     * otherwise.
     */
    public boolean contains(int x, int y);

    /**
     * Returns the insets of this container. Insets usually is the space that
     * is occupied by things like borders.
     *
     * @return the insets of this container
     */
    public Insets getInsets();

    /**
     * Sets the insets of this object.
     *
     * @param insets the desired <code>Insets</code>
     */
    public void setInsets(Insets insets);

    /**
     * Gets the background color of this object.
     *
     * @return this object's background color; if this object does
     * not have a background color,
     * the background color of its parent is returned
     * @see #setBackground
     */
    public Color getBackground();

    /**
     * Sets the background color of this object.
     *
     * @param color the desired background <code>Color</code>
     */
    public void setBackground(Color color);

    /**
     * Gets the foreground color of this object.
     *
     * @return this object's foreground color; if this object does
     * not have a foreground color,
     * the foreground color of its parent is returned
     * @see #setColor
     */
    public Color getColor();

    /**
     * Sets the foreground color of this object.
     *
     * @param color the desired bforeground <code>Color</code>
     */
    public void setColor(Color color);

    /**
     * Returns whether this <code>RObject</code> is currently closed.
     *
     * @return <code>true</code> if this object is closed, <code>false</code> otherwise
     */
    public boolean isClosed();

    /**
     * Closes this object if the argument is <code>true</code>.
     * If the object is already closed,
     * this method does nothing and returns immediately.
     *
     * @param closed must be <code>true</code>
     * @see #isClosed()
     */
    public void setClosed(boolean closed);

    /**
     * Returns whether this <code>RObject</code> can be closed by
     * some user action.
     *
     * @return <code>true</code> if this object can be closed
     */
    public boolean isClosable();

    /**
     * Sets whether this <code>RObject</code> can be closed by
     * some user action.
     *
     * @param closable a boolean value, where <code>true</code> means this object can be closed
     */
    public void setClosable(boolean closable);

    /**
     * Causes children of this <code>RObject</code>
     * to be laid out at their preferred size.
     */
    public void pack();

    /**
     * Determines whether this object should be visible when its
     * parent is visible. Objects are
     * initially visible.
     *
     * @return <code>true</code> if the object is visible,
     * <code>false</code> otherwise
     * @see #setVisible
     */
    public boolean isVisible();

    /**
     * Shows or hides this object depending on the value of parameter
     * <code>visible</code>.
     * <p/>
     *
     * @param visible if <code>true</code>, shows this object;
     *                otherwise, hides this object
     * @see #isVisible
     */
    public void setVisible(boolean visible);
}
