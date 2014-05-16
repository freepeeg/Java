package iitc.im;

/**
 * Cache
 *
 * @author Ian
 * @version 1.0
 */
public interface Cache<K, V> {
    public V getValue(K key);
}
