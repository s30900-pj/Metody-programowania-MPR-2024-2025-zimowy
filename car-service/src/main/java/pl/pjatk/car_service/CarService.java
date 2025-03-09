package pl.pjatk.car_service;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CarService {
    private final CarStorage carStorage;

    public CarService(CarStorage carStorage) {
        this.carStorage = carStorage;
    }

    public String rentCar(String vin, Client client, LocalDate startDate, LocalDate endDate) {
        Car car = carStorage.findCarByVin(vin);
        if (car == null) {
            return "Samochód o podanym VIN nie istnieje!";
        }
        if (!car.isAvailableInPeriod(startDate, endDate)) {
            return "Samochód jest niedostępny w wybranym okresie!";
        }

        Reservation reservation = new Reservation(vin, client, startDate, endDate);
        car.addReservation(reservation);
        return "Samochód wypożyczony pomyślnie!";
    }

    public String getCarStatus(LocalDate startDate, LocalDate endDate) {
        List<Car> availableCars = carStorage.getAllCars().stream()
                .filter(car -> car.isAvailableInPeriod(startDate, endDate))
                .collect(Collectors.toList());

        List<Car> rentedCars = carStorage.getAllCars().stream()
                .filter(car -> !car.isAvailableInPeriod(startDate, endDate))
                .collect(Collectors.toList());

        StringBuilder report = new StringBuilder();
        report.append("Samochody dostępne w okresie ").append(startDate).append(" - ").append(endDate).append(":\n");
        availableCars.forEach(car -> report.append(car).append("\n"));

        report.append("\nSamochody wypożyczone w okresie ").append(startDate).append(" - ").append(endDate).append(":\n");
        rentedCars.forEach(car -> report.append(car).append("\n"));

        return report.toString();
    }
}
