package bai_tap_lam_them.repository;

import bai_tap_lam_them.model.Brand;
import bai_tap_lam_them.model.Car;
import bai_tap_lam_them.ulti.DataHandler;

import java.util.LinkedList;
import java.util.List;

public class RepositoryCarImpl implements RepositoryCar {
    private static final List<Car> CAR_LIST = new LinkedList<>();
    private static final RepositoryBrand REPOSITORY_BRAND = new RepositoryBrandImpl();
    private static final List<Brand> BRAND_LIST = REPOSITORY_BRAND.findAll();
    private static final String[] TYPE = {"Du lich", "Xe khach"};
    private final String PATH;
    private final DataHandler DATA_HANDLER;

    public RepositoryCarImpl() {
        PATH = "src/bai_tap_lam_them/data/car.csv";
        DATA_HANDLER = new DataHandler();
    }

    static {
        CAR_LIST.add(new Car("123123", BRAND_LIST.get(0), "2020", "Pham Van Man", 5, TYPE[0]));
        CAR_LIST.add(new Car("456456", BRAND_LIST.get(1), "2020", "Pham Van Man", 5, TYPE[0]));
        CAR_LIST.add(new Car("789789", BRAND_LIST.get(2), "2020", "Pham Van Man", 5, TYPE[0]));
    }

    @Override
    public List<Car> findAll() {
        List<String[]> listContent = DATA_HANDLER.readerString(PATH);
        List<Car> carList = new LinkedList<>();
        for (String[] content : listContent) {
            carList.add(Car.createCar(content));
        }
        return carList;
    }

    public void save(List<Car> listCar) {
        List<String> list = new LinkedList<>();
        for (Car car : listCar) {
            list.add(car.getContent());
        }
        DATA_HANDLER.writerString(list, PATH, false);
    }
}
