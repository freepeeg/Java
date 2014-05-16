package iitc.chain;

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
 * XComponent
 *
 * @author Ian
 * @version 1.0
 */
@SuppressWarnings("unchecked")
//TODO:Implement unchained methods to avoid having to build to call them
public class XComponent<X extends XComponent, J extends JComponent> {
    protected final J component;

    /**
     * Creates an XComponent, replicating the specified component
     *
     * @param component the component to replicate
     */
    protected XComponent(J component) {
        if (component == null)
            throw new IllegalArgumentException("Component to be decorated cannot be null.");
        this.component = component;
    }

    /**
     * @return the swing component currently being replicated
     */
    public J build() {
        return component;
    }

    /**
     * Resizes this component so that it has width <code>size.width</code>
     * and height <code>size.height</code>.
     * <p/>
     * This method changes layout-related information, and therefore,
     * invalidates the component hierarchy.
     *
     * @param size the dimension specifying the new size
     *             of this component
     * @return a reference to this object.
     * @throws NullPointerException if {@code size} is {@code null}
     */
    public X size(Dimension size) {
        component.setSize(size);
        return (X) this;
    }

    /**
     * Registers the text to display in a tool tip.
     * The text displays when the cursor lingers over the component.
     * <p/>
     * See <a href="http://java.sun.com/docs/books/tutorial/uiswing/components/tooltip.html">How to Use Tool Tips</a>
     * in <em>The Java Tutorial</em>
     * for further documentation.
     *
     * @param text the string to display; if the text is <code>null</code>,
     *             the tool tip is turned off for this component
     *             description: The text to display in a tool tip.
     * @return a reference to this object.
     */
    public X tooltipText(String text) {
        component.setToolTipText(text);
        return (X) this;
    }

    /**
     * Sets the name of the component to the specified string.
     *
     * @param name the string that is to be this
     *             component's name
     * @return a reference to this object.
     */
    public X name(String name) {
        component.setName(name);
        return (X) this;
    }

    /**
     * Makes the component visible or invisible.
     * Overrides <code>Component.setVisible</code>.
     *
     * @param aFlag true to make the component visible; false to
     *              make it invisible
     * @return a reference to this object.
     */
    public X visible(boolean aFlag) {
        component.setVisible(aFlag);
        return (X) this;
    }

    /**
     * Resizes this component so that it has width <code>width</code>
     * and height <code>height</code>.
     * <p/>
     * This method changes layout-related information, and therefore,
     * invalidates the component hierarchy.
     *
     * @param width  the new width of this component in pixels
     * @param height the new height of this component in pixels
     * @return a reference to this object.
     */
    public X size(int width, int height) {
        component.setSize(width, height);
        return (X) this;
    }

    /**
     * Appends the specified component to the end of this container.
     * <p/>
     * This method changes layout-related information, and therefore,
     * invalidates the component hierarchy. If the container has already been
     * displayed, the hierarchy must be validated thereafter in order to
     * display the added component.
     *
     * @param component the component to be added
     * @return a reference to this object.
     */
    public X add(XComponent component) {
        return add(component.build());
    }

    /**
     * Adds the specified component to this container at the given
     * position.
     * <p/>
     * This method changes layout-related information, and therefore,
     * invalidates the component hierarchy. If the container has already been
     * displayed, the hierarchy must be validated thereafter in order to
     * display the added component.
     *
     * @param component the component to be added
     * @param index     the position at which to insert the component,
     *                  or <code>-1</code> to append the component to the end
     * @return a reference to this object.
     * @throws NullPointerException     if {@code comp} is {@code null}
     * @throws IllegalArgumentException if {@code index} is invalid
     */
    public X add(XComponent component, int index) {
        return add(component.build(), index);
    }

    /**
     * Adds the specified component to the end of this container.
     * Also notifies the layout manager to add the component to
     * this container's layout using the specified constraints object.
     * <p/>
     * This method changes layout-related information, and therefore,
     * invalidates the component hierarchy. If the container has already been
     * displayed, the hierarchy must be validated thereafter in order to
     * display the added component.
     *
     * @param component   the component to be added
     * @param constraints an object expressing
     *                    layout contraints for this component
     * @return a reference to this object.
     * @throws NullPointerException if {@code comp} is {@code null}
     */
    public X add(XComponent component, Object constraints) {
        return add(component.build(), constraints);
    }

    /**
     * Adds the specified component to this container with the specified
     * constraints at the specified index.  Also notifies the layout
     * manager to add the component to the this container's layout using
     * the specified constraints object.
     * <p/>
     * This method changes layout-related information, and therefore,
     * invalidates the component hierarchy. If the container has already been
     * displayed, the hierarchy must be validated thereafter in order to
     * display the added component.
     *
     * @param component   the component to be added
     * @param constraints an object expressing layout contraints for this
     * @param index       the position in the container's list at which to insert
     *                    the component; <code>-1</code> means insert at the end
     *                    component
     * @return a reference to this object.
     * @throws NullPointerException     if {@code comp} is {@code null}
     * @throws IllegalArgumentException if {@code index} is invalid
     */
    public X add(XComponent component, Object constraints, int index) {
        return add(component.build(), constraints, index);
    }

    /**
     * Appends the specified component to the end of this container.
     * <p/>
     * This method changes layout-related information, and therefore,
     * invalidates the component hierarchy. If the container has already been
     * displayed, the hierarchy must be validated thereafter in order to
     * display the added component.
     *
     * @param component the component to be added
     * @return a reference to this object.
     */
    public X add(Component component) {
        this.component.add(component);
        return (X) this;
    }

    /**
     * Adds the specified component to this container at the given
     * position.
     * <p/>
     * This method changes layout-related information, and therefore,
     * invalidates the component hierarchy. If the container has already been
     * displayed, the hierarchy must be validated thereafter in order to
     * display the added component.
     *
     * @param component the component to be added
     * @param index     the position at which to insert the component,
     *                  or <code>-1</code> to append the component to the end
     * @return a reference to this object.
     * @throws NullPointerException     if {@code comp} is {@code null}
     * @throws IllegalArgumentException if {@code index} is invalid
     */
    public X add(Component component, int index) {
        this.component.add(component, index);
        return (X) this;
    }

    /**
     * Adds the specified component to the end of this container.
     * Also notifies the layout manager to add the component to
     * this container's layout using the specified constraints object.
     * <p/>
     * This method changes layout-related information, and therefore,
     * invalidates the component hierarchy. If the container has already been
     * displayed, the hierarchy must be validated thereafter in order to
     * display the added component.
     *
     * @param component   the component to be added
     * @param constraints an object expressing
     *                    layout contraints for this component
     * @return a reference to this object.
     * @throws NullPointerException if {@code comp} is {@code null}
     */
    public X add(Component component, Object constraints) {
        this.component.add(component, constraints);
        return (X) this;
    }

    /**
     * Adds the specified component to this container with the specified
     * constraints at the specified index.  Also notifies the layout
     * manager to add the component to the this container's layout using
     * the specified constraints object.
     * <p/>
     * This method changes layout-related information, and therefore,
     * invalidates the component hierarchy. If the container has already been
     * displayed, the hierarchy must be validated thereafter in order to
     * display the added component.
     *
     * @param component   the component to be added
     * @param constraints an object expressing layout contraints for this
     * @param index       the position in the container's list at which to insert
     *                    the component; <code>-1</code> means insert at the end
     *                    component
     * @return a reference to this object.
     * @throws NullPointerException     if {@code comp} is {@code null}
     * @throws IllegalArgumentException if {@code index} is invalid
     */
    public X add(Component component, Object constraints, int index) {
        this.component.add(component, constraints, index);
        return (X) this;
    }

    /**
     * Adds the specified popup menu to the component.
     *
     * @param menu the popup menu to be added to the component.
     * @return a reference to this object.
     * @throws NullPointerException if {@code popup} is {@code null}
     * @see #remove(java.awt.MenuComponent)
     */
    public X add(PopupMenu menu) {
        component.add(menu);
        return (X) this;
    }

    /**
     * Adds the specified component to this container.
     * <p/>
     * This method is obsolete as of 1.1.  Please use the
     * method <code>add(Component, Object)</code> instead.
     * <p/>
     * This method changes layout-related information, and therefore,
     * invalidates the component hierarchy. If the container has already been
     * displayed, the hierarchy must be validated thereafter in order to
     * display the added component.
     *
     * @return a reference to this object.
     * @throws NullPointerException if {@code comp} is {@code null}
     */
    public X add(String name, Component component) {
        this.component.add(name, component);
        return (X) this;
    }

