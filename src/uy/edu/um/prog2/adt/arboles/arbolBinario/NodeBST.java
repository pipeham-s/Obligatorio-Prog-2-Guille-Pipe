package uy.edu.um.prog2.adt.arboles.arbolBinario;

import java.util.Objects;

public class NodeBST <K extends Comparable<K>, T> {
    K key;
    T data;
    NodeBST <K, T> leftChild;
    NodeBST <K, T> rightChild;

    public NodeBST(K key, T data) {
        this.key = key;
        this.data = data;
        this.leftChild = null;
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

    public NodeBST<K, T> getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(NodeBST<K, T> leftChild) {
        this.leftChild = leftChild;
    }

    public NodeBST<K, T> getRightChild() {
        return rightChild;
    }

    public void setRightChild(NodeBST<K, T> rightChild) {
        this.rightChild = rightChild;
    }

    public T find (K key){
        if (this.key == null) {
            return null;
        }
        if(this.key.equals(key)){
            return this.data;
        }else if(this.key.compareTo(key) > 0){
            if(this.leftChild == null){
                return null;
            }else{
                return this.leftChild.find(key);
            }
        }else{
            if(this.rightChild == null){
                return null;
            }else{
                return this.rightChild.find(key);
            }
        }
    }

    public void insert (K key, T data){
        if(this.key.compareTo(key) > 0){
            if(this.leftChild == null){
                this.leftChild = new NodeBST<>(key, data);
            }else{
                this.leftChild.insert(key, data);
            }
        }else{
            if(this.rightChild == null){
                this.rightChild = new NodeBST<>(key, data);
            }else{
                this.rightChild.insert(key, data);
            }
        }
    }
    public void delete (K key){
        if(this.key.equals(key)){
            if(this.leftChild == null && this.rightChild == null){
                this.key = null;
                this.data = null;
            }else if(this.leftChild != null && this.rightChild == null){
                this.key = this.leftChild.key;
                this.data = this.leftChild.data;
                this.leftChild = null;
            }else if(this.leftChild == null && this.rightChild != null){
                this.key = this.rightChild.key;
                this.data = this.rightChild.data;
                this.rightChild = null;
            }else{
                NodeBST<K, T> temp = this.rightChild;
                while(temp.leftChild != null){
                    temp = temp.leftChild;
                }
                this.key = temp.key;
                this.data = temp.data;
                temp.key = null;
                temp.data = null;
            }
        }else if(this.key.compareTo(key) > 0){
            if(this.leftChild != null){
                this.leftChild.delete(key);
            }
        }else{
            if(this.rightChild != null){
                this.rightChild.delete(key);
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NodeBST<?, ?> nodeBST = (NodeBST<?, ?>) o;
        return Objects.equals(key, nodeBST.key) && Objects.equals(data, nodeBST.data) && Objects.equals(leftChild, nodeBST.leftChild) && Objects.equals(rightChild, nodeBST.rightChild);
    }
}
