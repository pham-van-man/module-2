package bai_tap_lam_them.service;

import bai_tap_lam_them.repository.RepositoryCar;

public class ServiceCar extends ServiceVehicle {
    public ServiceCar() {
        repositoryVehicle = new RepositoryCar();
    }
}
