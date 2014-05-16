package iitc.graph;

/**
 * DistanceEquation
 *
 * @author Ian
 * @version 1.0
 */
public enum DistanceEquation {
    MANHATTAN {
        @Override
        public double getCost(int x1, int y1, int x2, int y2) {
            return Math.abs(x1 - x2) + Math.abs(y1 - y2);
        }
    },
    DIAGONAL {
        @Override
        public double getCost(int x1, int y1, int x2, int y2) {
            return Math.max(Math.abs(x1 - x2), Math.abs(y1 - y2));
        }
    },
    ABSOULTE {
        @Override
        public double getCost(int x1, int y1, int x2, int y2) {
            return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
        }
    };

    public double getCost(final Vertex a, final Vertex b) {
        return getCost(a.x, a.y, b.x, b.y);
    }

    public abstract double getCost(int x1, int y1, int x2, int y2);
}
