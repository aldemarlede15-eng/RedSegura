package com.redsegura.graph;

import java.util.ArrayList;
import java.util.List;

public class BFSTree {

    private final String root;
    private final List<String> order;
    private final List<String[]> connections;

    public BFSTree(String root) {
        this.root = root;
        this.order = new ArrayList<>();
        this.connections = new ArrayList<>();
    }

    public void addVertex(String vertex) {
        order.add(vertex);
    }

    public void addConnection(String parent, String child) {
        connections.add(new String[]{parent, child});
    }

    public String getRoot() {
        return root;
    }

    public List<String> getOrder() {
        return order;
    }

    public List<String[]> getConnections() {
        return connections;
    }

    public void showTree() {
        System.out.println("\n--- ARBOL BFS ---");
        System.out.println("Raiz: " + root);
        System.out.println("Orden de recorrido:");

        for (String vertex : order) {
            System.out.print(vertex + " ");
        }

        System.out.println("\nConexiones del arbol:");

        for (String[] connection : connections) {
            System.out.println(connection[0] + " -> " + connection[1]);
        }
    }
}
