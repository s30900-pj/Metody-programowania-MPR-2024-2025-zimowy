package org.example;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.time.LocalDate;

@SpringBootApplication
public class Main implements CommandLineRunner {
    private final CarStorage carStorage;
    private final RentStorage rentStorage;

    public Main(CarStorage carStorage, RentStorage rentStorage) {
        this.carStorage = carStorage;
        this.rentStorage = rentStorage;
    }

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        initProcess();
        printAllData();
    }

    public void initProcess() {
        Car car1 = new Car("Audi", "A7", 324552, Type.Sedan);
        Car car2 = new Car("BMW", "X5", 123456, Type.Suv);
        Car car3 = new Car("Volkswagen", "Passat", 789012, Type.Kombi);

        carStorage.addcar(car1);
        carStorage.addcar(car2);
        carStorage.addcar(car3);

        User user1 = new User(1);
        User user2 = new User(2);
        RentalService rentalService = new RentalService(carStorage, rentStorage);

        rentalService.createRent(LocalDate.now(), LocalDate.now().plusDays(5), car1, user1);
        rentalService.createRent(LocalDate.now(), LocalDate.now().plusDays(2), car2, user1);
        rentalService.createRent(LocalDate.now(), LocalDate.now().plusDays(10), car3, user2);

        double price1 = rentalService.estimatePrice(324552, LocalDate.now(), LocalDate.now().plusDays(5));
        System.out.println("Cena wynajmu samochodu o VIN 324552: " + price1 + " PLN");

        double price2 = rentalService.estimatePrice(123456, LocalDate.now(), LocalDate.now().plusDays(2));
        System.out.println("Cena wynajmu samochodu o VIN 123456: " + price2 + " PLN");

        double price3 = rentalService.estimatePrice(789012, LocalDate.now(), LocalDate.now().plusDays(10));
        System.out.println("Cena wynajmu samochodu o VIN 789012: " + price3 + " PLN");
    }

    public void printAllData() {
        System.out.println("===== Lista samochodów =====");
        for (Car car : carStorage.getCarList()) {
            System.out.println("Marka: " + car.getMarka() +
                    ", Model: " + car.getModel() +
                    ", VIN: " + car.getVin() +
                    ", Segment: " + car.getSegment() +
                    ", Wynajęty: " + (car.isRented() ? "Tak" : "Nie"));
        }

        System.out.println("\n===== Lista rezerwacji =====");
        rentStorage.printRentList();
    }
}
