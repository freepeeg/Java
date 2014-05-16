package iitc.projects.work;

import iitc.im.ListOperations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Tab
 *
 * @author Ian
 * @version 1.0
 */
public class Tab extends Entry {
    protected final List<Item> tab_track;
    protected final String id;
    private boolean hasUpdated;
    private float cachedPrice;
    private String string;

    public Tab(String id) {
        super(0.0f);
        this.id = id;
        this.hasUpdated = false;
        this.cachedPrice = 0.0f;
        this.tab_track = new ArrayList<>();
        this.string = null;
    }

    @Override
    public String name() {
        return id;
    }

    public Tab add(Item... items) {
        hasUpdated = Collections.addAll(tab_track, items);
        return this;
    }

    public Tab add(List<Item> items) {
        hasUpdated = tab_track.addAll(items);
        return this;
    }

    public Tab pickup(Tab tab) {
        add(tab.tab_track);
        tab.clear();
        return this;
    }

    public Tab clear() {
        tab_track.clear();
        hasUpdated = true;
        return this;
    }

    public Tab remove(Item... items) {
        hasUpdated = ListOperations.removeAll(tab_track, items);
        return this;
    }

    public Tab remove(List<Item> items) {
        hasUpdated = tab_track.removeAll(items);
        return this;
    }

    @Override
    public float base_price() {
        if (hasUpdated) {
            float price = 0.0f;
            for (Item item : tab_track)
                price += item.final_price();
            this.cachedPrice = price;
        }
        return cachedPrice;
    }

    @Override
    public String toString() {
        if (hasUpdated || string == null) {
            StringBuilder builder = new StringBuilder(id + "\n");
            for (Item i : tab_track)
                builder.append(i.toTab()).append("\n");
            if (tab_track.size() > 0) {
                for (int i = 0; i < 29; i++)
                    builder.append('-');
                builder.append("\n");
            }
            builder.append(String.format("%-20s %s %s", "Total", " | ", price()));
            this.string = builder.toString();
        }
        return string;
    }
}
