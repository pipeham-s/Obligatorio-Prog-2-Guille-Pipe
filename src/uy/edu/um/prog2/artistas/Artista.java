package uy.edu.um.prog2.artistas;

import uy.edu.um.prog2.adt.linkedlist.MyLinkedListImpl;
import uy.edu.um.prog2.adt.linkedlist.MyList;
import uy.edu.um.prog2.canciones.Cancion;

import java.util.Objects;

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

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Artista artista = (Artista) o;
        return Objects.equals(nombreApellido, artista.nombreApellido) && Objects.equals(canciones, artista.canciones);
    }
}
