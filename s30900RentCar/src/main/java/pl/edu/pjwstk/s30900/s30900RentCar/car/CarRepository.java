package pl.edu.pjwstk.s30900.s30900RentCar.car;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class CarRepository {
    public List<Car> cars = new ArrayList<>();
public CarRepository(List<Car> cars) {
    this.cars = cars;
    cars.add(new Car(1,"asterka","opel",1234));
    cars.add(new Car(1,"polo","volkswagen",1234));
    cars.add(new Car(2,"panda","fiat",5678));
    cars.add(new Car(3,"octavia","skoda",9012));
    cars.add (new Car(4,"zafira","opel",3456));
}
    public void addCar(Car car) {
        cars.add(car);
    }

    public List<Car> getAllCars() {
        return cars;
    }
}
