package org.example;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CarStorage {
    private static CarStorage instance;

    private List<Car> carList = new ArrayList<>();

    public static CarStorage getInstance(){
        if ( instance == null){
            instance = new CarStorage();
        }
        return instance;
    }
    public void addcar(Car samochod) {
        carList.add(samochod);
    }

    public List<Car> getCarList() {
        return carList;
    }
}
