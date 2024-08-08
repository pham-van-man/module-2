package bai_tap_lam_them.controller;

import bai_tap_lam_them.model.Brand;
import bai_tap_lam_them.model.Truck;
import bai_tap_lam_them.service.ServiceVehicle;
import bai_tap_lam_them.service.ServiceBrand;
import bai_tap_lam_them.service.ServiceBrandImpl;
import bai_tap_lam_them.service.ServiceTruckImpl;

import java.util.Scanner;

public class ControllerTruck {
    private final ServiceVehicle<Truck> SERVICE_TRUCK = new ServiceTruckImpl();
    private final Scanner SC = new Scanner(System.in);
    private Brand brand;
    private final ServiceBrand SERVICE_BRAND = new ServiceBrandImpl();

    public void display() {
        for (Truck truck : SERVICE_TRUCK.findAll()) {
            System.out.println(truck);
        }
    }

    public void add() {
        System.out.println("Nhập biển số xe");
        String licensePlate = SC.nextLine();
        boolean flag = true;
        do {
            System.out.println("Chọn hãng sản xuất");
            System.out.println("" +
                    "1. Yamaha \n" +
                    "2. Honda \n" +
                    "3. Suzuki");
            int choice = Integer.parseInt(SC.nextLine());
            switch (choice) {
                case 1:
                    for (Brand hangSanXuatXe : SERVICE_BRAND.findAll()) {
                        if (hangSanXuatXe.getName().equals("Yamaha")) {
                            brand = hangSanXuatXe;
                        }
                    }
                    flag = false;
                    break;
                case 2:
                    for (Brand hangSanXuatXe : SERVICE_BRAND.findAll()) {
                        if (hangSanXuatXe.getName().equals("Honda")) {
                            brand = hangSanXuatXe;
                        }
                    }
                    flag = false;
                    break;
                case 3:
                    for (Brand hangSanXuatXe : SERVICE_BRAND.findAll()) {
                        if (hangSanXuatXe.getName().equals("Suzuki")) {
                            brand = hangSanXuatXe;
                        }
                    }
                    flag = false;
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ");
            }

        } while (flag);
        System.out.println("Nhập năm sản xuất");
        String releaseDate = SC.nextLine();
        System.out.println("Nhập chủ sở hửu");
        String owner = SC.nextLine();
        System.out.println("Nhập trọng tải");
        String payload = SC.nextLine();
        Truck newTruck = new Truck(licensePlate, brand, releaseDate, owner, payload);
        SERVICE_TRUCK.findAll().add(newTruck);
    }

    public boolean search(String inputSearch) {
        boolean flag = false;
        for (Truck xeTai : SERVICE_TRUCK.findAll()) {
            if (xeTai.getLicensePlate().toLowerCase().contains(inputSearch.toLowerCase())) {
                System.out.println(xeTai);
                flag = true;
            }
        }
        return flag;
    }
}
