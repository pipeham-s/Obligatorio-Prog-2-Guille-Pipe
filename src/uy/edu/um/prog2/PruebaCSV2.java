package uy.edu.um.prog2;

import uy.edu.um.prog2.adt.hash.HashTable;
import uy.edu.um.prog2.adt.hash.HashTableImpl;
import uy.edu.um.prog2.artistas.Artista;
import uy.edu.um.prog2.canciones.Cancion;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;

public class PruebaCSV2 {
    public static void CSVReader() {
        String record;
        HashTable<String, Cancion> canciones = new HashTableImpl<>(1000000);
        HashTable<String, Artista> artistas = new HashTableImpl<>(1000000);

        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Usuario\\OneDrive - Universidad de Montevideo\\PROG 2\\scv_reducido.csv.xlsx"))) {
            //Encabezado
            br.readLine();

            while ((record = br.readLine()) != null) {
                record = record.substring(1, record.length() - 2);


                String[] values = record.split("\",\"");

                Cancion cancion = new Cancion(values[0], values[1]);

                String[] artistasArray = values[2].split(",");
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
                String country = values[6];
                if (country.equals("")) {
                    country = "Global";
                }
                cancion.setCountry(country);

                cancion.setDailyRank(Integer.parseInt(values[3]));
                cancion.setDailyMovement(Integer.parseInt(values[4]));
                cancion.setWeeklyMovement(Integer.parseInt(values[5]));
                cancion.setSnapshotDate(LocalDate.parse(values[7]));
                cancion.setAlbumName(values[11]);
                cancion.setAlbumReleaseDate(LocalDate.parse(values[12]));
                cancion.setTempo(Float.parseFloat(values[23]));

                canciones.put(values[0], cancion);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}