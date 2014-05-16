package iitc.projects.work;

/**
 * AddOn
 *
 * @author Ian
 * @version 1.0
 */
public class AddOn extends Entry {
    protected final float price;
    protected final String name;

    public AddOn(String name, float price) {
        super(0.0f);
        this.name = name;
        this.price = price;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public float base_price() {
        return price;
    }
}
