package pl.edu.pjwstk.s30900.s30900RentCar.rent;


import org.springframework.stereotype.Service;
import pl.edu.pjwstk.s30900.s30900RentCar.Client;
import pl.edu.pjwstk.s30900.s30900RentCar.car.Car;
import pl.edu.pjwstk.s30900.s30900RentCar.klasa.Klasa;
import pl.edu.pjwstk.s30900.s30900RentCar.klasa.KlasaService;

import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class RentService {
    private final RentRepository rentRepository;
    private final KlasaService klasaService;


    public RentService(RentRepository rentRepository, KlasaService klasaService) {
        this.rentRepository = rentRepository;
        this.klasaService = klasaService;
    }

    public boolean availability(Car car, LocalDate from, LocalDate to) {
//metoda sortowania zapisanych wypożyczeń (szukamy tylko info o wybranym samochodzie)
        List<Rent> carRent = new ArrayList<>();
        for (Rent rent : rentRepository.getRent()) {
            if (rent.getCar().equals(car)) {
                carRent.add(rent);
            }
        }
        for (Rent rent : carRent) {
            if (rent.getFrom().isBefore(to) && rent.getTo().isAfter(from)) {
                return false;
            }
            if (rent.getFrom().equals(from) && rent.getTo().equals(to)) {
                return false;
            }
        }
        return true;
    }

    public Rent findByRentId(int RID) {
        Rent selectedRent = null;
        for (Rent rent : rentRepository.getRent()) {
            if (rent.getRentId() == RID) {
                selectedRent = rent;
            }
        }
        if (selectedRent == null) {
            throw new RuntimeException("no such car was found");
        }
        return selectedRent;
    }

    public void calculatePrice(Rent rent) {

        int classId = rent.getCar().getIdClass();
        Klasa klasa = klasaService.findByID(classId);

        LocalDate from = rent.getFrom();
        LocalDate to = rent.getTo();

        double days = Duration.between(from, to).toDays();
        double total = days * klasa.getPrice();
        System.out.println("total price for your rental is: " + total);

    }
//}

//    switch (klasa) {
//        case "super":{
//           carPrice= 100;
//           break;
//        }case "suer":{
//            carPrice= 100;
//            break;
//        }case "sper":{
//            carPrice= 100;
//            break;
//        }
//        System.out.println("koszt całkowity to:" + totalPrice);


    // , Car car,
//1 client, 2 samochód, 3 od kiedy, 4 do kiedy
    public void rent(Car car, Client client, LocalDate from, LocalDate to) {
        // car = carService.findByVIN(VIN);
        if (!availability(car, from, to)) {
            System.out.println("Nie ma takiego samochodu lub został on już wypożyczony.");
        }
        //nadawanie dpowiedniego id
        int newRentID = 1;
        for (Rent rent : rentRepository.getRent()) {
            newRentID++;
        }
        System.out.println("Samochód został wypożyczony. numer twojego wypożyczenia to:" + newRentID);
        rentRepository.addRental(new Rent(newRentID, car, client, from, to));
    }

//    public static void returnCar(int VIN) {
//        Car car = carRepository.findByVIN(VIN);
//        if (car != null && !car.isAvailable()) {
//            LocalDateTime rentalStartTime = car.getRentalStartTime();
//            long hours = Duration.between(rentalStartTime, LocalDateTime.now()).toHours();
//            if (Duration.between(rentalStartTime, LocalDateTime.now()).toMinutes() % 60 > 0) {
//                hours = (long) Math.ceil(hours + 1);
//            }
//
//            double totalPrice = hours * car.getPricePerHour();
//            car.setAvailable(true);
//            car.setRentalStartTime(null);
//
//            System.out.println("Samochód o VIN " + VIN + " został zwrócony.");
//            System.out.println("Czas: " + hours + " godzin.");
//            System.out.println("Koszt: " + totalPrice + " zł.");
//        } else {
//            System.out.println("Samochód o VIN " + VIN + " nie był wypożyczony.");
//        }
//    }

}

