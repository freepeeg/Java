package iitc.projects.work;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Item
 *
 * @author Ian
 * @version 1.0
 */
public abstract class Item extends Entry {
    protected final List<AddOn> addons;
    protected final float beginning;
    protected float price;

    public Item(float price, float tax_percentage) {
        super(tax_percentage);
        this.price = price;
        this.beginning = price;
        this.addons = new ArrayList<>();
    }

    public Item add(AddOn... addons) {
        for (AddOn a : addons) {
            this.addons.add(a);
            price += a.final_price();
        }
        return this;
    }

    public Item remove(AddOn... addons) {
        for (AddOn a : addons) {
            this.addons.remove(a);
            price -= a.final_price();
        }
        return this;
    }

    @Override
    public float base_price() {
        return price;
    }

    public String toTab() {
        String name = name();
        if (name.length() > 20)
            name = name.substring(0, 17) + "...";
        return String.format("%-20s %s %s", name, " | ", price());

    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder(name() + ": [" + beginning + "] + [");
        if (addons.isEmpty())
            string.append("NO_ADDONS");
        else {
            Iterator<AddOn> iterator = addons.iterator();
            while (iterator.hasNext()) {
                AddOn a = iterator.next();
                string.append(a.name()).append("->$").append(a.final_price());
                if (iterator.hasNext())
                    string.append("] + [");
            }
        }
        string.append("]");
        if (tax_percentage != 0.0)
            string.append(" * ").append(tax_percentage);
        string.append(" = $").append(price());
        return string.toString();
    }

    @Override
    public boolean equals(Object other) {
        return other instanceof Item && name() != null && name().equals(((Item) other).name());
    }
}
