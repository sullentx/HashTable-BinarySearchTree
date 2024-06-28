package models;

public class Business {

    private String id;

    private  String name;

    private  String address;

    private String city;

    private String state;

    public Business(String id, String name, String address, String city,
                    String state) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.city = city;
        this.state = state;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Business{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
