package iitc.im;

import java.util.*;

/**
 * AbstractQuery
 *
 * @author Ian
 * @version 1.0
 */
@SuppressWarnings("unchecked")
public abstract class AbstractQuery<T extends AbstractQuery<T, T1>, T1> implements Query<T, T1> {

    protected List<T1> items;

    public AbstractQuery() {
        this(10);
    }

    public AbstractQuery(int beginningCapacity) {
        this(new ArrayList<T1>(beginningCapacity));
    }

    public AbstractQuery(List<T1> beginningElements) {
        items = beginningElements;
    }

    protected abstract List<T1> query();

    public T pull() {
        update(query());
        return (T) this;
    }

    protected void update(List<T1> newCache) {
        if (newCache != null)
            items = newCache;
    }

    @Override
    public T sort(Comparator<T1> comparator) {
        Collections.sort(items, comparator);
        return (T) this;
    }

    @Override
    public T filter(Predicate<T1> predicate) {
        List<T1> newCache = new ArrayList<>(items.size());
        for (T1 k : items)
            if (predicate.apply(k))
                newCache.add(k);
        update(newCache);
        return (T) this;
    }

    @Override
    public T reverse() {
        Collections.reverse(items);
        return (T) this;
    }

    @Override
    public T empty() {
        items.clear();
        return (T) this;
    }

    @Override
    public boolean isEmpty() {
        return items.isEmpty();
    }

    @Override
    public T add(T1 item) {
        items.add(item);
        return (T) this;
    }

    @Override
    public T remove(T1 item) {
        items.remove(item);
        return (T) this;
    }

    @Override
    public void appendTo(Collection<T1> collection) {
        collection.addAll(items);
    }

    @Override
    public T group(int count) {
        return group(0, count);
    }

    @Override
    public T group(int lowerBound, int count) {
        items = items.subList(lowerBound, count + lowerBound);
        return (T) this;
    }

    @Override
    public int size() {
        return items.size();
    }

    @Override
    public boolean contains(Object o) {
        return items.contains(o);
    }

    @Override
    public Iterator<T1> iterator() {
        return items.iterator();
    }

    @Override
    public String toString() {
        return items.toString();
    }
}
