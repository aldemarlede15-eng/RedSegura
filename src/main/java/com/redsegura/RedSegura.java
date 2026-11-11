
package com.redsegura;

import com.redsegura.core.RedSeguraCore;
import com.redsegura.graph.MixedGraph;
import com.redsegura.graph.GraphRepresentations;
import com.redsegura.graph.BFS;
import com.redsegura.graph.BFSTree;
import com.redsegura.graph.DFS;
import com.redsegura.graph.DijkstraSolver;
import com.redsegura.model.Vertex;
import com.redsegura.tree.BinarySearchTree;
import com.redsegura.tree.AvlTree;
import java.util.List;

public class RedSegura {

    public static void main(String[] args) {

        RedSeguraCore core = new RedSeguraCore();
        MixedGraph graph = core.getGraph();

        System.out.println("======================================");
        System.out.println("          SISTEMA RED SEGURA");
        System.out.println("======================================");

        // 1. MOSTRAR VERTICES
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

        // 5. ARBOL BFS
        System.out.println("\n--- CONSTRUCCION DEL ARBOL BFS ---");

        BFSTree bfsTree = BFS.buildTree(graph, "S02");

        if (bfsTree != null) {
            bfsTree.showTree();
        }

        // 6. RECORRIDO DFS
        DFS.traverse(graph, "S02");

        // 7. DETECCION DE CICLOS
        System.out.println("\n--- DETECCION DE CICLOS ---");

        System.out.println("¿El grafo contiene ciclos?: "
                + DFS.hasCycle(graph));

        // 8. COMPONENTES CONEXOS DEBILES
        System.out.println("\n--- COMPONENTES CONEXOS DEBILES ---");

        List<List<String>> components =
                DFS.weaklyConnectedComponents(graph);

        System.out.println("Cantidad de componentes: "
                + components.size());

        for (int i = 0; i < components.size(); i++) {
            System.out.println("Componente " + (i + 1) + ": "
                    + components.get(i));
        }

        // 9. DIJKSTRA
        System.out.println("\n--- DIJKSTRA S02 -> S08 ---");

        DijkstraSolver.findShortestPath(graph, "S02", "S08");

        // 10. BLOQUEAR RUTA R16
        System.out.println("\n--- BLOQUEO DE LA RUTA R16 ---");

        graph.blockEdge("R16");

        System.out.println("La ruta R16 ha sido bloqueada.");

        System.out.println("\n--- NUEVA RUTA S02 -> S08 ---");

        DijkstraSolver.findShortestPath(graph, "S02", "S08");

        // 11. ARBOL BINARIO DE BUSQUEDA
        System.out.println("\n--- ARBOL BINARIO DE BUSQUEDA (ABB) ---");

        BinarySearchTree abb = new BinarySearchTree();

        for (Vertex vertex : graph.getVertices()) {
            abb.insert(vertex);
        }

        System.out.println("\nBuscar S05: " + abb.search("S05"));
        System.out.println("Buscar S10: " + abb.search("S10"));

        System.out.println("Comparaciones para S05: "
                + abb.searchComparisons("S05"));

        System.out.println("Altura del ABB: " + abb.height());

        abb.inOrder();
        abb.preOrder();
        abb.postOrder();

        // 12. ARBOL AVL
        System.out.println("\n--- ARBOL AVL ---");

        AvlTree avl = new AvlTree();

        for (Vertex vertex : graph.getVertices()) {
            avl.insert(vertex);
        }

        System.out.println("\nBuscar S05: " + avl.search("S05"));
        System.out.println("Buscar S10: " + avl.search("S10"));

        System.out.println("Comparaciones para S05: "
                + avl.searchComparisons("S05"));

        System.out.println("Altura del AVL: " + avl.height());

        System.out.println("Factor de equilibrio de la raiz: "
                + avl.getRootBalanceFactor());

        System.out.println("¿El AVL esta equilibrado?: "
                + avl.isBalanced());

        avl.inOrder();
        avl.preOrder();
        avl.postOrder();

        // 13. DEMOSTRACION DE ROTACIONES AVL
        System.out.println("\n--- DEMOSTRACION DE ROTACIONES AVL ---");

        mostrarRotacion("ROTACION LL", "30", "20", "10");
        mostrarRotacion("ROTACION RR", "10", "20", "30");
        mostrarRotacion("ROTACION LR", "30", "10", "20");
        mostrarRotacion("ROTACION RL", "10", "30", "20");

        // 14. VERTICE INEXISTENTE
        System.out.println("\n--- CONSULTA DE VERTICE INEXISTENTE ---");

        System.out.println("Buscar S99 en ABB: "
                + abb.search("S99"));

        System.out.println("Buscar S99 en AVL: "
                + avl.search("S99"));

        System.out.println("\n======================================");
        System.out.println("            FIN DEL PROGRAMA");
        System.out.println("======================================");
    }

    // METODO PARA DEMOSTRAR LAS ROTACIONES AVL
    private static void mostrarRotacion(
            String nombre, String primero,
            String segundo, String tercero) {

        AvlTree prueba = new AvlTree();

        prueba.insert(new Vertex(primero, primero, "Prueba"));
        prueba.insert(new Vertex(segundo, segundo, "Prueba"));
        prueba.insert(new Vertex(tercero, tercero, "Prueba"));

        System.out.println("\n" + nombre);
        System.out.println("Valores insertados: "
                + primero + ", " + segundo + ", " + tercero);

        System.out.println("Recorrido preorden después del balanceo:");
        prueba.preOrder();
    }
}
