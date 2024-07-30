package bai_tap_lam_them.view;

import bai_tap_lam_them.controller.ControllerXeMay;
import bai_tap_lam_them.controller.ControllerXeOto;
import bai_tap_lam_them.controller.ControllerXeTai;

import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);

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

    private static void display() {
        do {
            System.out.println("1. Danh sách xe tải \n" +
                    "2. Danh sách xe oto \n" +
                    "3. Danh sách xe máy \n" +
                    "4. Thoát");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    ControllerXeTai.display();
                    break;
                case 2:
                    ControllerXeOto.display();
                    break;
                case 3:
                    ControllerXeMay.display();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ");
            }
        } while (true);
    }

    private static void search() {
        System.out.println("Tìm kiếm");
        String inputSearch = sc.nextLine();
        boolean flag1 = ControllerXeOto.search(inputSearch);
        System.out.println();
        boolean flag2 = ControllerXeMay.sreach(inputSearch);
        System.out.println();
        boolean flag3 = ControllerXeTai.search(inputSearch);
        if (!flag1 && !flag2 && !flag3) {
            System.out.println("Không tìm thấy");
        }
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
                    "3. Thêm xe oto \n" +
                    "4. Thoát");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    ControllerXeTai.add();
                    break;
                case 2:
                    ControllerXeMay.add();
                    break;
                case 3:
                    ControllerXeOto.add();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ");
            }
        } while (true);
    }
}