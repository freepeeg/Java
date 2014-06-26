package iitc.im;

/**
 * Predicate
 *
 * @author Ian
 * @version 1.0
 */
public interface Precondition<T> {
    public boolean condition(T t);
}
