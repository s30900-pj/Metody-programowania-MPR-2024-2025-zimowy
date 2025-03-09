package pl.pjatk.car_service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Car {
    private String marka;
    private String model;
    private String vin;
    private String klasa;
    private List<Reservation> reservations;

    public Car(String marka, String model, String vin, String klasa) {
        this.marka = marka;
        this.model = model;
        this.vin = vin;
        this.klasa = klasa;
        this.reservations = new ArrayList<>();
    }

    public String getVin() {
        return vin;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public boolean isAvailableInPeriod(LocalDate startDate, LocalDate endDate) {
        for (Reservation reservation : reservations) {
            if (!(endDate.isBefore(reservation.getStartDate()) || startDate.isAfter(reservation.getEndDate()))) {
                return false; // Nakładanie się dat
            }
        }
        return true;
    }

    public void addReservation(Reservation reservation) {
        reservations.add(reservation);
    }

    @Override
    public String toString() {
        return "Car{" +
                "marka='" + marka + '\'' +
                ", model='" + model + '\'' +
                ", vin='" + vin + '\'' +
                ", klasa='" + klasa + '\'' +
                '}';
    }
}
