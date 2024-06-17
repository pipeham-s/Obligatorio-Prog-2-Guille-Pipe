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

    public PruebaCSV2(HashTable<LocalDate, HashTable<String, MyList<Cancion>>> topDiaPais) {
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
                cancion.setCountry(country);

                LocalDate date = LocalDate.parse(row[7].replace("\"", ""));

                float tempo = Float.parseFloat(row[23].replace("\"", ""));

                // check if the song is in the songs hash
                Cancion cancion = canciones.get(idCancion);
                if (cancion == null) {
                    cancion = new Cancion(idCancion, nombreCancion);
                    canciones.put(idCancion, cancion);
                    songKeys[songCounter] = spotifyId;
                    songCounter += 1;
                } else {
                    Integer appearances = cancion.getAppearances().get(date);
                    if (appearances == null) {
                        cancion.getAppearances().put(date, 1);
                    } else {
                        cancion.getAppearances().setValueForKey(date, appearances + 1);
                    }
                }

                // check artists in the singer hash
                for (String name : artistNames) {
                    name = name.trim();
                    HashTable<LocalDate, Integer> songRanking = artists.get(name);
                    if (songRanking == null) { // the artist hasn't been initialized yet
                        HashTable<LocalDate, Integer> artistRanking = new HashTableImpl<LocalDate, Integer>(300);
                        artistRanking.put(date, 1); // when we encounter an artist for the first time we add his
                        // participation in the ranking
                        artists.put(name, artistRanking); // we must check the size later
                        artistKeys[artistCounter] = name;
                        artistCounter += 1;
                    } else { // the singer already existed
                        Integer appearances = songRanking.get(date); // get the amount of times the artist poped up,on a certain date
                        if (appearances == null) {
                            songRanking.put(date, 1);
                        } else {
                            songRanking.setValueForKey(date, appearances + 1);
                        }
                    }
                }

                // now begins the triple Hash setup

                HashTable<String, HashTable<Integer, Song>> HashForDate = dailyRanks.get(date);
                if (HashForDate == null) {
                    HashForDate = new HashTableImpl<String, HashTable<Integer, Song>>(103); //
                    dailyRanks.put(date, HashForDate);
                }
                HashTable<Integer, Song> RankingDateCountry = HashForDate.get(countryName);
                if (RankingDateCountry == null) {
                    RankingDateCountry = new HashTableImpl<Integer, Song>(71);
                    // there are 50 elements but for efficiency we chose 75 to get a loading factor of 0.7 aprox
                    HashForDate.put(countryName, RankingDateCountry);
                }
                while (true) {
                    try {
                        RankingDateCountry.put(dailyRank, cancion);
                        break;
                    } catch (KeyAlreadyExistsException _) {
                        dailyRank += 1;
                        if (dailyRank == 51) break;
                    }
                }


            }
        } catch (Exception _) {
            throw new Exception();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}