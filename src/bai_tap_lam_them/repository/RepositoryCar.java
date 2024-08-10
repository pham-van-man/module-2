package bai_tap_lam_them.repository;

import bai_tap_lam_them.ulti.CreateCar;

public class RepositoryCar extends RepositoryVehicle {
    public RepositoryCar() {
        path = "src/bai_tap_lam_them/data/car.csv";
        create = new CreateCar();
    }
}
