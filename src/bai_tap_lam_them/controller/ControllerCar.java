package bai_tap_lam_them.controller;

import bai_tap_lam_them.model.Brand;
import bai_tap_lam_them.model.Car;
import bai_tap_lam_them.service.ServiceBrand;
import bai_tap_lam_them.service.ServiceBrandImpl;
import bai_tap_lam_them.service.ServiceCar;
import bai_tap_lam_them.service.ServiceCarImpl;
import case_study.ulti.ValidateInputValue;

public class ControllerCar {
    private final ServiceCar SERVICE_CAR = new ServiceCarImpl();
    private Brand brand;
    private final ServiceBrand SERVICE_BRAND = new ServiceBrandImpl();

    public void display() {
        for (Car xeOto : SERVICE_CAR.findAll()) {
            System.out.println(xeOto);
        }
    }

    public void add() {
        String licensePlate = ValidateInputValue.getStringInput("Biển số xe: ");
        boolean flag = true;
        do {
            System.out.println("Chọn hãng sản xuất: ");
            System.out.println(
                    "1. Yamaha \n" +
                            "2. Honda \n" +
                            "3. Suzuki");
            int choice = ValidateInputValue.getIntInput("");
            switch (choice) {
                case 1:
                    for (Brand brand : SERVICE_BRAND.findAll()) {
                        if (brand.getName().equals("Yamaha")) {
                            this.brand = brand;
                        }
                    }
                    flag = false;
                    break;
                case 2:
                    for (Brand brand : SERVICE_BRAND.findAll()) {
                        if (brand.getName().equals("Honda")) {
                            this.brand = brand;
                        }
                    }
                    flag = false;
                    break;
                case 3:
                    for (Brand brand : SERVICE_BRAND.findAll()) {
                        if (brand.getName().equals("Suzuki")) {
                            this.brand = brand;
                        }
                    }
                    flag = false;
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }

        } while (flag);
        String releaseDate = ValidateInputValue.getStringInput("Năm sản xuất: ");
        String owner = ValidateInputValue.getStringInput("Chủ sở hửu: ");
        int seatingCapacity = ValidateInputValue.getIntInput("Chỗ ngồi: ");
        String carModel = ValidateInputValue.getStringInput("Kiểu xe: ");
        Car newCar = new Car(licensePlate, brand, releaseDate, owner, seatingCapacity, carModel);
        SERVICE_CAR.findAll().add(newCar);
    }

    public boolean search(String inputSearch) {
        boolean flag = false;
        for (Car car : SERVICE_CAR.findAll()) {
            if (car.getLicensePlate().toLowerCase().contains(inputSearch.toLowerCase())) {
                System.out.println(car);
                flag = true;
            }
        }
        return flag;
    }
}