    /**
     * Adds the specified component to this container.
     * <p/>
     * This method is obsolete as of 1.1.  Please use the
     * method <code>add(Component, Object)</code> instead.
     * <p/>
     * This method changes layout-related information, and therefore,
     * invalidates the component hierarchy. If the container has already been
     * displayed, the hierarchy must be validated thereafter in order to
     * display the added component.
     *
     * @return a reference to this object.
     * @throws NullPointerException if {@code comp} is {@code null}
     */
    public X add(String name, XComponent component) {
        return add(name, component.build());
    }

    /**
     * Registers <code>listener</code> so that it will receive
     * <code>AncestorEvents</code> when it or any of its ancestors
     * move or are made visible or invisible.
     * Events are also sent when the component or its ancestors are added
     * or removed from the containment hierarchy.
     *
     * @param listener the <code>AncestorListener</code> to register
     * @return a reference to this object.
     */
    public X ancestorListener(AncestorListener listener) {
        component.addAncestorListener(listener);
        return (X) this;
    }

    /**
     * Adds a <code>VetoableChangeListener</code> to the listener list.
     * The listener is registered for all properties.
     *
     * @param listener the <code>VetoableChangeListener</code> to be added
     * @return a reference to this object.
     */
    public X addVetoable(VetoableChangeListener listener) {
        component.addVetoableChangeListener(listener);
        return (X) this;
    }

    /**
     * Returns the <code>Component</code>'s "visible rect rectangle" -  the
     * intersection of the visible rectangles for this component
     * and all of its ancestors.  The return value is stored in
     * <code>visibleRect</code>.
     *
     * @param visibleRect a <code>Rectangle</code> computed as the
     *                    intersection of all visible rectangles for this
     *                    component and all of its ancestors -- this is the return
     *                    value for this method
     * @return a reference to this object.
     */
    public X computeRect(Rectangle visibleRect) {
        component.computeVisibleRect(visibleRect);
        return (X) this;
    }

    /**
     * Requests that this Component get the input focus, and that this
     * Component's top-level ancestor become the focused Window. This component
     * must be displayable, visible, and focusable for the request to be
     * granted.
     * <p/>
     *
     * @return a reference to this object.
     */
    public X grabFocus() {
        component.grabFocus();
        return (X) this;
    }

    /**
     * Adds an arbitrary key/value "client property" to this component.
     * <p/>
     * The <code>get/putClientProperty</code> methods provide access to
     * a small per-instance hashtable. Callers can use get/putClientProperty
     * to annotate components that were created by another module.
     * For example, a
     * layout manager might store per child constraints this way. For example:
     * <pre>
     * componentA.putClientProperty("to the left of", componentB);
     * </pre>
     * If value is <code>null</code> this method will removeAll the property.
     * Changes to client properties are reported with
     * <code>PropertyChange</code> events.
     * The name of the property (for the sake of PropertyChange
     * events) is <code>key.toString()</code>.
     * <p/>
     * The <code>clientProperty</code> dictionary is not intended to
     * support large
     * scale extensions to JComponent nor should be it considered an
     * alternative to subclassing when designing a new component.
     *
     * @param key   the new client property key
     * @param value the new client property value; if <code>null</code>
     *              this method will removeAll the property
     * @return a reference to this object.
     */
    public X clientProperty(Object key, Object value) {
        component.putClientProperty(key, value);
        return (X) this;
    }

    /**
     * This method is now obsolete, please use a combination of
     * <code>getActionMap()</code> and <code>getInputMap()</code> for
     * similiar behavior.
     *
     * @return a reference to this object.
     */
    public X registerKeyboard(ActionListener listener, KeyStroke keyStroke, int condition) {
        component.registerKeyboardAction(listener, keyStroke, condition);
        return (X) this;
    }

    /**
     * This method is now obsolete, please use a combination of
     * <code>getActionMap()</code> and <code>getInputMap()</code> for
     * similiar behavior. For example, to bind the <code>KeyStroke</code>
     * <code>aKeyStroke</code> to the <code>Action</code> <code>anAction</code>
     * now use:
     * <pre>
     *   component.getInputMap().put(aKeyStroke, aCommand);
     *   component.getActionMap().put(aCommmand, anAction);
     * </pre>
     * The above assumes you want the binding to be applicable for
     * <code>WHEN_FOCUSED</code>. To register bindings for other focus
     * states use the <code>getInputMap</code> method that takes an integer.
     * <p/>
     * Register a new keyboard action.
     * <code>anAction</code> will be invoked if a key event matching
     * <code>aKeyStroke</code> occurs and <code>aCondition</code> is verified.
     * The <code>KeyStroke</code> object defines a
     * particular combination of a keyboard key and one or more modifiers
     * (alt, shift, ctrl, meta).
     * <p/>
     * The <code>aCommand</code> will be set in the delivered event if
     * specified.
     * <p/>
     * The <code>aCondition</code> can be one of:
     * <blockquote>
     * <DL>
     * <DT>WHEN_FOCUSED
     * <DD>The action will be invoked only when the keystroke occurs
     * while the component has the focus.
     * <DT>WHEN_IN_FOCUSED_WINDOW
     * <DD>The action will be invoked when the keystroke occurs while
     * the component has the focus or if the component is in the
     * window that has the focus. Note that the component need not
     * be an immediate descendent of the window -- it can be
     * anywhere in the window's containment hierarchy. In other
     * words, whenever <em>any</em> component in the window has the focus,
     * the action registered with this component is invoked.
     * <DT>WHEN_ANCESTOR_OF_FOCUSED_COMPONENT
     * <DD>The action will be invoked when the keystroke occurs while the
     * component has the focus or if the component is an ancestor of
     * the component that has the focus.
     * </DL>
     * </blockquote>
     * <p/>
     * The combination of keystrokes and conditions lets you define high
     * level (semantic) action events for a specified keystroke+modifier
     * combination (using the KeyStroke class) and direct to a parent or
     * child of a component that has the focus, or to the component itself.
     * In other words, in any hierarchical structure of components, an
     * arbitrary key-combination can be immediately directed to the
     * appropriate component in the hierarchy, and cause a specific method
     * to be invoked (usually by way of adapter objects).
     * <p/>
     * If an action has already been registered for the receiving
     * container, with the same charCode and the same modifiers,
     * <code>anAction</code> will replace the action.
     *
     * @param listener  the <code>Action</code> to be registered
     * @param command   the command to be set in the delivered event
     * @param keyStroke the <code>KeyStroke</code> to bind to the action
     * @param condition the condition that needs to be met, see above
     * @return a reference to this object.
     */
    public X registerKeyboard(ActionListener listener, String command, KeyStroke keyStroke, int condition) {
        component.registerKeyboardAction(listener, command, keyStroke, condition);
        return (X) this;
    }

    /**
     * Unregisters <code>listener</code> so that it will no longer receive
     * <code>AncestorEvents</code>.
     *
     * @param listener the <code>AncestorListener</code> to be removed
     * @return a reference to this object.
     */
    public X removeAncestor(AncestorListener listener) {
        component.removeAncestorListener(listener);
        return (X) this;
    }

    /**
     * Removes the specified component from this container.
     * This method also notifies the layout manager to removeAll the
     * component from this container's layout via the
     * <code>removeLayoutComponent</code> method.
     * <p/>
     * This method changes layout-related information, and therefore,
     * invalidates the component hierarchy. If the container has already been
     * displayed, the hierarchy must be validated thereafter in order to
     * reflect the changes.
     *
     * @param component the component to be removed
     * @return a reference to this object.
     * @throws NullPointerException if {@code comp} is {@code null}
     */
    public X remove(Component component) {
        this.component.remove(component);
        return (X) this;
    }

    /**
     * Removes the component, specified by <code>index</code>,
     * from this container.
     * This method also notifies the layout manager to removeAll the
     * component from this container's layout via the
     * <code>removeLayoutComponent</code> method.
     * <p/>
     * This method changes layout-related information, and therefore,
     * invalidates the component hierarchy. If the container has already been
     * displayed, the hierarchy must be validated thereafter in order to
     * reflect the changes.
     *
     * @param index the index of the component to be removed
     * @return a reference to this object.
     * @throws ArrayIndexOutOfBoundsException if {@code index} is not in
     *                                        range {@code [0, getComponentCount()-1]}
     */
    public X remove(int index) {
        component.remove(index);
        return (X) this;
    }

