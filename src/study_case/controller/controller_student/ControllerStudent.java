package study_case.controller.controller_student;

import study_case.model.Student;
import study_case.service.service_student.InterfaceServiceStudent;
import study_case.service.service_student.ServiceStudent;

import java.util.LinkedList;
import java.util.Scanner;

public class ControllerStudent implements InterfaceControllerStudent {
    private static InterfaceServiceStudent studentService = new ServiceStudent();
    private static Scanner sc = new Scanner(System.in);

    @Override
    public void display() {
        LinkedList<Student> listStudents = studentService.findAll();
        for (Student student : listStudents) {
            System.out.println(student);
        }
    }

    @Override
    public void add() {
        System.out.println("Nhập ID");
        int id = Integer.parseInt(sc.nextLine());
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
        studentService.add(student);
        System.out.println("Thêm mới thành công");
    }

    @Override
    public void delete() {
        System.out.println("Nhập ID cần xóa");
        int id = Integer.parseInt(sc.nextLine());
        Student student = studentService.delete(id);
        if (student != null) {
            System.out.println("Xóa thành công");
        } else {
            System.out.println("Xóa thất bại");
        }
    }
}
