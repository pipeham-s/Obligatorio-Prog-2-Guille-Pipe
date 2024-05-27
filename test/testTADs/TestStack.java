package testTADs;

import uy.edu.um.prog2.adt.linkedlist.MyLinkedListImpl;
import uy.edu.um.prog2.adt.stack.EmptyStackException;
import uy.edu.um.prog2.adt.stack.MyStack;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
public class TestStack {

    MyStack<String> ListaEnlazada = new MyLinkedListImpl<>();

    @Test
    public void testPush () {
        ListaEnlazada.push("A");
        ListaEnlazada.push("B");
        ListaEnlazada.push("C");
        ListaEnlazada.push("D");
        ListaEnlazada.push("E");
    }
    //asumo correctitud gracias a las siguientes funciones verificaremos si se cumple de manera correcta

    @Test
    public void testPop () throws EmptyStackException {
        ListaEnlazada.push("A");
        ListaEnlazada.push("B");
        ListaEnlazada.push("C");
        ListaEnlazada.push("D");
        ListaEnlazada.push("E");
        assertEquals("E", ListaEnlazada.pop());
        assertEquals("D", ListaEnlazada.pop());
        assertEquals("C", ListaEnlazada.pop());
        assertEquals("B", ListaEnlazada.pop());
        assertNotEquals("B", ListaEnlazada.pop());
    }

    @Test
    public void testPeek () {
        ListaEnlazada.push("A");
        ListaEnlazada.push("B");
        ListaEnlazada.push("C");
        ListaEnlazada.push("D");
        ListaEnlazada.push("E");
        assertEquals("E", ListaEnlazada.peek());
        assertNotEquals("D", ListaEnlazada.peek());
    }
    // en el size asumo correcitud ya que fueron probados en el test de MyLinkedList
}
