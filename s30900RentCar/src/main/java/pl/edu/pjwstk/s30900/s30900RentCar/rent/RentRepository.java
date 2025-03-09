package pl.edu.pjwstk.s30900.s30900RentCar.rent;


import org.springframework.stereotype.Repository;
import pl.edu.pjwstk.s30900.s30900RentCar.Client;
import pl.edu.pjwstk.s30900.s30900RentCar.car.CarService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class RentRepository {
    List<Rent> rentals;
//private final CarService carService;
    public RentRepository(CarService carService) {
       // this.carService = carService;

        rentals = new ArrayList<>();
        rentals.add(new Rent(1, carService.findByVIN(1234),new Client(2), LocalDate.now().plusDays(10),LocalDate.now().plusDays(20)));
    }

    public void addRental(Rent rent) {
        rentals.add(rent);
    }

    public List<Rent> getRent() {
        return rentals;
    }
}
