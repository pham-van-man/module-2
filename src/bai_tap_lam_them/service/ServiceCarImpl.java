package bai_tap_lam_them.service;

import bai_tap_lam_them.model.Car;
import bai_tap_lam_them.repository.RepositoryCar;
import bai_tap_lam_them.repository.RepositoryCarImpl;

import java.util.List;

public class ServiceCarImpl implements ServiceCar {
    private final RepositoryCar REPOSITORY_CAR = new RepositoryCarImpl();

    @Override
    public List<Car> findAll() {
        return REPOSITORY_CAR.findAll();
    }
}
