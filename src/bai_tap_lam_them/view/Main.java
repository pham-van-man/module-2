package bai_tap_lam_them.view;

import bai_tap_lam_them.controller.ControllerMotorbike;
import bai_tap_lam_them.controller.ControllerCar;
import bai_tap_lam_them.controller.ControllerTruck;
import case_study.ulti.ValidateInputValue;

public class Main {
    private final static ControllerMotorbike motorbike = new ControllerMotorbike();
    private final static ControllerCar car = new ControllerCar();
    private final static ControllerTruck truck = new ControllerTruck();

    public static void main(String[] args) {
        do {
            System.out.println("1. Xem danh sách \n" +
                    "2. Thêm phương tiện \n" +
                    "3. Xóa phương tiện \n" +
                    "4. Tìm kiếm \n" +
                    "5. Thoát");
            int choice = ValidateInputValue.getIntInput("");
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

    public static void display() {
        do {
            System.out.println("1. Danh sách xe tải \n" +
                    "2. Danh sách xe oto \n" +
                    "3. Danh sách xe máy \n" +
                    "4. Thoát");
            int choice = ValidateInputValue.getIntInput("");
            switch (choice) {
                case 1:
                    truck.display();
                    break;
                case 2:
                    car.display();
                    break;
                case 3:
                    motorbike.display();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ");
            }
        } while (true);
    }

    public static void search() {
        System.out.println("Tìm kiếm");
        String inputSearch = ValidateInputValue.getStringInput("");
        boolean flag1 = car.search(inputSearch);
        System.out.println();
        boolean flag2 = motorbike.search(inputSearch);
        System.out.println();
        boolean flag3 = truck.search(inputSearch);
        if (!flag1 && !flag2 && !flag3) {
            System.out.println("Không tìm thấy");
        }
    }

    public static void delete() {
        do {
            System.out.println("1. Xóa xe tải \n" +
                    "2. Xóa xe máy \n" +
                    "3. Xóa xe oto \n" +
                    "4. Thoát");
            int choice = ValidateInputValue.getIntInput("");
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

    public static void add() {
        do {
            System.out.println("1. Thêm xe tải \n" +
                    "2. Thêm xe máy \n" +
                    "3. Thêm xe oto \n" +
                    "4. Thoát");
            int choice = ValidateInputValue.getIntInput("");
            switch (choice) {
                case 1:
                    truck.add();
                    break;
                case 2:
                    motorbike.add();
                    break;
                case 3:
                    car.add();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ");
            }
        } while (true);
    }
}