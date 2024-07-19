package study_case.controller.controller_instructor;

import study_case.model.Instructor;
import study_case.service.service_instructor.ServiceInstructor;
import study_case.service.service_instructor.IServiceInstructor;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
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
                    System.out.println("Không có lựa chọn này");
            }
        }
    }


    public static void display() {
        for (Instructor instructor : listInstructor) {
            System.out.println(instructor);
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
        Instructor instructor = new Instructor(id, name, age, phoneNumber, email, address);
        serviceInstructor.add(instructor);
        System.out.println("Thêm mới thành công");
    }

    private static boolean isEmpty(int id) {
        return serviceInstructor.isEmpty(id);
    }

    public static void delete() {
        System.out.println("Nhập ID cần xóa");
        int id = Integer.parseInt(sc.nextLine());
        Instructor instructor = serviceInstructor.delete(id);
        if (instructor != null) {
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
            Instructor instructor = new Instructor(id, name, age, phoneNumber, email, address);
            int index = serviceInstructor.getIndex(id);
            serviceInstructor.update(index, instructor);
            System.out.println("Chỉnh sửa thành công");
        }
    }

    public static void save() {
        try {
            ObjectOutputStream data = new ObjectOutputStream(new FileOutputStream("list_instructor.ser"));
            data.writeObject(listInstructor);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
