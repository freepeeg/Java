package iitc.graph;

/**
 * Vertex3D
 *
 * @author Ian
 * @version 1.0
 */
public class Vertex3D<V extends Vertex3D<V>> extends Vertex<V> {
    protected final int z;

    public Vertex3D(int x, int y, int z) {
        super(x, y);
        this.z = z;
    }

    public int getZ() {
        return z;
    }

    public Vertex3D<V> translate(int dx, int dy, int dz) {
        return new Vertex3D<>(x + dx, y + dy, z + dz);
    }
}
