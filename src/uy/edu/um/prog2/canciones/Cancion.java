package uy.edu.um.prog2.canciones;

import uy.edu.um.prog2.adt.hash.HashTable;
import uy.edu.um.prog2.adt.hash.HashTableImpl;
import uy.edu.um.prog2.adt.linkedlist.MyLinkedListImpl;
import uy.edu.um.prog2.adt.linkedlist.MyList;
import uy.edu.um.prog2.artistas.Artista;

import java.time.LocalDate;

public class Cancion {
    private String id;
    private String name;
    private MyList<Artista> artists; // no creo que sea una lista pero vemo
    private int dailyRank;
    private LocalDate snapshotDate;
    private String albumName;   //NOMBRE ALBUM
    private LocalDate albumReleaseDate;//FECHA RELEASE ALBUM    clase album???
    private float tempo;
    private HashTable<LocalDate,Integer> aparicionesPorDia;

    public Cancion(String id, String name) {
        this.id = id;
        this.name = name;
        this.artists = new MyLinkedListImpl<Artista>();
        this.aparicionesPorDia = new HashTableImpl<>(400);
    }

    public HashTable<LocalDate, Integer> getAparicionesPorDia() {
        return aparicionesPorDia;
    }

    public void setAparicionesPorDia(HashTable<LocalDate,Integer> aparicionesPorDia) {
        this.aparicionesPorDia = aparicionesPorDia;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MyList<Artista> getArtists() {
        return artists;
    }

    public void setArtists(MyList<Artista> artists) {
        this.artists = artists;
    }

    public int getDailyRank() {
        return dailyRank;
    }

    public void setDailyRank(int dailyRank) {
        this.dailyRank = dailyRank;
    }

    public LocalDate getSnapshotDate() {
        return snapshotDate;
    }

    public void setSnapshotDate(LocalDate snapshotDate) {
        this.snapshotDate = snapshotDate;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public LocalDate getAlbumReleaseDate() {
        return albumReleaseDate;
    }

    public void setAlbumReleaseDate(LocalDate albumReleaseDate) {
        this.albumReleaseDate = albumReleaseDate;
    }

    public float getTempo() {
        return tempo;
    }

    public void setTempo(float tempo) {
        this.tempo = tempo;
    }
}
