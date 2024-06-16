package uy.edu.um.prog2.estadisticas;

import uy.edu.um.prog2.adt.hash.HashTable;
import uy.edu.um.prog2.adt.linkedlist.MyList;
import uy.edu.um.prog2.artistas.Artista;
import uy.edu.um.prog2.canciones.Cancion;

import java.time.LocalDate;

public interface Estadistica {
    public MyList<Cancion> getTop10PorPaisEnDiaDado(String pais, String dia, HashTable<String, HashTable<String, MyList<Cancion>>> cancionPorPaisyDia); //le voy a pasar un hash en el cual las canciones esten almacenadadas en funcion del pais de su top, y esto en funcion de la fecha.
    public MyList<Cancion> getTop5CancionesQueMasAparecen(String diaDado, HashTable<String, MyList<Cancion>> cancionesxFecha);

    public MyList <Artista>  get7ArtistasQueMasAparecenEnTop50 (LocalDate fechaInicio, LocalDate fechaFin);

    public int cantidadDeVecesQueApareceUnArtistaEnUnTop50 (Artista artista, LocalDate fecha);

    public int cantidadDeCancionesConUnTempo (float tempo, LocalDate fecha);
}
