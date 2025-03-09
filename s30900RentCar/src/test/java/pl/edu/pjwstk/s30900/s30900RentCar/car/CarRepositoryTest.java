package pl.edu.pjwstk.s30900.s30900RentCar.car;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class CarRepositoryTest {
    private Object List;
    CarRepository carRepository= new CarRepository(List<Car> cars);
    @Test
    public void shouldGetAllCars() {
        //given



        //when

        java.util.List<Car> selectedCars=carRepository.getAllCars();
        //then
        assertThat(selectedCars).isNotNull();
    }
}