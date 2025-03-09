package org.example;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
@Component
public class RentalService {

    private CarStorage carStorage;
    private RentStorage rentStorage;

    public RentalService(CarStorage carStorage, RentStorage rentStorage) {
        this.carStorage = carStorage;
        this.rentStorage = rentStorage;
    }


    int baseOneDayRent = 100;

    public CarRentInfo createRent(LocalDate dateFrom, LocalDate dateTo, Car car, User user) {
        if (!car.isRented() && dateFrom.isBefore(dateTo)) {
            car.setRented(true);
            car.setTemporaryOwner(user);
            CarRentInfo rentInfo = new CarRentInfo(car.getTemporaryOwner(), car.getVin(), dateFrom, dateTo);
            rentStorage.addRent(rentInfo);
            return rentInfo;
        } else {
            System.out.println("Błąd przy tworzeniu rezerwacji");
        }
        return null;
    }


    public boolean carExist(int vin) {
        return carStorage.getCarList().stream().anyMatch(v -> v.getVin() == vin);
    }

    public double estimatePrice(int vin, LocalDate dateFrom, LocalDate dateTo) {
        double price = baseOneDayRent;
        double daysBetween = ChronoUnit.DAYS.between(dateFrom, dateTo);
        Car carPrice = carStorage.getCarList().stream()
                .filter(car -> car.getVin() == vin)
                .findAny()
                .orElseThrow();

        price *= daysBetween * carPrice.getSegment().getStandardValue();
        price = (double) Math.round(price * 100.0) / 100.0;

        return price;
    }
}