package bai_tap_lam_them.service;

import bai_tap_lam_them.model.Brand;
import bai_tap_lam_them.repository.RepositoryBrand;
import bai_tap_lam_them.repository.RepositoryBrandImpl;

import java.util.ArrayList;

public class ServiceBrandImpl implements ServiceBrand {
    RepositoryBrand repositoryBrand = new RepositoryBrandImpl();

    @Override
    public ArrayList<Brand> findAll() {
        return repositoryBrand.findAll();
    }
}
