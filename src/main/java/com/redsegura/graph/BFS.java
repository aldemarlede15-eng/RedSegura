
package com.redsegura.graph;

import com.redsegura.model.Edge;
import com.redsegura.model.Vertex;
import java.util.*;

public class BFS {

    public static void traverse(MixedGraph graph, String startId) {

        // Verificar que el vertice inicial exista
        if (graph.getVertex(startId) == null) {
            System.out.println("El vertice no existe");
            return;
        }

        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();

        // Marcar el vertice inicial
        visited.add(startId);
        queue.offer(startId);

        System.out.println("\n--- RECORRIDO BFS ---");

        // Recorrer mientras existan vertices en la cola
        while (!queue.isEmpty()) {

            String current = queue.poll();

            System.out.print(current + " ");

            // Obtener las conexiones disponibles
            for (Edge edge : graph.getNeighbors(current)) {

                Vertex neighborVertex =
                        graph.getOppositeVertex(current, edge);

                if (neighborVertex == null) {
                    continue;
                }

                String neighbor = neighborVertex.getId();

                // Visitar cada vertice una sola vez
                if (!visited.contains(neighbor)) {

                    visited.add(neighbor);
                    queue.offer(neighbor);
                }
            }
        }

        System.out.println();
    }
}
