package uy.edu.um.prog2;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import uy.edu.um.prog2.adt.hash.HashTable;
import uy.edu.um.prog2.artistas.Artista;
import uy.edu.um.prog2.canciones.Cancion;

import java.io.FileReader;
import java.io.Reader;

public class CSVLoader {
    public static void loadCSVData(HashTable<String, Cancion> canciones, HashTable<String, Artista> artistas) {
        //     long startTime = System.currentTimeMillis();

        try {
            Reader in = new FileReader("path al archivo csv");

            Iterable<CSVRecord> records = CSVFormat.DEFAULT


        } catch