
package com.redsegura.graph;

import com.redsegura.model.Edge;
import com.redsegura.model.Vertex;
import java.util.*;

public class BFS {

    // =====================================
    // RECORRIDO BFS
    // =====================================

    public static void traverse(MixedGraph graph, String startId) {

        if (graph == null || graph.getVertex(startId) == null) {
            System.out.println("El vertice no existe");
            return;
        }

        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();

        visited.add(startId);
        queue.offer(startId);

        System.out.println("\n--- RECORRIDO BFS ---");

        while (!queue.isEmpty()) {

            String current = queue.poll();

            System.out.print(current + " ");

            for (Edge edge : graph.getNeighbors(current)) {

                Vertex neighborVertex =
                        graph.getOppositeVertex(current, edge);

                if (neighborVertex == null) {
                    continue;
                }

                String neighbor = neighborVertex.getId();

                if (!visited.contains(neighbor)) {

                    visited.add(neighbor);
                    queue.offer(neighbor);
                }
            }
        }

        System.out.println();
    }

    // =====================================
    // CONSTRUCCION DEL ARBOL BFS
    // =====================================

    public static BFSTree buildTree(
            MixedGraph graph, String startId) {

        if (graph == null || graph.getVertex(startId) == null) {
            System.out.println("El vertice no existe");
            return null;
        }

        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();

        BFSTree tree = new BFSTree(startId);

        visited.add(startId);
        queue.offer(startId);
        tree.addVertex(startId);

        while (!queue.isEmpty()) {

            String current = queue.poll();

            for (Edge edge : graph.getNeighbors(current)) {

                Vertex neighborVertex =
                        graph.getOppositeVertex(current, edge);

                if (neighborVertex == null) {
                    continue;
                }

                String neighbor = neighborVertex.getId();

                if (!visited.contains(neighbor)) {

                    visited.add(neighbor);
                    queue.offer(neighbor);

                    tree.addVertex(neighbor);
                    tree.addConnection(current, neighbor);
                }
            }
        }

        return tree;
    }
}
