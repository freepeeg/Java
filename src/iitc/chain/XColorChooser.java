package iitc.chain;

import javax.accessibility.AccessibleContext;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.colorchooser.AbstractColorChooserPanel;
import javax.swing.colorchooser.ColorSelectionModel;
import javax.swing.event.AncestorListener;
import javax.swing.plaf.ColorChooserUI;
import java.awt.*;
import java.awt.dnd.DropTarget;
import java.awt.event.*;
import java.beans.PropertyChangeListener;
import java.beans.VetoableChangeListener;
import java.util.Locale;
import java.util.Set;

/**
 * XColorChooser
 *
 * @author Ian
 * @version 1.0
 */
@SuppressWarnings("unchecked")
//TODO:Finish
public class XColorChooser<X extends XColorChooser, J extends JColorChooser> extends XComponent<X, J> {
    /**
     * Creates an XColorChooser, replicating the specified component
     *
     * @param component the component to replicate
     */
    protected XColorChooser(J component) {
        super(component);
    }

    /**
     * Creates and returns a new dialog containing the specified
     * <code>ColorChooser</code> pane along with "OK", "Cancel", and "Reset"
     * buttons. If the "OK" or "Cancel" buttons are pressed, the dialog is
     * automatically hidden (but not disposed).  If the "Reset"
     * button is pressed, the color-chooser's color will be reset to the
     * color which was set the last time <code>show</code> was invoked on the
     * dialog and the dialog will remain showing.
     *
     * @param c              the parent component for the dialog
     * @param title          the title for the dialog
     * @param modal          a boolean. When true, the remainder of the program
     *                       is inactive until the dialog is closed.
     * @param chooserPane    the color-chooser to be placed inside the dialog
     * @param okListener     the ActionListener invoked when "OK" is pressed
     * @param cancelListener the ActionListener invoked when "Cancel" is pressed
     * @return a new dialog containing the color-chooser pane
     * @throws java.awt.HeadlessException if GraphicsEnvironment.isHeadless()
     *                           returns true.
     * @see java.awt.GraphicsEnvironment#isHeadless
     */
    public static JDialog createDialog(Component c, String title, boolean modal, JColorChooser chooserPane, ActionListener okListener, ActionListener cancelListener) {
        return JColorChooser.createDialog(c, title, modal, chooserPane, okListener, cancelListener);

    }

    /**
     * Creates a color chooser pane with an initial color of white.
     */
    public static XColorChooser<XColorChooser, JColorChooser> create() {
        return new XColorChooser<>(new JColorChooser());
    }

    /**
     * Creates a color chooser pane with the specified initial color.
     *
     * @param initialColor the initial color set in the chooser
     */
    public static XColorChooser<XColorChooser, JColorChooser> create(Color initialColor) {
        return new XColorChooser<>(new JColorChooser(initialColor));
    }

    /**
     * Creates a color chooser pane with the specified
     * <code>ColorSelectionModel</code>.
     *
     * @param model the <code>ColorSelectionModel</code> to be used
     */
    public static XColorChooser<XColorChooser, JColorChooser> create(ColorSelectionModel model) {
        return new XColorChooser<>(new JColorChooser(model));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public J build() {
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
     * Adds a color chooser panel to the color chooser.
     *
     * @param panel the <code>AbstractColorChooserPanel</code> to be added
     * @return a reference to this object.
     */
    public X chooserPanel(AbstractColorChooserPanel panel) {
        component.addChooserPanel(panel);
        return (X) this;
    }

    /**
     * Gets the AccessibleContext associated with this JColorChooser.
     * For color choosers, the AccessibleContext takes the form of an
     * AccessibleJColorChooser.
     * A new AccessibleJColorChooser instance is created if necessary.
     *
     * @return an AccessibleJColorChooser that serves as the
     *         AccessibleContext of this JColorChooser
     */
    public AccessibleContext getAccessibleContext() {
        return component.getAccessibleContext();
    }

    /**
     * Returns the specified color panels.
     *
     * @return an array of <code>AbstractColorChooserPanel</code> objects
     */
    public AbstractColorChooserPanel[] getChooserPanels() {
        return component.getChooserPanels();
    }

    /**
     * Gets the current color value from the color chooser.
     * By default, this delegates to the model.
     *
     * @return the current color value of the color chooser
     */
    public Color getColor() {
        return component.getColor();
    }

    /**
     * Gets the value of the <code>dragEnabled</code> property.
     *
     * @return the value of the <code>dragEnabled</code> property
     * @since 1.4
     */
    public boolean getDragEnabled() {
        return component.getDragEnabled();
    }

    /**
     * Returns the preview panel that shows a chosen color.
     *
     * @return the preview panel
     */
    public XComponent<XComponent, JComponent> getPreview() {
        return new XComponent<>(component.getPreviewPanel());
    }

    /**
     * Returns the data model that handles color selections.
     *
     * @return a <code>ColorSelectionModel</code> object
     */
    public ColorSelectionModel getSelectionModel() {
        return component.getSelectionModel();
    }

    /**
     * Returns the L&F object that renders this component.
     *
     * @return the <code>ColorChooserUI</code> object that renders
     *         this component
     */
    public ColorChooserUI getUI() {
        return component.getUI();
    }

    /**
     * Returns the name of the L&F class that renders this component.
     *
     * @return the string "ColorChooserUI"
     * @see javax.swing.JComponent#getUIClassID
     * @see javax.swing.UIDefaults#getUI
     */
    public String getUIClassID() {
        return component.getUIClassID();
    }

    /**
     * Removes the Color Panel specified.
     *
     * @param panel a string that specifies the panel to be removed
     * @return a reference to this object.
     */
    public X removeChooserPanel(AbstractColorChooserPanel panel) {
        component.removeChooserPanel(panel);
        return (X) this;
    }

    /**
     * Specifies the Color Panels used to choose a color value.
     *
     * @param panels an array of <code>AbstractColorChooserPanel</code>
     *               objects
     * @return a reference to this object.
     */
    public X chooserPanels(AbstractColorChooserPanel... panels) {
        component.setChooserPanels(panels);
        return (X) this;
    }

    /**
     * Sets the current color of the color chooser to the specified color.
     * The <code>ColorSelectionModel</code> will fire a <code>ChangeEvent</code>
     *
     * @param color the color to be set in the color chooser
     * @return a reference to this object.
     * @see javax.swing.JComponent#addPropertyChangeListener
     */
    public X color(Color color) {
        component.setColor(color);
        return (X) this;
    }

}
