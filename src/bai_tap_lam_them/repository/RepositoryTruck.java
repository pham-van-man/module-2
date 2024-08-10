package bai_tap_lam_them.repository;

import bai_tap_lam_them.ulti.CreateTruck;

public class RepositoryTruck extends RepositoryVehicle {
    public RepositoryTruck() {
        path = "src/bai_tap_lam_them/data/truck.csv";
        create = new CreateTruck();
    }
}
