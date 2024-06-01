package uy.edu.um.prog2.canciones;

import uy.edu.um.prog2.adt.linkedlist.MyLinkedListImpl;
import uy.edu.um.prog2.adt.linkedlist.MyList;
import uy.edu.um.prog2.artistas.Artista;

import java.time.LocalDate;

public class Cancion {
    private String id;
    private String name;
    private MyList<Artista> artists; // no creo que sea una lista pero vemo
    private int dailyRank;
    private int dailyMovement;
    private int weeklyMovement;
    private String country;
    private LocalDate snapshotDate;
    private int popularity;
    private boolean isExplicit;
    //la duracion de la cancion en milisegundos
    private int duration;
    private String albumName;   //NOMBRE ALBUM
    private LocalDate albumReleaseDate;//FECHA RELEASE ALBUM    clase album???
    private float danceability;
    private float energy;
    private int key;
    private float loudness;
    private int mode;
    private float speechiness;
    private float acousticness;
    private float instrumentalness;
    private float liveness;
    private float valence;
    private float tempo;
    private int timeSignature;


    public Cancion(String id, String name) {
        this.id = id;
        this.name = name;
        this.artists = new MyLinkedListImpl<Artista>();
        this.dailyRank = Integer.parseInt(null);
        this.dailyMovement = Integer.parseInt(null);
        this.weeklyMovement = Integer.parseInt(null);
        this.country = null;
        this.snapshotDate = null;
        this.popularity = Integer.parseInt(null);
        this.isExplicit = Boolean.parseBoolean(null);
        this.duration = Integer.parseInt(null);
        this.albumName = null;
        this.albumReleaseDate = null;
        this.danceability = Float.parseFloat(null);
        this.energy = Float.parseFloat(null);
        this.key = Integer.parseInt(null);
        this.loudness = Float.parseFloat(null);
        this.mode = Integer.parseInt(null);
        this.speechiness = Float.parseFloat(null);
        this.acousticness = Float.parseFloat(null);
        this.instrumentalness = Float.parseFloat(null);
        this.liveness = Float.parseFloat(null);
        this.valence = Float.parseFloat(null);
        this.tempo = Float.parseFloat(null);
        this.timeSignature = Integer.parseInt(null);
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

    public void setDailyRank(int dialyRank) {
        this.dailyRank = dialyRank;
    }

    public int getDailyMovement() {
        return dailyMovement;
    }

    public void setDailyMovement(int dailyMovement) {
        this.dailyMovement = dailyMovement;
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

    public LocalDate getSnapshotDate() {
        return snapshotDate;
    }

    public void setSnapshotDate(LocalDate snapshotDate) {
        this.snapshotDate = snapshotDate;
    }

    public int getPopularity() {
        return popularity;
    }

    public void setPopularity(int popularity) {
        this.popularity = popularity;
    }

    public boolean isExplicit() {
        return isExplicit;
    }

    public void setExplicit(boolean explicit) {
        isExplicit = explicit;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
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

    public float getDanceability() {
        return danceability;
    }

    public void setDanceability(float danceability) {
        this.danceability = danceability;
    }

    public float getEnergy() {
        return energy;
    }

    public void setEnergy(float energy) {
        this.energy = energy;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public float getLoudness() {
        return loudness;
    }

    public void setLoudness(float loudness) {
        this.loudness = loudness;
    }

    public int getMode() {
        return mode;
    }

    public void setMode(int mode) {
        this.mode = mode;
    }

    public float getSpeechiness() {
        return speechiness;
    }

    public void setSpeechiness(float speechiness) {
        this.speechiness = speechiness;
    }

    public float getAcousticness() {
        return acousticness;
    }

    public void setAcousticness(float acousticness) {
        this.acousticness = acousticness;
    }

    public float getInstrumentalness() {
        return instrumentalness;
    }

    public void setInstrumentalness(float instrumentalness) {
        this.instrumentalness = instrumentalness;
    }

    public float getLiveness() {
        return liveness;
    }

    public void setLiveness(float liveness) {
        this.liveness = liveness;
    }

    public float getValence() {
        return valence;
    }

    public void setValence(float valence) {
        this.valence = valence;
    }

    public float getTempo() {
        return tempo;
    }

    public void setTempo(float tempo) {
        this.tempo = tempo;
    }

    public int getTimeSignature() {
        return timeSignature;
    }

    public void setTimeSignature(int timeSignature) {
        this.timeSignature = timeSignature;
    }

}
