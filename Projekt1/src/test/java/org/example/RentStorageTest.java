package org.example;

import org.example.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;

import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

class RentStorageTest {

    private CarStorage carStorage;
    private RentStorage rentStorage;
    private RentalService rentalService;

    @BeforeEach
    void init() {
        carStorage = new CarStorage();
        rentStorage = new RentStorage();
        rentalService = new RentalService(carStorage, rentStorage);
    }

    @Test
    void IsprintRentList() {
        var car = new Car("Audi", "A7", 324552, Type.Sedan);
        carStorage.addcar(car);

    }
}