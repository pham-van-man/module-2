package bai_tap_lam_them.repository;

import bai_tap_lam_them.ulti.CreateMotorbike;

public class RepositoryMotorbike extends RepositoryVehicle {
    public RepositoryMotorbike() {
        path = "src/bai_tap_lam_them/data/motorbike.csv";
        create = new CreateMotorbike();
    }
}
