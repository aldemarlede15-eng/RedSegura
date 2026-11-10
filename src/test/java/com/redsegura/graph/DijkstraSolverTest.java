
package com.redsegura.graph;

import com.redsegura.app.DataFactory;
import com.redsegura.model.Vertex;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DijkstraSolverTest {

    @Test
    public void testRutaMinima24Minutos() {
        MixedGraph graph = DataFactory.createGraph();

        PathResult result =
                DijkstraSolver.calculateShortestPath(graph, "S02", "S08");

        assertNotNull(result);
        assertEquals(24, result.getTotalCost());

        assertEquals(
                List.of("S02", "S01", "S07", "S08"),
                result.getPath());

        assertEquals(
                List.of("R04", "R01", "R16"),
                result.getEdges().stream()
                        .map(edge -> edge.getId())
                        .toList());
    }

    @Test
    public void testRutaAlternativaDespuesDeBloquearR16() {
        MixedGraph graph = DataFactory.createGraph();

        graph.blockEdge("R16");

        PathResult result =
                DijkstraSolver.calculateShortestPath(graph, "S02", "S08");

        assertNotNull(result);
        assertEquals(24, result.getTotalCost());

        assertEquals(
                List.of("S02", "S01", "S09", "S10", "S08"),
                result.getPath());

        assertEquals(
                List.of("R04", "R03", "R08", "R09"),
                result.getEdges().stream()
                        .map(edge -> edge.getId())
                        .toList());
    }

    @Test
    public void testGrafoDesconectado() {
        MixedGraph graph = new MixedGraph();

        graph.addVertex(new Vertex("S01", "Universidad"));
        graph.addVertex(new Vertex("S02", "Hospital"));

        PathResult result =
                DijkstraSolver.calculateShortestPath(graph, "S01", "S02");

        assertNull(result);
    }

    @Test
    public void testVerticeInexistente() {
        MixedGraph graph = DataFactory.createGraph();

        PathResult result =
                DijkstraSolver.calculateShortestPath(graph, "S02", "S99");

        assertNull(result);
    }

    @Test
    public void testPesoDeRuta() {
        MixedGraph graph = DataFactory.createGraph();

        assertEquals(12, graph.getEdge("R16").getPeso());
    }

    @Test
    public void testBloqueoDeRuta() {
        MixedGraph graph = DataFactory.createGraph();

        graph.blockEdge("R16");

        assertTrue(graph.isEdgeBlocked("R16"));
    }

    @Test
    public void testRutaDeUnSoloVertice() {
        MixedGraph graph = DataFactory.createGraph();

        PathResult result =
                DijkstraSolver.calculateShortestPath(graph, "S02", "S02");

        assertNotNull(result);
        assertEquals(0, result.getTotalCost());
        assertEquals(List.of("S02"), result.getPath());
        assertTrue(result.getEdges().isEmpty());
    }
}
