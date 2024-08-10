package bai_tap_lam_them.ulti;


import bai_tap_lam_them.model.Brand;
import bai_tap_lam_them.model.Car;
import bai_tap_lam_them.model.Vehicle;

public class CreateCar implements Create {
    @Override
    public Vehicle getVehicle(String[] content) {
        return new Car(content[0], new Brand(content[1], content[2], content[3]), content[4], content[5], Integer.parseInt(content[6]), content[7]);
    }
}
