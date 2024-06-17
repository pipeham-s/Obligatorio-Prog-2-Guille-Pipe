package uy.edu.um.prog2.artistas;

import uy.edu.um.prog2.adt.linkedlist.MyLinkedListImpl;
import uy.edu.um.prog2.adt.linkedlist.MyList;
import uy.edu.um.prog2.canciones.Cancion;

import java.util.Objects;

public class Artista {

    private String nombreApellido;
    private MyList<Cancion> canciones;
    private int contadorParaVerAparicionesEnTop50;

    public Artista(String nombreApellido) {
        this.nombreApellido = nombreApellido;
        this.canciones = new MyLinkedListImpl<>();
        this.contadorParaVerAparicionesEnTop50 = 0;
    }

    public int getContadorParaVerAparicionesEnTop50() {
        return contadorParaVerAparicionesEnTop50;
    }

    public void setContadorParaVerAparicionesEnTop50(int contadorParaVerAparicionesEnTop50) {
        this.contadorParaVerAparicionesEnTop50 = contadorParaVerAparicionesEnTop50;
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

    public void addSong(Cancion cancion) {
        canciones.add(cancion);
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Artista artista = (Artista) o;
        return Objects.equals(nombreApellido, artista.nombreApellido) && Objects.equals(canciones, artista.canciones);
    }
}
