package iitc.web.html;

/**
 * NullTag
 *
 * @author Ian
 * @version 1.0
 */
public class NullTag implements HTMLObject {
    private final static HTMLObject[] NILL = new HTMLObject[0];
    protected final String text;

    public NullTag(String text) {
        this.text = text;
    }

    @Override
    public HTMLObject[] children() {
        return NILL;
    }

    @Override
    public String compile() {
        return text;
    }

    @Override
    public String compile(int tab_offset) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < tab_offset; i++)
            builder.append("\t");
        builder.append(text);
        return builder.toString();
    }
}
