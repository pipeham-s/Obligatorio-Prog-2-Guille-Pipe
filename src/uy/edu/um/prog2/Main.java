package uy.edu.um.prog2;

import uy.edu.um.prog2.adt.hash.HashTable;
import uy.edu.um.prog2.adt.hash.HashTableImpl;
import uy.edu.um.prog2.artistas.Artista;
import uy.edu.um.prog2.canciones.Cancion;

import java.io.FileNotFoundException;
import java.io.IOException;

import static uy.edu.um.prog2.CSVLoader.loadCSVData;
import static uy.edu.um.prog2.PruebaCSV2.CSVReader;


public class Main {

    public static void main(String[] args) throws IOException {
        HashTable<String, Cancion> canciones = new HashTableImpl<>(1000000);
        HashTable<String, Artista> artistas = new HashTableImpl<>(1000000);

        //CSVReader();
        //loadCSVData(artistas, canciones);

    }
}
