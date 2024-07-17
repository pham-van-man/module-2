package study_case.controller.controller_instructor;

import study_case.model.Instructor;
import study_case.service.service_instructor.ServiceInstructor;
import study_case.service.service_instructor.InterfaceServiceInstructor;

import java.util.LinkedList;
import java.util.Scanner;

public class ControllerInstructor implements InterfaceControllerInstructor {
    InterfaceServiceInstructor interfaceInstructorService = new ServiceInstructor();
    Scanner sc = new Scanner(System.in);

    @Override
    public void display() {
        LinkedList<Instructor> listStudents = interfaceInstructorService.findAll();
        for (Instructor instructor : listStudents) {
            System.out.println(instructor);
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
        Instructor instructor = new Instructor(id, name, age, phoneNumber, email, address);
        interfaceInstructorService.add(instructor);
        System.out.println("Thêm mới thành công");
    }

    @Override
    public void delete() {
        System.out.println("Nhập ID cần xóa");
        int id = Integer.parseInt(sc.nextLine());
        Instructor instructor = interfaceInstructorService.delete(id);
        if (instructor != null) {
            System.out.println("Xóa thành công");
        } else {
            System.out.println("Xóa thất bại");
        }
    }
}
