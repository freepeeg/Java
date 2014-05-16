package iitc.im;

import java.util.ArrayList;
import java.util.Collection;

/**
 * NullRestrictiveArrayList
 *
 * @author Ian
 * @version 1.0
 */
public class NullRestrictiveArrayList<E> extends ArrayList<E> {
    /**
     * Constructs an empty list with the specified initial capacity.
     *
     * @param initialCapacity the initial capacity of the list
     * @throws IllegalArgumentException if the specified initial capacity
     *                                  is negative
     */
    public NullRestrictiveArrayList(int initialCapacity) {
        super(initialCapacity);
    }

    /**
     * Constructs an empty list with an initial capacity of ten.
     */
    public NullRestrictiveArrayList() {
    }

    /**
     * Constructs a list containing the elements of the specified
     * collection, in the order they are returned by the collection's
     * iterator.
     *
     * @param c the collection whose elements are to be placed into this list
     * @throws NullPointerException if the specified collection is null
     */
    public NullRestrictiveArrayList(Collection<? extends E> c) {
        super(c);
    }

    @Override
    public boolean add(E element) {
        return element != null && super.add(element);
    }
}
