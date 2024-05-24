import org.junit.jupiter.api.Test;
import uy.edu.um.prog2.adt.arbolitos.binarytree.SearchBinaryTreeImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestBinaryTree {
    SearchBinaryTreeImpl<Integer> ArbolBinario = new SearchBinaryTreeImpl<>();
    @Test
    public void testAdd () {
        ArbolBinario.add(1);
        ArbolBinario.add(2);
        ArbolBinario.add(3);
        ArbolBinario.add(5);
        ArbolBinario.add(4);
        assertEquals(ArbolBinario.inOrder().toString(), "[1, 2, 3, 4, 5]");
    }

    @Test
    public void testContains () {
        ArbolBinario.add(1);
        ArbolBinario.add(2);
        ArbolBinario.add(3);
        ArbolBinario.add(5);
        ArbolBinario.add(4);
        assertEquals(ArbolBinario.contains(3), true);
    }

    @Test
    public void testFind () {
        ArbolBinario.add(1);
        ArbolBinario.add(2);
        ArbolBinario.add(3);
        ArbolBinario.add(5);
        ArbolBinario.add(4);
        assertEquals(ArbolBinario.find(3), 3);
    }

    @Test
    public void testRemove () {
        ArbolBinario.add(1);
        ArbolBinario.add(2);
        ArbolBinario.add(3);
        ArbolBinario.add(5);
        ArbolBinario.add(4);
        ArbolBinario.remove(4);
        assertEquals(ArbolBinario.inOrder().toString(), "[1, 2, 3, 5]");
    }


}
