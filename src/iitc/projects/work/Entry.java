package iitc.projects.work;

import java.math.BigDecimal;

/**
 * Entry
 *
 * @author Ian
 * @version 1.0
 */
public abstract class Entry {
    protected float tax_percentage;

    public Entry(float tax_percentage) {
        this.tax_percentage = tax_percentage > 0.0f ? tax_percentage / 100.0f : tax_percentage;
    }

    public abstract String name();

    public abstract float base_price();

    public float final_price() {
        float base = base_price();
        return base + (base * tax_percentage);
    }

    public BigDecimal price() {
        BigDecimal bd = new BigDecimal(Float.toString(final_price()));
        bd = bd.setScale(2, BigDecimal.ROUND_HALF_UP);
        return bd;
    }

    @Override
    public boolean equals(Object other) {
        return other instanceof Item && name() != null && name().equals(((Item) other).name());
    }
}