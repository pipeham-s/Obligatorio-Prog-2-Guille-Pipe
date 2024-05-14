import Tads.linkedlist.MyLinkedListImpl;
import Tads.queue.EmptyQueueException;
import Tads.stack.EmptyStackException;
import Tads.queue.MyQueue;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
public class TestQueue {

    MyQueue<String> ListaEnlazada = new MyLinkedListImpl<>();

    @Test
    public void testEnqueue () {
        ListaEnlazada.enqueue("A");
        ListaEnlazada.enqueue("B");
        ListaEnlazada.enqueue("C");
        ListaEnlazada.enqueue("D");
        ListaEnlazada.enqueue("E");
    }
    //asumo correctitud gracias a las siguientes funciones verificaremos si se cumple de manera correcta

    @Test
    public void testDequeue () throws EmptyStackException, EmptyQueueException {
        ListaEnlazada.enqueue("A");
        ListaEnlazada.enqueue("B");
        ListaEnlazada.enqueue("C");
        ListaEnlazada.enqueue("D");
        ListaEnlazada.enqueue("E");
        assertEquals("A", ListaEnlazada.dequeue());
        assertEquals("B", ListaEnlazada.dequeue());
        assertEquals("C", ListaEnlazada.dequeue());
        assertEquals("D", ListaEnlazada.dequeue());
        assertNotEquals("B", ListaEnlazada.dequeue());
    }
    // tanto size como contains asumo correcitud ya que fueron probados en el test de MyLinkedList
}
