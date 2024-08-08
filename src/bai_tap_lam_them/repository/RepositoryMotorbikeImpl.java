package bai_tap_lam_them.repository;

import bai_tap_lam_them.model.Brand;
import bai_tap_lam_them.model.Motorbike;

import java.util.LinkedList;
import java.util.List;

public class RepositoryMotorbikeImpl implements RepositoryMotorbike {
    private static final List<Motorbike> MOTORBIKE_LIST = new LinkedList<>();
    private static final RepositoryBrand REPOSITORY_BRAND = new RepositoryBrandImpl();
    private static final List<Brand> BRAND_LIST = REPOSITORY_BRAND.findAll();

    static {
        MOTORBIKE_LIST.add(new Motorbike("123123", BRAND_LIST.get(0), "2020", "Pham Van Man", "150cc"));
        MOTORBIKE_LIST.add(new Motorbike("456456", BRAND_LIST.get(1), "2020", "Pham Van Man", "150cc"));
        MOTORBIKE_LIST.add(new Motorbike("789789", BRAND_LIST.get(2), "2020", "Pham Van Man", "150cc"));
    }

    public List<Motorbike> findAll() {
        return MOTORBIKE_LIST;
    }
}
