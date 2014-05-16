package iitc.graph;

import java.util.Arrays;

/**
 * Graph
 *
 * @author Ian
 * @version 1.0
 */
public class Graph<N extends Node, E extends Edge<N>> {
    protected final N[] nodes;
    protected final E[] edges;

    public Graph(N[] nodes, E[] edges) {
        if (nodes == null || nodes.length == 0)
            throw new IllegalArgumentException("The list of nodes must be non-null and non-empty.");
        this.nodes = nodes;
        this.edges = edges;
    }

    public N[] getNodes() {
        return Arrays.copyOf(nodes, nodes.length);
    }

    public E[] getEdges() {
        return Arrays.copyOf(edges, edges.length);
    }

    public Graph<N, E> subgraph(int nodeIndex, int edgeIndex) {
        return new Graph<>(Arrays.copyOfRange(nodes, nodeIndex, nodes.length), Arrays.copyOfRange(edges, edgeIndex, nodes.length));
    }

    public Graph<N, E> subgraph(int nodeIndex, int toNodeIndex, int edgeIndex, int toEdgeIndex) {
        return new Graph<>(Arrays.copyOfRange(nodes, nodeIndex, toNodeIndex), Arrays.copyOfRange(edges, edgeIndex, toEdgeIndex));
    }

    public Graph<N, E> subgraph(N[] nodes, E[] edges) {
        return new Graph<>(nodes, edges);
    }

    @SafeVarargs
    public final Graph<N, E> append(N... nodes) {
        if (nodes == null)
            return new Graph<>(getNodes(), getEdges());
        N[] newNodes = Arrays.copyOf(this.nodes, this.nodes.length + nodes.length);
        for (int n = this.nodes.length, i = n; i < newNodes.length; i++)
            newNodes[i] = nodes[i - n];
        return new Graph<>(newNodes, Arrays.copyOf(edges, edges.length));
    }

    @SafeVarargs
    public final Graph<N, E> append(E... edges) {
        if (edges == null)
            return new Graph<>(getNodes(), getEdges());
        E[] newEdges = Arrays.copyOf(this.edges, this.edges.length + edges.length);
        for (int n = this.edges.length, i = n; i < newEdges.length; i++)
            newEdges[i] = edges[i - n];
        return new Graph<>(Arrays.copyOf(nodes, nodes.length), newEdges);
    }

    @Override
    public String toString() {
        return "nodes:[" + Arrays.toString(nodes) + "], edges:[" + Arrays.toString(edges) + "]";
    }
}
