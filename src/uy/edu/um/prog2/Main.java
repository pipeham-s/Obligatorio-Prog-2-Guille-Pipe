package uy.edu.um.prog2;

import uy.edu.um.prog2.adt.hash.HashTable;
import uy.edu.um.prog2.adt.hash.HashTableImpl;
import uy.edu.um.prog2.artistas.Artista;
import uy.edu.um.prog2.canciones.Cancion;

import static uy.edu.um.prog2.CSVLoader.loadCSVData;

public class Main {

    public static void main(String[] args) {
        HashTable<String, Artista> artistas = new HashTableImpl<>(100);
        HashTable<String, Cancion> canciones = new HashTableImpl<>(100);

        try {
            loadCSVData(artistas, canciones);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
