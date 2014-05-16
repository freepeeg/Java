package iitc.graph;

import javax.swing.*;
import java.awt.*;

/**
 * Visual
 *
 * @author Ian
 * @version 1.0
 */
public class Visual<N extends Vertex, E extends Edge<N>> extends JFrame {
    public Visual(final Dimension panelSize, final Graph<N, E> graph, final Path<N> path) {
        super("Graph and Path Visual");
        JSplitPane pane = new JSplitPane();
        JPanel panel = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                N[] nodes = graph.nodes;
                E[] edges = graph.edges;
                g.setColor(Color.DARK_GRAY);
                for (N node : nodes) {
                    g.drawOval(node.getX() - 3, node.getY() - 3, 6, 6);
                    g.drawString(node.toString(), node.getX() + 6, node.getY());
                }
                g.setColor(Color.lightGray);
                for (E e : edges)
                    g.drawLine(e.getFirst().getX(), e.getFirst().getY(), e.getNext().getX(), e.getNext().getY());
            }
        };
        panel.setPreferredSize(panelSize);
        pane.setLeftComponent(panel);
        JPanel panel2 = new
                JPanel() {
                    @Override
                    public void paintComponent(Graphics g) {
                        super.paintComponent(g);
                        for (int i = 0; i < path.elements.size() - 1; ) {
                            N first = path.elements.get(i);
                            N second = path.elements.get(++i);
                            g.setColor(Color.DARK_GRAY);
                            g.drawOval(first.getX() - 3, first.getY() - 3, 6, 6);
                            g.drawString(first.toString(), first.getX() + 6, first.getY());
                            if (second != null) {
                                g.drawOval(second.getX() - 3, second.getY() - 3, 6, 6);
                                g.drawString(second.toString(), second.getX() + 6, second.getY());
                                g.setColor(Color.LIGHT_GRAY);
                                g.drawLine(first.getX(), first.getY(), second.getX(), second.getY());
                            }
                        }
                    }
                };
        panel2.setPreferredSize(panelSize);
        pane.setRightComponent(panel2);
        setContentPane(pane);
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

    }
}
