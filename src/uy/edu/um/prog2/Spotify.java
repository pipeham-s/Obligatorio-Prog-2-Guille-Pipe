package uy.edu.um.prog2;

import uy.edu.um.prog2.adt.hash.HashTable;
import uy.edu.um.prog2.adt.hash.HashTableImpl;
import uy.edu.um.prog2.artistas.Artista;
import uy.edu.um.prog2.canciones.Cancion;

import java.time.LocalDate;

public class Spotify {
    private HashTable<LocalDate,HashTable<String,HashTable<Integer, Cancion>>> dailyRanking;
    private HashTable<String,Cancion> canciones;
    private HashTable<String,HashTable<LocalDate,Integer>> artistas; //para la 3ra consulta, por cada artista y fecha tengo la cantidad de canciones en el top 50
    private String[] keyCanciones; // para la 2da consulta, recorro y sumo apariciones a cada cancion
    private String[] keyArtistas;

    public Spotify() {
        this.dailyRanking = new HashTableImpl<>(400); //son 209 dias, lo hago un poco mas grande
        this.canciones = new HashTableImpl<>(20000);
        this.artistas = new HashTableImpl<>(20000);
        this.keyCanciones = new String[20000];
        this.keyArtistas = new String[20000];
    }

    public HashTable<LocalDate, HashTable<String, HashTable<Integer, Cancion>>> getDailyRanking() {
        return dailyRanking;
    }

    public HashTable<String, Cancion> getCanciones() {
        return canciones;
    }

    public HashTable<String, HashTable<LocalDate, Integer>> getArtistas() {
        return artistas;
    }

    public String[] getKeyCanciones() {
        return keyCanciones;
    }

    public String[] getKeyArtistas() {
        return keyArtistas;
    }

    public void loadCSVData() {
        //TODO
    }
}
