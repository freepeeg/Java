package iitc.awt.paint;

import iitc.awt.ShapeTransform;
import iitc.awt.paint.event.ListEventContainer;
import iitc.awt.paint.layout.FreestyleLayout;

import java.awt.*;
import java.awt.event.ComponentListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelListener;
import java.awt.geom.RectangularShape;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * RAbstractObject
 * <p/>
 * Basic implementation of RObject. All sizing/positioning features will be left up to the subclasses of RAbstractObject.
 *
 * @author Ian
 * @version 1.0
 */
public abstract class RAbstractObject implements RObject {
    private LayoutManager manager;
    private EventContainer container;
    private java.util.List<RObject> children;
    private float alignX;
    private float alignY;
    private Insets insets;
    private boolean update;
    private boolean closable;
    private boolean closed;
    private Color foreground;
    private Color background;
    private boolean visible;
    private RObject parent;
    private RectangularShape current;
    private RectangularShape preferred;
    private RectangularShape minimum;
    private RectangularShape maximum;

    public RAbstractObject() {
        this(new FreestyleLayout());
    }

    public RAbstractObject(LayoutManager manager) {
        this.manager = manager;
        this.children = new CopyOnWriteArrayList<>();
        this.container = new ListEventContainer();
        this.alignX = Alignment.LEFT_ALIGNMENT;
        this.alignY = Alignment.TOP_ALIGNMENT;
        this.insets = new Insets(0, 0, 0, 0);
        this.closable = true;
        this.update = false;
        this.closed = false;
        this.visible = true;
        this.background = Color.BLACK;
        this.foreground = Color.WHITE;
    }

    protected abstract RectangularShape getContainingShape();

