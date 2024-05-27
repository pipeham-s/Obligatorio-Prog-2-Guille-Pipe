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
}
