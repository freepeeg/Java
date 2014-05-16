package iitc.im;

import java.util.Comparator;

/**
 * Query
 *
 * @author Ian
 * @version 1.0
 */
public interface Query<T extends Query<T, K>, K> extends FluentCollection<T, K> {
    public T pull();

    public T sort(Comparator<K> comparator);

    public T filter(Predicate<K> predicate);
}
