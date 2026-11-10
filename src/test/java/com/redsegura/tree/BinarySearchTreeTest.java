
package com.redsegura.tree;

import com.redsegura.model.Vertex;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BinarySearchTreeTest {

    @Test
    public void testInsertarYBuscar() {
        BinarySearchTree abb = new BinarySearchTree();

        abb.insert(new Vertex("S02", "Vertice 2"));
        abb.insert(new Vertex("S01", "Vertice 1"));
        abb.insert(new Vertex("S03", "Vertice 3"));

        assertTrue(abb.search("S02"));
        assertTrue(abb.search("S01"));
        assertTrue(abb.search("S03"));
        assertFalse(abb.search("S99"));
    }

    @Test
    public void testEliminarHoja() {
        BinarySearchTree abb = new BinarySearchTree();

        abb.insert(new Vertex("S02", "Vertice 2"));
        abb.insert(new Vertex("S01", "Vertice 1"));
        abb.insert(new Vertex("S03", "Vertice 3"));

        abb.delete("S01");

        assertFalse(abb.search("S01"));
        assertTrue(abb.search("S02"));
    }

    @Test
    public void testEliminarNodoConDosHijos() {
        BinarySearchTree abb = new BinarySearchTree();

        abb.insert(new Vertex("S02", "Vertice 2"));
        abb.insert(new Vertex("S01", "Vertice 1"));
        abb.insert(new Vertex("S03", "Vertice 3"));

        abb.delete("S02");

        assertFalse(abb.search("S02"));
        assertTrue(abb.search("S01"));
        assertTrue(abb.search("S03"));
    }

    @Test
    public void testAltura() {
        BinarySearchTree abb = new BinarySearchTree();

        abb.insert(new Vertex("S02", "Vertice 2"));
        abb.insert(new Vertex("S01", "Vertice 1"));
        abb.insert(new Vertex("S03", "Vertice 3"));

        assertEquals(2, abb.height());
    }

    @Test
    public void testArbolVacio() {
        BinarySearchTree abb = new BinarySearchTree();

        assertFalse(abb.search("S01"));
        assertEquals(0, abb.height());
    }
}
