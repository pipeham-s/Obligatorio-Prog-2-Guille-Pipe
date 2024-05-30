package uy.edu.um.prog2.adt.hash;

public class HashTableImpl <K,V> implements HashTable <K,V> {

    private int size;
    private HashNode<K,V>[] table;
    private float loadFactor;

    private int umbralRehash;

    public HashTableImpl(int size) {
        this.size = size;
        this.table = new HashNode[size];
        this.loadFactor = 0; // en el constructor comienza en 0 ya que sea del tamaño que sea el arreglo, no tiene elementos.
        // o el load factor es el limite
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
    // put tiene que tener en cuenta el factor de carga y hacer crecer el array si se pasa?

    // se suma 1 a pos (se busca el libre) o se hace un hash a key + 1? en realidad no se hace a key + 1 pq puede ser un string
    @Override
    public void put(K key, V value) {
        if (this.contains(key)== false) { // si la key ya esta usada no se va a agregar el nodo
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
            if (loadFactor >= 0.75) { //loadfactor tomamos como maximo ideal 0,75. POner en informe
                reHash();
            }
        }
    }



    public void reHash () {
        HashNode<K, V>[] oldTable = table;
        size = size * 2;
        table = new HashNode[size];
        for (int i = 0; i < oldTable.length; i++) {
            if (oldTable[i] != null) {
                int pos2 = funHash(oldTable[i].getKey());
                table[pos2] = oldTable[i];
            }
        }
        loadFactor = loadFactor / 2;
    }

    @Override
    public boolean contains(K key) {
        int pos = funHash(key);
        if (table[pos] != null && table[pos].getKey().equals(key)) {
            return true;
        } else {
            int i = pos + 1;
            while (i != pos) {
                if (i == size) {
                    i = 0;
                }
                if (table[i] != null && table[i].getKey().equals(key)) {
                    return true;
                }
                i++;
            }
        }
        return false;
    }

    @Override
    public void remove(K key) {
        int pos = funHash(key);
        if (table[pos] != null && table[pos].getKey().equals(key)) {
            table[pos] = null;
            loadFactor = ((loadFactor * size) - 1) / size;
        } else {
            int i = pos + 1;
            while (i != pos) {
                if (i == size) {
                    i = 0;
                }
                if (table[i] != null && table[i].getKey().equals(key)) {
                    table[i] = null;
                    loadFactor = ((loadFactor * size) - 1) / size;
                    break;
                }
                i++;
            }
        }
    }

    @Override
    public String toString() {
        for (int i = 0; i < table.length; i++) {
            if (table[i] != null){
                System.out.println(table[i].getKey());
            }
            else{
                System.out.println("null");
            }
        }
        return null;
    }

}
