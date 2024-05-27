package uy.edu.um.prog2.canciones;

import uy.edu.um.prog2.artistas.Artista;

import java.time.LocalDate;
import java.util.List;

public class Cancion {
    private String id;
    private String name;
    private List<Artista> artists; // no creo que sea una lista pero vemo
    private int dialyRank;
    private int dialyMovement;
    private int weeklyMovement;
    private String country;
    private LocalDate snapshotDate;
    private int popularity;
    private boolean isExplicit;
    //la duracion de la cancion en milisegundos
    private int duration;
    private String albumName;   //NOMBRE ALBUM
    private LocalDate albumReleaseDate;//FECHA RELEASE ALBUM
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


    public Cancion(String id, String name, List<Artista> artists, int dialyRank, int dialyMovement, int weeklyMovement, String country, LocalDate snapshotDate, int popularity, boolean isExplicit, int duration, String albumName, LocalDate albumReleaseDate, float danceability, float energy, int key, float loudness, int mode, float speechiness, float acousticness, float instrumentalness, float liveness, float valence, float tempo, int timeSignature) {
        this.id = id;
        this.name = name;
        this.artists = artists;
        this.dialyRank = dialyRank;
        this.dialyMovement = dialyMovement;
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
}
