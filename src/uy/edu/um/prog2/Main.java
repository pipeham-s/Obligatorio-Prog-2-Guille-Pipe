package uy.edu.um.prog2;

import uy.edu.um.prog2.adt.arbolitos.binarytree.BinaryTreeInterface;
import uy.edu.um.prog2.adt.hash.HashTable;
import uy.edu.um.prog2.adt.hash.HashTableImpl;
import uy.edu.um.prog2.adt.linkedlist.MyList;
import uy.edu.um.prog2.artistas.Artista;
import uy.edu.um.prog2.canciones.Cancion;

import java.io.IOException;





public class Main {

    public static void main(String[] args) throws IOException {
        CSVReader C = new CSVReader();

        HashTable<String, HashTable<String,MyList<Cancion>>> diaPaisTop50 = C.getDiaPaisTop50();
        BinaryTreeInterface<Float, MyList<Cancion>> arbolTempos = C.getArbolTempos();
        MyList<String> paises = C.getPaises();
        HashTable<String,MyList<Cancion>> diaCanciones = C.getDiaCanciones();

        System.out.println(paises.size());

    }

}
