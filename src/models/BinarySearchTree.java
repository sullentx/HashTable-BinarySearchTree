package models;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree {
    private BSTNode root;
    public BinarySearchTree() {
        root = null;
    }

    public void put(String key, Business value) {
        root = putRecursive(root, key, value);
    }

    // metodo auxiliar recursivo para insertar un nodo en el árbol
    private BSTNode putRecursive(BSTNode currentNode, String key, Business value) {
        if (currentNode == null) {
            return new BSTNode(key, value); // Crea un nuevo nodo si el nodo actual es nulo
        }

        // compara la clave con la clave del nodo actual y decide dónde insertar
        int comparisonResult = key.compareTo(currentNode.entry.getKey());
        if (comparisonResult < 0) {
            currentNode.left = putRecursive(currentNode.left, key, value); // Inserta a la izquierda
        } else if (comparisonResult > 0) {
            currentNode.right = putRecursive(currentNode.right, key, value); // Inserta a la derecha
        } else {
            currentNode.entry.setValue(value); // actualiza el valor si la clave ya existe
        }

        return currentNode;
    }

    // Obtiene el valor asociado a una clave
    public Business get(String key) {
        BSTNode node = getRecursive(root, key);
        return (node == null) ? null : node.entry.getValue();
    }

    // metodo auxiliar recursivo para buscar un nodo por su clave
    private BSTNode getRecursive(BSTNode currentNode, String key) {
        if (currentNode == null || currentNode.entry.getKey().equals(key)) {
            return currentNode; // Retorna el nodo si se encuentra o si es nulo
        }

        if (key.compareTo(currentNode.entry.getKey()) < 0) {
            return getRecursive(currentNode.left, key); // Búsqueda en el subárbol izquierdo
        }
        return getRecursive(currentNode.right, key); // Búsqueda en el subárbol derecho
    }

    // realiza un recorrido inorden del árbol y retorna una lista de los valores
    public List<Business> inOrderTraversal() {
        List<Business> result = new ArrayList<>();
        inOrderRecursive(root, result);
        return result;
    }

    // metodo auxiliar recursivo para realizar el recorrido inorden
    private void inOrderRecursive(BSTNode currentNode, List<Business> result) {
        if (currentNode != null) {
            inOrderRecursive(currentNode.left, result); // Recorre el subárbol izquierdo
            result.add(currentNode.entry.getValue()); // Agrega el valor del nodo actual a la lista
            inOrderRecursive(currentNode.right, result); // Recorre el subárbol derecho
        }
    }
}