    /**
     * Removes the specified component from this container.
     * This method also notifies the layout manager to removeAll the
     * component from this container's layout via the
     * <code>removeLayoutComponent</code> method.
     * <p/>
     * This method changes layout-related information, and therefore,
     * invalidates the component hierarchy. If the container has already been
     * displayed, the hierarchy must be validated thereafter in order to
     * reflect the changes.
     *
     * @param component the component to be removed
     * @return a reference to this object.
     * @throws NullPointerException if {@code comp} is {@code null}
     */
    public X remove(XComponent component) {
        return remove(component.build());
    }

    /**
     * Removes the specified popup menu from the component.
     *
     * @param component the popup menu to be removed
     * @return a reference to this object.
     */
    public X remove(MenuComponent component) {
        this.component.remove(component);
        return (X) this;
    }

    /**
     * Removes a <code>VetoableChangeListener</code> from the listener list.
     * This removes a <code>VetoableChangeListener</code> that was registered
     * for all properties.
     *
     * @param listener the <code>VetoableChangeListener</code> to be removed
     * @return a reference to this object.
     */
    public X removeVetoable(VetoableChangeListener listener) {
        component.removeVetoableChangeListener(listener);
        return (X) this;
    }

    /**
     * Requests that this <code>Component</code> gets the input focus.
     * Refer to {@link java.awt.Component#requestFocus()
     * Component.requestFocus()} for a complete description of
     * this method.
     * <p/>
     * Note that the use of this method is discouraged because
     * its behavior is platform dependent.
     * If you would like more information on focus, see
     * <a href="http://java.sun.com/docs/books/tutorial/uiswing/misc/focus.html">
     * How to Use the Focus Subsystem</a>,
     * a section in <em>The Java Tutorial</em>.
     *
     * @return a reference to this object.
     * @see java.awt.Component#requestFocusInWindow()
     * @see java.awt.Component#requestFocusInWindow(boolean)
     */
    public X requestFocus() {
        component.requestFocus();
        return (X) this;
    }

    /**
     * Requests that this <code>Component</code> gets the input focus.
     * Refer to {@link java.awt.Component#requestFocus(boolean)
     * Component.requestFocus(boolean)} for a complete description of
     * this method.
     * <p/>
     * Note that the use of this method is discouraged because
     * its behavior is platform dependent.
     * If you would like more information on focus, see
     * <a href="http://java.sun.com/docs/books/tutorial/uiswing/misc/focus.html">
     * How to Use the Focus Subsystem</a>,
     * a section in <em>The Java Tutorial</em>.
     *
     * @param temporary boolean indicating if the focus change is temporary
     * @return a reference to this object.
     * @see java.awt.Component#requestFocusInWindow()
     * @see java.awt.Component#requestFocusInWindow(boolean)
     */
    public X requestFocus(boolean temporary) {
        component.requestFocus(temporary);
        return (X) this;
    }

    /**
     * Supports deferred automatic layout.
     * <p/>
     * Calls <code>invalidate</code> and then adds this component's
     * <code>validateRoot</code> to a list of components that need to be
     * validated.  Validation will occur after all currently pending
     * events have been dispatched.  In other words after this method
     * is called,  the first validateRoot (if any) found when walking
     * up the containment hierarchy of this component will be validated.
     * By default, <code>JRootPane</code>, <code>JScrollPane</code>,
     * and <code>JTextField</code> return true
     * from <code>isValidateRoot</code>.
     * <p/>
     * This method will automatically be called on this component
     * when a property value changes such that size, location, or
     * internal layout of this component has been affected.  This automatic
     * updating differs from the AWT because programs generally no
     * longer need to invoke <code>validate</code> to get the contents of the
     * GUI to update.
     * <p/>
     *
     * @return a reference to this object.
     */
    public X revalidate() {
        component.revalidate();
        return (X) this;
    }

    /**
     * Forwards the <code>scrollRectToVisible()</code> message to the
     * <code>JComponent</code>'s parent. Components that can service
     * the request, such as <code>JViewport</code>,
     * override this method and transform the scrolling.
     *
     * @param rectangle the visible <code>Rectangle</code>
     * @return a reference to this object.
     */
    public X scrollToVisible(Rectangle rectangle) {
        component.scrollRectToVisible(rectangle);
        return (X) this;
    }

    /**
     * Sets the <code>ActionMap</code> to <code>am</code>. This does not set
     * the parent of the <code>am</code> to be the <code>ActionMap</code>
     * from the UI (if there was one), it is up to the caller to have done this.
     *
     * @param map the new <code>ActionMap</code>
     * @return a reference to this object.
     */
    public X actionMap(ActionMap map) {
        component.setActionMap(map);
        return (X) this;
    }

    /**
     * Sets the the vertical alignment.
     *
     * @param alignmentX the new vertical alignment
     * @return a reference to this object.
     */
    public X alignX(float alignmentX) {
        component.setAlignmentX(alignmentX);
        return (X) this;
    }

    /**
     * Sets the the horizontal alignment.
     *
     * @param alignmentY the new horizontal alignment
     * @return a reference to this object.
     */
    public X alignY(float alignmentY) {
        component.setAlignmentY(alignmentY);
        return (X) this;
    }

    /**
     * Sets the <code>autoscrolls</code> property.
     * If <code>true</code> mouse dragged events will be
     * synthetically generated when the mouse is dragged
     * outside of the component's bounds and mouse motion
     * has paused (while the button continues to be held
     * down). The synthetic events make it appear that the
     * drag gesture has resumed in the direction established when
     * the component's boundary was crossed.  Components that
     * support autoscrolling must handle <code>mouseDragged</code>
     * events by calling <code>scrollRectToVisible</code> with a
     * rectangle that contains the mouse event's location.  All of
     * the Swing components that support item selection and are
     * typically displayed in a <code>JScrollPane</code>
     * (<code>JTable</code>, <code>JList</code>, <code>JTree</code>,
     * <code>JTextArea</code>, and <code>JEditorPane</code>)
     * already handle mouse dragged events in this way.  To enable
     * autoscrolling in any other component, add a mouse motion
     * listener that calls <code>scrollRectToVisible</code>.
     * For example, given a <code>JPanel</code>, <code>myPanel</code>:
     * <pre>
     * MouseMotionListener doScrollRectToVisible = new MouseMotionAdapter() {
     *     public void mouseDragged(MouseEvent e) {
     *        Rectangle r = new Rectangle(e.getX(), e.getY(), 1, 1);
     *        ((JPanel)e.getSource()).scrollRectToVisible(r);
     *    }
     * };
     * myPanel.addMouseMotionListener(doScrollRectToVisible);
     * </pre>
     * The default value of the <code>autoScrolls</code>
     * property is <code>false</code>.
     *
     * @param autoscrolls if true, synthetic mouse dragged events
     *                    are generated when the mouse is dragged outside of a component's
     *                    bounds and the mouse button continues to be held down; otherwise
     *                    false
     * @return a reference to this object.
     */
    public X autoScrolls(boolean autoscrolls) {
        component.setAutoscrolls(autoscrolls);
        return (X) this;
    }

    /**
     * Sets the background color of this component.  The background
     * color is used only if the component is opaque, and only
     * by subclasses of <code>JComponent</code> or
     * <code>ComponentUI</code> implementations.  Direct subclasses of
     * <code>JComponent</code> must override
     * <code>paintComponent</code> to honor this property.
     * <p/>
     * It is up to the look and feel to honor this property, some may
     * choose to ignore it.
     *
     * @param bg the desired background <code>Color</code>
     * @return a reference to this object.
     * @see java.awt.Component#getBackground
     */
    public X background(Color bg) {
        component.setBackground(bg);
        return (X) this;
    }

    /**
     * Sets the border of this component.  The <code>Border</code> object is
     * responsible for defining the insets for the component
     * (overriding any insets set directly on the component) and
     * for optionally rendering any border decorations within the
     * bounds of those insets.  Borders should be used (rather
     * than insets) for creating both decorative and non-decorative
     * (such as margins and padding) regions for a swing component.
     * Compound borders can be used to nest multiple borders within a
     * single component.
     * <p/>
     * Although technically you can set the border on any object
     * that inherits from <code>JComponent</code>, the look and
     * feel implementation of many standard Swing components
     * doesn't java.work well with user-set borders.  In general,
     * when you want to set a border on a standard Swing
     * component other than <code>JPanel</code> or <code>JLabel</code>,
     * we recommend that you put the component in a <code>JPanel</code>
     * and set the border on the <code>JPanel</code>.
     * <p/>
     * This is a bound property.
     *
     * @param border the border to be rendered for this component
     * @return a reference to this object.
     */
    public X border(Border border) {
        component.setBorder(border);
        return (X) this;
    }

