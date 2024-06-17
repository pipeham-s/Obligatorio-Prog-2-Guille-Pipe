package uy.edu.um.prog2;

import uy.edu.um.prog2.adt.hash.HashTable;
import uy.edu.um.prog2.adt.hash.HashTableImpl;
import uy.edu.um.prog2.adt.linkedlist.MyList;
import uy.edu.um.prog2.artistas.Artista;
import uy.edu.um.prog2.canciones.Cancion;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;

public class PruebaCSV2 {
    private HashTable<LocalDate, HashTable<String, MyList<Cancion>>> topDiaPais;
    private HashTable<String, Artista> artistas;
    private HashTable<String, Cancion> canciones;

    public PruebaCSV2(HashTable<LocalDate, HashTable<String, MyList<Cancion>>> topDiaPais) throws Exception {
        this.artistas = new HashTableImpl<>(1000000);
        this.canciones = new HashTableImpl<>(1000000);
        this.topDiaPais = new HashTableImpl<>(400); //son 209 dias, lo hago un poco mas grande
    }

    public HashTable<String, Artista> getArtistas() {
        return artistas;
    }

    public HashTable<String, Cancion> getCanciones() {
        return canciones;
    }

    public HashTable<LocalDate, HashTable<String, MyList<Cancion>>> getTopDiaPais() {
        return topDiaPais;
    }

    public void setTopDiaPais(HashTable<LocalDate, HashTable<String, MyList<Cancion>>> topDiaPais) {
        this.topDiaPais = topDiaPais;
    }

    public void setArtistas(HashTable<String, Artista> artistas) {
        this.artistas = artistas;
    }

    public void setCanciones(HashTable<String, Cancion> canciones) {
        this.canciones = canciones;
    }

    public void CSVReader() throws Exception {

        int artistCounter = 0;
        int songCounter = 0;
        String filePath = "";
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(filePath));
            String line = reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] row = line.split("\",\"");
                String idCancion = row[0].replace("\"", "");
                String nombreCancion = row[1];
                String artistasStr = row[2];

                Cancion cancion = new Cancion(idCancion, nombreCancion);

                String[] artistasArray = artistasStr.split(",");
                //crear o agregar artistas
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

                Integer dailyRank = Integer.parseInt(row[3].replace("\"", ""));
                cancion.setDailyRank(dailyRank);
                String country = row[6];
                if (country.isEmpty()) {
                    country = "Global";
                }

                LocalDate fecha = LocalDate.parse(row[7].replace("\"", ""));

                float tempo = Float.parseFloat(row[23].replace("\"", ""));
                cancion.setTempo(tempo);

                // check if the song is in the songs hash

            }
        } catch (Exception _) {
            throw new Exception();


    }
}