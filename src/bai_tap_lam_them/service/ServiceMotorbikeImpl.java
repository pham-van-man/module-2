package bai_tap_lam_them.service;

import bai_tap_lam_them.model.Motorbike;
import bai_tap_lam_them.repository.RepositoryMotorbike;
import bai_tap_lam_them.repository.RepositoryMotorbikeImpl;

import java.util.List;

public class ServiceMotorbikeImpl implements IServiceMotorbike {
   private final RepositoryMotorbike REPOSITORY_MOTORBIKE = new RepositoryMotorbikeImpl();

    @Override
    public List<Motorbike> findAll() {
        return REPOSITORY_MOTORBIKE.findAll();
    }
}
