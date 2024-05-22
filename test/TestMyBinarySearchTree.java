import uy.edu.um.prog2.adt.arboles.arbolBusquedaBinaria.MyBinarySearchTree;
import uy.edu.um.prog2.adt.arboles.arbolBusquedaBinaria.MyBinarySearchTreeImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class TestMyBinarySearchTree {
    @Test // siempre importr el 5
    public void testFind (){
        MyBinarySearchTree <String, String> MiArbol = new MyBinarySearchTreeImpl<>("A", "A");
        MiArbol.insert("B", "B");
        MiArbol.insert("C", "C");
        MiArbol.insert("D", "D");
        MiArbol.insert("E", "E");
        assertEquals("E", MiArbol.find("E"));
        assertNotEquals("B", MiArbol.find("E"));
    } // CON ESTE TEST PASO TANTO EL INSERT COMO EL FIND.
    @Test
    public void testDelete (){
        MyBinarySearchTree <String, String> MiArbol = new MyBinarySearchTreeImpl<>("A", "A");
        MiArbol.insert("B", "B");
        MiArbol.insert("C", "C");
        MiArbol.insert("D", "D");
        MiArbol.insert("E", "E");
        MiArbol.delete("C");
        assertEquals(null, MiArbol.find("C"));
        assertNotEquals("C", MiArbol.find("C"));
        assertEquals("[A, B, D, E]", MiArbol.toString());
    } // CON ESTE TEST PASO TANTO EL INSERT COMO EL DELETE.

    @Test
    public void testOrder(){
        MyBinarySearchTree <Integer, String> MiArbol = new MyBinarySearchTreeImpl<>(5, "A");
        MiArbol.insert(1, "B");
        MiArbol.insert(4, "C");
        MiArbol.insert(6, "D");
        MiArbol.insert(3, "E");
        assertEquals("[1, 3, 4, 5, 6]", MiArbol.toString());
    }

}
