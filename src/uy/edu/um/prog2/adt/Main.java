package uy.edu.um.prog2.adt;

import uy.edu.um.prog2.adt.hash.HashTable;
import uy.edu.um.prog2.adt.hash.HashTableImpl;

public class Main {
    public static void main(String[] args) {
        HashTable<Integer, String> hashTable = new HashTableImpl<>(10);
        hashTable.put(4, "uno");
        hashTable.put(13, "a");
        hashTable.put(2, "dos");
        hashTable.put(3, "tres");
        hashTable.put(5, "cinco");
        hashTable.put(6, "seis");
        hashTable.put(6, "siete");
        hashTable.put(12, "ocho");
        hashTable.put(4, "cuatro");
        hashTable.remove(4);
        hashTable.toString();
    }
}
