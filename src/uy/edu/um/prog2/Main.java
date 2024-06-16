package uy.edu.um.prog2;

import uy.edu.um.prog2.adt.hash.HashTable;
import uy.edu.um.prog2.adt.hash.HashTableImpl;
import uy.edu.um.prog2.artistas.Artista;
import uy.edu.um.prog2.canciones.Cancion;


public class Main {
    private final HashTable<String, Cancion> canciones;
    private final HashTable<String, Artista> artistas;

    public Main(HashTable<String, Cancion> canciones, HashTable<String, Artista> artistas) {

        this.canciones = canciones;
        this.artistas = artistas;
    }

    public static void main(String[] args) {
        HashTable<String, Cancion> canciones = new HashTableImpl<>(1000000);
        HashTable<String, Artista> artistas = new HashTableImpl<>(1000000);


    }
}
