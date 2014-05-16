package iitc.im;

import java.util.Map;

/**
 * Maps
 *
 * @author Ian
 * @version 1.0
 */
public class Maps {
    public static <K, V> void putAll(Map<K, V> map, K[] keys, V[] values) {
        if (keys == null || values == null)
            throw new IllegalArgumentException("Both arrays must consist of values. To map null to each key, provide an array of null values.");
        if (keys.length != values.length)
            throw new IllegalArgumentException("There must be an equal number of keys and values to be mapped.");
        for (int i = 0; i < keys.length; i++)
            map.put(keys[i], values[i]);
    }
}
