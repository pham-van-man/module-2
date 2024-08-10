package bai_tap_lam_them.controller;

import bai_tap_lam_them.model.Brand;
import bai_tap_lam_them.model.Motorbike;
import bai_tap_lam_them.model.Vehicle;
import bai_tap_lam_them.service.ServiceBrand;
import bai_tap_lam_them.service.ServiceBrandImpl;
import bai_tap_lam_them.service.ServiceMotorbike;
import bai_tap_lam_them.service.ServiceVehicle;
import case_study.ulti.ValidateInputValue;

public class ControllerMotorbike {
    private final ServiceVehicle SERVICE = new ServiceMotorbike();
    private Brand brand;
    private final ServiceBrand SERVICE_BRAND = new ServiceBrandImpl();

    public void display() {
        for (Vehicle vehicle : SERVICE.findAll()) {
            System.out.println(vehicle);
        }
    }

    public void add() {
        String licensePlate = ValidateInputValue.getStringInput("Biển số xe: ");
        boolean flag = true;
        do {
            System.out.println("Chọn hãng sản xuất: ");
            System.out.println("1. Yamaha");
            System.out.println("2. Honda");
            System.out.println("3. Suzuki");
            int choice = ValidateInputValue.getIntInput("");
            switch (choice) {
                case 1:
                    for (Brand brand : SERVICE_BRAND.findAll()) {
                        if (brand.getName().equals("Yamaha")) {
                            this.brand = brand;
                            break;
                        }
                    }
                    flag = false;
                    break;
                case 2:
                    for (Brand brand : SERVICE_BRAND.findAll()) {
                        if (brand.getName().equals("Honda")) {
                            this.brand = brand;
                            break;
                        }
                    }
                    flag = false;
                    break;
                case 3:
                    for (Brand brand : SERVICE_BRAND.findAll()) {
                        if (brand.getName().equals("Suzuki")) {
                            this.brand = brand;
                            break;
                        }
                    }
                    flag = false;
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ");
            }

        } while (flag);
        String releaseDate = ValidateInputValue.getStringInput("Năm sản xuất: ");
        String owner = ValidateInputValue.getStringInput("Chủ sở hửu: ");
        String horsepower = ValidateInputValue.getStringInput("Công suất: ");
        Vehicle newMotorcycle = new Motorbike(licensePlate, brand, releaseDate, owner, horsepower);
        SERVICE.add(newMotorcycle);
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
