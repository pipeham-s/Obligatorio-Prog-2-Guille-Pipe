package uy.edu.um.prog2.adt;

import uy.edu.um.prog2.adt.hash.HashTable;
import uy.edu.um.prog2.adt.hash.HashTableImpl;

// no tiene ninguna aplicacion puntual, es para el probado de los algoritmos
public class MostrarHash {
    public static void main(String[] args) {
        HashTable<Integer, String> hashTable = new HashTableImpl<>(10);
        hashTable.put(4, "uno");
        hashTable.put(1, "a");
        hashTable.put(2, "dos");
        hashTable.put(14, "siete");
        hashTable.put(7, "ocho");
        hashTable.put(4, "cuatro");
        hashTable.put(8, "nueve");
        hashTable.put(3, "tres");
        hashTable.put(5, "cinco");
        hashTable.put(6, "seis");
        hashTable.put(16, "cinco");
        hashTable.toString();
    }
}
