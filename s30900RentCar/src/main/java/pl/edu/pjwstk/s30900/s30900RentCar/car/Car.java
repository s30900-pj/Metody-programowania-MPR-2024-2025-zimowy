package pl.edu.pjwstk.s30900.s30900RentCar.car;


public class Car {
    private String model;
    private String marka;
    private int VIN;
    private int idClass;

//    private boolean available;
//    private LocalDateTime rentalStartTime;
//    private double pricePerHour;

    public Car( int idClass, String model, String marka, int VIN) {
        this.idClass = idClass;
        this.model = model;
        this.marka = marka;
        this.VIN = VIN;
//        this.pricePerHour = pricePerHour;
//        this.available = available;
    }

    public int getIdClass() {
        return idClass;
    }

    public String getModel() {
        return model;
    }

    public String getMarka() {
        return marka;
    }

    public int getVIN() {
        return VIN;
    }

//    public boolean isAvailable() {
//        return available;
//    }

//    public LocalDateTime getRentalStartTime() {
//        return rentalStartTime;
//    }
//
//    public double getPricePerHour() {
//        return pricePerHour;
//    }
//
//    public void setAvailable(boolean available) {
//        this.available = available;
//    }
//
//    public void setRentalStartTime(LocalDateTime rentalStartTime) {
//        this.rentalStartTime = rentalStartTime;
//    }





//    @Override
//    public String toString() {
//        return String.format("Car{model='%s', marka='%s', klasa='%s', VIN=%d, available=%b, pricePerHour=%.2f}",
//                model, marka, klasa, VIN, available, pricePerHour);
//    }
}
