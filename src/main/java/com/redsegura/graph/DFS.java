
package com.redsegura.graph;

import com.redsegura.model.Edge;
import com.redsegura.model.Vertex;
import java.util.HashSet;
import java.util.Set;

public class DFS {

    public static void traverse(MixedGraph graph, String startId) {

        // Verificar que el vertice inicial exista
        if (graph.getVertex(startId) == null) {
            System.out.println("El vertice no existe");
            return;
        }

        Set<String> visited = new HashSet<>();

        System.out.println("\n--- RECORRIDO DFS ---");

        // Iniciar recorrido recursivo
        traverseRecursive(graph, startId, visited);

        System.out.println();
    }

    private static void traverseRecursive(
            MixedGraph graph,
            String current,
            Set<String> visited) {

        // Marcar el vertice como visitado
        visited.add(current);

        System.out.print(current + " ");

        // Revisar las conexiones del vertice actual
        for (Edge edge : graph.getNeighbors(current)) {

            Vertex neighborVertex =
                    graph.getOppositeVertex(current, edge);

            if (neighborVertex == null) {
                continue;
            }

            String neighbor = neighborVertex.getId();

            // Continuar si el vecino no ha sido visitado
            if (!visited.contains(neighbor)) {

                traverseRecursive(graph, neighbor, visited);
            }
        }
    }
}
