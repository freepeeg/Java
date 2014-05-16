package iitc.im;

import java.util.HashMap;

/**
 * CachableHashMap
 *
 * @author Ian
 * @version 1.0
 */
@SuppressWarnings("unchecked")
public abstract class CachableHashMap<K, V> extends HashMap<K, V> implements Cache<K, V> {
    @Override
    public V get(Object key) {
        if (containsKey(key))
            return super.get(key);
        else {
            V value = getValue((K) key);
            put((K) key, value);
            return value;
        }
    }
}
