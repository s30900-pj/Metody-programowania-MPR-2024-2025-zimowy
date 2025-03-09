package org.example;

import java.util.ArrayList;
import java.util.List;
public class CarStorageSingleton {
    private List<Car> cars = new ArrayList<>();

    private CarStorageSingleton() {

    }

    public List<Car> getCars() {
        return cars;
    }

    public void addCar(Car car) {
        cars.add(car);
    }
}
