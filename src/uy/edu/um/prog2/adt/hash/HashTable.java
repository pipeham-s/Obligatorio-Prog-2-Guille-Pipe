package uy.edu.um.prog2.adt.hash;

public interface HashTable <K,V> {
    public void put(K key, V value);
    public boolean contains(K key);
    public void remove(K key);

    public V get(K artista);

    public int search(K key);

    public HashNode<K,V> searchNode(K key);

}
