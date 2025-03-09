package pl.edu.pjwstk.s30900.s30900RentCar.rent;



import pl.edu.pjwstk.s30900.s30900RentCar.Client;
import pl.edu.pjwstk.s30900.s30900RentCar.car.Car;

import java.time.LocalDate;

public class Rent {
    private Client client;
    private Car car;
    private LocalDate from;
    private LocalDate to;
    private int rentId;

    public Rent(int rentId, Car car, Client client, LocalDate from, LocalDate to) {
        this.rentId = rentId;
        this.car = car;
        this.client = client;
        this.from = from;
        this.to = to;
    }

    public Car getCar() {
        return car;
    }

    public Client getClient() {
        return client;
    }

    public LocalDate getFrom() {
        return from;
    }

    public int getRentId() {return rentId; }

    public LocalDate getTo() {
        return to;
    }
}
