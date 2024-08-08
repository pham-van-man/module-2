package bai_tap_lam_them.service;

import bai_tap_lam_them.model.Truck;
import bai_tap_lam_them.repository.RepositoryTruck;
import bai_tap_lam_them.repository.RepositoryTruckImpl;

import java.util.List;

public class ServiceTruckImpl implements IServiceTruck {
    private final RepositoryTruck REPOSITORY_TRUCK = new RepositoryTruckImpl();

    @Override
    public List<Truck> findAll() {
        return REPOSITORY_TRUCK.findAll();
    }
}
