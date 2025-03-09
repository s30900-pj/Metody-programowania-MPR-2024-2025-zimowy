package pl.pjatk.car_service;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class CarRentals {
    private Map<String, Client> activeRentals = new HashMap<>();

    public boolean rentCar(String vin, Client client) {
        if (activeRentals.containsKey(vin)) {
            return false; // Samochód jest już wypożyczony
        }
        activeRentals.put(vin, client);
        return true;
    }

    public boolean returnCar(String vin) {
        return activeRentals.remove(vin) != null;
    }

    public Client getRenter(String vin) {
        return activeRentals.get(vin);
    }
}
