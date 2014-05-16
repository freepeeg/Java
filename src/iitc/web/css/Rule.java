package iitc.web.css;

import iitc.im.Maps;
import iitc.web.WebObject;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Rule
 *
 * @author Ian
 * @version 1.0
 */
public class Rule implements WebObject {
    private final String selector;
    private final Map<String, String> declarations;
    private String cached;

    public Rule(String selector) {
        this(selector, new HashMap<String, String>());
    }

    public Rule(String selector, String[] properties, String[] values) {
        this(selector, new HashMap<String, String>(properties.length));
        Maps.putAll(declarations, properties, values);
    }

    public Rule(String selector, Map<String, String> declarations) {
        this.selector = selector;
        this.declarations = declarations;
    }

    public Rule declare(String property, String value) {
        declarations.put(property, value);
        cached = null;
        return this;
    }

    public Rule remove(String property) {
        declarations.remove(property);
        cached = null;
        return this;
    }

    private void cache() {
        StringBuilder builder = new StringBuilder(selector + " {");
        //keep no/one declaration rules to one line
        if (declarations.size() > 1)
            builder.append("\n");
        Iterator<Map.Entry<String, String>> it = declarations.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, String> entry = it.next();
            builder.append("\t").append(entry.getKey()).append(": ").append(entry.getValue()).append(";");
            //Only add a new line if there is a declaration coming up
            if (it.hasNext())
                builder.append("\n");
        }
        //line up the end bracket if the rule is multi-lined
        if (declarations.size() > 1)
            builder.append("\n");
        builder.append("}");
        this.cached = builder.toString();
    }

    @Override
    public String compile() {
        if (cached == null)
            cache();
        return cached;
    }
}
