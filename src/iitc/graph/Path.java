package iitc.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Path
 *
 * @author Ian
 * @version 1.0
 */
public class Path<T extends Vertex> {
    protected final List<T> elements;

    public Path(List<T> elements) {
        this.elements = elements == null ? new ArrayList<T>() : elements;
    }

    @SafeVarargs
    public Path(T... elements) {
        this.elements = new ArrayList<>(elements != null && elements.length > 10 ? elements.length : 10);
        if (elements != null && elements.length > 0)
            Collections.addAll(this.elements, elements);
    }

    protected void add(int index, T vertex) {
        elements.add(index, vertex);
    }

    protected boolean add(T vertex) {
        return elements.add(vertex);
    }

    public Path<T> reverse() {
        List<T> newElements = elements;
        Collections.reverse(newElements);
        return new Path<>(newElements);
    }

    protected boolean remove(T vertex) {
        return elements.remove(vertex);
    }

    public T getSource() {
        return elements.size() > 0 ? elements.get(0) : null;
    }

    public T getDestination() {
        return elements.size() > 0 ? elements.get(elements.size() - 1) : null;
    }

    @Override
    public String toString() {
        return elements.toString();
    }
}
