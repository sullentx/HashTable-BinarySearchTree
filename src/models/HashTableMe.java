package models;

import java.util.ArrayList;
import java.util.List;

public class HashTableMe {
    private int size;
    private BinarySearchTree[] table;

    public HashTableMe(int size) {
        this.size = size;
        table = new BinarySearchTree[size];
        for (int i = 0; i < size; i++) {
            table[i] = new BinarySearchTree();
        }
    }

    public void put(String key, Business value) {
        int index = hashing(key);
        table[index].put(key, value);
    }

    public Business get(String key) {
        int index =hashing(key);
        return table[index].get(key);
    }

    public List<Business> getAllBusinesses() {
        List<Business> allBusinesses = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            List<Business> businesses = table[i].inOrderTraversal();
            allBusinesses.addAll(businesses);
        }
        return allBusinesses;
    }
    private int hashMultiplicacion(String key) {
        final double A = 0.6180339887;
        double hashCode = key.hashCode();
        double fraction = A * hashCode;
        fraction -= Math.floor(fraction);
        return (int) (fraction * size);
    }
    private int hashDivision(String key) {
        int hash = key.hashCode();
        return Math.abs(hash % size); // Utiliza valor absoluto para asegurar índices positivos
    }
    private int hashing(String key){
        //return hashDivision(key);
        return hashMultiplicacion(key);
    }

}
