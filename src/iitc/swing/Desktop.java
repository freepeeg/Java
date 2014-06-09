package iitc.swing;

import javax.swing.*;
import java.awt.*;

/**
 * Desktop
 *
 * @author Ian
 * @version 1.0
 */
public class Desktop<J extends JInternalFrame> implements WindowConstants {
    private final JDesktopPane home;
    private final JFrame frame;

    public Desktop() {
        this("");
    }

    public Desktop(String title) {
        this.home = new JDesktopPane();
        this.frame = new JFrame(title);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        home.setVisible(true);
        frame.setContentPane(home);
    }

    public void add(J component) {
        component.setVisible(true);
        home.add(component);
    }

    public DesktopManager getDesktopManager() {
        return home.getDesktopManager();
    }

    public void setDesktopManager(DesktopManager manager) {
        home.setDesktopManager(manager);
    }

    public int getDragMode() {
        return home.getDragMode();
    }

    public void setDragMode(int mode) {
        home.setDragMode(mode);
    }

    public void setSelected(J component) {
        home.setSelectedFrame(component);
    }

    public JInternalFrame[] components(int layer) {
        return home.getAllFramesInLayer(layer);
    }

    public JInternalFrame[] components() {
        return home.getAllFrames();
    }

    public void remove(J component) {
        home.remove(component);
    }

    public void setBackground(Color color) {
        home.setBackground(color);
    }

    public void setDefaultCloseOperation(int operation) {
        frame.setDefaultCloseOperation(operation);
    }

    public void center() {
        center(null);
    }

    public void center(Component component) {
        frame.setLocationRelativeTo(component);
    }

    public void setStaticSize(Dimension dimension) {
        frame.setMinimumSize(dimension);
        frame.setSize(dimension);
        frame.setPreferredSize(dimension);
        frame.setMaximumSize(dimension);
    }

    public void pack() {
        frame.pack();
    }

    public boolean isValid() {
        return frame.isValid();
    }

    public boolean isVisible() {
        return frame.isVisible();
    }

    public void setVisible(boolean visible) {
        frame.setVisible(visible);
    }

    public Dimension getSize() {
        return frame.getSize();
    }

    public void setSize(Dimension size) {
        frame.setSize(size);
    }

    public void setSize(int width, int height) {
        setSize(new Dimension(width, height));
    }

    public void setPreferredSize(int width, int height) {
        setPreferredSize(new Dimension(width, height));
    }

    public void setMinimumSize(int width, int height) {
        setMinimumSize(new Dimension(width, height));
    }

    public void setMaximumSize(int width, int height) {
        setMaximumSize(new Dimension(width, height));
    }

    public Dimension getPreferredSize() {
        return frame.getPreferredSize();
    }

    public void setPreferredSize(Dimension size) {
        frame.setPreferredSize(size);
    }

    public Dimension getMinimumSize() {
        return frame.getMinimumSize();
    }

    public void setMinimumSize(Dimension size) {
        frame.setMinimumSize(size);
    }

    public Dimension getMaximumSize() {
        return frame.getMaximumSize();
    }

    public void setMaximumSize(Dimension size) {
        frame.setMaximumSize(size);
    }

    public String getName() {
        return frame.getName();
    }

    public void setName(String name) {
        frame.setName(name);
    }
}