    /**
     * Sets the <code>JPopupMenu</code> for this <code>JComponent</code>.
     * The UI is responsible for registering bindings and adding the necessary
     * listeners such that the <code>JPopupMenu</code> will be shown at
     * the appropriate time. When the <code>JPopupMenu</code> is shown
     * depends upon the look and feel: some may show it on a mouse event,
     * some may enable a key binding.
     * <p/>
     * If <code>popup</code> is null, and <code>getInheritsPopupMenu</code>
     * returns true, then <code>getComponentPopupMenu</code> will be delegated
     * to the parent. This provides for a way to make all child components
     * inherit the popupmenu of the parent.
     * <p/>
     * This is a bound property.
     *
     * @param menu the popup that will be assigned to this component
     *             may be null
     * @return a reference to this object.
     */
    public X componentPopupMenu(JPopupMenu menu) {
        component.setComponentPopupMenu(menu);
        return (X) this;
    }

    /**
     * Enables or disables diagnostic information about every graphics
     * operation performed within the component or one of its children.
     *
     * @param debugOptions determines how the component should display
     *                     the information;  one of the following options:
     *                     <ul>
     *                     <li>DebugGraphics.LOG_OPTION - causes a text message to be printed.
     *                     <li>DebugGraphics.FLASH_OPTION - causes the drawing to flash several
     *                     times.
     *                     <li>DebugGraphics.BUFFERED_OPTION - creates an
     *                     <code>ExternalWindow</code> that displays the operations
     *                     performed on the View's offscreen buffer.
     *                     <li>DebugGraphics.NONE_OPTION disables debugging.
     *                     <li>A value of 0 causes no changes to the debugging options.
     *                     </ul>
     *                     <code>debugOptions</code> is bitwise OR'd into the current value
     * @return a reference to this object.
     */
    public X debugGraphicsOptions(int debugOptions) {
        component.setDebugGraphicsOptions(debugOptions);
        return (X) this;
    }

    /**
     * Sets whether this component should use a buffer to paint.
     * If set to true, all the drawing from this component will be done
     * in an offscreen painting buffer. The offscreen painting buffer will
     * the be copied onto the screen.
     * If a <code>Component</code> is buffered and one of its ancestor
     * is also buffered, the ancestor buffer will be used.
     *
     * @param aFlag if true, set this component to be double buffered
     * @return a reference to this object.
     */
    public X doubleBuffered(boolean aFlag) {
        component.setDoubleBuffered(aFlag);
        return (X) this;
    }

    /**
     * Sets whether or not this component is enabled.
     * A component that is enabled may respond to user input,
     * while a component that is not enabled cannot respond to
     * user input.  Some components may alter their visual
     * representation when they are disabled in order to
     * provide feedback to the user that they cannot take input.
     * <p>Note: Disabling a component does not disable its children.
     * <p/>
     * <p>Note: Disabling a lightweight component does not prevent it from
     * receiving MouseEvents.
     *
     * @param enabled true if this component should be enabled, false otherwise
     * @return a reference to this object.
     */
    public X enabled(boolean enabled) {
        component.setEnabled(enabled);
        return (X) this;
    }

    /**
     * Sets the focus traversal keys for a given traversal operation for this
     * Component.
     * Refer to
     * {@link java.awt.Component#setFocusTraversalKeys}
     * for a complete description of this method.
     *
     * @param id         one of KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS,
     *                   KeyboardFocusManager.BACKWARD_TRAVERSAL_KEYS, or
     *                   KeyboardFocusManager.UP_CYCLE_TRAVERSAL_KEYS
     * @param keystrokes the Set of AWTKeyStroke for the specified operation
     * @return a reference to this object.
     * @throws IllegalArgumentException if id is not one of
     *                                  KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS,
     *                                  KeyboardFocusManager.BACKWARD_TRAVERSAL_KEYS, or
     *                                  KeyboardFocusManager.UP_CYCLE_TRAVERSAL_KEYS, or if keystrokes
     *                                  contains null, or if any Object in keystrokes is not an
     *                                  AWTKeyStroke, or if any keystroke represents a KEY_TYPED event,
     *                                  or if any keystroke already maps to another focus traversal
     *                                  operation for this Component
     * @see java.awt.KeyboardFocusManager#FORWARD_TRAVERSAL_KEYS
     * @see java.awt.KeyboardFocusManager#BACKWARD_TRAVERSAL_KEYS
     * @see java.awt.KeyboardFocusManager#UP_CYCLE_TRAVERSAL_KEYS
     */
    public X focusTraversalKeys(int id, Set<? extends AWTKeyStroke> keystrokes) {
        component.setFocusTraversalKeys(id, keystrokes);
        return (X) this;
    }

    /**
     * Sets the font for this component.
     *
     * @param font the desired <code>Font</code> for this component
     * @return a reference to this object.
     * @see java.awt.Component#getFont
     */
    public X font(Font font) {
        component.setFont(font);
        return (X) this;
    }

    /**
     * Sets the foreground color of this component.  It is up to the
     * look and feel to honor this property, some may choose to ignore
     * it.
     *
     * @param fg the desired foreground <code>Color</code>
     * @return a reference to this object.
     * @see java.awt.Component#getForeground
     */
    public X foreground(Color fg) {
        component.setForeground(fg);
        return (X) this;
    }

    /**
     * Sets whether or not <code>getComponentPopupMenu</code> should delegate
     * to the parent if this component does not have a <code>JPopupMenu</code>
     * assigned to it.
     * <p/>
     * The default value for this is false, but some <code>JComponent</code>
     * subclasses that are implemented as a number of <code>JComponent</code>s
     * may set this to true.
     * <p/>
     * This is a bound property.
     *
     * @param value whether or not the JPopupMenu is inherited
     * @return a reference to this object.
     */
    public X inheritsPopupMenu(boolean value) {
        component.setInheritsPopupMenu(value);
        return (X) this;
    }

    /**
     * Sets the <code>InputMap</code> to use under the condition
     * <code>condition</code> to
     * <code>map</code>. A <code>null</code> value implies you
     * do not want any bindings to be used, even from the UI. This will
     * not reinstall the UI <code>InputMap</code> (if there was one).
     * <code>condition</code> has one of the following values:
     * <ul>
     * <li><code>WHEN_IN_FOCUSED_WINDOW</code>
     * <li><code>WHEN_FOCUSED</code>
     * <li><code>WHEN_ANCESTOR_OF_FOCUSED_COMPONENT</code>
     * </ul>
     * If <code>condition</code> is <code>WHEN_IN_FOCUSED_WINDOW</code>
     * and <code>map</code> is not a <code>ComponentInputMap</code>, an
     * <code>IllegalArgumentException</code> will be thrown.
     * Similarly, if <code>condition</code> is not one of the values
     * listed, an <code>IllegalArgumentException</code> will be thrown.
     *
     * @param condition one of the values listed above
     * @param map       the <code>InputMap</code> to use for the given condition
     * @return a reference to this object.
     * @throws IllegalArgumentException if <code>condition</code> is
     *                                  <code>WHEN_IN_FOCUSED_WINDOW</code> and <code>map</code>
     *                                  is not an instance of <code>ComponentInputMap</code>; or
     *                                  if <code>condition</code> is not one of the legal values
     *                                  specified above
     */
    public X inputMap(int condition, InputMap map) {
        component.setInputMap(condition, map);
        return (X) this;
    }

    /**
     * Sets the input verifier for this component.
     *
     * @param verifier the new input verifier
     * @return a reference to this object.
     */
    public X inputVerifier(InputVerifier verifier) {
        component.setInputVerifier(verifier);
        return (X) this;
    }

    /**
     * Sets the maximum size of this component to a constant
     * value.  Subsequent calls to <code>getMaximumSize</code> will always
     * return this value; the component's UI will not be asked
     * to compute it.  Setting the maximum size to <code>null</code>
     * restores the default behavior.
     *
     * @param max a <code>Dimension</code> containing the
     *            desired maximum allowable size
     * @return a reference to this object.
     */
    public X maximumSize(Dimension max) {
        component.setMaximumSize(max);
        return (X) this;
    }

    /**
     * Sets the minimum size of this component to a constant
     * value.  Subsequent calls to <code>getMinimumSize</code> will always
     * return this value; the component's UI will not be asked
     * to compute it.  Setting the minimum size to <code>null</code>
     * restores the default behavior.
     *
     * @param min the new minimum size of this component
     * @return a reference to this object.
     */
    public X minimumSize(Dimension min) {
        component.setMinimumSize(min);
        return (X) this;
    }

