package study_case.controller.controller_instructor;

import study_case.model.Instructor;
import study_case.service.service_instructor.ServiceInstructor;
import study_case.service.service_instructor.IServiceInstructor;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;

public class ControllerInstructor {
    private static IServiceInstructor serviceInstructor = new ServiceInstructor();
    private static LinkedList<Instructor> listInstructor = serviceInstructor.findAll();
    private static Scanner sc = new Scanner(System.in);

    public static void teacherMenu() {
        while (true) {
            System.out.println("Chọn chức năng \n" +
                    "1.Hiển thị\n" +
                    "2.Thêm mới \n" +
                    "3.Chỉnh sửa\n" +
                    "4.Xóa\n" +
                    "5.Lưu\n" +
                    "6.Thoát\n");
            int choose = Integer.parseInt(sc.nextLine());
            switch (choose) {
                case 1:
                    display();
                    break;
                case 2:
                    add();
                    break;
                case 3:
                    edit();
                    break;
                case 4:
                    delete();
                    break;
                case 5:
                    save();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ");
            }
        }
    }


    public static void display() {
        while (true) {
            for (Instructor instructor : listInstructor) {
                System.out.println(instructor);
            }
            System.out.println("Chọn chức năng \n" +
                    "1.Sắp xếp theo tên\n" +
                    "2.Sắp xếp theo ID \n" +
                    "3.Thoát\n");
            int choose = Integer.parseInt(sc.nextLine());
            switch (choose) {
                case 1:
                    sortByName();
                    break;
                case 2:
                    sortByID();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ");
            }
        }
    }

    private static void sortByID() {
        Comparator<Instructor> comparator = Comparator
                .comparing(Instructor::getId)
                .thenComparing(Instructor::getName);
        listInstructor.sort(comparator);
    }

    private static void sortByName() {
        Comparator<Instructor> comparator = Comparator
                .comparing(Instructor::getName)
                .thenComparing(Instructor::getId);
        listInstructor.sort(comparator);
    }

    public static void add() {
        int id = getIntInput("Nhập ID");
        if (isEmpty(id)) {
            System.out.println("ID đã tồn tại");
            return;
        }
        String name = getStringInput("Nhập tên");
        int age = getIntInput("Nhập tuổi");
        String phoneNumber = getStringInput("Nhập số điện thoại");
        String email = getStringInput("Nhâp Email");
        String address = getStringInput("Nhập địa chỉ");
        Instructor instructor = new Instructor(id, name, age, phoneNumber, email, address);
        serviceInstructor.add(instructor);
        System.out.println("Thêm mới thành công");
    }

    private static boolean isEmpty(int id) {
        return serviceInstructor.isEmpty(id);
    }

    public static void delete() {
        int id = getIntInput("Nhập ID cần xóa");
        Instructor instructor = serviceInstructor.delete(id);
        if (instructor != null) {
            System.out.println("Xóa thành công");
        } else {
            System.out.println("Xóa thất bại");
        }
    }

    public static void edit() {
        int id = getIntInput("Nhập ID cần chỉnh sửa");
        if (!isEmpty(id)) {
            System.out.println("Chỉnh sửa thất bại");
        } else {
            String name = getStringInput("Nhập tên");
            int age = getIntInput("Nhập tuổi");
            String phoneNumber = getStringInput("Nhập số điện thoại");
            String email = getStringInput("Nhâp Email");
            String address = getStringInput("Nhập địa chỉ");
            Instructor instructor = new Instructor(id, name, age, phoneNumber, email, address);
            int index = serviceInstructor.getIndex(id);
            serviceInstructor.update(index, instructor);
            System.out.println("Chỉnh sửa thành công");
        }
    }

    public static void save() {
        serviceInstructor.updateData();
    }

    public static int getIntInput(String prompt) {
        int value;
        while (true) {
            try {
                System.out.println(prompt);
                value = Integer.parseInt(sc.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Dữ liệu không hợp lệ");
            }
        }
        return value;
    }

    public static String getStringInput(String prompt) {
        while (true) {
            System.out.println(prompt);
            String value = sc.nextLine().trim();
            if (!value.isEmpty()) {
                value = value.replaceAll("\\s+", " ");
                return value;
            }
            System.out.println("Dữ liệu không hợp lệ");
        }
    }

}
