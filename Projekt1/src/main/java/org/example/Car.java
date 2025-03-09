package org.example;

public class Car {
    private String marka;
    private String model;
    private int vin;
    private Type segment;

    private User temporaryOwner;
    public boolean isRented;

    public Car(String Marka, String Model, int Vin, Type Segment) {
        marka = Marka;
        this.model = Model;
        this.vin = Vin;
        this.segment = Segment;
        this.isRented = false;

    }

    public String getModel() {
        return model;
    }

    public int getVin() {
        return vin;
    }

    public String getMarka() {
        return marka;
    }

    public void setTemporaryOwner(User temporaryOwner) {
        this.temporaryOwner = temporaryOwner;
    }

    public User getTemporaryOwner() {
        return temporaryOwner;
    }

    public void setRented(boolean rented) {
        isRented = rented;
    }

    public boolean isRented() {
        return isRented;
    }

    public Type getSegment() {
        return segment;
    }
}
