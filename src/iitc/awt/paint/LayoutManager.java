package iitc.awt.paint;

import java.awt.*;

/**
 * LayoutManager
 *
 * @author Ian
 * @version 1.0
 */
public interface LayoutManager {
    public Dimension preferredLayout(RObject object, Graphics graphics);

    public Dimension minimumLayout(RObject object, Graphics graphics);

    public Dimension layout(RObject object, Graphics graphics);

    public void revalidate(RObject object, Graphics graphics);

    public void doLayout(RObject object, Graphics graphics);

    public void addLayoutComponent(RObject object, Object constraint);

    public void removeLayoutComponent(RObject object);

    public void removeLayoutComponent(Object constraints);
}
