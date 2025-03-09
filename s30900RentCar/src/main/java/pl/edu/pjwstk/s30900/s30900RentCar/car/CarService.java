package pl.edu.pjwstk.s30900.s30900RentCar.car;

import org.springframework.stereotype.Service;

@Service
public class CarService {
    private final CarRepository carRepository;
    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public Car findByVIN(int VIN) {
        Car selectedCar = null;
        for (Car car : carRepository.getAllCars()) {
            if (car.getVIN() == VIN) {
                selectedCar = car;
            }
        }
        if (selectedCar == null) {
            throw new RuntimeException("no such car was found");
        }
        return selectedCar;
    }
//    public void rentCar(int VIN) {
//        Car car = carRepository.findByVIN(VIN);
//        if (car != null && car.isAvailable()) {
//            car.setAvailable(false);
//            car.setRentalStartTime(LocalDateTime.now());
//            System.out.println("Samochód o VIN " + VIN + " został wypożyczony.");
//        } else {
//            System.out.println("Nie ma takiego samochodu lub został on już wypożyczony");
//        }
//    }
    public void listCars() {
        carRepository.getAllCars().forEach(System.out::println);
    }
}