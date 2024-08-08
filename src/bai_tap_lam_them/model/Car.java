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
                "seatingCapacity='" + seatNumber + '\'' +
                ", carModel='" + type + '\'' +
                "} " + super.toString();
    }

    public static Car createCar(String[] content) {
        return new Car(content[0], new Brand(content[1], content[2], content[3]), content[4], content[5], Integer.parseInt(content[6]), content[7]);
    }

    public String getContent() {
        return getLicensePlate() + "," + getBrand().getContent() + "," + getReleaseDate() + "," + getOwner() + "," + getSeatNumber() + "," + getType();
    }
}
