
package com.redsegura.graph;

import com.redsegura.app.DataFactory;
import com.redsegura.model.Vertex;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DFSTest {

    @Test
    public void testDeteccionDeCiclos() {

        MixedGraph graph = new MixedGraph();

        graph.addVertex(new Vertex("A", "A", "Test"));
        graph.addVertex(new Vertex("B", "B", "Test"));
        graph.addVertex(new Vertex("C", "C", "Test"));

        graph.addUndirectedEdge("R1", "A", "B", 5, "Ruta 1");
        graph.addUndirectedEdge("R2", "B", "C", 5, "Ruta 2");
        graph.addUndirectedEdge("R3", "C", "A", 5, "Ruta 3");

        assertTrue(DFS.hasCycle(graph));
    }

    @Test
    public void testGrafoSinCiclos() {

        MixedGraph graph = new MixedGraph();

        graph.addVertex(new Vertex("A", "A", "Test"));
        graph.addVertex(new Vertex("B", "B", "Test"));
        graph.addVertex(new Vertex("C", "C", "Test"));

        graph.addUndirectedEdge("R1", "A", "B", 5, "Ruta 1");
        graph.addUndirectedEdge("R2", "B", "C", 5, "Ruta 2");

        assertFalse(DFS.hasCycle(graph));
    }

    @Test
    public void testComponentesConexosDebiles() {

        MixedGraph graph = new MixedGraph();

        graph.addVertex(new Vertex("A", "A", "Test"));
        graph.addVertex(new Vertex("B", "B", "Test"));
        graph.addVertex(new Vertex("C", "C", "Test"));
        graph.addVertex(new Vertex("D", "D", "Test"));

        graph.addDirectedEdge("R1", "A", "B", 5, "Ruta 1");
        graph.addUndirectedEdge("R2", "C", "D", 5, "Ruta 2");

        List<List<String>> components =
                DFS.weaklyConnectedComponents(graph);

        assertEquals(2, components.size());
    }

    @Test
    public void testComponentesDebilesEnRedSegura() {

        MixedGraph graph = DataFactory.createGraph();

        List<List<String>> components =
                DFS.weaklyConnectedComponents(graph);

        assertEquals(1, components.size());
    }
}
