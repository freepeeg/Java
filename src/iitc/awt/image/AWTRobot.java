package iitc.awt.image;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

/**
 * AWTRobot
 *
 * @author Ian
 * @version 1.0
 */
public class AWTRobot extends Robot {
    private java.util.List<String> types = Arrays.asList(ImageIO.getWriterFileSuffixes());

    public AWTRobot() throws AWTException {
        super();
    }

    public BufferedImage createImage(JComponent component) {
        Dimension d = component.getSize();
        return createImage(component, new Rectangle(0, 0, d.width, d.height));
    }

    public Color getColorAt(Component component, Point p) throws AWTException {
        return getColorAt(createImage(component), p);
    }

    public Color getColorAt(Component component, int x, int y) throws AWTException {
        return getColorAt(createImage(component), x, y);
    }

    public Color getColorAt(BufferedImage image, Point p) {
        return getColorAt(image, p.x, p.y);
    }

    public Color getColorAt(BufferedImage image, int x, int y) {
        return image != null ? new Color(image.getRGB(x, y)) : null;
    }

    public BufferedImage createImage(Component component, Rectangle region) {
        if (!component.isDisplayable()) {
            Dimension d = component.getSize();
            if (d.width == 0 || d.height == 0)
                component.setSize(component.getPreferredSize());
            layoutComponent(component);
        }
        BufferedImage image = new BufferedImage(region.width, region.height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = image.createGraphics();
        if (!component.isOpaque()) {
            g2d.setColor(component.getBackground());
            g2d.fillRect(region.x, region.y, region.width, region.height);
        }
        g2d.translate(-region.x, -region.y);
        component.paint(g2d);
        g2d.dispose();
        return image;
    }

    public BufferedImage createImage(Component component)
            throws AWTException {
        Point p = new Point(0, 0);
        SwingUtilities.convertPointToScreen(p, component);
        Rectangle region = component.getBounds();
        region.setLocation(p.x, p.y);
        return createScreenCapture(region);
    }

    public boolean writeImage(BufferedImage image, String name)
            throws IOException {
        if (name == null)
            return false;
        int offset = name.lastIndexOf(".");
        if (offset == -1)
            throw new IOException("Invalid filename (no file extension)");
        String type = name.substring(offset + 1);
        if (types.contains(type))
            return ImageIO.write(image, type, new File(name));
        throw new IOException("Unknown file extension (" + type + ")");
    }

    private void layoutComponent(Component component) {
        if (component instanceof Container) {
            component.validate();
            for (Component child : ((Container) component).getComponents())
                layoutComponent(child);
        }
    }

}
