package pl.pjatk.car_service;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class CarServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarServiceApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(CarService carService, CarStorage carStorage) {
		return args -> {
			Car car1 = new Car("Audi", "A4", "VIN123", "Premium");
			Car car2 = new Car("BMW", "X5", "VIN456", "Standard");

			carStorage.addCar(car1);
			carStorage.addCar(car2);

			Client client1 = new Client("John Doe", "ID001");
			Client client2 = new Client("Jane Smith", "ID002");

			System.out.println(carService.rentCar("VIN123", client1, LocalDate.of(2024, 11, 20), LocalDate.of(2024, 11, 25)));
			System.out.println(carService.rentCar("VIN123", client2, LocalDate.of(2024, 11, 24), LocalDate.of(2024, 11, 30)));
			System.out.println(carService.rentCar("VIN456", client2, LocalDate.of(2024, 11, 21), LocalDate.of(2024, 11, 23)));

			System.out.println("\n" + carService.getCarStatus(LocalDate.of(2024, 11, 20), LocalDate.of(2024, 11, 30)));
		};
	}
}
