package bai_tap_lam_them.service;

import bai_tap_lam_them.repository.RepositoryTruck;

public class ServiceTruck extends ServiceVehicle {
    public ServiceTruck() {
        repositoryVehicle = new RepositoryTruck();
    }
}
