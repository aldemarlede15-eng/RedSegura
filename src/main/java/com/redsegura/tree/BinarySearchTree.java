
package com.redsegura.tree;

import com.redsegura.model.Vertex;

public class BinarySearchTree {

    private class Node {

        Vertex vertex;
        Node left;
        Node right;

        Node(Vertex vertex) {
            this.vertex = vertex;
        }
    }

    private Node root;

    // =====================================
    // INSERTAR
    // =====================================

    public void insert(Vertex vertex) {

        if (vertex == null) {
            throw new IllegalArgumentException(
                    "El vertice no puede ser nulo");
        }

        root = insertRecursive(root, vertex);
    }

    private Node insertRecursive(Node current, Vertex vertex) {

        if (current == null) {
            return new Node(vertex);
        }

        int comparison = vertex.getId().compareTo(
                current.vertex.getId());

        if (comparison < 0) {
            current.left = insertRecursive(
                    current.left, vertex);

        } else if (comparison > 0) {
            current.right = insertRecursive(
                    current.right, vertex);
        }

        return current;
    }

    // =====================================
    // BUSCAR
    // =====================================

    public boolean search(String id) {

        if (id == null) {
            return false;
        }

        return searchRecursive(root, id);
    }

    private boolean searchRecursive(Node current, String id) {

        if (current == null) {
            return false;
        }

        int comparison = id.compareTo(
                current.vertex.getId());

        if (comparison == 0) {
            return true;
        }

        if (comparison < 0) {
            return searchRecursive(current.left, id);
        }

        return searchRecursive(current.right, id);
    }

    // =====================================
    // CONTAR COMPARACIONES
    // =====================================

    public int searchComparisons(String id) {

        if (id == null) {
            return 0;
        }

        Node current = root;
        int comparisons = 0;

        while (current != null) {

            comparisons++;

            int comparison = id.compareTo(
                    current.vertex.getId());

            if (comparison == 0) {
                return comparisons;
            }

            if (comparison < 0) {
                current = current.left;
            } else {
                current = current.right;
            }
        }

        return comparisons;
    }

    // =====================================
    // ELIMINAR
    // =====================================

    public void delete(String id) {

        if (id == null) {
            return;
        }

        root = deleteRecursive(root, id);
    }

    private Node deleteRecursive(Node current, String id) {

        if (current == null) {
            return null;
        }

        int comparison = id.compareTo(
                current.vertex.getId());

        if (comparison < 0) {

            current.left = deleteRecursive(
                    current.left, id);

        } else if (comparison > 0) {

            current.right = deleteRecursive(
                    current.right, id);

        } else {

            // Caso 1: no tiene hijos
            if (current.left == null
                    && current.right == null) {
                return null;
            }

            // Caso 2: tiene un hijo
            if (current.left == null) {
                return current.right;
            }

            if (current.right == null) {
                return current.left;
            }

            // Caso 3: tiene dos hijos
            Node successor = findMinimum(current.right);

            current.vertex = successor.vertex;

            current.right = deleteRecursive(
                    current.right,
                    successor.vertex.getId());
        }

        return current;
    }

    private Node findMinimum(Node current) {

        while (current.left != null) {
            current = current.left;
        }

        return current;
    }

    // =====================================
    // RECORRIDO INORDEN
    // =====================================

    public void inOrder() {

        System.out.println("\nRecorrido Inorden:");

        inOrderRecursive(root);

        System.out.println();
    }

    private void inOrderRecursive(Node current) {

        if (current != null) {

            inOrderRecursive(current.left);

            System.out.print(current.vertex.getId() + " ");

            inOrderRecursive(current.right);
        }
    }

    // =====================================
    // RECORRIDO PREORDEN
    // =====================================

    public void preOrder() {

        System.out.println("\nRecorrido Preorden:");

        preOrderRecursive(root);

        System.out.println();
    }

    private void preOrderRecursive(Node current) {

        if (current != null) {

            System.out.print(current.vertex.getId() + " ");

            preOrderRecursive(current.left);

            preOrderRecursive(current.right);
        }
    }

    // =====================================
    // RECORRIDO POSTORDEN
    // =====================================

    public void postOrder() {

        System.out.println("\nRecorrido Postorden:");

        postOrderRecursive(root);

        System.out.println();
    }

    private void postOrderRecursive(Node current) {

        if (current != null) {

            postOrderRecursive(current.left);

            postOrderRecursive(current.right);

            System.out.print(current.vertex.getId() + " ");
        }
    }

    // =====================================
    // CALCULAR ALTURA
    // =====================================

    public int height() {

        return heightRecursive(root);
    }

    private int heightRecursive(Node current) {

        if (current == null) {
            return 0;
        }

        int leftHeight = heightRecursive(current.left);

        int rightHeight = heightRecursive(current.right);

        return 1 + Math.max(leftHeight, rightHeight);
    }
}
