package iitc.graph;

/**
 * Edge
 *
 * @author Ian
 * @version 1.0
 */
public interface Edge<N extends Node> {
    public N getFirst();

    public N getNext();

    public double getCost();
}
