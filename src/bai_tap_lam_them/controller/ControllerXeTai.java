package bai_tap_lam_them.controller;

import bai_tap_lam_them.model.hang_san_xuat.HangSanXuat;
import bai_tap_lam_them.model.phuong_tien.XeTai;
import bai_tap_lam_them.service.service_hang_san_xuat.IServiceHangSanXuat;
import bai_tap_lam_them.service.service_hang_san_xuat.ServiceHangSanXuat;
import bai_tap_lam_them.service.service_xe_tai.IServiceXeTai;
import bai_tap_lam_them.service.service_xe_tai.ServiceXeTai;

import java.util.Scanner;

public class ControllerXeTai {
    private static IServiceXeTai iServiceXeTai = new ServiceXeTai();
    private static Scanner sc = new Scanner(System.in);
    private static String bienSoXe;
    private static HangSanXuat hangSanXuat;
    private static String namSanXuat;
    private static String chuSoHuu;
    private static IServiceHangSanXuat serviceHangSanXuat = new ServiceHangSanXuat();

    public static void hienThi() {
        for (XeTai xeTai : iServiceXeTai.findALL()) {
            System.out.println(xeTai);
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
        System.out.println("Nhập trọng tải");
        String payload = sc.nextLine();
        XeTai newTruck = new XeTai(bienSoXe, hangSanXuat, namSanXuat, chuSoHuu, payload);
        iServiceXeTai.findALL().add(newTruck);
    }

    public static boolean search(String inputSearch) {
        boolean flag = false;
        for (XeTai xeTai : iServiceXeTai.findALL()) {
            if (xeTai.getBienSoXe().toLowerCase().contains(inputSearch.toLowerCase())) {
                System.out.println(xeTai);
                flag = true;
            }
        }
        return flag;
    }
}
