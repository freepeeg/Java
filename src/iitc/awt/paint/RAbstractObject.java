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

    @Override
    public void add(RObject object) {
        children.add(object);
    }

    @Override
    public void add(RObject object, Object constraints) {
        add(object);
        manager.addLayoutComponent(object, constraints);

    }

    @Override
    public void remove(RObject object) {
        children.remove(object);
        manager.removeLayoutComponent(object);
    }

    @Override
    public void remove(int index) {
        remove(children.get(index));
    }

    @Override
    public float getAlignmentX() {
        return alignX;
    }

    @Override
    public float getAlignmentY() {
        return alignY;
    }

    @Override
    public void setAlignmentX(float alignment) {
        this.alignX = alignment;
    }

    @Override
    public void setAlignmentY(float alignment) {
        this.alignY = alignment;
    }

    @Override
    public LayoutManager getLayout() {
        return manager;
    }

    @Override
    public void setLayout(LayoutManager manager) {
        this.manager = manager;
    }

    @Override
    public RectangularShape getShape(Graphics graphics) {
        return current;
    }

    @Override
    public void resizeCurrentShape(Dimension dimension) {
        RectangularShape shape = current;
        if (shape == null)
            shape = getContainingShape();
        if (shape.getWidth() != dimension.width && shape.getHeight() != dimension.height)
            current = (RectangularShape) ShapeTransform.resizeRect(shape, dimension.width, dimension.height);
    }

    @Override
    public RectangularShape getPreferredShape(Graphics graphics) {
        return preferred;
    }

    @Override
    public void resizedPreferredShape(Graphics graphics, Dimension dimension) {
        RectangularShape shape = preferred;
        if (shape == null)
            shape = getContainingShape();
        if (shape.getWidth() != dimension.width && shape.getHeight() != dimension.height)
            preferred = (RectangularShape) ShapeTransform.resizeRect(shape, dimension.width, dimension.height);
    }

    @Override
    public void resizeMinimumShape(Graphics graphics, Dimension dimension) {
        RectangularShape shape = minimum;
        if (shape == null)
            shape = getContainingShape();
        if (shape.getWidth() != dimension.width && shape.getHeight() != dimension.height)
            minimum = (RectangularShape) ShapeTransform.resizeRect(shape, dimension.width, dimension.height);
    }

    @Override
    public RectangularShape getMinimumShape(Graphics graphics) {
        return minimum;
    }

    @Override
    public void resizeMaximumShape(Graphics graphics, Dimension dimension) {
        RectangularShape shape = maximum;
        if (shape == null)
            shape = getContainingShape();
        if (shape.getWidth() != dimension.width && shape.getHeight() != dimension.height)
            maximum = (RectangularShape) ShapeTransform.resizeRect(shape, dimension.width, dimension.height);
    }

    @Override
    public RectangularShape getMaximumShape(Graphics graphics) {
        return maximum;
    }

    @Override
    public int getLocalX() {
        return current != null ? (int) current.getX() : 0;
    }

    @Override
    public int getLocalY() {
        return current != null ? (int) current.getY() : 0;
    }

    @Override
    public int getRealX() {
        RObject parent = getParent();
        return getLocalX() + (parent == null ? 0 : parent.getRealX());
    }

    @Override
    public int getRealY() {
        RObject parent = getParent();
        return getLocalY() + (parent == null ? 0 : parent.getRealY());
    }

    @Override
    public int getWidth() {
        return current != null ? (int) current.getWidth() : 0;
    }

    @Override
    public int getHeight() {
        return current != null ? (int) current.getHeight() : 0;
    }


    @Override
    public Point getOffset() {
        return current == null ? new Point(0, 0) : new Point((int) current.getX(), (int) current.getY());
    }

    @Override
    public void setOffset(Point p) {
        setOffset(p.x, p.y);
    }

    @Override
    public void setOffset(int x, int y) {
        if (current == null)
            return;
        ShapeTransform.translateShape(current, x, y);
    }

    @Override
    public void setOffsetRelativeTo(RObject component) {
        if (component == null)
            return;
        int widthDiff = getWidth() / 2;
        int heightDiff = getHeight() / 2;
        int offsetX = component.getWidth() / 2;
        int offsetY = component.getHeight() / 2;
        setOffset(offsetX - widthDiff, offsetY - heightDiff);
    }

    @Override
    public RObject getParent() {
        return parent;
    }

    @Override
    public void setParent(RObject parent) {
        RObject currentParent = getParent();
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

    @Override
    public RObject[] getObjects() {
        return children.toArray(new RObject[children.size()]);
    }

    @Override
    public int getObjectCount() {
        return children.size();
    }

    @Override
    public RObject getObjectAt(Point p) {
        return getObjectAt(p.x, p.y);
    }

    @Override
    public RObject getObjectAt(int x, int y) {
        RObject[] objects = getObjects();
        for (int i = objects.length - 1; i >= 0; --i) {
            RObject object = objects[i];
            if (object != null && object.contains(x, y))
                return object;
        }
        return null;
    }

    @Override
    public boolean contains(Point p) {
        return contains(p.x, p.y);
    }

    @Override
    public boolean contains(int x, int y) {
        return current.contains(x, y);
    }

    @Override
    public Insets getInsets() {
        return insets;
    }

    @Override
    public void setInsets(Insets insets) {
        this.insets = insets;
    }

    @Override
    public Color getBackground() {
        return background;
    }

    @Override
    public void setBackground(Color color) {
        this.background = color;
    }

    @Override
    public Color getColor() {
        return foreground;
    }

    @Override
    public void setColor(Color color) {
        this.foreground = color;
    }

    @Override
    public boolean isClosed() {
        return closed;
    }

    @Override
    public void setClosed(boolean closed) {
        //TODO:Throw proper exceptions
        if (closable)
            this.closed = closed;
    }

    @Override
    public boolean isClosable() {
        return closable;
    }

    @Override
    public void setClosable(boolean closable) {
        this.closable = closable;
    }

    @Override
    public void pack() {
        update = true;
    }

    @Override
    public boolean isVisible() {
        return visible;
    }

    @Override
    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    @Override
    public MouseListener[] getMouseListeners() {
        return container.getMouseListeners();
    }

    @Override
    public void addMouseListeners(MouseListener... listeners) {
        container.addMouseListeners(listeners);
    }

    @Override
    public void removeMouseListeners(MouseListener... listeners) {
        container.removeMouseListeners(listeners);
    }

    @Override
    public MouseMotionListener[] getMouseMotionListeners() {
        return container.getMouseMotionListeners();
    }

    @Override
    public void addMouseMotionListeners(MouseMotionListener... listeners) {
        container.addMouseMotionListeners(listeners);
    }

    @Override
    public void removeMouseMotionListeners(MouseMotionListener... listeners) {
        container.removeMouseMotionListeners(listeners);
    }

    @Override
    public MouseWheelListener[] getMouseWheelListeners() {
        return container.getMouseWheelListeners();
    }

    @Override
    public void addMouseWheelListeners(MouseWheelListener... listeners) {
        container.addMouseWheelListeners(listeners);
    }

    @Override
    public void removeMouseWheelListeners(MouseWheelListener... listeners) {
        container.removeMouseWheelListeners(listeners);
    }

    @Override
    public ComponentListener[] getComponentListeners() {
        return container.getComponentListeners();
    }

    @Override
    public void addComponentListeners(ComponentListener... listeners) {
        container.addComponentListeners(listeners);
    }

    @Override
    public void removeComponentListeners(ComponentListener... listeners) {
        container.removeComponentListeners(listeners);
    }

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
