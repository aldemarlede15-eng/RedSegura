
package com.redsegura.graph;

import com.redsegura.model.Vertex;
import com.redsegura.model.Edge;
import java.util.*;

public class MixedGraph {

    private final Map<String, Vertex> vertices;
    private final Map<String, List<Edge>> adjacencyList;
    private final Map<String, Edge> edges;
    private final Set<String> blockedEdges;

    public MixedGraph() {
        vertices = new LinkedHashMap<>();
        adjacencyList = new LinkedHashMap<>();
        edges = new LinkedHashMap<>();
        blockedEdges = new HashSet<>();
    }

    // Agregar un vértice
    public void addVertex(Vertex vertex) {

        if (vertex == null) {
            throw new IllegalArgumentException("El vértice no puede ser nulo");
        }

        if (vertices.containsKey(vertex.getId())) {
            throw new IllegalArgumentException(
                    "Ya existe un vértice con ID: " + vertex.getId());
        }

        vertices.put(vertex.getId(), vertex);
        adjacencyList.put(vertex.getId(), new ArrayList<>());
    }

    // Agregar una ruta dirigida
    public void addDirectedEdge(String id, String origen,
            String destino, int peso, String etiqueta) {

        addEdge(id, origen, destino, peso, etiqueta, true);
    }

    // Agregar una ruta no dirigida
    public void addUndirectedEdge(String id, String origen,
            String destino, int peso, String etiqueta) {

        addEdge(id, origen, destino, peso, etiqueta, false);
    }

    // Método interno para registrar las rutas
    private void addEdge(String id, String origen, String destino,
            int peso, String etiqueta, boolean dirigida) {

        if (edges.containsKey(id)) {
            throw new IllegalArgumentException(
                    "Ya existe una ruta con ID: " + id);
        }

        Vertex vOrigen = vertices.get(origen);
        Vertex vDestino = vertices.get(destino);

        if (vOrigen == null || vDestino == null) {
            throw new IllegalArgumentException(
                    "Uno o ambos vértices no existen");
        }

        Edge edge = new Edge(
                id, vOrigen, vDestino, peso, etiqueta, dirigida);

        edges.put(id, edge);

        // Registrar la conexión desde el origen
        adjacencyList.get(origen).add(edge);

        // Si es no dirigida, también se registra desde el destino
        if (!dirigida) {
            adjacencyList.get(destino).add(edge);
        }
    }

    // Bloquear una ruta por su ID
    public void blockEdge(String id) {

        if (!edges.containsKey(id)) {
            throw new IllegalArgumentException(
                    "No existe una ruta con ID: " + id);
        }

        blockedEdges.add(id);
    }

    // Desbloquear una ruta
    public void unblockEdge(String id) {

        if (!edges.containsKey(id)) {
            throw new IllegalArgumentException(
                    "No existe una ruta con ID: " + id);
        }

        blockedEdges.remove(id);
    }

    // Consultar si una ruta está bloqueada
    public boolean isEdgeBlocked(String id) {
        return blockedEdges.contains(id);
    }

    // Consultar un vértice
    public Vertex getVertex(String id) {
        return vertices.get(id);
    }

    // Consultar todas las rutas originales
    public List<Edge> getEdges() {
        return new ArrayList<>(edges.values());
    }

    // Consultar una ruta por su ID
    public Edge getEdge(String id) {
        return edges.get(id);
    }

    // Consultar todos los vértices
    public List<Vertex> getVertices() {
        return new ArrayList<>(vertices.values());
    }

    // Consultar conexiones disponibles desde un vértice
    public List<Edge> getNeighbors(String id) {

        if (!vertices.containsKey(id)) {
            throw new IllegalArgumentException(
                    "No existe el vértice: " + id);
        }

        List<Edge> disponibles = new ArrayList<>();

        for (Edge edge : adjacencyList.get(id)) {
            if (!blockedEdges.contains(edge.getId())) {
                disponibles.add(edge);
            }
        }

        return disponibles;
    }

    // Obtener el otro extremo de una conexión
    public Vertex getOppositeVertex(String vertexId, Edge edge) {

        if (edge.getOrigen().getId().equals(vertexId)) {
            return edge.getDestino();
        }

        if (!edge.isDirigida()
                && edge.getDestino().getId().equals(vertexId)) {
            return edge.getOrigen();
        }

        return null;
    }

    // Mostrar el grafo
    public void showGraph() {

        for (String id : adjacencyList.keySet()) {

            System.out.print(id + " -> ");

            for (Edge edge : getNeighbors(id)) {

                Vertex vecino = getOppositeVertex(id, edge);

                if (vecino != null) {
                    System.out.print(
                            vecino.getId() + "("
                            + edge.getPeso() + ") ");
                }
            }

            System.out.println();
        }
    }
}