    /**
     * If true the component paints every pixel within its bounds.
     * Otherwise, the component may not paint some or all of its
     * pixels, allowing the underlying pixels to show through.
     * <p/>
     * The default value of this property is false for <code>JComponent</code>.
     * However, the default value for this property on most standard
     * <code>JComponent</code> subclasses (such as <code>JButton</code> and
     * <code>JTree</code>) is look-and-feel dependent.
     *
     * @param isOpaque true if this component should be opaque
     * @return a reference to this object.
     */
    public X opaque(boolean isOpaque) {
        component.setOpaque(isOpaque);
        return (X) this;
    }

    /**
     * Sets the preferred size of this component.
     * If <code>preferredSize</code> is <code>null</code>, the UI will
     * be asked for the preferred size.
     *
     * @return a reference to this object.
     */
    public X preferredSize(Dimension preferredSize) {
        component.setPreferredSize(preferredSize);
        return (X) this;
    }

    /**
     * Provides a hint as to whether or not this <code>JComponent</code>
     * should get focus. This is only a hint, and it is up to consumers that
     * are requesting focus to honor this property. This is typically honored
     * for mouse operations, but not keyboard operations. For example, look
     * and feels could verify this property is true before requesting focus
     * during a mouse operation. This would often times be used if you did
     * not want a mouse press on a <code>JComponent</code> to steal focus,
     * but did want the <code>JComponent</code> to be traversable via the
     * keyboard. If you do not want this <code>JComponent</code> focusable at
     * all, use the <code>setFocusable</code> method instead.
     * <p/>
     * Please see
     * <a href="http://java.sun.com/docs/books/tutorial/uiswing/misc/focus.html">
     * How to Use the Focus Subsystem</a>,
     * a section in <em>The Java Tutorial</em>,
     * for more information.
     *
     * @param requestFocusEnabled indicates whether you want this
     *                            <code>JComponent</code> to be focusable or not
     * @return a reference to this object.
     */
    public X requestFocusEnabled(boolean requestFocusEnabled) {
        component.setRequestFocusEnabled(requestFocusEnabled);
        return (X) this;
    }

    /**
     * Sets the {@code TransferHandler}, which provides support for transfer
     * of data into and out of this component via cut/copy/paste and drag
     * and drop. This may be {@code null} if the component does not support
     * data transfer operations.
     * <p/>
     * If the new {@code TransferHandler} is not {@code null}, this method
     * also installs a <b>new</b> {@code DropTarget} on the component to
     * activate drop handling through the {@code TransferHandler} and activate
     * any built-in support (such as calculating and displaying potential drop
     * locations). If you do not wish for this component to respond in any way
     * to drops, you can disable drop support entirely either by removing the
     * drop target ({@code setDropTarget(null)}) or by de-activating it
     * ({@code getDropTaget().setActive(false)}).
     * <p/>
     * If the new {@code TransferHandler} is {@code null}, this method removes
     * the drop target.
     * <p/>
     * Under two circumstances, this method does not modify the drop target:
     * First, if the existing drop target on this component was explicitly
     * set by the developer to a {@code non-null} value. Second, if the
     * system property {@code suppressSwingDropSupport} is {@code true}. The
     * default value for the system property is {@code false}.
     * <p/>
     * Please see
     * <a href="http://java.sun.com/docs/books/tutorial/uiswing/misc/dnd.html">
     * How to Use Drag and Drop and Data Transfer</a>,
     * a section in <em>The Java Tutorial</em>, for more information.
     *
     * @param handler the new {@code TransferHandler}
     * @return a reference to this object.
     */
    public X transferHandler(TransferHandler handler) {
        component.setTransferHandler(handler);
        return (X) this;
    }

    /**
     * Sets the value to indicate whether input verifier for the
     * current focus owner will be called before this component requests
     * focus. The default is true. Set to false on components such as a
     * Cancel button or a scrollbar, which should activate even if the
     * input in the current focus owner is not "passed" by the input
     * verifier for that component.
     *
     * @param verifyInputWhenFocusTarget value for the
     *                                   <code>verifyInputWhenFocusTarget</code> property
     * @return a reference to this object.
     */
    public X verifyInputWhenFocusTarget(boolean verifyInputWhenFocusTarget) {
        component.setVerifyInputWhenFocusTarget(verifyInputWhenFocusTarget);
        return (X) this;
    }

    /**
     * This method is now obsolete. To unregister an existing binding
     * you can either removeAll the binding from the
     * <code>ActionMap/InputMap</code>, or place a dummy binding the
     * <code>InputMap</code>. Removing the binding from the
     * <code>InputMap</code> allows bindings in parent <code>InputMap</code>s
     * to be active, whereas putting a dummy binding in the
     * <code>InputMap</code> effectively disables
     * the binding from ever happening.
     * <p/>
     * Unregisters a keyboard action.
     * This will removeAll the binding from the <code>ActionMap</code>
     * (if it exists) as well as the <code>InputMap</code>s.
     *
     * @return a reference to this object.
     */
    public X unregisterAction(KeyStroke aKeyStroke) {
        component.unregisterKeyboardAction(aKeyStroke);
        return (X) this;
    }

    /**
     * Resets the UI property to a value from the current look and feel.
     *
     * @return a reference to this object.
     */
    public X updateUI() {
        component.updateUI();
        return (X) this;
    }

    /**
     * Adds the specified component listener to receive component events from
     * this component.
     * If listener <code>l</code> is <code>null</code>,
     * no exception is thrown and no action is performed.
     * <p>Refer to <a href="doc-files/AWTThreadIssues.html#ListenersThreads"
     * >AWT Threading Issues</a> for details on AWT's threading model.
     *
     * @param listener the component listener
     * @return a reference to this object.
     */
    public X componentListener(ComponentListener listener) {
        component.addComponentListener(listener);
        return (X) this;
    }

    /**
     * Adds the specified component listener to receive component events from
     * this component.
     * If listener <code>l</code> is <code>null</code>,
     * no exception is thrown and no action is performed.
     * <p>Refer to <a href="doc-files/AWTThreadIssues.html#ListenersThreads"
     * >AWT Threading Issues</a> for details on AWT's threading model.
     *
     * @param listener the component listener
     * @return a reference to this object.
     */
    public X containerListener(ContainerListener listener) {
        component.addContainerListener(listener);
        return (X) this;
    }

    /**
     * Adds the specified focus listener to receive focus events from
     * this component when this component gains input focus.
     * If listener <code>l</code> is <code>null</code>,
     * no exception is thrown and no action is performed.
     * <p>Refer to <a href="doc-files/AWTThreadIssues.html#ListenersThreads"
     * >AWT Threading Issues</a> for details on AWT's threading model.
     *
     * @param listener the focus listener
     * @return a reference to this object.
     */
    public X focusListener(FocusListener listener) {
        component.addFocusListener(listener);
        return (X) this;
    }

    /**
     * Adds the specified hierarchy bounds listener to receive hierarchy
     * bounds events from this component when the hierarchy to which this
     * container belongs changes.
     * If listener <code>l</code> is <code>null</code>,
     * no exception is thrown and no action is performed.
     * <p>Refer to <a href="doc-files/AWTThreadIssues.html#ListenersThreads"
     * >AWT Threading Issues</a> for details on AWT's threading model.
     *
     * @param listener the hierarchy bounds listener
     * @return a reference to this object.
     */
    public X hierarchyBoundsListener(HierarchyBoundsListener listener) {
        component.addHierarchyBoundsListener(listener);
        return (X) this;
    }

    /**
     * Adds the specified hierarchy listener to receive hierarchy changed
     * events from this component when the hierarchy to which this container
     * belongs changes.
     * If listener <code>l</code> is <code>null</code>,
     * no exception is thrown and no action is performed.
     * <p>Refer to <a href="doc-files/AWTThreadIssues.html#ListenersThreads"
     * >AWT Threading Issues</a> for details on AWT's threading model.
     *
     * @param listener the hierarchy listener
     * @return a reference to this object.
     */
    public X hierarchyListener(HierarchyListener listener) {
        component.addHierarchyListener(listener);
        return (X) this;
    }

    /**
     * Adds the specified input method listener to receive
     * input method events from this component. A component will
     * only receive input method events from input methods
     * if it also overrides <code>getInputMethodRequests</code> to return an
     * <code>InputMethodRequests</code> instance.
     * If listener <code>l</code> is <code>null</code>,
     * no exception is thrown and no action is performed.
     * <p>Refer to <a href="{@docRoot}/java/awt/doc-files/AWTThreadIssues.html#ListenersThreads"
     * >AWT Threading Issues</a> for details on AWT's threading model.
     *
     * @param listener the input method listener
     * @return a reference to this object.
     */
    public X inputMethodListener(InputMethodListener listener) {
        component.addInputMethodListener(listener);
        return (X) this;
    }

