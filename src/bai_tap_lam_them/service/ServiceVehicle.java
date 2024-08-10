package bai_tap_lam_them.service;

import bai_tap_lam_them.model.Vehicle;
import bai_tap_lam_them.repository.RepositoryVehicle;

import java.util.List;

public abstract class ServiceVehicle {
    protected RepositoryVehicle repositoryVehicle;

    public List<Vehicle> findAll() {
        return repositoryVehicle.findAll();
    }

    public void add(Vehicle vehicle) {
        repositoryVehicle.add(vehicle);
    }

    public void delete(Vehicle vehicle) {
        repositoryVehicle.delete(vehicle);
    }

    public Vehicle getVehicle(String licensePlate) {
        return repositoryVehicle.getVehicle(licensePlate);
    }
}
