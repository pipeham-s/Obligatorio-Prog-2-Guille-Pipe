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


    // hash tiene que ser para cualquier variable? o para enteros?

    // se suma 1 a pos (se busca el libre) o se hace un hash a key + 1? en realidad no se hace a key + 1 pq puede ser un string
    @Override
    public void put(K key, V value) {
        int pos = funHash(key);
        HashNode<K, V> entrada = new HashNode<>(key, value);
        if (table[pos] == null) {
            table[pos] = entrada;
            loadFactor = ((loadFactor * size) + 1) / size;
        } else {
            // si la posicion ya esta ocupada
            // se busca la siguiente posicion libre
            int i = pos + 1;
            while (i != pos) {
                if (i == size) {
                    i = 0;
                }
                //seguira siendo O(1)?
                if (table[i] == null) {
                    table[i] = entrada;
                    loadFactor = ((loadFactor * size) + 1) / size;
                    break;
                }
                i++;
            }
        }
    }

    @Override
    public boolean contains(K key) {
        int pos = funHash(key);
        if (table[pos] != null) {
            if (table[pos].getKey().equals(key)) {
                return true;
            } else {
                int i = pos + 1;
                while (i != pos) {
                    if (i == size) {
                        i = 0;
                    }
                    if (table[i] != null) {
                        if (table[i].getKey().equals(key)) {
                            return true;
                        }
                    }
                    i++;
                }
            }
        }
        return false;
    }

    @Override
    public void remove(K key) {

    }
}
