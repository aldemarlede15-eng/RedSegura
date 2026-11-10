
package com.redsegura.tree;

import com.redsegura.model.Vertex;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AvlTest {

    // =====================================
    // ROTACION LL
    // =====================================

    @Test
    public void testRotacionLL() {

        AvlTree avl = new AvlTree();

        avl.insert(new Vertex("S03", "Vertice 3"));
        avl.insert(new Vertex("S02", "Vertice 2"));
        avl.insert(new Vertex("S01", "Vertice 1"));

        assertEquals("S02", avl.getRootId());
        assertTrue(avl.isBalanced());
    }

    // =====================================
    // ROTACION RR
    // =====================================

    @Test
    public void testRotacionRR() {

        AvlTree avl = new AvlTree();

        avl.insert(new Vertex("S01", "Vertice 1"));
        avl.insert(new Vertex("S02", "Vertice 2"));
        avl.insert(new Vertex("S03", "Vertice 3"));

        assertEquals("S02", avl.getRootId());
        assertTrue(avl.isBalanced());
    }

    // =====================================
    // ROTACION LR
    // =====================================

    @Test
    public void testRotacionLR() {

        AvlTree avl = new AvlTree();

        avl.insert(new Vertex("S03", "Vertice 3"));
        avl.insert(new Vertex("S01", "Vertice 1"));
        avl.insert(new Vertex("S02", "Vertice 2"));

        assertEquals("S02", avl.getRootId());
        assertTrue(avl.isBalanced());
    }

    // =====================================
    // ROTACION RL
    // =====================================

    @Test
    public void testRotacionRL() {

        AvlTree avl = new AvlTree();

        avl.insert(new Vertex("S01", "Vertice 1"));
        avl.insert(new Vertex("S03", "Vertice 3"));
        avl.insert(new Vertex("S02", "Vertice 2"));

        assertEquals("S02", avl.getRootId());
        assertTrue(avl.isBalanced());
    }

    // =====================================
    // BUSQUEDA
    // =====================================

    @Test
    public void testBusqueda() {

        AvlTree avl = new AvlTree();

        avl.insert(new Vertex("S01", "Vertice 1"));
        avl.insert(new Vertex("S02", "Vertice 2"));

        assertTrue(avl.search("S01"));
        assertFalse(avl.search("S99"));
    }

    // =====================================
    // ELIMINACION
    // =====================================

    @Test
    public void testEliminar() {

        AvlTree avl = new AvlTree();

        avl.insert(new Vertex("S01", "Vertice 1"));
        avl.insert(new Vertex("S02", "Vertice 2"));
        avl.insert(new Vertex("S03", "Vertice 3"));

        avl.delete("S02");

        assertFalse(avl.search("S02"));
        assertTrue(avl.isBalanced());
    }
}
