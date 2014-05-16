package iitc.chain;

import javax.accessibility.AccessibleContext;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.AncestorListener;
import java.awt.*;
import java.awt.dnd.DropTarget;
import java.awt.event.*;
import java.beans.PropertyChangeListener;
import java.beans.VetoableChangeListener;
import java.util.Locale;
import java.util.Set;

/**
 * XBox
 *
 * @author Ian
 * @version 1.0
 */
@SuppressWarnings("unchecked")
public class XBox<X extends XBox, B extends Box> extends XComponent<X, B> {

    /**
     * Creates an XBox, replicating the specified component
     *
     * @param component the component to replicate
     */
    protected XBox(B component) {
        super(component);
    }

    /**
     * Creates a <code>Box</code> that displays its components
     * along the the specified axis.
     *
     * @param axis can be {@link javax.swing.BoxLayout#X_AXIS},
     *             {@link javax.swing.BoxLayout#Y_AXIS},
     *             {@link javax.swing.BoxLayout#LINE_AXIS} or
     *             {@link javax.swing.BoxLayout#PAGE_AXIS}.
     * @throws java.awt.AWTError if the <code>axis</code> is invalid
     * @see #createHorizontalBox
     * @see #createVerticalBox
     */
    public static XBox<XBox, Box> create(int axis) {
        return new XBox<>(new Box(axis));
    }

    /**
     * Creates an invisible "glue" component
     * that can be useful in a Box
     * whose visible components have a maximum width
     * (for a horizontal box)
     * or height (for a vertical box).
     * You can think of the glue component
     * as being a gooey substance
     * that expands as much as necessary
     * to fill the space between its neighboring components.
     * <p/>
     * <p/>
     * <p/>
     * For example, suppose you have
     * a horizontal box that contains two fixed-size components.
     * If the box gets extra space,
     * the fixed-size components won't become larger,
     * so where does the extra space go?
     * Without glue,
     * the extra space goes to the right of the second component.
     * If you put glue between the fixed-size components,
     * then the extra space goes there.
     * If you put glue before the first fixed-size component,
     * the extra space goes there,
     * and the fixed-size components are shoved against the right
     * edge of the box.
     * If you put glue before the first fixed-size component
     * and after the second fixed-size component,
     * the fixed-size components are centered in the box.
     * <p/>
     * <p/>
     * <p/>
     * To use glue,
     * call <code>Box.createGlue</code>
     * and add the returned component to a container.
     * The glue component has no minimum or preferred size,
     * so it takes no space unless excess space is available.
     * If excess space is available,
     * then the glue component takes its share of available
     * horizontal or vertical space,
     * just like any other component that has no maximum width or height.
     *
     * @return the component
     */
    public static Component createGlue() {
        return Box.createGlue();
    }

    /**
     * Creates a <code>Box</code> that displays its components
     * from left to right. If you want a <code>Box</code> that
     * respects the component orientation you should create the
     * <code>Box</code> using the constructor and pass in
     * <code>BoxLayout.LINE_AXIS</code>, eg:
     * <pre>
     *   Box lineBox = new Box(BoxLayout.LINE_AXIS);
     * </pre>
     *
     * @return the box
     */
    public static XBox<XBox, Box> createHorizontalBox() {
        return new XBox<>(Box.createHorizontalBox());
    }

    /**
     * Creates a horizontal glue component.
     *
     * @return the component
     */
    public static Component createHorizontalGlue() {
        return Box.createHorizontalGlue();
    }

    /**
     * Creates an invisible component that's always the specified size.
     * <!-- WHEN WOULD YOU USE THIS AS OPPOSED TO A STRUT? -->
     *
     * @param dimension the dimensions of the invisible component
     * @return the component
     */
    public static Component createRigidArea(Dimension dimension) {
        return Box.createRigidArea(dimension);
    }

    /**
     * Creates a <code>Box</code> that displays its components
     * from top to bottom. If you want a <code>Box</code> that
     * respects the component orientation you should create the
     * <code>Box</code> using the constructor and pass in
     * <code>BoxLayout.PAGE_AXIS</code>, eg:
     * <pre>
     *   Box lineBox = new Box(BoxLayout.PAGE_AXIS);
     * </pre>
     *
     * @return the box
     */
    public static XBox<XBox, Box> createVerticalBox() {
        return new XBox<>(Box.createVerticalBox());
    }

    /**
     * Creates a vertical glue component.
     *
     * @return the component
     */
    public static Component createVerticalGlue() {
        return Box.createVerticalGlue();
    }

