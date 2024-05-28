package uy.edu.um.prog2.artistas;

import uy.edu.um.prog2.adt.linkedlist.MyLinkedListImpl;
import uy.edu.um.prog2.adt.linkedlist.MyList;
import uy.edu.um.prog2.canciones.Cancion;

public class Artista {

    private String nombreApellido;
    private MyList<Cancion> canciones;

    public Artista(String nombreApellido) {
        this.nombreApellido = nombreApellido;
        this.canciones = new MyLinkedListImpl<>();
    }

    public String getNombreApellido() {
        return nombreApellido;
    }

    public void setNombreApellido(String nombreApellido) {
        this.nombreApellido = nombreApellido;
    }

    public MyList<Cancion> getCanciones() {
        return canciones;
    }

    public void setCanciones(MyList<Cancion> canciones) {
        this.canciones = canciones;
    }
}
