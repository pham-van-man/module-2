package bai_tap_lam_them.service;

import bai_tap_lam_them.repository.RepositoryMotorbike;

public class ServiceMotorbike extends ServiceVehicle {
    public ServiceMotorbike() {
        repositoryVehicle = new RepositoryMotorbike();
    }
}
