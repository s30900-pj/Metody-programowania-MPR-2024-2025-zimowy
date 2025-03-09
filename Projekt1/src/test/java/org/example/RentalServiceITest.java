package org.example;

import org.example.RentalService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RentalServiceITest {

    @Autowired
    private RentalService rentalService;

    @Test
    void createRent() {
    }

    @Test
    void carExist() {
    }

    @Test
    void estimatePrice() {
    }
}