    /**
     * Adds the specified key listener to receive key events from
     * this component.
     * If l is null, no exception is thrown and no action is performed.
     * <p>Refer to <a href="doc-files/AWTThreadIssues.html#ListenersThreads"
     * >AWT Threading Issues</a> for details on AWT's threading model.
     *
     * @param listener the key listener.
     * @return a reference to this object.
     */
    public X keyListener(KeyListener listener) {
        component.addKeyListener(listener);
        return (X) this;
    }

    /**
     * Adds the specified mouse listener to receive mouse events from
     * this component.
     * If listener <code>l</code> is <code>null</code>,
     * no exception is thrown and no action is performed.
     * <p>Refer to <a href="doc-files/AWTThreadIssues.html#ListenersThreads"
     * >AWT Threading Issues</a> for details on AWT's threading model.
     *
     * @param listener the mouse listener
     * @return a reference to this object.
     */
    public X mouseListener(MouseListener listener) {
        component.addMouseListener(listener);
        return (X) this;
    }

    /**
     * Adds the specified mouse motion listener to receive mouse motion
     * events from this component.
     * If listener <code>l</code> is <code>null</code>,
     * no exception is thrown and no action is performed.
     * <p>Refer to <a href="doc-files/AWTThreadIssues.html#ListenersThreads"
     * >AWT Threading Issues</a> for details on AWT's threading model.
     *
     * @param listener the mouse motion listener
     * @return a reference to this object.
     */
    public X mouseMotionListener(MouseMotionListener listener) {
        component.addMouseMotionListener(listener);
        return (X) this;
    }

    /**
     * Adds the specified mouse wheel listener to receive mouse wheel events
     * from this component.  Containers also receive mouse wheel events from
     * sub-components.
     * <p/>
     * For information on how mouse wheel events are dispatched, see
     * the class description for {@link java.awt.event.MouseWheelEvent}.
     * <p/>
     * If l is <code>null</code>, no exception is thrown and no
     * action is performed.
     * <p>Refer to <a href="doc-files/AWTThreadIssues.html#ListenersThreads"
     * >AWT Threading Issues</a> for details on AWT's threading model.
     *
     * @param listener the mouse wheel listener
     * @return a reference to this object.
     */
    public X mouseWheelListener(MouseWheelListener listener) {
        component.addMouseWheelListener(listener);
        return (X) this;
    }

    /**
     * Adds a PropertyChangeListener to the listener list. The listener is
     * registered for all bound properties of this class, including the
     * following:
     * <ul>
     * <li>this Container's font ("font")</li>
     * <li>this Container's background color ("background")</li>
     * <li>this Container's foreground color ("foreground")</li>
     * <li>this Container's focusability ("focusable")</li>
     * <li>this Container's focus traversal keys enabled state
     * ("focusTraversalKeysEnabled")</li>
     * <li>this Container's Set of FORWARD_TRAVERSAL_KEYS
     * ("forwardFocusTraversalKeys")</li>
     * <li>this Container's Set of BACKWARD_TRAVERSAL_KEYS
     * ("backwardFocusTraversalKeys")</li>
     * <li>this Container's Set of UP_CYCLE_TRAVERSAL_KEYS
     * ("upCycleFocusTraversalKeys")</li>
     * <li>this Container's Set of DOWN_CYCLE_TRAVERSAL_KEYS
     * ("downCycleFocusTraversalKeys")</li>
     * <li>this Container's focus traversal policy ("focusTraversalPolicy")
     * </li>
     * <li>this Container's focus-cycle-root state ("focusCycleRoot")</li>
     * </ul>
     * Note that if this Container is inheriting a bound property, then no
     * event will be fired in response to a change in the inherited property.
     * <p/>
     * If listener is null, no exception is thrown and no action is performed.
     *
     * @param listener the PropertyChangeListener to be added
     * @return a reference to this object.
     */
    public X propertyChangeListener(PropertyChangeListener listener) {
        component.addPropertyChangeListener(listener);
        return (X) this;
    }

    /**
     * Adds a PropertyChangeListener to the listener list for a specific
     * property. The specified property may be user-defined, or one of the
     * following defaults:
     * <ul>
     * <li>this Container's font ("font")</li>
     * <li>this Container's background color ("background")</li>
     * <li>this Container's foreground color ("foreground")</li>
     * <li>this Container's focusability ("focusable")</li>
     * <li>this Container's focus traversal keys enabled state
     * ("focusTraversalKeysEnabled")</li>
     * <li>this Container's Set of FORWARD_TRAVERSAL_KEYS
     * ("forwardFocusTraversalKeys")</li>
     * <li>this Container's Set of BACKWARD_TRAVERSAL_KEYS
     * ("backwardFocusTraversalKeys")</li>
     * <li>this Container's Set of UP_CYCLE_TRAVERSAL_KEYS
     * ("upCycleFocusTraversalKeys")</li>
     * <li>this Container's Set of DOWN_CYCLE_TRAVERSAL_KEYS
     * ("downCycleFocusTraversalKeys")</li>
     * <li>this Container's focus traversal policy ("focusTraversalPolicy")
     * </li>
     * <li>this Container's focus-cycle-root state ("focusCycleRoot")</li>
     * <li>this Container's focus-traversal-policy-provider state("focusTraversalPolicyProvider")</li>
     * <li>this Container's focus-traversal-policy-provider state("focusTraversalPolicyProvider")</li>
     * </ul>
     * Note that if this Container is inheriting a bound property, then no
     * event will be fired in response to a change in the inherited property.
     * <p/>
     * If listener is null, no exception is thrown and no action is performed.
     *
     * @param property one of the property names listed above
     * @param listener the PropertyChangeListener to be added
     * @return a reference to this object.
     */
    public X propertyChangeListener(String property, PropertyChangeListener listener) {
        component.addPropertyChangeListener(property, listener);
        return (X) this;
    }

    /**
     * Sets the <code>ComponentOrientation</code> property of this container
     * and all components contained within it.
     * <p/>
     * This method changes layout-related information, and therefore,
     * invalidates the component hierarchy.
     *
     * @param orientation the new component orientation of this container and
     *                    the components contained within it.
     * @return a reference to this object.
     * @throws NullPointerException if <code>orientation</code> is null.
     */
    public X applyOrientation(ComponentOrientation orientation) {
        component.applyComponentOrientation(orientation);
        return (X) this;
    }

    /**
     * Dispatches an event to this component or one of its sub components.
     * Calls <code>processEvent</code> before returning for 1.1-style
     * events which have been enabled for the <code>Component</code>.
     *
     * @param event the event
     * @return a reference to this object.
     */
    public X dispatch(AWTEvent event) {
        component.dispatchEvent(event);
        return (X) this;
    }

    /**
     * Causes this container to lay out its components.  Most programs
     * should not call this method directly, but should invoke
     * the <code>validate</code> method instead.
     *
     * @return a reference to this object.
     */
    public X layout() {
        component.doLayout();
        return (X) this;
    }

    /**
     * Enables or disables input method support for this component. If input
     * method support is enabled and the component also processes key events,
     * incoming events are offered to
     * the current input method and will only be processed by the component or
     * dispatched to its listeners if the input method does not consume them.
     * By default, input method support is enabled.
     *
     * @param enableInputMethods true to enable, false to disable
     * @return a reference to this object.
     */
    public X enableInputMethods(boolean enableInputMethods) {
        component.enableInputMethods(enableInputMethods);
        return (X) this;
    }

    /**
     * Removes all the components from this container.
     * This method also notifies the layout manager to removeAll the
     * components from this container's layout via the
     * <code>removeLayoutComponent</code> method.
     * <p/>
     * This method changes layout-related information, and therefore,
     * invalidates the component hierarchy. If the container has already been
     * displayed, the hierarchy must be validated thereafter in order to
     * reflect the changes.
     *
     * @return a reference to this object.
     */
    public X removeAll() {
        component.removeAll();
        return (X) this;
    }

    /**
     * Removes the specified component listener so that it no longer
     * receives component events from this component. This method performs
     * no function, nor does it throw an exception, if the listener
     * specified by the argument was not previously added to this component.
     * If listener <code>l</code> is <code>null</code>,
     * no exception is thrown and no action is performed.
     * <p>Refer to <a href="doc-files/AWTThreadIssues.html#ListenersThreads"
     * >AWT Threading Issues</a> for details on AWT's threading model.
     *
     * @param listener the component listener
     * @return a reference to this object.
     */
    public X removeComponentListener(ComponentListener listener) {
        component.removeComponentListener(listener);
        return (X) this;
    }

