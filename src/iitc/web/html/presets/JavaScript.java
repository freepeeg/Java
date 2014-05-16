package iitc.web.html.presets;

import iitc.web.html.TagPair;

/**
 * JavaScript
 *
 * @author Ian
 * @version 1.0
 */
public class JavaScript extends TagPair {
    public JavaScript(String src) {
        super("script");
        property("src", src);
    }

    @Override
    public TagPair remove(String name) {
        throw new NoSuchMethodError("You cannot remove any properties of Javascript.");
    }
}
