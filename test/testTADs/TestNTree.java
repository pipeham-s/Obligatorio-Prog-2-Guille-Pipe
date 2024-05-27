package testTADs;

import org.junit.jupiter.api.Test;
import uy.edu.um.prog2.adt.arbolitos.naryTree.Tree;
import uy.edu.um.prog2.adt.arbolitos.naryTree.TreeImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestNTree {

    @Test
    public void testAdd () {
        Tree<Integer> arbolazo = new TreeImpl<>(1);
        arbolazo.add(2, 1);
        arbolazo.add(3, 1);
        arbolazo.add(4, 1);
        arbolazo.add(5, 2);
        arbolazo.add(6, 2);
        arbolazo.add(7, 3);
        arbolazo.add(8, 3);
    }

    @Test
    public void testSearchValue () {
        Tree<Integer> arbolazo = new TreeImpl<>(1);
        arbolazo.add(2, 1);
        arbolazo.add(3, 1);
        arbolazo.add(4, 1);
        arbolazo.add(5, 2);
        arbolazo.add(6, 2);
        arbolazo.add(7, 3);
        arbolazo.add(8, 3);
        Tree<Integer> nodo = arbolazo.searchValue(5);
        assertEquals(nodo.getValue(), 5);
    }

    @Test
    public void testGetValue() {
        Tree<Integer> arbolazo = new TreeImpl<>(1);
        assertEquals(arbolazo.getValue(), 1);
    }

    @Test
    public void testSetValue() {
        Tree<Integer> arbolazo = new TreeImpl<>(1);
        arbolazo.setValue(2);
        assertEquals(arbolazo.getValue(), 2);
    }

    @Test
    public void testGetChilds() {
        Tree<Integer> arbolazo = new TreeImpl<>(1);
        arbolazo.add(2, 1);
        arbolazo.add(3, 1);
        arbolazo.add(4, 1);
        arbolazo.add(5, 2);
        arbolazo.add(6, 2);
        arbolazo.add(7, 3);
        arbolazo.add(8, 3);
        Tree<Integer>[] hijos = arbolazo.getChilds();
        assertEquals(hijos[0].getValue(), 2);
        assertEquals(hijos[1].getValue(), 3);
        assertEquals(hijos[2].getValue(), 4);
    }
}
