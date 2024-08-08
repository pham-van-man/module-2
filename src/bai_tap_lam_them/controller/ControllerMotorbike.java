package bai_tap_lam_them.controller;

import bai_tap_lam_them.model.Brand;
import bai_tap_lam_them.model.Motorbike;
import bai_tap_lam_them.service.ServiceBrand;
import bai_tap_lam_them.service.ServiceBrandImpl;
import bai_tap_lam_them.service.IServiceMotorbike;
import bai_tap_lam_them.service.ServiceMotorbikeImpl;

import java.util.Scanner;

public class ControllerMotorbike {
    private final IServiceMotorbike SERVICE_MOTORBIKE = new ServiceMotorbikeImpl();
    private final Scanner SC = new Scanner(System.in);
    private Brand brand;
    private final ServiceBrand SERVICE_BRAND = new ServiceBrandImpl();

    public void display() {
        for (Motorbike xeMay : SERVICE_MOTORBIKE.findAll()) {
            System.out.println(xeMay);
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
        System.out.println("Nhập công suất");
        String horsepower = SC.nextLine();
        Motorbike newMotorcycle = new Motorbike(licensePlate, brand, releaseDate, owner, horsepower);
        SERVICE_MOTORBIKE.findAll().add(newMotorcycle);
    }

    public boolean search(String inputSearch) {
        boolean flag = false;
        for (Motorbike xeMay : SERVICE_MOTORBIKE.findAll()) {
            if (xeMay.getLicensePlate().toLowerCase().contains(inputSearch.toLowerCase())) {
                System.out.println(xeMay);
                flag = true;
            }
        }
        return flag;
    }
}