    /**
     * Removes the specified container listener so it no longer receives
     * container events from this container.
     * If l is null, no exception is thrown and no action is performed.
     * <p>Refer to <a href="doc-files/AWTThreadIssues.html#ListenersThreads"
     * >AWT Threading Issues</a> for details on AWT's threading model.
     *
     * @param listener the container listener
     * @return a reference to this object.
     */
    public X removeContainerListener(ContainerListener listener) {
        component.removeContainerListener(listener);
        return (X) this;
    }

    /**
     * Removes the specified focus listener so that it no longer
     * receives focus events from this component. This method performs
     * no function, nor does it throw an exception, if the listener
     * specified by the argument was not previously added to this component.
     * If listener <code>l</code> is <code>null</code>,
     * no exception is thrown and no action is performed.
     * <p>Refer to <a href="doc-files/AWTThreadIssues.html#ListenersThreads"
     * >AWT Threading Issues</a> for details on AWT's threading model.
     *
     * @param listener the focus listener
     * @return a reference to this object.
     */
    public X removeFocusListener(FocusListener listener) {
        component.removeFocusListener(listener);
        return (X) this;
    }

    /**
     * Removes the specified hierarchy bounds listener so that it no longer
     * receives hierarchy bounds events from this component. This method
     * performs no function, nor does it throw an exception, if the listener
     * specified by the argument was not previously added to this component.
     * If listener <code>l</code> is <code>null</code>,
     * no exception is thrown and no action is performed.
     * <p>Refer to <a href="doc-files/AWTThreadIssues.html#ListenersThreads"
     * >AWT Threading Issues</a> for details on AWT's threading model.
     *
     * @param listener the hierarchy bounds listener
     * @return a reference to this object.
     */
    public X removeHierarchyBoundsListener(HierarchyBoundsListener listener) {
        component.removeHierarchyBoundsListener(listener);
        return (X) this;
    }

    /**
     * Removes the specified hierarchy listener so that it no longer
     * receives hierarchy changed events from this component. This method
     * performs no function, nor does it throw an exception, if the listener
     * specified by the argument was not previously added to this component.
     * If listener <code>l</code> is <code>null</code>,
     * no exception is thrown and no action is performed.
     * <p>Refer to <a href="doc-files/AWTThreadIssues.html#ListenersThreads"
     * >AWT Threading Issues</a> for details on AWT's threading model.
     *
     * @param listener the hierarchy listener
     * @return a reference to this object.
     */
    public X removeHierarchyListener(HierarchyListener listener) {
        component.removeHierarchyListener(listener);
        return (X) this;
    }

    /**
     * Removes the specified input method listener so that it no longer
     * receives input method events from this component. This method performs
     * no function, nor does it throw an exception, if the listener
     * specified by the argument was not previously added to this component.
     * If listener <code>l</code> is <code>null</code>,
     * no exception is thrown and no action is performed.
     * <p>Refer to <a href="doc-files/AWTThreadIssues.html#ListenersThreads"
     * >AWT Threading Issues</a> for details on AWT's threading model.
     *
     * @param listener the input method listener
     * @return a reference to this object.
     */
    public X removeInputMethodListener(InputMethodListener listener) {
        component.removeInputMethodListener(listener);
        return (X) this;
    }

    /**
     * Removes the specified key listener so that it no longer
     * receives key events from this component. This method performs
     * no function, nor does it throw an exception, if the listener
     * specified by the argument was not previously added to this component.
     * If listener <code>l</code> is <code>null</code>,
     * no exception is thrown and no action is performed.
     * <p>Refer to <a href="doc-files/AWTThreadIssues.html#ListenersThreads"
     * >AWT Threading Issues</a> for details on AWT's threading model.
     *
     * @param listener the key listener
     * @return a reference to this object.
     */
    public X removeKeyListener(KeyListener listener) {
        component.removeKeyListener(listener);
        return (X) this;
    }

    /**
     * Removes the specified mouse listener so that it no longer
     * receives mouse events from this component. This method performs
     * no function, nor does it throw an exception, if the listener
     * specified by the argument was not previously added to this component.
     * If listener <code>l</code> is <code>null</code>,
     * no exception is thrown and no action is performed.
     * <p>Refer to <a href="doc-files/AWTThreadIssues.html#ListenersThreads"
     * >AWT Threading Issues</a> for details on AWT's threading model.
     *
     * @param listener the mouse listener
     * @return a reference to this object.
     */
    public X removeMouseListener(MouseListener listener) {
        component.removeMouseListener(listener);
        return (X) this;
    }

    /**
     * Removes the specified mouse motion listener so that it no longer
     * receives mouse motion events from this component. This method performs
     * no function, nor does it throw an exception, if the listener
     * specified by the argument was not previously added to this component.
     * If listener <code>l</code> is <code>null</code>,
     * no exception is thrown and no action is performed.
     * <p>Refer to <a href="doc-files/AWTThreadIssues.html#ListenersThreads"
     * >AWT Threading Issues</a> for details on AWT's threading model.
     *
     * @param listener the mouse motion listener
     * @return a reference to this object.
     */
    public X removeMouseMotionListener(MouseMotionListener listener) {
        component.removeMouseMotionListener(listener);
        return (X) this;
    }

    /**
     * Removes the specified mouse wheel listener so that it no longer
     * receives mouse wheel events from this component. This method performs
     * no function, nor does it throw an exception, if the listener
     * specified by the argument was not previously added to this component.
     * If l is null, no exception is thrown and no action is performed.
     * <p>Refer to <a href="doc-files/AWTThreadIssues.html#ListenersThreads"
     * >AWT Threading Issues</a> for details on AWT's threading model.
     *
     * @param listener the mouse wheel listener.
     * @return a reference to this object.
     */
    public X removeMouseWheelListener(MouseWheelListener listener) {
        component.removeMouseWheelListener(listener);
        return (X) this;
    }

    /**
     * Removes a PropertyChangeListener from the listener list. This method
     * should be used to removeAll PropertyChangeListeners that were registered
     * for all bound properties of this class.
     * <p/>
     * If listener is null, no exception is thrown and no action is performed.
     *
     * @param listener the PropertyChangeListener to be removed
     * @return a reference to this object.
     */
    public X removePropertyChangeListener(PropertyChangeListener listener) {
        component.removePropertyChangeListener(listener);
        return (X) this;
    }

    /**
     * Removes a <code>PropertyChangeListener</code> from the listener
     * list for a specific property. This method should be used to removeAll
     * <code>PropertyChangeListener</code>s
     * that were registered for a specific bound property.
     * <p/>
     * If <code>propertyName</code> or <code>listener</code> is <code>null</code>,
     * no exception is thrown and no action is taken.
     *
     * @param property a valid property name
     * @param listener the PropertyChangeListener to be removed
     * @return a reference to this object.
     */
    public X removePropertyChangeListener(String property, PropertyChangeListener listener) {
        component.removePropertyChangeListener(property, listener);
        return (X) this;
    }

    /**
     * Moves and resizes this component. The new location of the top-left
     * corner is specified by <code>x</code> and <code>y</code>, and the
     * new size is specified by <code>width</code> and <code>height</code>.
     * <p/>
     * This method changes layout-related information, and therefore,
     * invalidates the component hierarchy.
     *
     * @param x      the new <i>x</i>-coordinate of this component
     * @param y      the new <i>y</i>-coordinate of this component
     * @param width  the new <code>width</code> of this component
     * @param height the new <code>height</code> of this
     *               component
     * @return a reference to this object.
     */
    public X bounds(int x, int y, int width, int height) {
        component.setBounds(x, y, width, height);
        return (X) this;
    }

    /**
     * Moves and resizes this component to conform to the new
     * bounding rectangle <code>r</code>. This component's new
     * position is specified by <code>r.x</code> and <code>r.y</code>,
     * and its new size is specified by <code>r.width</code> and
     * <code>r.height</code>
     * <p/>
     * This method changes layout-related information, and therefore,
     * invalidates the component hierarchy.
     *
     * @param rectangle the new bounding rectangle for this component
     * @return a reference to this object.
     * @throws NullPointerException if {@code r} is {@code null}
     */
    public X bounds(Rectangle rectangle) {
        component.setBounds(rectangle);
        return (X) this;
    }

