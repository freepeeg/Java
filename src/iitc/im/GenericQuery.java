package iitc.im;

import java.util.List;

/**
 * GenericQuery
 *
 * @author Ian
 * @version 1.0
 */
public abstract class GenericQuery<K> extends AbstractQuery<GenericQuery<K>, K> {
    protected GenericQuery() {
    }

    public GenericQuery(int beginningCapacity) {
        super(beginningCapacity);
    }

    public GenericQuery(List<K> beginningElements) {
        super(beginningElements);
    }

    @Override
    public abstract List<K> query();
}
