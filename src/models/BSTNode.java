package models;

public class BSTNode {
    EntryData entry;
    BSTNode left, right;

    public BSTNode(String key, Business value) {
        entry = new EntryData(key, value);
        left = null;
        right = null;
    }
}
