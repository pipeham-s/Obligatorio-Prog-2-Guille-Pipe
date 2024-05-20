import org.junit.jupiter.api.Test;
import uy.edu.um.prog2.adt.hash.HashTable;
import uy.edu.um.prog2.adt.hash.HashTableImpl;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HashTableImplTests {

    @Test
    public void testPutAndContains() {
        HashTable<Integer, String> hashTable = new HashTableImpl<>(10);
        hashTable.put(1, "uno");
        hashTable.put(2, "dos");
        hashTable.put(3, "tres");
        hashTable.put(4, "cuatro");
        hashTable.put(5, "cinco");
        hashTable.put(6, "seis");
        hashTable.put(7, "siete");
        hashTable.put(8, "ocho");
        assertTrue(hashTable.contains(1));
        assertTrue(hashTable.contains(8));
        assertFalse(hashTable.contains(9));
    }

    @Test
    public void testRemove() {
        HashTable<Integer, String> hashTable = new HashTableImpl<>(10);
        hashTable.put(1, "uno");
        hashTable.put(2, "dos");
        hashTable.put(3, "tres");
        hashTable.put(4, "cuatro");
        hashTable.put(5, "cinco");
        hashTable.put(6, "seis");
        hashTable.put(7, "siete");
        hashTable.put(8, "ocho");
        hashTable.remove(1);
        assertFalse(hashTable.contains(1));
        hashTable.remove(8);
        assertFalse(hashTable.contains(8));
    }

}
