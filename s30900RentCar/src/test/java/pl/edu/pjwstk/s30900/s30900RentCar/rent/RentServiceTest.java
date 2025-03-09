package pl.edu.pjwstk.s30900.s30900RentCar.rent;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.edu.pjwstk.s30900.s30900RentCar.Client;
import pl.edu.pjwstk.s30900.s30900RentCar.car.Car;
import pl.edu.pjwstk.s30900.s30900RentCar.klasa.KlasaService;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class RentServiceTest {
    @Mock
    private RentRepository rentRepository;
    @Mock
    private KlasaService klasaService;
    @InjectMocks
    private RentService rentService;

    @Test
    void shouldCalcultePrice(){
        //given
        Rent rent= new Rent(1,new Car(1,"blabla","2s",1234),new Client(), LocalDate.now(),LocalDate.now().plusDays(5));

        //when

        //then
    }
}