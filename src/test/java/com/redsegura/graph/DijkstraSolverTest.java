
package com.redsegura.graph;

import com.redsegura.app.DataFactory;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DijkstraSolverTest {

    @Test
    public void testGrafoDesconectado() {
        MixedGraph graph = new MixedGraph();

        graph.addVertex(
                new com.redsegura.model.Vertex("S01", "Universidad"));
        graph.addVertex(
                new com.redsegura.model.Vertex("S02", "Hospital"));

        assertTrue(graph.getNeighbors("S01").isEmpty());
        assertTrue(graph.getNeighbors("S02").isEmpty());
    }

    @Test
    public void testBloqueoDeRuta() {
        MixedGraph graph = DataFactory.createGraph();

        assertEquals(3, graph.getNeighbors("S07").size());

        graph.blockEdge("R16");

        assertTrue(graph.isEdgeBlocked("R16"));
        assertEquals(2, graph.getNeighbors("S07").size());
    }

    @Test
    public void testRutaExistente() {
        MixedGraph graph = DataFactory.createGraph();

        assertNotNull(graph.getVertex("S02"));
        assertNotNull(graph.getVertex("S08"));
    }

    @Test
    public void testVerticeInexistente() {
        MixedGraph graph = DataFactory.createGraph();

        assertNull(graph.getVertex("S99"));
    }

    @Test
    public void testPesoDeRuta() {
        MixedGraph graph = DataFactory.createGraph();

        assertEquals(12, graph.getEdge("R16").getPeso());
    }
}
