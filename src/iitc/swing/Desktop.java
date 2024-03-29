package iitc.swing;

import iitc.swing.desktop.LoadableFrame;

import javax.swing.*;
import java.awt.*;

/**
 * Desktop
 *
 * @author Ian
 * @version 1.0
 */
public class Desktop<J extends LoadableFrame> implements WindowConstants {
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

    public void add(final J component) {
        component.setVisible(true);
        home.add(component);
        component.moveToFront();
        new Thread(new Runnable() {
            @Override
            public void run() {
                component.load();
            }
        }).start();
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

    public J selectFrame(boolean forward) {
        return (J) home.selectFrame(forward);
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

    public void centerChild(J component) {
        Dimension size = getSize();
        Dimension childSize = component.getSize();
        component.setLocation((size.width - childSize.width) / 2,
                (size.height - childSize.height) / 2);
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