    /**
     * {@inheritDoc}
     */
    @Override
    public void add(RObject object) {
        children.add(object);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void add(RObject object, Object constraints) {
        add(object);
        manager.addLayoutComponent(object, constraints);
        object.setParent(this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void remove(RObject object) {
        children.remove(object);
        manager.removeLayoutComponent(object);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void remove(int index) {
        remove(children.get(index));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public float getAlignmentX() {
        return alignX;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public float getAlignmentY() {
        return alignY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setAlignmentX(float alignment) {
        this.alignX = alignment;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setAlignmentY(float alignment) {
        this.alignY = alignment;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LayoutManager getLayout() {
        return manager;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setLayout(LayoutManager manager) {
        this.manager = manager;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RectangularShape getShape(Graphics graphics) {
        return current;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void resizeCurrentShape(Dimension dimension) {
        RectangularShape shape = current;
        if (shape == null)
            shape = getContainingShape();
        if (shape.getWidth() != dimension.width && shape.getHeight() != dimension.height)
            current = (RectangularShape) ShapeTransform.resizeRect(shape, dimension.width, dimension.height);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RectangularShape getPreferredShape(Graphics graphics) {
        return preferred;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void resizePreferredShape(Graphics graphics, Dimension dimension) {
        RectangularShape shape = preferred;
        if (shape == null)
            shape = getContainingShape();
        if (shape.getWidth() != dimension.width && shape.getHeight() != dimension.height)
            preferred = (RectangularShape) ShapeTransform.resizeRect(shape, dimension.width, dimension.height);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void resizeMinimumShape(Graphics graphics, Dimension dimension) {
        RectangularShape shape = minimum;
        if (shape == null)
            shape = getContainingShape();
        if (shape.getWidth() != dimension.width && shape.getHeight() != dimension.height)
            minimum = (RectangularShape) ShapeTransform.resizeRect(shape, dimension.width, dimension.height);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RectangularShape getMinimumShape(Graphics graphics) {
        return minimum;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void resizeMaximumShape(Graphics graphics, Dimension dimension) {
        RectangularShape shape = maximum;
        if (shape == null)
            shape = getContainingShape();
        if (shape.getWidth() != dimension.width && shape.getHeight() != dimension.height)
            maximum = (RectangularShape) ShapeTransform.resizeRect(shape, dimension.width, dimension.height);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RectangularShape getMaximumShape(Graphics graphics) {
        return maximum;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getLocalX() {
        return current != null ? (int) current.getX() : 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getLocalY() {
        return current != null ? (int) current.getY() : 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getRealX() {
        RObject parent = getParent();
        return getLocalX() + (parent == null ? 0 : parent.getRealX());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getRealY() {
        RObject parent = getParent();
        return getLocalY() + (parent == null ? 0 : parent.getRealY());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getWidth() {
        return current != null ? (int) current.getWidth() : 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getHeight() {
        return current != null ? (int) current.getHeight() : 0;
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public Point getOffset() {
        return current == null ? new Point(0, 0) : new Point((int) current.getX(), (int) current.getY());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setOffset(Point p) {
        setOffset(p.x, p.y);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setOffset(int x, int y) {
        if (current == null)
            return;
        ShapeTransform.translateShape(current, x, y);
    }

    private RObject oldestRelative() {
        RObject object = this;
        while (object.getParent() != null)
            object = object.getParent();
        return object;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setOffsetRelativeTo(RObject component) {
        if (component == null)
            component = oldestRelative();
        int widthDiff = getWidth() / 2;
        int heightDiff = getHeight() / 2;
        int offsetX = component.getWidth() / 2;
        int offsetY = component.getHeight() / 2;
        setOffset(offsetX - widthDiff, offsetY - heightDiff);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RObject getParent() {
        return parent;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setParent(RObject parent) {
        RObject currentParent = getParent();
        if (this.equals(currentParent))
            return;
        if (currentParent != null) {
            //Remove all connection to parent
            currentParent.remove(this);
            if (this instanceof MouseListener) {
                MouseListener[] parentListeners = currentParent.getMouseListeners();
                if (partOf(this, parentListeners))
                    removeMouseListeners((MouseListener) this);
            }
            if (this instanceof MouseMotionListener) {
                MouseMotionListener[] parentListeners = currentParent.getMouseMotionListeners();
                if (partOf(this, parentListeners))
                    removeMouseMotionListeners((MouseMotionListener) this);
            }
            if (this instanceof MouseWheelListener) {
                MouseWheelListener[] parentListeners = currentParent.getMouseWheelListeners();
                if (partOf(this, parentListeners))
                    removeMouseWheelListeners((MouseWheelListener) this);
            }
            if (this instanceof ComponentListener) {
                ComponentListener[] parentListeners = currentParent.getComponentListeners();
                if (partOf(this, parentListeners))
                    removeComponentListeners((ComponentListener) this);
            }
        }
        this.parent = parent;
    }

    private boolean partOf(Object test, Object... candidates) {
        for (Object o : candidates)
            if (o.equals(test))
                return true;
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RObject[] getObjects() {
        return children.toArray(new RObject[children.size()]);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getObjectCount() {
        return children.size();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RObject getObjectAt(Point p) {
        return getObjectAt(p.x, p.y);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RObject getObjectAt(int x, int y) {
        if (!contains(x, y))
            return null;
        RObject[] objects = getObjects();
        for (int i = objects.length - 1; i >= 0; --i) {
            RObject object = objects[i];
            if (object != null && object.contains(x, y))
                return object;
        }
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean contains(Point p) {
        return contains(p.x, p.y);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean contains(int x, int y) {
        return current.contains(x, y);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Insets getInsets() {
        return insets;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setInsets(Insets insets) {
        this.insets = insets;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Color getBackground() {
        return background;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setBackground(Color color) {
        this.background = color;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Color getColor() {
        return foreground;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setColor(Color color) {
        this.foreground = color;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isClosed() {
        return closed;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setClosed(boolean closed) {
        //TODO:Throw proper exceptions
        if (closable)
            this.closed = closed;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isClosable() {
        return closable;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setClosable(boolean closable) {
        this.closable = closable;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void pack() {
        update = true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isVisible() {
        return visible;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MouseListener[] getMouseListeners() {
        return container.getMouseListeners();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addMouseListeners(MouseListener... listeners) {
        container.addMouseListeners(listeners);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void removeMouseListeners(MouseListener... listeners) {
        container.removeMouseListeners(listeners);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MouseMotionListener[] getMouseMotionListeners() {
        return container.getMouseMotionListeners();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addMouseMotionListeners(MouseMotionListener... listeners) {
        container.addMouseMotionListeners(listeners);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void removeMouseMotionListeners(MouseMotionListener... listeners) {
        container.removeMouseMotionListeners(listeners);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MouseWheelListener[] getMouseWheelListeners() {
        return container.getMouseWheelListeners();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addMouseWheelListeners(MouseWheelListener... listeners) {
        container.addMouseWheelListeners(listeners);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void removeMouseWheelListeners(MouseWheelListener... listeners) {
        container.removeMouseWheelListeners(listeners);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ComponentListener[] getComponentListeners() {
        return container.getComponentListeners();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addComponentListeners(ComponentListener... listeners) {
        container.addComponentListeners(listeners);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void removeComponentListeners(ComponentListener... listeners) {
        container.removeComponentListeners(listeners);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void repaint(Graphics graphics) {
        //TODO:Make use of property listeners
        if (update) {
            Dimension preferred = manager.preferredLayout(this, graphics);
            if (preferred != null)
                resizeCurrentShape(preferred);
            for (RObject object : children)
                object.pack();
            update = false;
        }
        manager.doLayout(this, graphics);
        graphics.setClip(getShape(graphics));
        if (isVisible())
            for (RObject object : children)
                object.repaint(graphics);
        graphics.setClip(null);
    }
}
