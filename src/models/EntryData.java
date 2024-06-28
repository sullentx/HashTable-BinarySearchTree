package models;

public class EntryData {
    private String key;
    private Business value;

    public EntryData(String key, Business value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public Business getValue() {
        return value;
    }

    public void setValue(Business value) {
        this.value = value;
    }
}
