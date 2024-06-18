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
    private String artists;
    private String[] artistsArray; // no creo que sea una lista pero vemo
    private int dailyRank;
    private int dayliMovement;
    private int weeklyMovement;
    private String country;
    private String snapshotDate;
    private float tempo;
    private HashTable<LocalDate, Integer> aparicionesPorDia;

    public Cancion(String id, String name, String artists, String[] artistsArray, int dailyRank, int dayliMovement, int weeklyMovement, String country, String snapshotDate, float tempo) {
        this.id = id;
        this.name = name;
        this.artists = artists;
        this.artistsArray = artistsArray;
        this.dailyRank = dailyRank;
        this.dayliMovement = dayliMovement;
        this.weeklyMovement = weeklyMovement;
        this.country = country;
        this.snapshotDate = snapshotDate;
        this.tempo = tempo;
        this.aparicionesPorDia = new HashTableImpl<>(400);
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

    public String getArtists() {
        return artists;
    }

    public void setArtists(String artists) {
        this.artists = artists;
    }

    public String[] getArtistsArray() {
        return artistsArray;
    }

    public void setArtistsArray(String[] artistsArray) {
        this.artistsArray = artistsArray;
    }

    public int getDailyRank() {
        return dailyRank;
    }

    public void setDailyRank(int dailyRank) {
        this.dailyRank = dailyRank;
    }

    public int getDayliMovement() {
        return dayliMovement;
    }

    public void setDayliMovement(int dayliMovement) {
        this.dayliMovement = dayliMovement;
    }

    public int getWeeklyMovement() {
        return weeklyMovement;
    }

    public void setWeeklyMovement(int weeklyMovement) {
        this.weeklyMovement = weeklyMovement;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getSnapshotDate() {
        return snapshotDate;
    }

    public void setSnapshotDate(String snapshotDate) {
        this.snapshotDate = snapshotDate;
    }

    public float getTempo() {
        return tempo;
    }

    public void setTempo(float tempo) {
        this.tempo = tempo;
    }

    public HashTable<LocalDate, Integer> getAparicionesPorDia() {
        return aparicionesPorDia;
    }

    public void setAparicionesPorDia(HashTable<LocalDate, Integer> aparicionesPorDia) {
        this.aparicionesPorDia = aparicionesPorDia;
    }
}

