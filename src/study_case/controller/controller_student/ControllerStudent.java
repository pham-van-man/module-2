package study_case.controller.controller_student;

import study_case.model.Student;
import study_case.service.service_student.IServiceStudent;
import study_case.service.service_student.ServiceStudent;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;

public class ControllerStudent {
    private static IServiceStudent serviceStudent = new ServiceStudent();
    private static LinkedList<Student> listStudents = serviceStudent.findAll();
    private static Scanner sc = new Scanner(System.in);

    public static void studentMenu() {
        while (true) {
            System.out.println("Chọn chức năng \n" +
                    "1.Hiển thị\n" +
                    "2.Thêm mới \n" +
                    "3.Chỉnh sửa\n" +
                    "4.Xóa\n" +
                    "5.Lưu\n" +
                    "6.Tìm kiếm\n" +
                    "7.Thoát\n");
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
                    search();
                    break;
                case 7:
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ");
            }
        }
    }

    public static void display() {
        while (true) {
            for (Student student : listStudents) {
                System.out.println(student);
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
        Comparator<Student> comparator = Comparator
                .comparing(Student::getId)
                .thenComparing(Student::getName);
        serviceStudent.findAll().sort(comparator);
    }

    private static void sortByName() {
        Comparator<Student> comparator = Comparator
                .comparing(Student::getName)
                .thenComparing(Student::getId);
        serviceStudent.findAll().sort(comparator);
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
        Student student = new Student(id, name, age, phoneNumber, email, address);
        serviceStudent.add(student);
        System.out.println("Thêm mới thành công");
    }

    public static void delete() {
        int id = getIntInput("Nhập ID cần xóa");
        Student student = serviceStudent.delete(id);
        if (student != null) {
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
            Student students = new Student(id, name, age, phoneNumber, email, address);
            int index = serviceStudent.getIndex(id);
            serviceStudent.update(index, students);
            System.out.println("Chỉnh sửa thành công");
        }
    }

    private static boolean isEmpty(int id) {
        return serviceStudent.isEmpty(id);
    }

    public static void save() {
        serviceStudent.updateData();
    }

    public static int getIntInput(String prompt) {
        int value = 0;
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

    public static void search() {
        System.out.println("Tìm kiếm");
        String search = sc.nextLine();
        for (Student student : serviceStudent.findAll()) {
            if (student.getName().toLowerCase().contains(search.toLowerCase())) {
                System.out.println(student);
            }
        }
    }
}