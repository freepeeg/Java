package iitc.awt.paint;

import iitc.awt.paint.event.ListEventContainer;
import iitc.awt.paint.layout.FreestyleLayout;

import java.awt.*;
import java.awt.event.ComponentListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelListener;
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
    private Dimension preferredSize;
    private Color foreground;
    private Color background;
    private boolean visible;
    private RObject parent;

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
    }

    @Override
    public void remove(int index) {
        children.remove(index);
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
    public Dimension getPreferredSize(Graphics graphics) {
        Dimension layoutsDecision = manager.preferredLayout(this, graphics);
        if (layoutsDecision != null)
            setPreferredSize(graphics, layoutsDecision);
        return preferredSize;
    }

    @Override
    public void setPreferredSize(Graphics graphics, Dimension dimension) {
        preferredSize = dimension;
    }

    @Override
    public int getRealX() {
        RObject parent = getParent();
        return getOffsetX() + (parent == null ? 0 : parent.getRealX());
    }

    @Override
    public int getRealY() {
        RObject parent = getParent();
        return getOffsetY() + (parent == null ? 0 : parent.getRealY());
    }

    @Override
    public void setOffset(Point p) {
        setOffset(p.x, p.y);
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

        }
        this.parent = parent;
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
    public MouseMotionListener[] getMouseMotionListeners() {
        return container.getMouseMotionListeners();
    }

    @Override
    public MouseWheelListener[] getMouseWheelListeners() {
        return container.getMouseWheelListeners();
    }

    @Override
    public ComponentListener[] getComponentListeners() {
        return container.getComponentListeners();
    }

    @Override
    public void repaint(Graphics graphics) {
        //TODO:Make use of property listeners
        if (update) {
            setSize(getPreferredSize(graphics));
            for (RObject object : children)
                object.pack();
            update = false;
        }
        manager.doLayout(this, graphics);
        graphics.setClip(getOffsetX(), getOffsetY(), getWidth(), getHeight());
        if (isVisible())
            for (RObject object : children)
                object.repaint(graphics);
        graphics.setClip(null);
    }
}
