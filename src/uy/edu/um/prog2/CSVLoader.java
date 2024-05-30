package uy.edu.um.prog2;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
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
    public static void loadCSVData(MyLinkedListImpl<Artista> artistas, HashTable<String, Cancion> canciones) {
        Reader reader = new FileReader("C:\\Users\\Usuario\\OneDrive - Universidad de Montevideo\\PROG 2\\scv_reducido.xlsx");
        Iterable<CSVRecord> csvParser = CSVFormat.EXCEL.parse(reader);

        for (CSVRecord fila : csvParser) {
            String idCancion = fila.get(0);
            String nombreCancion = fila.get(1);

            Cancion cancion = new Cancion(idCancion, nombreCancion);

            String artistasStr = fila.get(2);
            String[] artistasArray = artistasStr.split(",");
            for (String artista : artistasArray) {
                artista = artista.trim();
                Artista artistaTemp = new Artista(artista);
                if (!artistas.contains(artistaTemp)) {
                    artistas.add(artistaTemp);
                    artistaTemp.getCanciones().add(cancion);
                }

            }






            String duracion = fila.get(2);
            String genero = fila.get(3);
            String album = fila.get(4);
            String anio = fila.get(5);

            Cancion cancion = new Cancion(nombreCancion, duracion, genero, album, anio);
            artista.getCanciones().add(cancion);
            canciones.put(nombreCancion, cancion);

            //por cada artista de la cancion (artistasArray), lo busco y le agrego la cancion que cree

            //a la cancion que cree, busco y le agrego el/los artistas que de artistasArray

        }
    }


}