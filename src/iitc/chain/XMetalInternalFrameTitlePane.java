package iitc.chain;

import javax.swing.plaf.metal.MetalInternalFrameTitlePane;

/**
 * XMetalInternalFrameTitlePane
 *
 * @author Ian
 * @version 1.0
 */
public class XMetalInternalFrameTitlePane<M extends MetalInternalFrameTitlePane> extends XBasicInternalFrameTitlePane<XMetalInternalFrameTitlePane<M>, M> {
    /**
     * Creates an XMetalInternalFrameTitlePane, replicating the specified component
     *
     * @param component the component to replicate
     */
    protected XMetalInternalFrameTitlePane(M component) {
        super(component);
    }

}
