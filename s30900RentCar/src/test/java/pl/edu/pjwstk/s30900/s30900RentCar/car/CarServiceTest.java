package pl.edu.pjwstk.s30900.s30900RentCar.car;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CarServiceTest {
    @Mock
    private CarRepository carRepository;

    @InjectMocks
    private CarService carService;




    @Test
    void shouldFindByVIN(){
        //GIVEN
        int vin = 1234;
        when(carRepository.getAllCars()).thenReturn(List.of(
                new Car(1,"impreza","subaru",1234),
                new Car(1,"panda","fiat",5321),
                new Car(2,"polo","volkswagen",5344)
        ));
        //WHEN
        Car selected=carService.findByVIN(vin);
        //THEN
        assertThat(selected.getVIN()).isEqualTo(1234);
    }
}