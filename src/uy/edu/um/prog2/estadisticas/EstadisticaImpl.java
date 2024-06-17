package uy.edu.um.prog2.estadisticas;

import uy.edu.um.prog2.adt.hash.HashTable;
import uy.edu.um.prog2.adt.linkedlist.MyLinkedListImpl;
import uy.edu.um.prog2.adt.linkedlist.MyList;
import uy.edu.um.prog2.artistas.Artista;
import uy.edu.um.prog2.canciones.Cancion;
import uy.edu.um.prog2.exceptions.InformacionInvalida;

import java.time.LocalDate;

public class EstadisticaImpl implements Estadistica{

    @Override
    public MyList<Cancion> getTop10PorPaisEnDiaDado(String pais, String dia, HashTable<String, HashTable<String, MyList<Cancion>>> cancionPorPaisyDia) throws InformacionInvalida {
        MyList<Cancion> cancionTop10xPais = new MyLinkedListImpl<>();
        if (cancionPorPaisyDia.get(pais) == null || cancionPorPaisyDia.get(pais).get(dia) == null || cancionPorPaisyDia.get(pais).get(dia).size() < 50) {
            throw new InformacionInvalida();
        }
        MyList <Cancion> temp = ordenarTop50(pais, dia, cancionPorPaisyDia);
        for (int i = 0; i < 10; i++) {
            cancionTop10xPais.add(temp.get(i));
        }
         return cancionTop10xPais;
        //Libertad total del implementacion, simplemente que corra en un tiempo razonable y justificar su implementacion
        //es decir, que si las otras funciones demoran 2 seg que esta no demore 10 min.
    }

    public MyList<Cancion> ordenarTop50 (String pais, String fecha, HashTable<String, HashTable<String, MyList<Cancion>>> cancionPorPaisyDia){
        MyList<uy.edu.um.prog2.canciones.Cancion> top5Orden = new MyLinkedListImpl<>();
        if (cancionPorPaisyDia.get(pais) == null || cancionPorPaisyDia.get(pais).get(fecha) == null || cancionPorPaisyDia.get(pais).get(fecha).size() < 50) {
            throw new InformacionInvalida();
        }
        for (int i = 0; i < 50; i++) {
            int lugarEnTop = cancionPorPaisyDia.get(pais).get(fecha).get(i).getDailyRank();
            top5Orden.insert(cancionPorPaisyDia.get(pais).get(fecha).get(i), lugarEnTop);
        }
        return top5Orden;

    }
    @Override
    public MyList<Cancion> getTop5CancionesQueMasAparecen(String diaDado, HashTable<String, MyList<Cancion>> cancionesxFecha) {
        if (cancionesxFecha.get(diaDado) == null) {
            throw new InformacionInvalida();
        }
        MyList<Cancion> top5Canciones = new MyLinkedListImpl<>();
        for (int i = 0; i < cancionesxFecha.get(diaDado).size(); i++) {
            ordenarTopApariciones(top5Canciones);
            Cancion temp = cancionesxFecha.get(diaDado).get(i);
            temp.setContadorParaVerAparicionesEnTop50(temp.getContadorParaVerAparicionesEnTop50() + 1);
            if (top5Canciones.size() < 5){
                top5Canciones.add(cancionesxFecha.get(diaDado).get(i));
            } else{
                if (temp.getContadorParaVerAparicionesEnTop50() > top5Canciones.get(4).getContadorParaVerAparicionesEnTop50()){
                    top5Canciones.remove(top5Canciones.get(4));
                    top5Canciones.add(temp);
                }
            }
        }
        resetarLosContadores(cancionesxFecha.get(diaDado));
        return top5Canciones;
        //Hay que recorrer todos los top50 y ver las 5 canciones que mas aparezcan, esto tiene que darse en orden n.
        //Que devuelva orden n en promedio implica que la estructura a usar es una lista enlazada o alguna variante de esta como stack o queue?
        //ver si al decir que las canciones esten ordenadas en orden descendente implica que se use un stack o queue.
        //respuesta del profe, pide que en el peor caso no sea mas que O (n)
        // dice que busca algo lineal, si poner 10 elementos demora 1, que poner 20 elementos demore 2.
        //No poner doble for's
    }

    public void ordenarTopApariciones (MyList<Cancion> cancionesEnTop5){
        for (int i = 0; i < cancionesEnTop5.size(); i++) { //desde nuestro punto de vista esto es O(1) porque siempre va a ser 5
            Cancion temp = cancionesEnTop5.get(i);
            Cancion temp2 = cancionesEnTop5.get(i+1);
            if (temp.getContadorParaVerAparicionesEnTop50() < temp2.getContadorParaVerAparicionesEnTop50()){
                cancionesEnTop5.insert(temp, i+1);
                cancionesEnTop5.insert(temp2, i);
            }
        }
    }

    public void resetarLosContadores (MyList<Cancion> canciones){
        for (int i = 0; i < canciones.size(); i++) {
            canciones.get(i).setContadorParaVerAparicionesEnTop50(0);
        }
    }

    public void resetarLosContadoresArtistas (MyList<Artista> artistas){
        for (int i = 0; i < artistas.size(); i++) {
            artistas.get(i).setContadorParaVerAparicionesEnTop50(0);
        }
    }
    @Override
    public MyList<Artista> get7ArtistasQueMasAparecenEnTop50(LocalDate fechaInicio, LocalDate fechaFin) {
        if ((fechaInicio == null) || fechaInicio.isAfter(fechaFin)) {
            throw new InformacionInvalida();
        }
        MyList<Artista> top7Artistas = new MyLinkedListImpl<>();
        for (int i = 0; i < fechaFin.getDayOfYear() - fechaInicio.getDayOfYear(); i++) {
            LocalDate fecha = fechaInicio.plusDays(i);
            for (int j = 0; j < 50; j++) {
                Artista temp = (Artista) ordenarTopArtistas(fecha).get(j);
                temp.setContadorParaVerAparicionesEnTop50(temp.getContadorParaVerAparicionesEnTop50() + 1);
                if (top7Artistas.size() < 7){
                    top7Artistas.add(temp);
                } else{
                    if (temp.getContadorParaVerAparicionesEnTop50() > top7Artistas.get(6).getContadorParaVerAparicionesEnTop50()){
                        top7Artistas.remove(top7Artistas.get(6));
                        top7Artistas.add(temp);
                    }
                }
            }
        }
        return top7Artistas;
        //Libertad total del implementacion, simplemente que corra en un tiempo razonable y justificar su implementacion
        //es decir, que si las otras funciones demoran 2 seg que esta no demore 10 min.
    }

    public MyList<Artista> ordenarTopArtistas (LocalDate fecha){
        MyList<Artista> topArtistas = new MyLinkedListImpl<>();
        for (int i = 0; i < 50; i++) {
            Artista temp = (Artista) ordenarTopArtistas(fecha).get(i);
            topArtistas.insert(temp, temp.getContadorParaVerAparicionesEnTop50());
        }
        return topArtistas;
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
