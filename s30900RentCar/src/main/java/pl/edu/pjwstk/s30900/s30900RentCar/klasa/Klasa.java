package pl.edu.pjwstk.s30900.s30900RentCar.klasa;


public class Klasa {
    int id;
    String name;
    double price;
    public Klasa(int id, String name, double price){
        this.id = id;
        this.name=name;
        this.price=price;

    }
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public Double getPrice() {
        return price;
    }
}
