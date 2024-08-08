package bai_tap_lam_them.model;

public class Truck extends Vehicle {
    private String payload;

    public Truck(String licensePlate, Brand brand, String releaseDate, String owner, String payload) {
        super(licensePlate, brand, releaseDate, owner);
        this.payload = payload;
    }

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }

    @Override
    public String toString() {
        return "Truck{" +
                "payload='" + payload + '\'' +
                "} " + super.toString();
    }
}
