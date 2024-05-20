package uy.edu.um.prog2.adt.hash;

public class HashTableImpl <K,V> implements HashTable <K,V> {

    private int size;
    private HashNode<K,V>[] table;
    private float loadFactor;

    public HashTableImpl(int size) {
        this.size = size;
        this.table = new HashNode[size];
        this.loadFactor = 0; // en el constructor comienza en 0 ya que sea del tamaño que sea el arreglo, no tiene elementos.
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public HashNode<K, V>[] getTable() {
        return table;
    }

    public void setTable(HashNode<K, V>[] table) {
        this.table = table;
    }

    public float getLoadFactor() {
        return loadFactor;
    }

    public void setLoadFactor(float loadFactor) {
        this.loadFactor = loadFactor;
    }

    private int funHash(K key) {return key.hashCode() % size;} //sin usar hashcode la idea es hallar el modulo de la division la llave por el tamaño del arreglo

    @Override
    public void put(K key, V value) {
        int pos = funHash(key);

    }

    @Override
    public boolean contains(K key) {
        return false;
    }

    @Override
    public void remove(K key) {

    }
}
