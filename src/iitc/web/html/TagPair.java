package iitc.web.html;

import iitc.im.Maps;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * TagPair
 *
 * @author Ian
 * @version 1.0
 */
public class TagPair implements HTMLObject {
    protected final String name;
    private final Map<String, Object> properties;
    protected HTMLObject[] children;
    private String cachedName;

    public TagPair(String name) {
        this(name, new HashMap<String, Object>());
    }

    public TagPair(String name, HTMLObject... children) {
        this(name);
        this.children = children;
    }

    public TagPair(String name, String[] keys, Object[] values) {
        this(name);
        Maps.putAll(properties, keys, values);
    }

    public TagPair(String name, Map<String, Object> properties) {
        this(name, properties, new HTMLObject[0]);
    }

    public TagPair(String name, Map<String, Object> properties, HTMLObject... children) {
        this.name = name;
        this.properties = properties;
        this.children = children;
    }

    public TagPair property(final String name, final String value) {
        properties.put(name, value);
        cachedName = null;
        return this;
    }

    public TagPair remove(final String name) {
        properties.remove(name);
        cachedName = null;
        return this;
    }

    private void setPhp(int offset) {
        StringBuilder tag = new StringBuilder();
        //Set up the tag in positioning to it's parent.
        for (int i = 0; i < offset; i++)
            tag.append("\t");
        tag.append("<").append(name);
        //Only add a space if there are properties to be displayed
        if (properties.size() > 0)
            tag.append(" ");
        Iterator<Map.Entry<String, Object>> it = properties.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, Object> entry = it.next();
            tag.append(entry.getKey()).append("=\"").append(entry.getValue()).append("\"");
            //Only add a space if there is another property coming up
            if (it.hasNext())
                tag.append(" ");
        }
        //Close opening tag
        tag.append(">");
        //Children check to make children-less tagpairs only one line long
        if (children.length > 0) {
            for (HTMLObject aChildren : children)
                tag.append("\n").append(aChildren.compile(offset + 1));
            tag.append("\n");
            //Line up the bottom tag
            for (int i = 0; i < offset; i++)
                tag.append("\t");
        }
        tag.append("</").append(name).append(">");
        this.cachedName = tag.toString();
    }

    @Override
    public HTMLObject[] children() {
        return children;
    }

    @Override
    public String compile() {
        return compile(0);
    }

    public String compile(int offset) {
        if (cachedName == null)
            setPhp(offset);
        return cachedName;
    }
}
