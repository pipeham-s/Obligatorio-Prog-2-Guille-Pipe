package uy.edu.um.prog2.estadisticas;

import uy.edu.um.prog2.adt.linkedlist.MyLinkedListImpl;
import uy.edu.um.prog2.artistas.Artista;
import uy.edu.um.prog2.canciones.Cancion;

import java.time.LocalDate;

public interface Estadistica {
    public MyLinkedListImpl<Cancion> getTop10PorPaisEnDiaDado(String pais, LocalDate dia);
    public MyLinkedListImpl<Cancion> getTop5CancionesQueMasAparecen(LocalDate diaDado);

    public MyLinkedListImpl <Artista>  get7ArtistasQueMasAparecenEnTop50 (LocalDate fechaInicio, LocalDate fechaFin);

    public int cantidadDeVecesQueApareceUnArtistaEnUnTop50 (Artista artista, LocalDate fecha);

    public int cantidadDeCancionesConUnTempo (float tempo, LocalDate fecha);
}
