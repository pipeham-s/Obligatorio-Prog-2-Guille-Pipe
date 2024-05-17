package Tads.arboles.arbolNormal;

import Tads.arboles.Exceptions.HijosCompletosExceptions;

public class MyTreeImpl <K, T> implements MyTree<K, T> {

    private Nodo<K, T> root;

    public MyTreeImpl(Nodo<K, T> root) {
        this.root = root;
    }

    public Nodo<K, T> getRoot() {
        return root;
    }

    public void setRoot(Nodo<K, T> root) {
        this.root = root;
    }

    @Override
    public Nodo<K, T> find(Nodo<K, T> root, K key) {
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

    @Override
    public void insert(Nodo<K, T> parentNode, K key, T data) throws HijosCompletosExceptions {
        Nodo<K, T> papa = root.find(parentNode, key);
        if(papa == null){
            throw new HijosCompletosExceptions();
        }
        if(papa.getLeftChild() == null) {
            papa.setLeftChild(new Nodo<>(key, data));
        }
        else if(papa.getRightChild() == null){
            papa.setRightChild(new Nodo<>(key, data));
        }
        else{
            throw new HijosCompletosExceptions();
        }
    }

    @Override
    public void delete(K key) {
        Nodo<K, T> nodo = root.find(root, key);
        if(nodo == null){
            return;
        }
        if(nodo.getLeftChild() == null && nodo.getRightChild() == null){
            Nodo<K, T> papa = root.findFather(root, key);
            if(papa.getLeftChild() != null && papa.getLeftChild().getKey().equals(key)){
                papa.setLeftChild(null);
            }else{
                papa.setRightChild(null);
            }
        }else if(nodo.getLeftChild() != null && nodo.getRightChild() == null){
            Nodo<K, T> papa = root.findFather(root, key);
            if(papa.getLeftChild() != null && papa.getLeftChild().getKey().equals(key)){
                papa.setLeftChild(nodo.getLeftChild());
            }else{
                papa.setRightChild(nodo.getLeftChild());
            }
        }else if(nodo.getLeftChild() == null && nodo.getRightChild() != null){
            Nodo<K, T> papa = root.findFather(root, key);
            if(papa.getLeftChild() != null && papa.getLeftChild().getKey().equals(key)){
                papa.setLeftChild(nodo.getRightChild());
            }else{
                papa.setRightChild(nodo.getRightChild());
            }
        }else{
            Nodo<K, T> papa = root.findFather(root, key);
            Nodo<K, T> aux = nodo.getRightChild();
            while(aux.getLeftChild() != null){
                aux = aux.getLeftChild();
            }
            delete(aux.getKey());
            if(papa.getLeftChild() != null && papa.getLeftChild().getKey().equals(key)){
                papa.setLeftChild(aux);
            }else{
                papa.setRightChild(aux);
            }
            aux.setLeftChild(nodo.getLeftChild());
            aux.setRightChild(nodo.getRightChild());
        }
    }
    public int size (){return root.size(root); }

    public int countLeaf (){return root.countLeaf(root); }

    public int countComplete (){return root.countComplete(root); }
}
