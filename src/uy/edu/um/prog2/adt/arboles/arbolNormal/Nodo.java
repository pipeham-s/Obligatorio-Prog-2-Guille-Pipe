package uy.edu.um.prog2.adt.arboles.arbolNormal;

import uy.edu.um.prog2.adt.arboles.Exceptions.HijosCompletosExceptions;

public class Nodo <K, T>{

    private K key;

    private T data;

    private Nodo<K, T> leftChild;

    private Nodo<K, T> rightChild;

    public Nodo(K key, T data) {
        this.key = key;
        this.data = data;
        this.leftChild = null; //se crea null porque desde un inicio no tiene hijos
        this.rightChild = null;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Nodo<K, T> getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Nodo<K, T> leftChild) {
        this.leftChild = leftChild;
    }

    public Nodo<K, T> getRightChild() {
        return rightChild;
    }

    public void setRightChild(Nodo<K, T> rightChild) {
        this.rightChild = rightChild;
    }

    public int size(Nodo<K, T> root){
        if(root == null){
            return 0;
        }else{
            return 1 + size(root.getLeftChild()) + size(root.getRightChild());
        }
    }
    public boolean isLeaf (Nodo<K, T> root){
        return root.getLeftChild() == null && root.getRightChild() == null;
    }
    public int countLeaf (Nodo<K, T> root){
        if(root == null){
            return 0;
        }else if(isLeaf(root)){
            return 1;
        }else{
            return countLeaf(root.getLeftChild()) + countLeaf(root.getRightChild());
        }
    }

    public boolean isComplete (Nodo<K, T> root){
        if(root == null){
            return true;
        }else if(root.getLeftChild() == null && root.getRightChild() == null){
            return true;
        }else if(root.getLeftChild() != null && root.getRightChild() != null){
            return isComplete(root.getLeftChild()) && isComplete(root.getRightChild());
        }else{
            return false;
        }
    }

    public int countComplete (Nodo<K, T> root) {
        if (root == null) {
            return 0;
        } else if (isComplete(root)) {
            return 1 + countComplete(root.getLeftChild()) + countComplete(root.getRightChild());
        } else {
            return countComplete(root.getLeftChild()) + countComplete(root.getRightChild());
        }
    }

    public Nodo <K, T> find(Nodo<K, T> root, K key){
        if(root == null){
            return null;
        }else if(root.getKey().equals(key)){
            return root;
        }else{
            Nodo<K, T> left = find(root.getLeftChild(), key);
            if(left != null){
                return left;
            }else{
                return find(root.getRightChild(), key);
            }
        }
    }

    public void insert(Nodo <K, T> parentNode, K key, T data) throws HijosCompletosExceptions {
        Nodo <K, T> papa = find(parentNode, key);
        if(papa == null){
            throw new HijosCompletosExceptions();
        }else if(papa.getLeftChild() == null){
            papa.setLeftChild(new Nodo<>(key, data));
        }else if(papa.getRightChild() == null){
            papa.setRightChild(new Nodo<>(key, data));
        }else{
            throw new HijosCompletosExceptions();
        }
    }

    public Nodo<K,T> findFather(Nodo<K, T> root, K key) {
        if(root == null){
            return null;
        }else if(root.getLeftChild() != null && root.getLeftChild().getKey().equals(key)){
            return root;
        }else if(root.getRightChild() != null && root.getRightChild().getKey().equals(key)){
            return root;
        }else{
            Nodo<K, T> left = findFather(root.getLeftChild(), key);
            if(left != null){
                return left;
            }else{
                return findFather(root.getRightChild(), key);
            }
        }
    }
}
