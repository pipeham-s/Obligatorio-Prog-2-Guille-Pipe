package uy.edu.um.prog2.estadisticas;

import uy.edu.um.prog2.adt.linkedlist.MyLinkedListImpl;
import uy.edu.um.prog2.artistas.Artista;
import uy.edu.um.prog2.canciones.Cancion;

import java.time.LocalDate;

public class EstadisticaImpl implements Estadistica{

    @Override
    public MyLinkedListImpl<Cancion> getTop10PorPaisEnDiaDado(String pais, LocalDate dia) {
        return null;
        //Libertad total del implementacion, simplemente que corra en un tiempo razonable y justificar su implementacion
        //es decir, que si las otras funciones demoran 2 seg que esta no demore 10 min.
    }
    @Override
    public MyLinkedListImpl<Cancion> getTop5CancionesQueMasAparecen(LocalDate diaDado) {
        return null;
        //Hay que recorrer todos los top50 y ver las 5 canciones que mas aparezcan, esto tiene que darse en orden n.
        //Que devuelva orden n en promedio implica que la estructura a usar es una lista enlazada o alguna variante de esta como stack o queue?
        //ver si al decir que las canciones esten ordenadas en orden descendente implica que se use un stack o queue.
        //respuesta del profe, pide que en el peor caso no sea mas que O (n)
        // dice que busca algo lineal, si poner 10 elementos demora 1, que poner 20 elementos demore 2.
        //No poner doble for's
    }

    @Override
    public MyLinkedListImpl<Artista> get7ArtistasQueMasAparecenEnTop50(LocalDate fechaInicio, LocalDate fechaFin) {
        return null;
        //Libertad total del implementacion, simplemente que corra en un tiempo razonable y justificar su implementacion
        //es decir, que si las otras funciones demoran 2 seg que esta no demore 10 min.
    }

    @Override
    public int cantidadDeVecesQueApareceUnArtistaEnUnTop50(Artista artista, LocalDate fecha) {
        return 0;
        //Libertad total del implementacion, simplemente que corra en un tiempo razonable y justificar su implementacion
        //es decir, que si las otras funciones demoran 2 seg que esta no demore 10 min.
    }

    @Override
    public int cantidadDeCancionesConUnTempo(float tempo, LocalDate fecha) {
        return 0;
        //Libertad total del implementacion, simplemente que corra en un tiempo razonable y justificar su implementacion
        //es decir, que si las otras funciones demoran 2 seg que esta no demore 10 min.
    }
}
