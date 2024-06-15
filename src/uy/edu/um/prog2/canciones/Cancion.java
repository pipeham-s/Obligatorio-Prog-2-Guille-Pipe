package uy.edu.um.prog2.canciones;

import uy.edu.um.prog2.adt.linkedlist.MyLinkedListImpl;
import uy.edu.um.prog2.adt.linkedlist.MyList;
import uy.edu.um.prog2.artistas.Artista;

import java.time.LocalDate;

public class Cancion {
    private String id;
    private String name;
    private MyList<Artista> artists; // no creo que sea una lista pero vemo
    private float dailyRank;
    private float dailyMovement;
    private float weeklyMovement;
    private String country;
    private LocalDate snapshotDate;
    private String albumName;   //NOMBRE ALBUM
    private LocalDate albumReleaseDate;//FECHA RELEASE ALBUM    clase album???
    private float tempo;



    public Cancion(String id, String name) {
        this.id = id;
        this.name = name;
        this.artists = new MyLinkedListImpl<Artista>();
        this.dailyRank = Integer.parseInt(null);
        this.dailyMovement = Integer.parseInt(null);
        this.weeklyMovement = Integer.parseInt(null);
        this.country = null;
        this.snapshotDate = null;
        this.albumName = null;
        this.albumReleaseDate = null;
        this.tempo = Float.parseFloat(null);
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

    public float getDailyRank() {
        return dailyRank;
    }

    public void setDailyRank(float dailyRank) {
        this.dailyRank = dailyRank;
    }

    public float getDailyMovement() {
        return dailyMovement;
    }

    public void setDailyMovement(float dailyMovement) {
        this.dailyMovement = dailyMovement;
    }

    public float getWeeklyMovement() {
        return weeklyMovement;
    }

    public void setWeeklyMovement(float weeklyMovement) {
        this.weeklyMovement = weeklyMovement;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
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
