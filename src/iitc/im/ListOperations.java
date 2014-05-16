package iitc.im;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * ListOperations
 *
 * @author Ian
 * @version 1.0
 */
public class ListOperations {
    @SafeVarargs
    public static <T> boolean removeAll(List<T> list, T... items) {
        for (T t : items)
            if (!list.remove(t))
                return false;
        return true;
    }

    public static List<double[]> allSubArrays(double[] array) {
        return allSubArrays(array, 0);
    }

    public static List<double[]> allSubArrays(double[] array, int minLength) {
        if (array.length < minLength)
            return Collections.emptyList();
        List<double[]> subarrays = new ArrayList<>();
        if (array.length == minLength) {
            subarrays.add(array);
        } else
            for (int i = minLength; i < array.length; i++) {
                for (int index = 0; index <= array.length - i; index++) {
                    double[] sub = Arrays.copyOfRange(array, index, index + i);
                    if (sub.length > 1)
                        subarrays.add(sub);
                }
            }
        return subarrays;
    }

    public static List<long[]> allSubArrays(long[] array) {
        return allSubArrays(array, 0);
    }

    public static List<long[]> allSubArrays(long[] array, int minLength) {
        if (array.length < minLength)
            return Collections.emptyList();
        List<long[]> subarrays = new ArrayList<>();
        if (array.length == minLength) {
            subarrays.add(array);
        } else
            for (int i = minLength; i < array.length; i++) {
                for (int index = 0; index <= array.length - i; index++) {
                    long[] sub = Arrays.copyOfRange(array, index, index + i);
                    if (sub.length > 1)
                        subarrays.add(sub);
                }
            }
        return subarrays;
    }

    public static <T> List<short[]> allSubArrays(short[] array) {
        return allSubArrays(array, 0);
    }

    public static List<short[]> allSubArrays(short[] array, int minLength) {
        if (array.length < minLength)
            return Collections.emptyList();
        List<short[]> subarrays = new ArrayList<>();
        if (array.length == minLength) {
            subarrays.add(array);
        } else
            for (int i = minLength; i < array.length; i++) {
                for (int index = 0; index <= array.length - i; index++) {
                    short[] sub = Arrays.copyOfRange(array, index, index + i);
                    if (sub.length > 1)
                        subarrays.add(sub);
                }
            }
        return subarrays;
    }

    public static List<float[]> allSubArrays(float[] array) {
        return allSubArrays(array, 0);
    }

    public static List<float[]> allSubArrays(float[] array, int minLength) {
        if (array.length < minLength)
            return Collections.emptyList();
        List<float[]> subarrays = new ArrayList<>();
        if (array.length == minLength) {
            subarrays.add(array);
        } else
            for (int i = minLength; i < array.length; i++) {
                for (int index = 0; index <= array.length - i; index++) {
                    float[] sub = Arrays.copyOfRange(array, index, index + i);
                    if (sub.length > 1)
                        subarrays.add(sub);
                }
            }
        return subarrays;
    }

    public static List<byte[]> allSubArrays(byte[] array) {
        return allSubArrays(array, 0);
    }

    public static List<byte[]> allSubArrays(byte[] array, int minLength) {
        if (array.length < minLength)
            return Collections.emptyList();
        List<byte[]> subarrays = new ArrayList<>();
        if (array.length == minLength) {
            subarrays.add(array);
        } else
            for (int i = minLength; i < array.length; i++) {
                for (int index = 0; index <= array.length - i; index++) {
                    byte[] sub = Arrays.copyOfRange(array, index, index + i);
                    if (sub.length > 1)
                        subarrays.add(sub);
                }
            }
        return subarrays;
    }

    public static <T> List<T[]> allSubArrays(T[] array) {
        return allSubArrays(array, 0);
    }

    public static <T> List<T[]> allSubArrays(T[] array, int minLength) {
        if (array.length < minLength)
            return Collections.emptyList();
        List<T[]> subarrays = new ArrayList<>();
        if (array.length == minLength) {
            subarrays.add(array);
        } else
            for (int i = minLength; i < array.length; i++) {
                for (int index = 0; index <= array.length - i; index++) {
                    T[] sub = Arrays.copyOfRange(array, index, index + i);
                    if (sub.length > 1)
                        subarrays.add(sub);
                }
            }
        return subarrays;
    }

    public static List<int[]> allSubArrays(int[] array) {
        return allSubArrays(array, 0);
    }

    public static List<int[]> allSubArrays(int[] array, int minLength) {
        if (array.length < minLength)
            return Collections.emptyList();
        List<int[]> subarrays = new ArrayList<>();
        if (array.length == minLength) {
            subarrays.add(array);
        } else
            for (int i = minLength; i < array.length; i++) {
                for (int index = 0; index <= array.length - i; index++) {
                    int[] sub = Arrays.copyOfRange(array, index, index + i);
                    if (sub.length > 1)
                        subarrays.add(sub);
                }
            }
        return subarrays;
    }
}
