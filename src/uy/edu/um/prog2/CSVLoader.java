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

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CSVLoader {
    public static void loadCSVData(HashTable<String,Artista> artistas, HashTable<String, Cancion> canciones) throws IOException {
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
            // Agrego el resto de atributos de la cancion
            int daily_rank  = Integer.parseInt(fila.get(3));
            cancion.setDailyRank(daily_rank);

            int daily_movement = Integer.parseInt(fila.get(4));
            cancion.setDailyMovement(daily_movement);

            int weekly_movement = Integer.parseInt(fila.get(5));
            cancion.setWeeklyMovement(weekly_movement);

            String country = fila.get(6);
            if (country.equals("")) {
                country = "Global";
            }
            cancion.setCountry(country);

            LocalDate snapshot_date = LocalDate.parse(fila.get(7));
            cancion.setSnapshotDate(snapshot_date);

            int popularity = Integer.parseInt(fila.get(8));
            cancion.setPopularity(popularity);

            boolean is_explicit = Boolean.parseBoolean(fila.get(9));
            cancion.setExplicit(is_explicit);

            int duration = Integer.parseInt(fila.get(10));
            cancion.setDuration(duration);

            String albumName = fila.get(11);
            cancion.setAlbumName(albumName);

            LocalDate albumReleaseDate = LocalDate.parse(fila.get(12));
            cancion.setAlbumReleaseDate(albumReleaseDate);

            float danceability = Float.parseFloat(fila.get(13));
            cancion.setDanceability(danceability);

            float energy = Float.parseFloat(fila.get(14));
            cancion.setEnergy(energy);

            int key = Integer.parseInt(fila.get(15));
            cancion.setKey(key);

            float loudness = Float.parseFloat(fila.get(16));
            cancion.setLoudness(loudness);

            int mode = Integer.parseInt(fila.get(17));
            cancion.setMode(mode);

            float speechiness = Float.parseFloat(fila.get(18));
            cancion.setSpeechiness(speechiness);

            float acousticness = Float.parseFloat(fila.get(19));
            cancion.setAcousticness(acousticness);

            float instrumentalness = Float.parseFloat(fila.get(20));
            cancion.setInstrumentalness(instrumentalness);

            float liveness = Float.parseFloat(fila.get(21));
            cancion.setLiveness(liveness);

            float valence = Float.parseFloat(fila.get(22));
            cancion.setValence(valence);

            float tempo = Float.parseFloat(fila.get(23));
            cancion.setTempo(tempo);

            int timeSignature = Integer.parseInt(fila.get(24));
            cancion.setTimeSignature(timeSignature);

            // Agregar cancion a la lista de canciones
            canciones.put(idCancion, cancion);

        }
    }


}