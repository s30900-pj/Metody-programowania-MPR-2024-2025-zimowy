package pl.pjatk.car_service;

import java.time.LocalDate;

public class Reservation {
    private String vin;
    private Client client;
    private LocalDate startDate;
    private LocalDate endDate;

    public Reservation(String vin, Client client, LocalDate startDate, LocalDate endDate) {
        this.vin = vin;
        this.client = client;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getVin() {
        return vin;
    }

    public Client getClient() {
        return client;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "vin='" + vin + '\'' +
                ", client=" + client +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
