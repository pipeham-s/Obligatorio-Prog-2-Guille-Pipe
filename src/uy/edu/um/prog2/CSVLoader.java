package uy.edu.um.prog2;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.csv.CSVParser;

import uy.edu.um.prog2.adt.arbolitos.binarytree.BinaryTree;
import uy.edu.um.prog2.adt.hash.HashTable;
import uy.edu.um.prog2.adt.linkedlist.MyLinkedListImpl;
import uy.edu.um.prog2.adt.linkedlist.MyList;
import uy.edu.um.prog2.artistas.Artista;
import uy.edu.um.prog2.canciones.Cancion;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class CSVLoader {
    public static void loadCSVData(HashTable<String,Artista> artistas, HashTable<String, Cancion> canciones) {
        Reader reader = new FileReader("C:\\Users\\Usuario\\OneDrive - Universidad de Montevideo\\PROG 2\\scv_reducido.xlsx");
        Iterable<CSVRecord> csvParser = CSVFormat.EXCEL.parse(reader);

        for (CSVRecord fila : csvParser) {
            if (fila.getRecordNumber() == 1) {
                continue;
            }

            String idCancion = fila.get(0);
            String nombreCancion = fila.get(1);

            Cancion cancion = new Cancion(idCancion,nombreCancion);

            // Logica para agregar artistas
            String artistasStr = fila.get(2);
            String[] artistasArray = artistasStr.split(",");
            for (String artista : artistasArray) {
                artista = artista.trim();
                if (artistas.get(artista) != null) {
                    artistas.get(artista).getCanciones().add(cancion);
                    cancion.getArtists().add(artistas.get(artista));
                } else {
                    Artista nuevoArtista = new Artista(artista);
                    artistas.put(artista, nuevoArtista);
                    nuevoArtista.getCanciones().add(cancion);
                    cancion.getArtists().add(nuevoArtista);
                }

            }


            String duracion = fila.get(2);
            String genero = fila.get(3);
            String album = fila.get(4);
            String anio = fila.get(5);


           // artista.getCanciones().add(cancion);
            canciones.put(nombreCancion, cancion);

            //por cada artista de la cancion (artistasArray), lo busco y le agrego la cancion que cree

            //a la cancion que cree, busco y le agrego el/los artistas que de artistasArray

        }
    }


}