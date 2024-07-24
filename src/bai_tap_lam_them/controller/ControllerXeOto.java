package bai_tap_lam_them.controller;

import bai_tap_lam_them.model.hang_san_xuat.HangSanXuat;
import bai_tap_lam_them.model.phuong_tien.XeOto;
import bai_tap_lam_them.service.service_hang_san_xuat.IServiceHangSanXuat;
import bai_tap_lam_them.service.service_hang_san_xuat.ServiceHangSanXuat;
import bai_tap_lam_them.service.service_xe_Oto.IServiceXeOto;
import bai_tap_lam_them.service.service_xe_Oto.ServiceXeOto;

import java.util.Scanner;

public class ControllerXeOto {
    private static IServiceXeOto serviceXeOto = new ServiceXeOto();
    private static Scanner sc = new Scanner(System.in);
    private static String bienSoXe;
    private static HangSanXuat hangSanXuat;
    private static String namSanXuat;
    private static String chuSoHuu;
    private static IServiceHangSanXuat serviceHangSanXuat = new ServiceHangSanXuat();

    public static void hienThi() {
        for (XeOto xeOto : serviceXeOto.findALL()) {
            System.out.println(xeOto);
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
        System.out.println("Nhập số chỗ ngồi");
        int seatingCapacity = Integer.parseInt(sc.nextLine());
        System.out.println("Nhập Kiểm xe");
        String carModel = sc.nextLine();
        XeOto newCar = new XeOto(bienSoXe, hangSanXuat, namSanXuat, chuSoHuu, seatingCapacity, carModel);
        serviceXeOto.findALL().add(newCar);
    }
}