    /**
     * Sets the language-sensitive orientation that is to be used to order
     * the elements or text within this component.  Language-sensitive
     * <code>LayoutManager</code> and <code>Component</code>
     * subclasses will use this property to
     * determine how to lay out and draw components.
     * <p/>
     * At construction time, a component's orientation is set to
     * <code>ComponentOrientation.UNKNOWN</code>,
     * indicating that it has not been specified
     * explicitly.  The UNKNOWN orientation behaves the same as
     * <code>ComponentOrientation.LEFT_TO_RIGHT</code>.
     * <p/>
     * To set the orientation of a single component, use this method.
     * To set the orientation of an entire component
     * hierarchy, use #applyComponentOrientation.
     * <p/>
     * This method changes layout-related information, and therefore,
     * invalidates the component hierarchy.
     *
     * @return a reference to this object.
     */
    public X componentOrientation(ComponentOrientation orientation) {
        component.setComponentOrientation(orientation);
        return (X) this;
    }

    /**
     * Sets the cursor image to the specified cursor.  This cursor
     * image is displayed when the <code>contains</code> method for
     * this component returns true for the current cursor location, and
     * this Component is visible, displayable, and enabled. Setting the
     * cursor of a <code>Container</code> causes that cursor to be displayed
     * within all of the container's subcomponents, except for those
     * that have a non-<code>null</code> cursor.
     * <p/>
     * The method may have no visual effect if the Java platform
     * implementation and/or the native system do not support
     * changing the mouse cursor shape.
     *
     * @param cursor One of the constants defined
     *               by the <code>Cursor</code> class;
     *               if this parameter is <code>null</code>
     *               then this component will inherit
     *               the cursor of its parent
     * @return a reference to this object.
     */
    public X cursor(Cursor cursor) {
        component.setCursor(cursor);
        return (X) this;
    }

    /**
     * Associate a <code>DropTarget</code> with this component.
     * The <code>Component</code> will receive drops only if it
     * is enabled.
     *
     * @param target The DropTarget
     * @return a reference to this object.
     */
    public X dropTarget(DropTarget target) {
        component.setDropTarget(target);
        return (X) this;
    }

    /**
     * Sets whether this Container is the root of a focus traversal cycle. Once
     * focus enters a traversal cycle, typically it cannot leave it via focus
     * traversal unless one of the up- or down-cycle keys is pressed. Normal
     * traversal is limited to this Container, and all of this Container's
     * descendants that are not descendants of inferior focus cycle roots. Note
     * that a FocusTraversalPolicy may bend these restrictions, however. For
     * example, ContainerOrderFocusTraversalPolicy supports implicit down-cycle
     * traversal.
     * <p/>
     * The alternative way to specify the traversal order of this Container's
     * children is to make this Container a
     * <a href="doc-files/FocusSpec.html#FocusTraversalPolicyProviders">focus traversal policy provider</a>.
     *
     * @param focusCycleRoot indicates whether this Container is the root of a
     *                       focus traversal cycle
     * @return a reference to this object.
     */
    public X focusCycleRoot(boolean focusCycleRoot) {
        component.setFocusCycleRoot(focusCycleRoot);
        return (X) this;
    }

    /**
     * Sets whether focus traversal keys are enabled for this Component.
     * Components for which focus traversal keys are disabled receive key
     * events for focus traversal keys. Components for which focus traversal
     * keys are enabled do not see these events; instead, the events are
     * automatically converted to traversal operations.
     *
     * @param enabled whether focus traversal keys are
     *                enabled for this Component
     * @return a reference to this object.
     */
    public X focusTraversalKeysEnabled(boolean enabled) {
        component.setFocusTraversalKeysEnabled(enabled);
        return (X) this;
    }

    /**
     * Sets the focus traversal policy that will manage keyboard traversal of
     * this Container's children, if this Container is a focus cycle root. If
     * the argument is null, this Container inherits its policy from its focus-
     * cycle-root ancestor. If the argument is non-null, this policy will be
     * inherited by all focus-cycle-root children that have no keyboard-
     * traversal policy of their own (as will, recursively, their focus-cycle-
     * root children).
     * <p/>
     * If this Container is not a focus cycle root, the policy will be
     * remembered, but will not be used or inherited by this or any other
     * Containers until this Container is made a focus cycle root.
     *
     * @param policy the new focus traversal policy for this Container
     * @return a reference to this object.
     */
    public X focusTraversalPolicy(FocusTraversalPolicy policy) {
        component.setFocusTraversalPolicy(policy);
        return (X) this;
    }

    /**
     * Sets whether this container will be used to provide focus
     * traversal policy. Container with this property as
     * <code>true</code> will be used to acquire focus traversal policy
     * instead of closest focus cycle root ancestor.
     *
     * @param provider indicates whether this container will be used to
     *                 provide focus traversal policy
     * @return a reference to this object.
     */
    public X focusTraversalPolicyProvider(boolean provider) {
        component.setFocusTraversalPolicyProvider(provider);
        return (X) this;
    }

    /**
     * Sets whether or not paint messages received from the operating system
     * should be ignored.  This does not affect paint events generated in
     * software by the AWT, unless they are an immediate response to an
     * OS-level paint message.
     * <p/>
     * This is useful, for example, if running under full-screen mode and
     * better performance is desired, or if page-flipping is used as the
     * buffer strategy.
     *
     * @return a reference to this object.
     */
    public X ignoreRepaint(boolean ignore) {
        component.setIgnoreRepaint(ignore);
        return (X) this;
    }

    /**
     * Sets the layout manager for this container.
     * <p/>
     * This method changes layout-related information, and therefore,
     * invalidates the component hierarchy.
     *
     * @param manager the specified layout manager
     * @return a reference to this object.
     */
    public X layout(LayoutManager manager) {
        component.setLayout(manager);
        return (X) this;
    }

    /**
     * Sets the locale of this component.  This is a bound property.
     * <p/>
     * This method changes layout-related information, and therefore,
     * invalidates the component hierarchy.
     *
     * @param locale the locale to become this component's locale
     * @return a reference to this object.
     */
    public X locale(Locale locale) {
        component.setLocale(locale);
        return (X) this;
    }

    /**
     * Moves this component to a new location. The top-left corner of
     * the new location is specified by the <code>x</code> and <code>y</code>
     * parameters in the coordinate space of this component's parent.
     * <p/>
     * This method changes layout-related information, and therefore,
     * invalidates the component hierarchy.
     *
     * @param x the <i>x</i>-coordinate of the new location's
     *          top-left corner in the parent's coordinate space
     * @param y the <i>y</i>-coordinate of the new location's
     *          top-left corner in the parent's coordinate space
     * @return a reference to this object.
     */
    public X location(int x, int y) {
        component.setLocation(x, y);
        return (X) this;
    }

    /**
     * Moves this component to a new location. The top-left corner of
     * the new location is specified by point <code>p</code>. Point
     * <code>p</code> is given in the parent's coordinate space.
     * <p/>
     * This method changes layout-related information, and therefore,
     * invalidates the component hierarchy.
     *
     * @param p the point defining the top-left corner
     *          of the new location, given in the coordinate space of this
     *          component's parent
     * @return a reference to this object.
     */
    public X location(Point p) {
        component.setLocation(p);
        return (X) this;
    }

    /**
     * Transfers the focus to the next component, as though this Component were
     * the focus owner.
     *
     * @return a reference to this object.
     */
    public X transferFocus() {
        component.transferFocus();
        return (X) this;
    }

    /**
     * Transfers the focus to the previous component, as though this Component
     * were the focus owner.
     *
     * @return a reference to this object.
     */
    public X transferFocusBackward() {
        component.transferFocusBackward();
        return (X) this;
    }

    /**
     * Transfers the focus down one focus traversal cycle. If this Container is
     * a focus cycle root, then the focus owner is set to this Container's
     * default Component to focus, and the current focus cycle root is set to
     * this Container. If this Container is not a focus cycle root, then no
     * focus traversal operation occurs.
     *
     * @return a reference to this object.
     */
    public X transferFocusDownCycle() {
        component.transferFocusDownCycle();
        return (X) this;
    }

    /**
     * Transfers the focus up one focus traversal cycle. Typically, the focus
     * owner is set to this Component's focus cycle root, and the current focus
     * cycle root is set to the new focus owner's focus cycle root. If,
     * however, this Component's focus cycle root is a Window, then the focus
     * owner is set to the focus cycle root's default Component to focus, and
     * the current focus cycle root is unchanged.
     *
     * @return a reference to this object.
     */
    public X transferFocusUpCycle() {
        component.transferFocusUpCycle();
        return (X) this;
    }
}
