package iitc.web.html;

import iitc.web.WebObject;

/**
 * HTMLObject
 *
 * @author Ian
 * @version 1.0
 */
public interface HTMLObject extends WebObject {
    HTMLObject[] children();

    String compile(int tab_offset);
}
