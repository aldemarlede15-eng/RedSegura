
package com.redsegura.graph;

import com.redsegura.model.Vertex;
import com.redsegura.model.Edge;
import java.util.List;

public class GraphRepresentations {

    // =====================================
    // 1. LISTA DE ADYACENCIA
    // =====================================

    public static void showAdjacencyList(MixedGraph graph) {

        System.out.println("\n--- LISTA DE ADYACENCIA ---");
        graph.showGraph();
    }

    // =====================================
    // 2. MATRIZ DE ADYACENCIA
    // =====================================

    public static void showAdjacencyMatrix(MixedGraph graph) {

        List<Vertex> vertices = graph.getVertices();
        int n = vertices.size();

        int[][] matrix = new int[n][n];

        // Recorrer las 18 rutas originales
        for (Edge edge : graph.getEdges()) {

            int origen = indexOf(vertices, edge.getOrigen().getId());
            int destino = indexOf(vertices, edge.getDestino().getId());

            if (origen == -1 || destino == -1) {
                continue;
            }

            // Sumar el peso para no sobrescribir
            // conexiones entre los mismos vértices
            matrix[origen][destino] += edge.getPeso();

            // Si es no dirigida, registrar ambos sentidos
            if (!edge.isDirigida()) {
                matrix[destino][origen] += edge.getPeso();
            }
        }

        System.out.println("\n--- MATRIZ DE ADYACENCIA ---");

        System.out.print("     ");

        for (Vertex vertex : vertices) {
            System.out.printf("%8s", vertex.getId());
        }

        System.out.println();

        for (int i = 0; i < n; i++) {

            System.out.printf("%-5s", vertices.get(i).getId());

            for (int j = 0; j < n; j++) {
                System.out.printf("%8d", matrix[i][j]);
            }

            System.out.println();
        }
    }

    // =====================================
    // 3. MATRIZ DE INCIDENCIA
    // =====================================

    public static void showIncidenceMatrix(MixedGraph graph) {

        List<Vertex> vertices = graph.getVertices();

        // Obtener las rutas originales sin duplicarlas
        List<Edge> edges = graph.getEdges();

        int[][] matrix = new int[vertices.size()][edges.size()];

        for (int j = 0; j < edges.size(); j++) {

            Edge edge = edges.get(j);

            int origen = indexOf(
                    vertices, edge.getOrigen().getId());

            int destino = indexOf(
                    vertices, edge.getDestino().getId());

            if (origen == -1 || destino == -1) {
                continue;
            }

            if (edge.isDirigida()) {

                // Dirigida: -1 origen y +1 destino
                matrix[origen][j] = -1;
                matrix[destino][j] = 1;

            } else {

                // No dirigida: +1 en ambos extremos
                matrix[origen][j] = 1;
                matrix[destino][j] = 1;
            }
        }

        System.out.println("\n--- MATRIZ DE INCIDENCIA ---");

        System.out.print("     ");

        for (Edge edge : edges) {
            System.out.printf("%5s", edge.getId());
        }

        System.out.println();

        for (int i = 0; i < vertices.size(); i++) {

            System.out.printf("%-5s", vertices.get(i).getId());

            for (int j = 0; j < edges.size(); j++) {
                System.out.printf("%5d", matrix[i][j]);
            }

            System.out.println();
        }

        System.out.println("\nTotal de rutas: " + edges.size());
    }

    // =====================================
    // 4. BUSCAR POSICION DE UN VERTICE
    // =====================================

    private static int indexOf(List<Vertex> vertices, String id) {

        for (int i = 0; i < vertices.size(); i++) {

            if (vertices.get(i).getId().equals(id)) {
                return i;
            }
        }

        return -1;
    }
}
