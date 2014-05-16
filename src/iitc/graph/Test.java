package iitc.graph;

import java.awt.*;

/**
 * Test
 *
 * @author Ian
 * @version 1.0
 */
public class Test {
    @SuppressWarnings("unchecked")
    public static void main(String... args) {
        Vertex[] nodes = new Vertex[10];
        for (int i = 0; i < 10; i++)
            nodes[i] = new Vertex(i * 40, 8 * (int) Math.pow(i, 2) + 25);
        Edge<Vertex>[] edges = (Edge<Vertex>[]) new Edge[9];
        for (int i = 0; i < nodes.length - 1; )
            edges[i] = nodes[i].connectTo(nodes[++i]);
        Graph<Vertex, Edge<Vertex>> graph = new Graph<>(nodes, edges);
        Visual<Vertex, Edge<Vertex>> visual = new Visual<>(new Dimension(425, 700), graph, Dijkstra.getInstance().generatePath(graph, new Vertex(30, 100), nodes[9]));
        visual.setVisible(true);
    }
}
