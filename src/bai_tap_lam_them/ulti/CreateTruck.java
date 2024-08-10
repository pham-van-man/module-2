package bai_tap_lam_them.ulti;

import bai_tap_lam_them.model.Brand;
import bai_tap_lam_them.model.Truck;
import bai_tap_lam_them.model.Vehicle;

public class CreateTruck implements Create {
    @Override
    public Vehicle getVehicle(String[] content) {
        return new Truck(content[0], new Brand(content[1], content[2], content[3]), content[4], content[5], content[6]);
    }
}
