package iitc.graph;

import java.util.*;

/**
 * Dijkstra
 *
 * @author Ian
 * @version 1.0
 */
public class Dijkstra extends Searcher {
    private static Dijkstra ourInstance = new Dijkstra();

    private Dijkstra() {
    }

    public static Dijkstra getInstance() {
        return ourInstance;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    public <T extends Vertex<T>, T1 extends Edge<T>> Path<T> generatePath(Graph<T, T1> graph, T source, T destination) {
        T[] vertices = graph.getNodes();
        T start = getClosest(vertices, source);
        T end = getClosest(vertices, destination);
        T1[] edgesFromGraph = graph.getEdges();
        List<T1> edges = new ArrayList<>(edgesFromGraph.length + 1);
        if (!start.equals(source))
            edges.add((T1) source.connectTo(start));
        Collections.addAll(edges, edgesFromGraph);
        List<T> settled = new ArrayList<>();
        List<T> unsettled = new ArrayList<>();
        Map<T, Double> distances = new HashMap<>();
        Map<T, T> path = new HashMap<>();
        distances.put(source, 0.0);
        unsettled.add(source);
        while (unsettled.size() > 0) {
            T vertex = getMinimum(distances, unsettled);
            settled.add(vertex);
            unsettled.remove(vertex);
            updateMinimalDistance(distances, path, edges, settled, unsettled, vertex);
        }
        Path<T> formedPath = getPathTo(path, end);
        if (!destination.equals(formedPath.getDestination()))
            formedPath.add(destination);
        return formedPath;
    }

}
