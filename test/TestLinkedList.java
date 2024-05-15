import uy.edu.um.prog2.adt.linkedlist.MyLinkedListImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestLinkedList {

    MyLinkedListImpl<String> ListaEnlazada = new MyLinkedListImpl<>();
    @Test // siempre importr el 5
    public void testAdd () {
        ListaEnlazada.add("A");
        ListaEnlazada.add("B");
        ListaEnlazada.add("C");
        ListaEnlazada.add("D");
        ListaEnlazada.add("E");
    }
    // asumimos que funciona el add y mediante las otras operaciones efectivamente comprobaremos que al ejecutarlas los elementos realmente se encontraban en la lista enlazada
    @Test
    public void testGet () {
        ListaEnlazada.add("A");
        ListaEnlazada.add("B");
        ListaEnlazada.add("C");
        ListaEnlazada.add("D");
        ListaEnlazada.add("E");
        assertEquals("A", ListaEnlazada.get(0));
        assertEquals("B", ListaEnlazada.get(1));
        assertEquals("C", ListaEnlazada.get(2));
        assertEquals("D", ListaEnlazada.get(3));
        assertEquals("E", ListaEnlazada.get(4));
    }
    @Test
    public void testContains () {
        ListaEnlazada.add("A");
        ListaEnlazada.add("B");
        ListaEnlazada.add("C");
        ListaEnlazada.add("D");
        ListaEnlazada.add("E");
        assertTrue(ListaEnlazada.contains("A"));
        assertTrue(ListaEnlazada.contains("B"));
        assertTrue(ListaEnlazada.contains("C"));
        assertTrue(ListaEnlazada.contains("D"));
        assertTrue(ListaEnlazada.contains("E"));
        assertFalse(ListaEnlazada.contains("F"));
    }
    @Test
    public void testRemove () {
        ListaEnlazada.add("A");
        ListaEnlazada.add("B");
        ListaEnlazada.add("C");
        ListaEnlazada.add("D");
        ListaEnlazada.add("E");
        ListaEnlazada.remove("A");
        assertFalse(ListaEnlazada.contains("A"));
        ListaEnlazada.remove("B");
        assertFalse(ListaEnlazada.contains("B"));
        ListaEnlazada.remove("C");
        assertFalse(ListaEnlazada.contains("C"));
        ListaEnlazada.remove("D");
        assertFalse(ListaEnlazada.contains("D"));
        ListaEnlazada.remove("E");
        assertFalse(ListaEnlazada.contains("E"));
    }
    @Test
    public void testSize () {
        ListaEnlazada.add("A");
        ListaEnlazada.add("B");
        ListaEnlazada.add("C");
        ListaEnlazada.add("D");
        ListaEnlazada.add("E");
        assertEquals(5, ListaEnlazada.size());
        assertNotEquals(4, ListaEnlazada.size());
    }

}