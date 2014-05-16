package iitc.graph;

/**
 * Vertex
 *
 * @author Ian
 * @version 1.0
 */
public class Vertex<V extends Vertex> implements Node {
    protected final int x;
    protected final int y;

    public Vertex(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Vertex<V> translate(int dx, int dy) {
        return new Vertex<>(x + dx, y + dy);
    }

    public double distanceTo(Vertex node) {
        return distanceTo(DistanceEquation.ABSOULTE, node);
    }

    public double distanceTo(DistanceEquation equation, Vertex node) {
        return node == null ? Double.MAX_VALUE : equation.getCost(this, node);
    }

    public Edge<V> connectTo(final V node) {
        return connectTo(node, DistanceEquation.ABSOULTE);
    }

    public Edge<V> connectTo(final V node, final DistanceEquation distanceEquation) {
        return node == null ? null : new Edge<V>() {
            @Override
            public V getFirst() {
                return (V) Vertex.this;
            }

            @Override
            public V getNext() {
                return node;
            }

            @Override
            public double getCost() {
                return Vertex.this.distanceTo(distanceEquation == null ? DistanceEquation.ABSOULTE : distanceEquation, node);
            }

            @Override
            public String toString() {
                return Vertex.this + " to " + node;
            }

            @Override
            public boolean equals(Object o) {
                if (o instanceof Edge) {
                    Node one = getFirst();
                    Node two = getNext();
                    Node three = ((Edge) o).getFirst();
                    Node four = ((Edge) o).getNext();
                    return (one.equals(three) | one.equals(four)) && (two.equals(three) | two.equals(four));
                }
                return false;
            }
        };
    }

    @Override
    public String toString() {
        return "x[" + x + "]:y[" + y + "]";
    }
}
