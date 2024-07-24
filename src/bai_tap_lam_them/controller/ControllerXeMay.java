package bai_tap_lam_them.controller;

import bai_tap_lam_them.model.hang_san_xuat.HangSanXuat;
import bai_tap_lam_them.model.phuong_tien.XeMay;
import bai_tap_lam_them.service.service_hang_san_xuat.IServiceHangSanXuat;
import bai_tap_lam_them.service.service_hang_san_xuat.ServiceHangSanXuat;
import bai_tap_lam_them.service.service_xe_may.IServiceXeMay;
import bai_tap_lam_them.service.service_xe_may.ServiceXeMay;

import java.util.Scanner;

public class ControllerXeMay {
    private static IServiceXeMay serviceXeMay = new ServiceXeMay();
    private static Scanner sc = new Scanner(System.in);
    private static String bienSoXe;
    private static HangSanXuat hangSanXuat;
    private static String namSanXuat;
    private static String chuSoHuu;
    private static IServiceHangSanXuat serviceHangSanXuat = new ServiceHangSanXuat();

    public static void hienThi() {
        for (XeMay xeMay : serviceXeMay.findALL()) {
            System.out.println(xeMay);
        }
    }

    public static void add() {
        System.out.println("Nhập biển số xe");
        bienSoXe = sc.nextLine();
        boolean flag = true;
        do {
            System.out.println("Chọn hãng sản xuất");
            System.out.println("" +
                    "1. Yamaha \n" +
                    "2. Honda \n" +
                    "3. Suzuki");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    for (HangSanXuat hangSanXuatXe : serviceHangSanXuat.findALL()) {
                        if (hangSanXuatXe.getTenHangSanXuat().equals("Yamaha")) {
                            hangSanXuat = hangSanXuatXe;
                        }
                    }
                    flag = false;
                    break;
                case 2:
                    for (HangSanXuat hangSanXuatXe : serviceHangSanXuat.findALL()) {
                        if (hangSanXuatXe.getTenHangSanXuat().equals("Honda")) {
                            hangSanXuat = hangSanXuatXe;
                        }
                    }
                    flag = false;
                    break;
                case 3:
                    for (HangSanXuat hangSanXuatXe : serviceHangSanXuat.findALL()) {
                        if (hangSanXuatXe.getTenHangSanXuat().equals("Suzuki")) {
                            hangSanXuat = hangSanXuatXe;
                        }
                    }
                    flag = false;
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ");
            }

        } while (flag);
        System.out.println("Nhập năm sản xuất");
        namSanXuat = sc.nextLine();
        System.out.println("Nhập chủ sở hửu");
        chuSoHuu = sc.nextLine();
        System.out.println("Nhập công suất");
        String horsepower = sc.nextLine();
        XeMay newMotorcycle = new XeMay(bienSoXe, hangSanXuat, namSanXuat, chuSoHuu, horsepower);
        serviceXeMay.findALL().add(newMotorcycle);
    }
}
