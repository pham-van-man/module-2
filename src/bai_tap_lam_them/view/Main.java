package bai_tap_lam_them.view;

import bai_tap_lam_them.hang_san_xuat.HangSanXuat;
import bai_tap_lam_them.phuong_tien.Oto;
import bai_tap_lam_them.phuong_tien.XeMay;
import bai_tap_lam_them.phuong_tien.XeTai;

import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    static LinkedList<XeMay> danhSachXeMay = new LinkedList<>();
    static LinkedList<XeTai> danhSachXeTai = new LinkedList<>();
    static LinkedList<Oto> danhSachXeOto = new LinkedList<>();
    static LinkedList<HangSanXuat> danhSachHangSanXuatXe = new LinkedList<>();

    static {
        HangSanXuat yamaha = new HangSanXuat("Yamaha210", "Yamaha", "VietNam");
        HangSanXuat honda = new HangSanXuat("Honda210", "Honda", "VietNam");
        HangSanXuat suzuki = new HangSanXuat("Suzuki210", "Suzuki", "VietNam");
        danhSachHangSanXuatXe.add(yamaha);
        danhSachHangSanXuatXe.add(honda);
        danhSachHangSanXuatXe.add(suzuki);
        try (BufferedReader br = new BufferedReader(new FileReader("danhSach.txt"))) {

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void save() throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("danhSach.txt"))) {

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static Scanner sc = new Scanner(System.in);
    static String bienSoXe;
    static HangSanXuat hangSanXuat;
    static String namSanXuat;
    static String chuSoHuu;

    public static void main(String[] args) {
        do {
            System.out.println("1. Xem danh sách \n" +
                    "2. Thêm phương tiện \n" +
                    "3. Xóa phương tiện \n" +
                    "4. Tìm kiếm \n" +
                    "5. Thoát");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    display();
                    break;
                case 2:
                    add();
                    break;
                case 3:
                    delete();
                    break;
                case 4:
                    search();
                    break;
                case 5:
                    return;
            }
        } while (true);
    }

    private static void search() {
        do {
            System.out.println("1. Tìm xe tải \n" +
                    "2. Tìm xe máy \n" +
                    "3. Tìm xe Oto \n" +
                    "4. Thoát");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    return;
            }
        } while (true);
    }

    private static void delete() {
        do {
            System.out.println("1. Xóa xe tải \n" +
                    "2. Xóa xe máy \n" +
                    "3. Xóa xe oto \n" +
                    "4. Thoát");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    return;
            }
        } while (true);
    }

    private static void add() {
        do {
            System.out.println("1. Thêm xe tải \n" +
                    "2. Thêm xe máy \n" +
                    "3. Thêm oto \n" +
                    "4. Thoát");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    inPut();
                    System.out.println("Nhập trọng tải");
                    String payload = sc.nextLine();
                    XeTai newTruck = new XeTai(bienSoXe, hangSanXuat, namSanXuat, chuSoHuu, payload);
                    danhSachXeTai.add(newTruck);
                    break;
                case 2:
                    inPut();
                    System.out.println("Nhập công suất");
                    String horsepower = sc.nextLine();
                    XeMay newMotorcycle = new XeMay(bienSoXe, hangSanXuat, namSanXuat, chuSoHuu, horsepower);
                    danhSachXeMay.add(newMotorcycle);
                    break;
                case 3:
                    inPut();
                    System.out.println("Nhập số chỗ ngồi");
                    int seatingCapacity = Integer.parseInt(sc.nextLine());
                    System.out.println("Nhập Kiểm xe");
                    String carModel = sc.nextLine();
                    Oto newCar = new Oto(bienSoXe, hangSanXuat, namSanXuat, chuSoHuu, seatingCapacity, carModel);
                    danhSachXeOto.add(newCar);
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ");
            }
        } while (true);
    }

    private static void display() {
        do {
            System.out.println("1. Danh sách xe tải \n" +
                    "2. Danh sách oto \n" +
                    "3. Danh sách xe máy \n" +
                    "4. Thoát");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    System.out.println(danhSachXeTai);
                    break;
                case 2:
                    System.out.println(danhSachXeOto);
                    break;
                case 3:
                    System.out.println(danhSachXeMay);
                    break;
                case 4:
                    return;
            }
        } while (true);
    }

    private static void inPut() {
        System.out.println("Nhập biển số xe");
        bienSoXe = sc.nextLine();
        System.out.println("Chọn hãng sản xuất");
        System.out.println("" +
                "1. Yamaha \n" +
                "2. Honda \n" +
                "3. Suzuki");
        int choice = Integer.parseInt(sc.nextLine());
        switch (choice) {
            case 1:
                for (HangSanXuat hangSanXuatXe : danhSachHangSanXuatXe) {
                    if (hangSanXuatXe.getTenHangSanXuat().equals("Yamaha")) {
                        hangSanXuat = hangSanXuatXe;
                    }
                }
                break;
            case 2:
                for (HangSanXuat hangSanXuatXe : danhSachHangSanXuatXe) {
                    if (hangSanXuatXe.getTenHangSanXuat().equals("Honda")) {
                        hangSanXuat = hangSanXuatXe;
                    }
                }
                break;
            case 3:
                for (HangSanXuat hangSanXuatXe : danhSachHangSanXuatXe) {
                    if (hangSanXuatXe.getTenHangSanXuat().equals("Suzuki")) {
                        hangSanXuat = hangSanXuatXe;
                    }
                }
                break;
            case 4:
            default:
        }
        System.out.println("Nhập năm sản xuất");
        namSanXuat = sc.nextLine();
        System.out.println("Nhập chủ sở hửu");
        chuSoHuu = sc.nextLine();
    }
}