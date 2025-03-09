package pl.edu.pjwstk.s30900.s30900RentCar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.edu.pjwstk.s30900.s30900RentCar.car.Car;
import pl.edu.pjwstk.s30900.s30900RentCar.car.CarService;
import pl.edu.pjwstk.s30900.s30900RentCar.klasa.KlasaService;
import pl.edu.pjwstk.s30900.s30900RentCar.rent.Rent;
import pl.edu.pjwstk.s30900.s30900RentCar.rent.RentService;

import java.time.LocalDate;

@SpringBootApplication
public class S30900RentCarApplication {
	public S30900RentCarApplication(RentService rentService, CarService carService, KlasaService klasaService) {
		Car rentedCar = carService.findByVIN(1234);
		rentService.rent(rentedCar, new Client(1), LocalDate.now(), LocalDate.now().plusDays(5));
		Rent rent = rentService.findByRentId(1);

		rentService.calculatePrice(rent);


	}

	public static void main(String[] args) {
		SpringApplication.run(S30900RentCarApplication.class, args);
	}

}
