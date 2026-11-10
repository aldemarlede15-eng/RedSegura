
package com.redsegura.graph;

import com.redsegura.model.Vertex;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MixedGraphTest {

    private MixedGraph crearGrafo() {
        MixedGraph graph = new MixedGraph();

        graph.addVertex(new Vertex("S01", "Universidad"));
        graph.addVertex(new Vertex("S02", "Hospital"));
        graph.addVertex(new Vertex("S03", "Terminal"));

        return graph;
    }

    @Test
    public void testAgregarVertices() {
        MixedGraph graph = crearGrafo();

        assertEquals(3, graph.getVertices().size());
        assertNotNull(graph.getVertex("S01"));
    }

    @Test
    public void testVerticeDuplicado() {
        MixedGraph graph = crearGrafo();

        assertThrows(IllegalArgumentException.class, () -> {
            graph.addVertex(new Vertex("S01", "Otro lugar"));
        });
    }

    @Test
    public void testConexionDirigida() {
        MixedGraph graph = crearGrafo();

        graph.addDirectedEdge(
                "R01", "S01", "S02", 5, "Ruta dirigida");

        assertEquals(1, graph.getNeighbors("S01").size());
        assertEquals(0, graph.getNeighbors("S02").size());
    }

    @Test
    public void testConexionNoDirigida() {
        MixedGraph graph = crearGrafo();

        graph.addUndirectedEdge(
                "R02", "S01", "S02", 5, "Ruta compartida");

        assertEquals(1, graph.getNeighbors("S01").size());
        assertEquals(1, graph.getNeighbors("S02").size());
    }

    @Test
    public void testBloquearYDesbloquearRuta() {
        MixedGraph graph = crearGrafo();

        graph.addDirectedEdge(
                "R03", "S01", "S02", 5, "Ruta principal");

        graph.blockEdge("R03");

        assertTrue(graph.isEdgeBlocked("R03"));
        assertEquals(0, graph.getNeighbors("S01").size());

        graph.unblockEdge("R03");

        assertFalse(graph.isEdgeBlocked("R03"));
        assertEquals(1, graph.getNeighbors("S01").size());
    }

    @Test
    public void testPesoInvalido() {
        MixedGraph graph = crearGrafo();

        assertThrows(IllegalArgumentException.class, () -> {
            graph.addDirectedEdge(
                    "R04", "S01", "S02", 0, "Peso invalido");
        });
    }

    @Test
    public void testVerticeInexistente() {
        MixedGraph graph = crearGrafo();

        assertNull(graph.getVertex("S99"));

        assertThrows(IllegalArgumentException.class, () -> {
            graph.getNeighbors("S99");
        });
    }

    @Test
    public void testRutaConVerticeInexistente() {
        MixedGraph graph = crearGrafo();

        assertThrows(IllegalArgumentException.class, () -> {
            graph.addDirectedEdge(
                    "R05", "S01", "S99", 5, "Ruta invalida");
        });
    }
}
