
package com.redsegura;

import com.redsegura.core.RedSeguraCore;
import com.redsegura.graph.MixedGraph;
import com.redsegura.graph.GraphRepresentations;
import com.redsegura.graph.BFS;
import com.redsegura.graph.DFS;
import com.redsegura.graph.DijkstraSolver;
import com.redsegura.model.Vertex;
import com.redsegura.tree.BinarySearchTree;
import com.redsegura.tree.AvlTree;

public class RedSegura {

    public static void main(String[] args) {

        // Crear el nucleo del sistema y obtener el grafo
        RedSeguraCore core = new RedSeguraCore();
        MixedGraph graph = core.getGraph();

        System.out.println("======================================");
        System.out.println("          SISTEMA RED SEGURA");
        System.out.println("======================================");

        // 1. MOSTRAR LOS VERTICES
        System.out.println("\n--- VERTICES ---");

        for (Vertex vertex : graph.getVertices()) {
            System.out.println(vertex);
        }

        // 2. MOSTRAR GRAFO
        System.out.println("\n--- GRAFO ---");
        graph.showGraph();

        // 3. REPRESENTACIONES DEL GRAFO
        GraphRepresentations.showAdjacencyList(graph);
        GraphRepresentations.showAdjacencyMatrix(graph);
        GraphRepresentations.showIncidenceMatrix(graph);

        // 4. RECORRIDO BFS
        BFS.traverse(graph, "S02");

        // 5. RECORRIDO DFS
        DFS.traverse(graph, "S02");

        // 6. ALGORITMO DE DIJKSTRA
        System.out.println("\n--- DIJKSTRA S02 -> S08 ---");

        DijkstraSolver.findShortestPath(
                graph, "S02", "S08");

        // 7. BLOQUEAR RUTA R16
        System.out.println("\n--- BLOQUEO DE LA RUTA R16 ---");

        graph.blockEdge("R16");

        System.out.println("La ruta R16 ha sido bloqueada.");

        System.out.println("\n--- NUEVA RUTA S02 -> S08 ---");

        DijkstraSolver.findShortestPath(
                graph, "S02", "S08");

        // 8. ARBOL BINARIO DE BUSQUEDA (ABB)
        System.out.println("\n--- ARBOL BINARIO DE BUSQUEDA (ABB) ---");

        BinarySearchTree abb = new BinarySearchTree();

        for (Vertex vertex : graph.getVertices()) {
            abb.insert(vertex);
        }

        System.out.println("\nBuscar S05 (Hospital Universitario): "
                + abb.search("S05"));

        System.out.println("Buscar S10: "
                + abb.search("S10"));

        System.out.println("Comparaciones para buscar S05: "
                + abb.searchComparisons("S05"));

        System.out.println("Altura del ABB: "
                + abb.height());

        abb.inOrder();
        abb.preOrder();
        abb.postOrder();

        // 9. ARBOL AVL
        System.out.println("\n--- ARBOL AVL ---");

        AvlTree avl = new AvlTree();

        for (Vertex vertex : graph.getVertices()) {
            avl.insert(vertex);
        }

        System.out.println("\nBuscar S05 (Hospital Universitario): "
                + avl.search("S05"));

        System.out.println("Buscar S10: "
                + avl.search("S10"));

        System.out.println("Comparaciones para buscar S05: "
                + avl.searchComparisons("S05"));

        System.out.println("Altura del AVL: "
                + avl.height());

        System.out.println("Factor de equilibrio de la raiz: "
                + avl.getRootBalanceFactor());

        System.out.println("¿El AVL esta equilibrado?: "
                + avl.isBalanced());

        avl.inOrder();
        avl.preOrder();
        avl.postOrder();

        // 10. CONSULTA DE VERTICE INEXISTENTE
        System.out.println("\n--- CONSULTA DE VERTICE INEXISTENTE ---");

        System.out.println("Buscar S99 en ABB: "
                + abb.search("S99"));

        System.out.println("Buscar S99 en AVL: "
                + avl.search("S99"));

        System.out.println("\n======================================");
        System.out.println("            FIN DEL PROGRAMA");
        System.out.println("======================================");
    }
}
