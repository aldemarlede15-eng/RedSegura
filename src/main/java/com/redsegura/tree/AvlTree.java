
package com.redsegura.tree;

import com.redsegura.model.Vertex;

public class AvlTree {

    private class Node {

        Vertex vertex;
        Node left;
        Node right;
        int height;

        Node(Vertex vertex) {
            this.vertex = vertex;
            this.height = 1;
        }
    }

    private Node root;

    // =====================================
    // ALTURA DE UN NODO
    // =====================================

    private int height(Node node) {
        return node == null ? 0 : node.height;
    }

    // =====================================
    // FACTOR DE EQUILIBRIO
    // =====================================

    private int balance(Node node) {
        return node == null
                ? 0
                : height(node.left) - height(node.right);
    }

    // =====================================
    // ACTUALIZAR ALTURA
    // =====================================

    private void updateHeight(Node node) {
        node.height = 1 + Math.max(
                height(node.left),
                height(node.right));
    }

    // =====================================
    // ROTACION DERECHA (LL)
    // =====================================

    private Node rotateRight(Node y) {

        Node x = y.left;
        Node temp = x.right;

        x.right = y;
        y.left = temp;

        updateHeight(y);
        updateHeight(x);

        return x;
    }

    // =====================================
    // ROTACION IZQUIERDA (RR)
    // =====================================

    private Node rotateLeft(Node x) {

        Node y = x.right;
        Node temp = y.left;

        y.left = x;
        x.right = temp;

        updateHeight(x);
        updateHeight(y);

        return y;
    }

    // =====================================
    // REBALANCEAR EL ARBOL
    // =====================================

    private Node rebalance(Node node) {

        if (node == null) {
            return null;
        }

        updateHeight(node);

        int factor = balance(node);

        // Caso LL
        if (factor > 1 && balance(node.left) >= 0) {
            return rotateRight(node);
        }

        // Caso LR
        if (factor > 1 && balance(node.left) < 0) {
            node.left = rotateLeft(node.left);
            return rotateRight(node);
        }

        // Caso RR
        if (factor < -1 && balance(node.right) <= 0) {
            return rotateLeft(node);
        }

        // Caso RL
        if (factor < -1 && balance(node.right) > 0) {
            node.right = rotateRight(node.right);
            return rotateLeft(node);
        }

        return node;
    }

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

    private Node insertRecursive(Node node, Vertex vertex) {

        if (node == null) {
            return new Node(vertex);
        }

        int comparison = vertex.getId().compareTo(
                node.vertex.getId());

        if (comparison < 0) {
            node.left = insertRecursive(node.left, vertex);

        } else if (comparison > 0) {
            node.right = insertRecursive(node.right, vertex);

        } else {
            return node;
        }

        return rebalance(node);
    }

    // =====================================
    // BUSCAR
    // =====================================

    public boolean search(String id) {

        if (id == null) {
            return false;
        }

        Node current = root;

        while (current != null) {

            int comparison = id.compareTo(
                    current.vertex.getId());

            if (comparison == 0) {
                return true;
            }

            current = comparison < 0
                    ? current.left
                    : current.right;
        }

        return false;
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

            current = comparison < 0
                    ? current.left
                    : current.right;
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

    private Node deleteRecursive(Node node, String id) {

        if (node == null) {
            return null;
        }

        int comparison = id.compareTo(
                node.vertex.getId());

        if (comparison < 0) {

            node.left = deleteRecursive(node.left, id);

        } else if (comparison > 0) {

            node.right = deleteRecursive(node.right, id);

        } else {

            // Caso 1: no tiene hijos
            if (node.left == null && node.right == null) {
                return null;
            }

            // Caso 2: tiene un solo hijo
            if (node.left == null) {
                return node.right;
            }

            if (node.right == null) {
                return node.left;
            }

            // Caso 3: tiene dos hijos
            Node successor = findMinimum(node.right);

            node.vertex = successor.vertex;

            node.right = deleteRecursive(
                    node.right,
                    successor.vertex.getId());
        }

        return rebalance(node);
    }

    private Node findMinimum(Node node) {

        while (node.left != null) {
            node = node.left;
        }

        return node;
    }

    // =====================================
    // ALTURA DEL ARBOL
    // =====================================

    public int height() {
        return height(root);
    }

    // =====================================
    // FACTOR DE EQUILIBRIO DE LA RAIZ
    // =====================================

    public int getRootBalanceFactor() {
        return balance(root);
    }

    // =====================================
    // IDENTIFICADOR DE LA RAIZ
    // =====================================

    public String getRootId() {
        return root == null ? null : root.vertex.getId();
    }

    // =====================================
    // RECORRIDO INORDEN
    // =====================================

    public void inOrder() {

        System.out.println("\nRecorrido Inorden:");

        inOrderRecursive(root);

        System.out.println();
    }

    private void inOrderRecursive(Node node) {

        if (node != null) {

            inOrderRecursive(node.left);

            System.out.print(node.vertex.getId() + " ");

            inOrderRecursive(node.right);
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

    private void preOrderRecursive(Node node) {

        if (node != null) {

            System.out.print(node.vertex.getId() + " ");

            preOrderRecursive(node.left);

            preOrderRecursive(node.right);
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

    private void postOrderRecursive(Node node) {

        if (node != null) {

            postOrderRecursive(node.left);

            postOrderRecursive(node.right);

            System.out.print(node.vertex.getId() + " ");
        }
    }

    // =====================================
    // VERIFICAR EQUILIBRIO
    // =====================================

    public boolean isBalanced() {
        return checkHeight(root) != -1;
    }

    private int checkHeight(Node node) {

        if (node == null) {
            return 0;
        }

        int leftHeight = checkHeight(node.left);

        if (leftHeight == -1) {
            return -1;
        }

        int rightHeight = checkHeight(node.right);

        if (rightHeight == -1) {
            return -1;
        }

        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }

        int calculatedHeight = 1 + Math.max(
                leftHeight, rightHeight);

        if (node.height != calculatedHeight) {
            return -1;
        }

        return calculatedHeight;
    }
}
