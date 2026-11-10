
package com.redsegura.app;

import com.redsegura.model.Vertex;
import com.redsegura.tree.AvlTree;

public class AvlTest {

    public static void main(String[] args) {

        System.out.println("================================");
        System.out.println("       PRUEBAS DEL ARBOL AVL");
        System.out.println("================================");

        // PRUEBA LL
        System.out.println("\nCASO LL");
        AvlTree ll = new AvlTree();
        ll.insert(new Vertex("30", "Nodo 30"));
        ll.insert(new Vertex("20", "Nodo 20"));
        ll.insert(new Vertex("10", "Nodo 10"));

        mostrarResultados(ll);

        // PRUEBA RR
        System.out.println("\nCASO RR");
        AvlTree rr = new AvlTree();
        rr.insert(new Vertex("10", "Nodo 10"));
        rr.insert(new Vertex("20", "Nodo 20"));
        rr.insert(new Vertex("30", "Nodo 30"));

        mostrarResultados(rr);

        // PRUEBA LR
        System.out.println("\nCASO LR");
        AvlTree lr = new AvlTree();
        lr.insert(new Vertex("30", "Nodo 30"));
        lr.insert(new Vertex("10", "Nodo 10"));
        lr.insert(new Vertex("20", "Nodo 20"));

        mostrarResultados(lr);

        // PRUEBA RL
        System.out.println("\nCASO RL");
        AvlTree rl = new AvlTree();
        rl.insert(new Vertex("10", "Nodo 10"));
        rl.insert(new Vertex("30", "Nodo 30"));
        rl.insert(new Vertex("20", "Nodo 20"));

        mostrarResultados(rl);

        System.out.println("\n================================");
        System.out.println("       FIN DE LAS PRUEBAS");
        System.out.println("================================");
    }

    public static void mostrarResultados(AvlTree arbol) {

        System.out.println("Buscar 10: " + arbol.search("10"));
        System.out.println("Buscar 20: " + arbol.search("20"));
        System.out.println("Buscar 30: " + arbol.search("30"));

        System.out.println("Raiz del arbol: " + arbol.getRootId());
        System.out.println("Arbol equilibrado: " + arbol.isBalanced());
    }
}
