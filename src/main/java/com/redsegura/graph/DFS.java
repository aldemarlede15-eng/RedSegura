
package com.redsegura.graph;

import com.redsegura.model.Edge;
import com.redsegura.model.Vertex;
import java.util.*;

public class DFS {

    // =====================================
    // RECORRIDO DFS
    // =====================================

    public static void traverse(MixedGraph graph, String startId) {

        if (graph == null || graph.getVertex(startId) == null) {
            System.out.println("El vertice no existe");
            return;
        }

        Set<String> visited = new HashSet<>();

        System.out.println("\n--- RECORRIDO DFS ---");

        traverseRecursive(graph, startId, visited);

        System.out.println();
    }

    private static void traverseRecursive(
            MixedGraph graph,
            String current,
            Set<String> visited) {

        visited.add(current);
        System.out.print(current + " ");

        for (Edge edge : graph.getNeighbors(current)) {

            Vertex neighborVertex =
                    graph.getOppositeVertex(current, edge);

            if (neighborVertex == null) {
                continue;
            }

            String neighbor = neighborVertex.getId();

            if (!visited.contains(neighbor)) {
                traverseRecursive(graph, neighbor, visited);
            }
        }
    }

    // =====================================
    // DETECCION DE CICLOS
    // =====================================

    public static boolean hasCycle(MixedGraph graph) {

        if (graph == null) {
            throw new IllegalArgumentException(
                    "El grafo no puede ser nulo");
        }

        Set<String> visited = new HashSet<>();
        Set<String> active = new HashSet<>();

        for (Vertex vertex : graph.getVertices()) {

            String id = vertex.getId();

            if (!visited.contains(id)) {

                if (hasCycleRecursive(
                        graph, id, null, visited, active)) {
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean hasCycleRecursive(
            MixedGraph graph,
            String current,
            String parentEdgeId,
            Set<String> visited,
            Set<String> active) {

        visited.add(current);
        active.add(current);

        for (Edge edge : graph.getNeighbors(current)) {

            Vertex neighborVertex =
                    graph.getOppositeVertex(current, edge);

            if (neighborVertex == null) {
                continue;
            }

            String neighbor = neighborVertex.getId();

            if (!visited.contains(neighbor)) {

                if (hasCycleRecursive(
                        graph,
                        neighbor,
                        edge.getId(),
                        visited,
                        active)) {
                    return true;
                }

            } else if (edge.isDirigida()) {

                // Detectar una ruta dirigida hacia un vertice activo
                if (active.contains(neighbor)) {
                    return true;
                }

            } else {

                // Evitar contar la misma ruta no dirigida
                // por la que llegamos al vertice
                if (!edge.getId().equals(parentEdgeId)) {
                    return true;
                }
            }
        }

        active.remove(current);

        return false;
    }

    // =====================================
    // COMPONENTES CONEXOS DEBILES
    // =====================================

    public static List<List<String>> weaklyConnectedComponents(
            MixedGraph graph) {

        if (graph == null) {
            throw new IllegalArgumentException(
                    "El grafo no puede ser nulo");
        }

        List<List<String>> components = new ArrayList<>();
        Set<String> visited = new HashSet<>();

        for (Vertex vertex : graph.getVertices()) {

            String id = vertex.getId();

            if (!visited.contains(id)) {

                List<String> component = new ArrayList<>();

                weakComponentRecursive(
                        graph, id, visited, component);

                components.add(component);
            }
        }

        return components;
    }

    private static void weakComponentRecursive(
            MixedGraph graph,
            String current,
            Set<String> visited,
            List<String> component) {

        visited.add(current);
        component.add(current);

        // Revisar conexiones que salen del vertice
        for (Edge edge : graph.getNeighbors(current)) {

            Vertex neighbor =
                    graph.getOppositeVertex(current, edge);

            if (neighbor != null
                    && !visited.contains(neighbor.getId())) {

                weakComponentRecursive(
                        graph, neighbor.getId(), visited, component);
            }
        }

        // Revisar conexiones dirigidas que llegan al vertice
        for (Edge edge : graph.getEdges()) {

            if (edge.isDirigida()
                    && edge.getDestino().getId().equals(current)) {

                String origin = edge.getOrigen().getId();

                if (!graph.isEdgeBlocked(edge.getId())
                        && !visited.contains(origin)) {

                    weakComponentRecursive(
                            graph, origin, visited, component);
                }
            }
        }
    }
}
