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
                .withIgnoreEmptyLines()
                .withTrim()
                .parse(in);
            int lineNumber = 0;
            for (CSVRecord record : records) {
                //Carga Canciones

                if (record.size() != 26) {
                    System.out.println("Línea " + lineNumber + " desordenada. Se omitirá.");
                    continue;
                }
                Sting id = record.get(1);
                String name = record.get(2);
                String dailyRank = record.get(4);

                if ()


            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}