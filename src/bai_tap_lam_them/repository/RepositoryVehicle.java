package bai_tap_lam_them.repository;

import bai_tap_lam_them.model.Vehicle;
import bai_tap_lam_them.ulti.Create;
import bai_tap_lam_them.ulti.DataHandler;

import java.util.LinkedList;
import java.util.List;

public abstract class RepositoryVehicle {
    private final DataHandler DATA_HANDLER = new DataHandler();
    protected String path;
    protected Create create;

    public List<Vehicle> findAll() {
        List<String[]> listContent = DATA_HANDLER.readerString(path);
        List<Vehicle> vehicleListList = new LinkedList<>();
        for (String[] content : listContent) {
            vehicleListList.add(create.getVehicle(content));
        }
        return vehicleListList;
    }

    public void save(List<Vehicle> carList) {
        List<String> list = new LinkedList<>();
        for (Vehicle vehicle : carList) {
            list.add(vehicle.getContent());
        }
        DATA_HANDLER.writerString(list, path, false);
    }

    public void add(Vehicle vehicle) {
        List<String> list = new LinkedList<>();
        list.add(vehicle.getContent());
        DATA_HANDLER.writerString(list, path, true);
    }

    public void delete(Vehicle vehicle) {
        List<Vehicle> list = findAll();
        list.remove(vehicle);
        save(list);
    }


    public Vehicle getVehicle(String licensePlate) {
        List<Vehicle> list = findAll();
        for (Vehicle vehicle : list) {
            if (vehicle.getLicensePlate().equals(licensePlate)) {
                return vehicle;
            }
        }
        return null;
    }
}