    /**
     * Creates an invisible, fixed-height component.
     * In a vertical box,
     * you typically use this method
     * to force a certain amount of space between two components.
     * In a horizontal box,
     * you might use this method
     * to force the box to be at least the specified height.
     * The invisible component has no width
     * unless excess space is available,
     * in which case it takes its share of available space,
     * just like any other component that has no maximum width.
     *
     * @param height the height of the invisible component, in pixels >= 0
     * @return the component
     */
    public static Component createVerticalStrut(int height) {
        return Box.createVerticalStrut(height);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public B build() {
        return super.build();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public X size(Dimension size) {
        return super.size(size);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public X tooltipText(String text) {
        return super.tooltipText(text);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public X name(String name) {
        return super.name(name);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public X visible(boolean aFlag) {
        return super.visible(aFlag);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public X size(int width, int height) {
        return super.size(width, height);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public X add(XComponent component) {
        return super.add(component);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public X add(XComponent component, int index) {
        return super.add(component, index);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public X add(XComponent component, Object constraints) {
        return super.add(component, constraints);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public X add(XComponent component, Object constraints, int index) {
        return super.add(component, constraints, index);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public X add(Component component) {
        return super.add(component);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public X add(Component component, int index) {
        return super.add(component, index);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public X add(Component component, Object constraints) {
        return super.add(component, constraints);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public X add(Component component, Object constraints, int index) {
        return super.add(component, constraints, index);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public X add(PopupMenu menu) {
        return super.add(menu);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public X add(String name, Component component) {
        return super.add(name, component);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public X add(String name, XComponent component) {
        return super.add(name, component);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public X ancestorListener(AncestorListener listener) {
        return super.ancestorListener(listener);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public X addVetoable(VetoableChangeListener listener) {
        return super.addVetoable(listener);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public X computeRect(Rectangle visibleRect) {
        return super.computeRect(visibleRect);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public X grabFocus() {
        return super.grabFocus();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public X clientProperty(Object key, Object value) {
        return super.clientProperty(key, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public X registerKeyboard(ActionListener listener, KeyStroke keyStroke, int condition) {
        return super.registerKeyboard(listener, keyStroke, condition);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public X registerKeyboard(ActionListener listener, String command, KeyStroke keyStroke, int condition) {
        return super.registerKeyboard(listener, command, keyStroke, condition);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public X removeAncestor(AncestorListener listener) {
        return super.removeAncestor(listener);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public X remove(Component component) {
        return super.remove(component);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public X remove(int index) {
        return super.remove(index);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public X remove(XComponent component) {
        return super.remove(component);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public X remove(MenuComponent component) {
        return super.remove(component);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public X removeVetoable(VetoableChangeListener listener) {
        return super.removeVetoable(listener);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public X requestFocus() {
        return super.requestFocus();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public X requestFocus(boolean temporary) {
        return super.requestFocus(temporary);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public X revalidate() {
        return super.revalidate();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public X scrollToVisible(Rectangle rectangle) {
        return super.scrollToVisible(rectangle);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public X actionMap(ActionMap map) {
        return super.actionMap(map);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public X alignX(float alignmentX) {
        return super.alignX(alignmentX);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public X alignY(float alignmentY) {
        return super.alignY(alignmentY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public X autoScrolls(boolean autoscrolls) {
        return super.autoScrolls(autoscrolls);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public X background(Color bg) {
        return super.background(bg);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public X border(Border border) {
        return super.border(border);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public X componentPopupMenu(JPopupMenu menu) {
        return super.componentPopupMenu(menu);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public X debugGraphicsOptions(int debugOptions) {
        return super.debugGraphicsOptions(debugOptions);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public X doubleBuffered(boolean aFlag) {
        return super.doubleBuffered(aFlag);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public X enabled(boolean enabled) {
        return super.enabled(enabled);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public X focusTraversalKeys(int id, Set<? extends AWTKeyStroke> keystrokes) {
        return super.focusTraversalKeys(id, keystrokes);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public X font(Font font) {
        return super.font(font);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public X foreground(Color fg) {
        return super.foreground(fg);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public X inheritsPopupMenu(boolean value) {
        return super.inheritsPopupMenu(value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public X inputMap(int condition, InputMap map) {
        return super.inputMap(condition, map);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public X inputVerifier(InputVerifier verifier) {
        return super.inputVerifier(verifier);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public X maximumSize(Dimension max) {
        return super.maximumSize(max);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public X minimumSize(Dimension min) {
        return super.minimumSize(min);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public X opaque(boolean isOpaque) {
        return super.opaque(isOpaque);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public X preferredSize(Dimension preferredSize) {
        return super.preferredSize(preferredSize);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public X requestFocusEnabled(boolean requestFocusEnabled) {
        return super.requestFocusEnabled(requestFocusEnabled);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public X transferHandler(TransferHandler handler) {
        return super.transferHandler(handler);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public X verifyInputWhenFocusTarget(boolean verifyInputWhenFocusTarget) {
        return super.verifyInputWhenFocusTarget(verifyInputWhenFocusTarget);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public X unregisterAction(KeyStroke aKeyStroke) {
        return super.unregisterAction(aKeyStroke);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public X updateUI() {
        return super.updateUI();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public X componentListener(ComponentListener listener) {
        return super.componentListener(listener);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public X containerListener(ContainerListener listener) {
        return super.containerListener(listener);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public X focusListener(FocusListener listener) {
        return super.focusListener(listener);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public X hierarchyBoundsListener(HierarchyBoundsListener listener) {
        return super.hierarchyBoundsListener(listener);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public X hierarchyListener(HierarchyListener listener) {
        return super.hierarchyListener(listener);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public X inputMethodListener(InputMethodListener listener) {
        return super.inputMethodListener(listener);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public X keyListener(KeyListener listener) {
        return super.keyListener(listener);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public X mouseListener(MouseListener listener) {
        return super.mouseListener(listener);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public X mouseMotionListener(MouseMotionListener listener) {
        return super.mouseMotionListener(listener);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public X mouseWheelListener(MouseWheelListener listener) {
        return super.mouseWheelListener(listener);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public X propertyChangeListener(PropertyChangeListener listener) {
        return super.propertyChangeListener(listener);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public X propertyChangeListener(String property, PropertyChangeListener listener) {
        return super.propertyChangeListener(property, listener);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public X applyOrientation(ComponentOrientation orientation) {
        return super.applyOrientation(orientation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public X dispatch(AWTEvent event) {
        return super.dispatch(event);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public X layout() {
        return super.layout();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public X enableInputMethods(boolean enableInputMethods) {
        return super.enableInputMethods(enableInputMethods);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public X removeAll() {
        return super.removeAll();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public X removeComponentListener(ComponentListener listener) {
        return super.removeComponentListener(listener);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public X removeContainerListener(ContainerListener listener) {
        return super.removeContainerListener(listener);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public X removeFocusListener(FocusListener listener) {
        return super.removeFocusListener(listener);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public X removeHierarchyBoundsListener(HierarchyBoundsListener listener) {
        return super.removeHierarchyBoundsListener(listener);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public X removeHierarchyListener(HierarchyListener listener) {
        return super.removeHierarchyListener(listener);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public X removeInputMethodListener(InputMethodListener listener) {
        return super.removeInputMethodListener(listener);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public X removeKeyListener(KeyListener listener) {
        return super.removeKeyListener(listener);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public X removeMouseListener(MouseListener listener) {
        return super.removeMouseListener(listener);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public X removeMouseMotionListener(MouseMotionListener listener) {
        return super.removeMouseMotionListener(listener);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public X removeMouseWheelListener(MouseWheelListener listener) {
        return super.removeMouseWheelListener(listener);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public X removePropertyChangeListener(PropertyChangeListener listener) {
        return super.removePropertyChangeListener(listener);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public X removePropertyChangeListener(String property, PropertyChangeListener listener) {
        return super.removePropertyChangeListener(property, listener);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public X bounds(int x, int y, int width, int height) {
        return super.bounds(x, y, width, height);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public X bounds(Rectangle rectangle) {
        return super.bounds(rectangle);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public X componentOrientation(ComponentOrientation orientation) {
        return super.componentOrientation(orientation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public X cursor(Cursor cursor) {
        return super.cursor(cursor);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public X dropTarget(DropTarget target) {
        return super.dropTarget(target);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public X focusCycleRoot(boolean focusCycleRoot) {
        return super.focusCycleRoot(focusCycleRoot);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public X focusTraversalKeysEnabled(boolean enabled) {
        return super.focusTraversalKeysEnabled(enabled);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public X focusTraversalPolicy(FocusTraversalPolicy policy) {
        return super.focusTraversalPolicy(policy);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public X focusTraversalPolicyProvider(boolean provider) {
        return super.focusTraversalPolicyProvider(provider);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public X ignoreRepaint(boolean ignore) {
        return super.ignoreRepaint(ignore);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public X layout(LayoutManager manager) {
        return super.layout(manager);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public X locale(Locale locale) {
        return super.locale(locale);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public X location(int x, int y) {
        return super.location(x, y);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public X location(Point p) {
        return super.location(p);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public X transferFocus() {
        return super.transferFocus();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public X transferFocusBackward() {
        return super.transferFocusBackward();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public X transferFocusDownCycle() {
        return super.transferFocusDownCycle();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public X transferFocusUpCycle() {
        return super.transferFocusUpCycle();
    }

    /**
     * Gets the AccessibleContext associated with this Box.
     * For boxes, the AccessibleContext takes the form of an
     * AccessibleBox.
     * A new AccessibleAWTBox instance is created if necessary.
     *
     * @return an AccessibleBox that serves as the
     *         AccessibleContext of this Box
     */
    public AccessibleContext getAccessibleContext() {
        return component.getAccessibleContext();
    }

    /**
     * Paints each of the components in this container.
     *
     * @param g the graphics context.
     * @return a reference to this object.
     */
    public X paintComponent(Graphics g) {
        component.paintComponents(g);
        return (X) this;
    }

    public static class XFiller<X extends XFiller, F extends Box.Filler> extends XComponent<X, F> {
        protected XFiller(F component) {
            super(component);
        }

        public static XFiller<XFiller, Box.Filler> create(Dimension min, Dimension pref, Dimension max) {
            return new XFiller<>(new Box.Filler(min, pref, max));
        }

        public X change(Dimension min, Dimension pref, Dimension max) {
            component.changeShape(min, pref, max);
            return (X) this;
        }

        public AccessibleContext getAccessibleContext() {
            return component.getAccessibleContext();
        }

        public X paintComponent(Graphics g) {
            component.paintComponents(g);
            return (X) this;
        }
    }
}
