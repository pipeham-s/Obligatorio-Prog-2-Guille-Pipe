package uy.edu.um.prog2.adt.linkedlist;

public interface MyList<T> {

    void add(T value);

    void insert(T value, int position);

    T get(int position);

    boolean contains(T value);

    void remove(T value);

    int size();

    int getPosition(T value);

}
