import Tads.arboles.arbolBinario.MyBinarySearchTree;
import Tads.arboles.arbolBinario.MyBinarySearchTreeImpl;
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
        MiArbol.delete("E");
        assertEquals(null, MiArbol.find("E"));
        assertNotEquals("E", MiArbol.find("E"));
    } // CON ESTE TEST PASO TANTO EL INSERT COMO EL DELETE.

}
