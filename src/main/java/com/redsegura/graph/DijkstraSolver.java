
package com.redsegura.graph;

import com.redsegura.model.Edge;
import com.redsegura.model.Vertex;
import java.util.*;

public class DijkstraSolver {

    public static void findShortestPath(
            MixedGraph graph, String startId, String endId) {

        // Validar vertices
        if (graph.getVertex(startId) == null
                || graph.getVertex(endId) == null) {

            System.out.println("El vertice no existe");
            return;
        }

        Map<String, Integer> distances = new HashMap<>();
        Map<String, String> previous = new HashMap<>();
        Map<String, Edge> previousEdge = new HashMap<>();

        Set<String> visited = new HashSet<>();

        // Cola de prioridad
        PriorityQueue<String> queue = new PriorityQueue<>(
                Comparator.comparingInt(distances::get));

        // Inicializar distancias
        for (Vertex vertex : graph.getVertices()) {
            distances.put(vertex.getId(), Integer.MAX_VALUE);
        }

        distances.put(startId, 0);
        queue.add(startId);

        // Algoritmo de Dijkstra
        while (!queue.isEmpty()) {

            String current = queue.poll();

            if (visited.contains(current)) {
                continue;
            }

            visited.add(current);

            if (current.equals(endId)) {
                break;
            }

            // Revisar conexiones disponibles
            for (Edge edge : graph.getNeighbors(current)) {

                Vertex neighborVertex =
                        graph.getOppositeVertex(current, edge);

                if (neighborVertex == null) {
                    continue;
                }

                String neighbor = neighborVertex.getId();

                if (visited.contains(neighbor)) {
                    continue;
                }

                int newDistance =
                        distances.get(current) + edge.getPeso();

                // Relajacion de la arista
                if (newDistance < distances.get(neighbor)) {

                    distances.put(neighbor, newDistance);
                    previous.put(neighbor, current);
                    previousEdge.put(neighbor, edge);

                    queue.remove(neighbor);
                    queue.add(neighbor);
                }
            }
        }

        // Comprobar si existe una ruta
        if (distances.get(endId) == Integer.MAX_VALUE) {

            System.out.println("\n--- RUTA MAS CORTA ---");
            System.out.println("No existe una ruta disponible");
            return;
        }

        // Reconstruir vertices y conexiones
        List<String> path = new ArrayList<>();
        List<Edge> pathEdges = new ArrayList<>();

        String current = endId;

        while (!current.equals(startId)) {

            path.add(current);

            Edge edge = previousEdge.get(current);

            if (edge == null) {
                System.out.println("No se pudo reconstruir la ruta");
                return;
            }

            pathEdges.add(edge);
            current = previous.get(current);
        }

        path.add(startId);

        Collections.reverse(path);
        Collections.reverse(pathEdges);

        // Mostrar resultados
        System.out.println("\n--- RUTA MAS CORTA ---");

        System.out.println("Origen: " + startId);
        System.out.println("Destino: " + endId);

        System.out.println(
                "Recorrido: " + String.join(" -> ", path));

        System.out.print("Rutas utilizadas: ");

        if (pathEdges.isEmpty()) {
            System.out.println("Ninguna");
        } else {
            for (int i = 0; i < pathEdges.size(); i++) {

                System.out.print(pathEdges.get(i).getId());

                if (i < pathEdges.size() - 1) {
                    System.out.print(" -> ");
                }
            }

            System.out.println();
        }

        System.out.println("Detalle de conexiones:");

        for (Edge edge : pathEdges) {

            System.out.println(
                    edge.getId() + " | "
                    + edge.getEtiqueta() + " | "
                    + edge.getPeso() + " minutos");
        }

        System.out.println(
                "Tiempo total: "
                + distances.get(endId) + " minutos");
    }
}
