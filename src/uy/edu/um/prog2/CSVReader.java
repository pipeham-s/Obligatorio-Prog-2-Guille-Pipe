package uy.edu.um.prog2;

import uy.edu.um.prog2.adt.arbolitos.binarytree.BinaryTreeInterface;
import uy.edu.um.prog2.adt.arbolitos.binarytree.SearchBinaryTreeImpl;
import uy.edu.um.prog2.adt.hash.HashTable;
import uy.edu.um.prog2.adt.hash.HashTableImpl;
import uy.edu.um.prog2.adt.linkedlist.MyLinkedListImpl;
import uy.edu.um.prog2.adt.linkedlist.MyList;
import uy.edu.um.prog2.artistas.Artista;
import uy.edu.um.prog2.canciones.Cancion;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;

public class CSVReader {

    private HashTable<String, HashTable<String, MyList<Cancion>>> diaPaisTop50;

    private HashTable<String, MyList<Cancion>> diaCanciones;

    private MyList<String> paises;

    private MyList<Artista> artistas;

    private BinaryTreeInterface<Float, MyList<Cancion>> arbolTempos;

    public void setDiaPaisTop50(HashTable<String, HashTable<String, MyList<Cancion>>> hash) {
        this.diaPaisTop50 = hash;
    }

    public HashTable<String, HashTable<String, MyList<Cancion>>> getDiaPaisTop50() {
        return diaPaisTop50;
    }

    public BinaryTreeInterface<Float, MyList<Cancion>> getArbolTempos() {
        return arbolTempos;
    }

    public void setArbolTempos(BinaryTreeInterface<Float, MyList<Cancion>> arbolTempos) {
        this.arbolTempos = arbolTempos;
    }

    public HashTable<String, MyList<Cancion>> getDiaCanciones() {
        return diaCanciones;
    }

    public void setDiaCanciones(HashTable<String, MyList<Cancion>> diaCanciones) {
        this.diaCanciones = diaCanciones;
    }

    public void setPaises(MyList<String> paises){
        this.paises = paises;
    }
    public MyList<String> getPaises(){
        return paises;
    }

    public void setArtistas(MyList<Artista> artistas){
        this.artistas = artistas;
    }
    public MyList<Artista> getArtistas(){
        return artistas;
    }

    public CSVReader() {
        String line;
        HashTable<String, HashTable<String,MyList<Cancion>>> diaPaisTop50 = new HashTableImpl<>(400);
        BinaryTreeInterface<Float, MyList<Cancion>> arbolTempos = new SearchBinaryTreeImpl<>();
        MyList<String> listaPaises = new MyLinkedListImpl<>();
        HashTable<String,MyList<Cancion>> diaCanciones = new HashTableImpl<>(1000);
        MyList<Artista> listaArtistas = new MyLinkedListImpl<>();
        System.out.println("Leyendo archivo");
        try (BufferedReader br = new BufferedReader(new FileReader("csv_reducido.csv"))) {
            //Lee la primer linea, que no nos importa
            br.readLine();

            while ((line = br.readLine()) != null) {

                //Borra los ;; del final
                //line = line.substring(1, line.length() - 2);

                // Separa por la coma
                String[] fields = line.split("\",\"");

                //Separa y crea los artistas
                String[] artistasArray = fields[2].split(", ");
                String artists = "";
                for (String art : artistasArray) {
                    Artista artista = new Artista(art);
//                    if (!listaArtistas.contains(artist)){ la.add(artist); }
                    if (Objects.equals(art, artistasArray[0])) {
                        artists = art;
                    }
                    else{
                        artists = artists + ", " + art;
                    }
                    if (!listaArtistas.contains(artista)) {
                        listaArtistas.add(artista);
                    }
                }

                //Agrega los paises a la lista de paises
                if (fields[6].isEmpty()) {
                    fields[6] = "Global";
                }

                if (!listaPaises.contains(fields[6])) {
                    listaPaises.add(fields[6]);
                }

                // Crear la Cancion
                Cancion cancion = new Cancion(
                    fields[0],                   // spotifyId
                    fields[1],                   // name
                    artists,                     // artists
                    artistasArray,               // artistsArray
                    Integer.parseInt(fields[3]), // dailyRank
                    Integer.parseInt(fields[4]), // dailyMovement
                    Integer.parseInt(fields[5]), // weeklyMovement
                    fields[6],                   // country
                    fields[7],                   // snapshotDate
                    Float.parseFloat(fields[23]) // tempo
                );
                System.out.println("Leyendo canciones");
                //Agrega la cancion al hash
                if(diaPaisTop50.search(cancion.getSnapshotDate()) == -1) {
                    diaPaisTop50.put(cancion.getSnapshotDate(), new HashTableImpl<>(148)); //doble de paises para mas espacio
                }
                System.out.println("1");
                if (diaPaisTop50.searchNode(cancion.getSnapshotDate()).getValue().search(cancion.getCountry()) == -1) {
                    diaPaisTop50.searchNode(cancion.getSnapshotDate()).getValue().put(cancion.getCountry(), new MyLinkedListImpl<>()); //esta linea no esta funcionando, no se porque

                }
                System.out.println("2");
                diaPaisTop50.searchNode(cancion.getSnapshotDate()).getValue().searchNode(cancion.getCountry()).getValue().add(cancion);

                if(!arbolTempos.contains(cancion.getTempo())){
                    arbolTempos.add(cancion.getTempo(), new MyLinkedListImpl<>());
                }
                arbolTempos.find(cancion.getTempo()).add(cancion);
                System.out.println("3");
                // agrega las canciones al diaCanciones

                if(diaCanciones.search(cancion.getSnapshotDate()) == -1) {
                    diaCanciones.put(cancion.getSnapshotDate(), new MyLinkedListImpl<>());
                }
                diaCanciones.searchNode(cancion.getSnapshotDate()).getValue().add(cancion);
                System.out.println("Cancion leida y agregada");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Fin de la lectura");
        //setea los tads
        setDiaPaisTop50(diaPaisTop50);
        setArbolTempos(arbolTempos);
        setPaises(listaPaises);
        setDiaCanciones(diaCanciones);
        //setArtistas(la);
    }
}