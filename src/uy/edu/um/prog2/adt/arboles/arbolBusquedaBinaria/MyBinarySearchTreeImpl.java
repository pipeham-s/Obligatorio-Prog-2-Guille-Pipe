package uy.edu.um.prog2.adt.arboles.arbolBusquedaBinaria;

import java.security.Key;
import java.util.ArrayList;
import java.util.List;

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

    public List<K> inOrder() {
        List<K> result = new ArrayList<>();
        inOrderHelper(root, result);
        return result;
    }

    // Función auxiliar que realiza el recorrido in-order
    private void inOrderHelper(NodeBST<K,T> node, List<K> result) {
        if (node != null) {
            inOrderHelper(node.leftChild, result); // Recorrer subárbol izquierdo
            result.add(node.key);             // Visitar el nodo
            inOrderHelper(node.rightChild, result); // Recorrer subárbol derecho
        }
    }

    public String toString(){
        return this.inOrder().toString();
    }
}
