package bai_tap_lam_them.repository;

import bai_tap_lam_them.model.Brand;
import bai_tap_lam_them.model.Truck;

import java.util.LinkedList;
import java.util.List;

public class RepositoryTruckImpl implements RepositoryTruck {
    private static final List<Truck> TRUCK_LIST = new LinkedList<>();
    private static final RepositoryBrand REPOSITORY_BRAND = new RepositoryBrandImpl();
    private static final List<Brand> BRAND_LIST = REPOSITORY_BRAND.findAll();

    static {
        TRUCK_LIST.add(new Truck("123123", BRAND_LIST.get(0), "2020", "Pham Van Man", "5 tấn"));
        TRUCK_LIST.add(new Truck("456456", BRAND_LIST.get(1), "2020", "Pham Van Man", "5 tấn"));
        TRUCK_LIST.add(new Truck("789789", BRAND_LIST.get(2), "2020", "Pham Van Man", "5 tấn"));
    }

    @Override
    public List<Truck> findAll() {
        return TRUCK_LIST;
    }
}
