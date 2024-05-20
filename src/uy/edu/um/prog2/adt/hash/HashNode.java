package uy.edu.um.prog2.adt.hash;

public class HashNode <K,V> {
    private K key;
    private V value;
    private boolean deleted;

    public HashNode(K key, V value) {
        this.key = key;
        this.value = value;
        this.deleted = false;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}