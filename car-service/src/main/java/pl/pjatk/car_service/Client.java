package pl.pjatk.car_service;

public class Client {
    private String name;
    private String id;

    public Client(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
