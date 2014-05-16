package iitc.im;

import java.util.Iterator;

/**
 * AdjustableIterator
 *
 * @author Ian
 * @version 1.0
 */
public interface AdjustableIterator<E> extends Iterator<E> {
    public void adjust(int index);

    public int getIndex();
}
