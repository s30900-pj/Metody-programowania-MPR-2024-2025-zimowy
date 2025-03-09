package org.example;

import org.example.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;
class RentalServiceTest {
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
    void estimatePriceIs3000() {
        //Given
        Car car = new Car("Skoda", "Octavia", 231323123, Type.Kombi);
        carStorage.addcar(car);
        LocalDate dateFrom = LocalDate.of(2023, 12, 4);
        LocalDate dateTo = LocalDate.of(2023, 12, 9);
        //When
        double price = rentalService.estimatePrice(car.getVin(), dateFrom, dateTo);
        //Then
        assertEquals(3000, price);
    }
    @Test
    void estimatePriceIsNot3000() {
        //Given
        var car = new Car("Skoda", "Octavia", 231323123, Type.Kombi);
        carStorage.addcar(car);
        LocalDate dateFrom = LocalDate.of(2023, 11, 20);
        LocalDate dateTo = LocalDate.now();
        //When
        double price = rentalService.estimatePrice(car.getVin(), dateFrom, dateTo);
        //Then
        assertNotEquals(2000, price);
    }

    @Test
    void IsCarExist(){
        //given
        var car = new Car("Audi", "A7", 324552, Type.Sedan);
        carStorage.addcar(car);
        //when
        boolean isExist = rentalService.carExist(car.getVin());
        //then
        assertTrue(isExist);
    }
    @Test
    void IsCarNotExist(){
        //given
        var car = new Car("Audi", "A7", 324552, Type.Sedan);
        //when
        boolean isExist = rentalService.carExist(car.getVin());
        //then
        assertFalse(isExist);
    }



}