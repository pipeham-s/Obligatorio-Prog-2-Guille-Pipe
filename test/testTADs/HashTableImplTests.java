package testTADs;

import org.junit.jupiter.api.Test;
import uy.edu.um.prog2.adt.hash.HashTable;
import uy.edu.um.prog2.adt.hash.HashTableImpl;

import static org.junit.jupiter.api.Assertions.*;

public class HashTableImplTests {

    @Test
    public void testPutAndContains() {
        HashTable<Integer, String> hashTable = new HashTableImpl<>(10);
        hashTable.put(4, "uno");
        hashTable.put(1, "uno");
        hashTable.put(2, "dos");
        hashTable.put(3, "tres");
        hashTable.put(4, "cuatro");
        hashTable.put(5, "cinco");
        hashTable.put(6, "seis");
        hashTable.put(7, "siete");
        hashTable.put(8, "ocho");

        assertTrue(hashTable.contains(6));
        assertFalse(hashTable.contains(9));
        assertEquals(20, ((HashTableImpl<Integer, String>) hashTable).getSize()); //caso en el cual haya que expandir la lista
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
        assertTrue(hashTable.contains(1));
        hashTable.remove(1);
        assertFalse(hashTable.contains(1));
        assertTrue(hashTable.contains(8));
        hashTable.remove(8);
        assertFalse(hashTable.contains(8));
    }



}
