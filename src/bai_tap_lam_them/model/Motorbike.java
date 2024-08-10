package bai_tap_lam_them.model;

public class Motorbike extends Vehicle {
    private String wattage;

    public Motorbike(String licensePlate, Brand brand, String releaseDate, String owner, String wattage) {
        super(licensePlate, brand, releaseDate, owner);
        this.wattage = wattage;
    }

    public String getWattage() {
        return wattage;
    }

    public void setWattage(String wattage) {
        this.wattage = wattage;
    }

    @Override
    public String toString() {
        return "Motorbike{" +
                "wattage='" + wattage + '\'' +
                "} " + super.toString();
    }

    @Override
    public String getContent() {
        return getLicensePlate() + "," + getBrand().getContent() + "," + getReleaseDate() + "," + getOwner() + "," + getWattage();
    }
}
