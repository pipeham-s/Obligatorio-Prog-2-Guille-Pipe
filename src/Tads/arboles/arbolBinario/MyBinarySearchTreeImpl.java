package Tads.arboles.arbolBinario;

public class MyBinarySearchTreeImpl <K extends Comparable<K>, T> implements MyBinarySearchTree <K, T>{

    private NodeBST <K, T> root;

    public MyBinarySearchTreeImpl(K key, T rootData) {
        this.root = new NodeBST<>(key, rootData);
    }

    @Override
    public T find(K key){
        return this.root.find(key);
    }

    @Override
    public void insert(K key, T data) {
        this.root.insert(key, data);
    }

    @Override
    public void delete(K key) {
        this.root.delete(key);
    }
}
