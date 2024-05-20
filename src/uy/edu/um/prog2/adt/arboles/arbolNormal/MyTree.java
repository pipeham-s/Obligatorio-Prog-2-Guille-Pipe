package uy.edu.um.prog2.adt.arboles.arbolNormal;

import uy.edu.um.prog2.adt.arboles.Exceptions.HijosCompletosExceptions;

public interface MyTree<K,T> {

    Nodo<K, T> find(Nodo<K, T> root, K key);

    void insert(Nodo<K, T> parentNode, K key, T data) throws HijosCompletosExceptions;

    void delete(K key);
}
