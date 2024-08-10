package bai_tap_lam_them.model;

public class Car extends Vehicle {
    private int seatNumber;
    private String type;

    public Car(String licensePlate, Brand brand, String releaseDate, String owner, int seatNumber, String type) {
        super(licensePlate, brand, releaseDate, owner);
        this.seatNumber = seatNumber;
        this.type = type;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Car{" +
                "seatNumber=" + seatNumber +
                ", type='" + type + '\'' +
                "} " + super.toString();
    }

    @Override
    public String getContent() {
        return getLicensePlate() + "," + getBrand().getContent() + "," + getReleaseDate() + "," + getOwner() + "," + getSeatNumber() + "," + getType();
    }
}
