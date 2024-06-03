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
    private float popularity;
    private boolean isExplicit;
    //la duracion de la cancion en milisegundos
    private float duration;
    private String albumName;   //NOMBRE ALBUM
    private LocalDate albumReleaseDate;//FECHA RELEASE ALBUM    clase album???
    private float danceability;
    private float energy;
    private float key;
    private float loudness;
    private float mode;
    private float speechiness;
    private float acousticness;
    private float instrumentalness;
    private float liveness;
    private float valence;
    private float tempo;
    private float timeSignature;


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

    public Cancion(String id, String name, MyList<Artista> artists, float dailyRank, float dailyMovement, float weeklyMovement, String country, LocalDate snapshotDate, float popularity, boolean isExplicit, float duration, String albumName, LocalDate albumReleaseDate, float danceability, float energy, float key, float loudness, float mode, float speechiness, float acousticness, float instrumentalness, float liveness, float valence, float tempo, float timeSignature) {
        this.id = id;
        this.name = name;
        this.artists = artists;
        this.dailyRank = dailyRank;
        this.dailyMovement = dailyMovement;
        this.weeklyMovement = weeklyMovement;
        this.country = country;
        this.snapshotDate = snapshotDate;
        this.popularity = popularity;
        this.isExplicit = isExplicit;
        this.duration = duration;
        this.albumName = albumName;
        this.albumReleaseDate = albumReleaseDate;
        this.danceability = danceability;
        this.energy = energy;
        this.key = key;
        this.loudness = loudness;
        this.mode = mode;
        this.speechiness = speechiness;
        this.acousticness = acousticness;
        this.instrumentalness = instrumentalness;
        this.liveness = liveness;
        this.valence = valence;
        this.tempo = tempo;
        this.timeSignature = timeSignature;
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

    public float getPopularity() {
        return popularity;
    }

    public void setPopularity(float popularity) {
        this.popularity = popularity;
    }

    public boolean isExplicit() {
        return isExplicit;
    }

    public void setExplicit(boolean explicit) {
        isExplicit = explicit;
    }

    public float getDuration() {
        return duration;
    }

    public void setDuration(float duration) {
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

    public float getKey() {
        return key;
    }

    public void setKey(float key) {
        this.key = key;
    }

    public float getLoudness() {
        return loudness;
    }

    public void setLoudness(float loudness) {
        this.loudness = loudness;
    }

    public float getMode() {
        return mode;
    }

    public void setMode(float mode) {
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

    public float getTimeSignature() {
        return timeSignature;
    }

    public void setTimeSignature(float timeSignature) {
        this.timeSignature = timeSignature;
    }
}
