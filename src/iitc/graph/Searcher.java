package iitc.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Searcher
 *
 * @author Ian
 * @version 1.0
 */
//TODO:Finish documentation
public abstract class Searcher {
    /**
     * Generates a path from the collection of edges and vertices provided by a <code>Graph</code>.
     *
     * @param graph       graph that contains the edges and vertices to be traversed
     * @param source      beginning of desired path
     * @param destination destination of desired path
     * @param <T>         type of vertex to be used
     * @param <T1>        type of edge to be used
     * @return a shortest path from source to destination
     */
    public <T extends Vertex<T>, T1 extends Edge<T>> Path<T> generatePath(Graph<T, T1> graph, T source, T destination) {
        throw new AbstractMethodError("Default searcher method is simply here to simulate inheritance.");
    }

    /**
     * Finds and returns an <code>Edge</code> from a provided collection that has a source <code>Vertex</code> that matches the parametrized <code>Vertex</code>.
     *
     * @param edges collection of edges
     * @param test  vertex to search edges for a matching source
     * @param <T>   type of vertex to be used
     * @param <T1>  type of edge to be used
     * @return
     */
    protected <T extends Vertex<T>, T1 extends Edge<T>> T1 getEdgeFromVertex(T1[] edges, T test) {
        for (T1 vertex : edges)
            if (vertex.getFirst().equals(test))
                return vertex;
        return null;
    }

    /**
     * Finds and returns an <code>Edge</code> from a provided collection that has a source <code>Vertex</code> that matches the parametrized source <code>Vertex</code>
     * and a destination <code>Vertex</code> that matches the parametrized destination <code>Vertex</code>.
     *
     * @param edges       collection of edges
     * @param source      beginning of desired path
     * @param destination destination of desired path
     * @param <T>         type of vertex to be used
     * @param <T1>        type of edge to be used
     * @return
     */
    protected <T extends Vertex<T>, T1 extends Edge<T>> T1 getEdgeFromVertices(List<T1> edges, T source, T destination) {
        for (T1 vertex : edges)
            if (vertex.getFirst().equals(source) && vertex.getNext().equals(destination))
                return vertex;
        return null;
    }

    /**
     * Searches through the collection of settled vertices for a match. A linear search must be done as the settled list is unsorted in all cases.
     *
     * @param settled collection of visited vertices
     * @param vertex  vertex to find within settled
     * @param <T>     type of vertex to be used
     * @return true is the list of settled vertices contains the parametrized vertex
     */
    protected <T extends Vertex<T>> boolean isSettled(List<T> settled, T vertex) {
        for (T check : settled)
            if (check.equals(vertex))
                return true;
        return false;
    }

    protected <T extends Vertex<T>> Path<T> getPathTo(Map<T, T> path, T end) {
        Path<T> newPath = new Path<>();
        T step = end;
        if (path.get(step) == null) {
            return null;
        }
        newPath.add(step);
        T newStep;
        while ((newStep = path.get(step)) != null) {
            step = newStep;
            newPath.add(step);
        }
        return newPath.reverse();
    }

    protected <T extends Vertex<T>, T1 extends Edge<T>> void updateMinimalDistance(Map<T, Double> cache, Map<T, T> path, List<T1> edges, List<T> settled, List<T> unsettled, T vertex) {
        List<T> neighbors = getNeighbors(edges, settled, vertex);
        for (T target : neighbors) {
            double distance = getShortestFromCache(cache, vertex) + getEdgeFromVertices(edges, vertex, target).getCost();
            if (getShortestFromCache(cache, target) > distance) {
                cache.put(target, distance);
                path.put(target, vertex);
                unsettled.add(target);
            }
        }
    }

    protected <T extends Vertex<T>, T1 extends Edge<T>> List<T> getNeighbors(List<T1> edges, List<T> settled, T vertex) {
        List<T> neighbors = new ArrayList<>(edges.size());
        for (T1 edge : edges)
            if (edge.getFirst().equals(vertex) && !isSettled(settled, edge.getNext()))
                neighbors.add(edge.getNext());
        return neighbors;
    }

    protected <T extends Vertex<T>> T getMinimum(Map<T, Double> cache, List<T> vertices) {
        if (vertices == null || vertices.size() == 0)
            return null;
        T minimum = vertices.get(0);
        for (T vertex : vertices)
            if (getShortestFromCache(cache, vertex) < getShortestFromCache(cache, minimum))
                minimum = vertex;
        return minimum;
    }

    protected <T extends Vertex<T>> double getShortestFromCache(Map<T, Double> cache, T check) {
        Double cached = cache.get(check);
        return cached != null ? cached : Double.MAX_VALUE;
    }

    protected <T extends Vertex<T>> T getClosest(T[] vertices, T test) {
        if (vertices == null || test == null)
            throw new IllegalArgumentException("Graph and test vertex must be non-null");
        double distance = Double.MAX_VALUE;
        T closest = null;
        for (T t : vertices) {
            double current = test.distanceTo(t);
            if (current < distance) {
                closest = t;
                distance = current;
            }
        }
        return closest;
    }
}
