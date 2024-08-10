package bai_tap_lam_them.controller;

import bai_tap_lam_them.model.Brand;
import bai_tap_lam_them.model.Car;
import bai_tap_lam_them.model.Vehicle;
import bai_tap_lam_them.service.ServiceBrand;
import bai_tap_lam_them.service.ServiceBrandImpl;
import bai_tap_lam_them.service.ServiceCar;
import bai_tap_lam_them.service.ServiceVehicle;
import case_study.ulti.ValidateInputValue;

import java.util.List;

public class ControllerCar {
    private final ServiceVehicle SERVICE = new ServiceCar();
    private final String[] TYPE = {"Du lich", "Xe khach"};
    private final ServiceBrand SERVICE_BRAND = new ServiceBrandImpl();
    private final List<Brand> brandList = SERVICE_BRAND.findAll();

    public void display() {
        for (Vehicle vehicle : SERVICE.findAll()) {
            System.out.println(vehicle);
        }
    }

    public void add() {
        String licensePlate = ValidateInputValue.getStringInput("Biển số: ");
        Brand brand = null;
        do {
            System.out.println("Chọn hãng sản xuất: ");
            System.out.println("1. Yamaha");
            System.out.println("2. Honda");
            System.out.println("3. Suzuki");
            int choice = ValidateInputValue.getIntInput("");
            switch (choice) {
                case 1:
                    brand = brandList.getFirst();
                    break;
                case 2:
                    brand = brandList.get(1);
                    break;
                case 3:
                    brand = brandList.getLast();
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }

        } while (brand == null);
        String releaseDate = ValidateInputValue.getStringInput("Năm sản xuất: ");
        String owner = ValidateInputValue.getStringInput("Chủ sở hửu: ");
        int seatingCapacity = ValidateInputValue.getIntInput("Chỗ ngồi: ");
        System.out.println("Kiểu xe (1. Du lịch/2.Xe Khách): ");
        String carModel = null;
        do {
            int choice = ValidateInputValue.getIntInput("");
            switch (choice) {
                case 1:
                    carModel = TYPE[0];
                    break;
                case 2:
                    carModel = TYPE[1];
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (carModel == null);
        Vehicle newCar = new Car(licensePlate, brand, releaseDate, owner, seatingCapacity, carModel);
        SERVICE.add(newCar);
    }

    public boolean search(String inputSearch) {
        boolean flag = false;
        for (Vehicle vehicle : SERVICE.findAll()) {
            if (vehicle.getLicensePlate().toLowerCase().contains(inputSearch.toLowerCase())) {
                System.out.println(vehicle);
                flag = true;
            }
        }
        return flag;
    }

    public Vehicle delete() {
        String licensePlate = ValidateInputValue.getStringInput("Biển số: ");
        Vehicle vehicle;
        if ((vehicle = SERVICE.getVehicle(licensePlate)) != null) {
            SERVICE.delete(vehicle);
            return vehicle;
        } else {
            return null;
        }
    }
}
