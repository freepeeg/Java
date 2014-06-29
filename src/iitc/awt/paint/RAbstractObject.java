package iitc.awt.paint;

import iitc.awt.paint.event.ListEventContainer;
import iitc.awt.paint.layout.FreestyleLayout;

import java.awt.*;
import java.awt.event.ComponentListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelListener;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * RAbstractObject
 *
 * @author Ian
 * @version 1.0
 */
public class RAbstractObject implements RObject {
    private LayoutManager manager;
    private EventContainer container;
    private Map<RObject, Float> childAlignmentMapping;
    private float alignX;
    private float alignY;
    private Insets insets;
    private boolean update;
    private boolean closable;
    private boolean closed;
    private boolean preferredSizeSet;
    private Rectangle backgroundObject;
    private Dimension preferredSize;
    private Color foreground;
    private Color background;
    private boolean visible;

    public RAbstractObject(int x, int y) {
        this(x, y, new FreestyleLayout());
    }

    public RAbstractObject(int x, int y, LayoutManager manager) {
        this.backgroundObject = new Rectangle(x, y, 0, 0);
        this.manager = manager;
        this.childAlignmentMapping = new HashMap<>();
        this.container = new ListEventContainer();
        this.alignX = Alignment.LEFT_ALIGNMENT;
        this.alignY = Alignment.TOP_ALIGNMENT;
        this.insets = new Insets(0, 0, 0, 0);
        this.closable = true;
        this.update = false;
        this.closed = false;
        this.preferredSizeSet = false;
        this.visible = true;
        this.background = Color.BLACK;
        this.foreground = Color.WHITE;
    }

    @Override
    public void add(RObject object) {
        add(object, Alignment.LEFT_ALIGNMENT);
    }

    @Override
    public void add(RObject object, float alignment) {
        childAlignmentMapping.put(object, alignment);
    }

    @Override
    public void remove(RObject object) {
        childAlignmentMapping.remove(object);
    }

    @Override
    public void remove(int index) {
        Iterator<Map.Entry<RObject, Float>> objects = childAlignmentMapping.entrySet().iterator();
        int i = 0;
        while (objects.hasNext() && i <= index) {
            objects.next();
            if (i == index)
                objects.remove();
            i++;
        }
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
    public Dimension getSize(Graphics graphics) {
        return backgroundObject.getSize();
    }

    @Override
    public void setSize(Dimension dimension) {
        backgroundObject.setSize(dimension);
    }

    @Override
    public Dimension getPreferredSize(Graphics graphics) {
        if (!preferredSizeSet)
            setPreferredSize(graphics, manager.preferredLayout(this, graphics));
        return preferredSize;
    }

    @Override
    public void setPreferredSize(Graphics graphics, Dimension dimension) {
        preferredSizeSet = true;
        preferredSize = dimension;
    }

    @Override
    public int getX() {
        return backgroundObject.x;
    }

    @Override
    public int getY() {
        return backgroundObject.y;
    }

    @Override
    public int getWidth() {
        return backgroundObject.width;
    }

    @Override
    public int getHeight() {
        return backgroundObject.height;
    }

    @Override
    public Point getLocation() {
        return backgroundObject.getLocation();
    }

    @Override
    public void setLocation(Point p) {
        setLocation(p.x, p.y);
    }

    @Override
    public void setLocation(int x, int y) {
        backgroundObject.setLocation(x, y);
    }

    @Override
    public void setLocationRelativeTo(RObject component) {
        if (component == null)
            return;
        int widthDiff = getWidth() / 2;
        int heightDiff = getHeight() / 2;
        int offsetX = component.getWidth() / 2;
        int offsetY = component.getHeight() / 2;
        setLocation(offsetX - widthDiff, offsetY - heightDiff);
    }

    @Override
    public RObject[] getObjects() {
        return childAlignmentMapping.keySet().toArray(new RObject[childAlignmentMapping.size()]);
    }

    @Override
    public int getObjectCount() {
        return childAlignmentMapping.size();
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
        return backgroundObject.contains(x, y);
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
            update = false;
        }
        manager.doLayout(this, graphics);
        if (isVisible())
            for (RObject object : childAlignmentMapping.keySet())
                object.repaint(graphics);
    }
}
