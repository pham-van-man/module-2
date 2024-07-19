package study_case.controller.controller_student;

import study_case.model.Student;
import study_case.service.service_student.IServiceStudent;
import study_case.service.service_student.ServiceStudent;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
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
                    System.out.println("Không có lựa chọn này");
            }
        }
    }

    public static void display() {
        for (Student student : listStudents) {
            System.out.println(student);
        }
    }

    public static void add() {
        System.out.println("Nhập ID");
        int id = Integer.parseInt(sc.nextLine());
        if (isEmpty(id)) {
            System.out.println("ID đã tồn tại");
            return;
        }
        System.out.println("Nhập tên");
        String name = sc.nextLine();
        System.out.println("Nhập tuổi");
        int age = Integer.parseInt(sc.nextLine());
        System.out.println("Nhập số điện thoại");
        String phoneNumber = sc.nextLine();
        System.out.println("Nhập Email");
        String email = sc.nextLine();
        System.out.println("Nhập địa chỉ");
        String address = sc.nextLine();
        Student student = new Student(id, name, age, phoneNumber, email, address);
        serviceStudent.add(student);
        System.out.println("Thêm mới thành công");
    }

    public static void delete() {
        System.out.println("Nhập ID cần xóa");
        int id = Integer.parseInt(sc.nextLine());
        Student student = serviceStudent.delete(id);
        if (student != null) {
            System.out.println("Xóa thành công");
        } else {
            System.out.println("Xóa thất bại");
        }
    }

    public static void edit() {
        System.out.println("Nhập ID cần chỉnh sửa");
        int id = Integer.parseInt(sc.nextLine());
        if (!isEmpty(id)) {
            System.out.println("Chỉnh sửa thất bại");
        } else {
            System.out.println("Nhập tên");
            String name = sc.nextLine();
            System.out.println("Nhập tuổi");
            int age = Integer.parseInt(sc.nextLine());
            System.out.println("Nhập số điện thoại");
            String phoneNumber = sc.nextLine();
            System.out.println("Nhập Email");
            String email = sc.nextLine();
            System.out.println("Nhập địa chỉ");
            String address = sc.nextLine();
            Student students = new Student(id, name, age, phoneNumber, email, address);
            int index = listStudents.indexOf(id);
            serviceStudent.update(index, students);
            System.out.println("Chỉnh sửa thành công");
        }
    }

    private static boolean isEmpty(int id) {
        return serviceStudent.isEmpty(id);
    }

    public static void save() {
        try {
            ObjectOutputStream data = new ObjectOutputStream(new FileOutputStream("list_student.ser"));
            data.writeObject(listStudents);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}