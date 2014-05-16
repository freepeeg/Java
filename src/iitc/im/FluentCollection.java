package iitc.im;

import java.util.Collection;
import java.util.Iterator;

/**
 * FluentCollection
 *
 * @author Ian
 * @version 1.0
 */
public interface FluentCollection<T extends FluentCollection<T, K>, K> extends Iterable<K> {
    public int size();

    public boolean contains(Object o);

    public Iterator<K> iterator();

    public T reverse();

    public T empty();

    public boolean isEmpty();

    public T add(K item);

    public T remove(K item);

    public void appendTo(Collection<K> collection);

    public T group(int count);

    public T group(int lowerBound, int count);

}
