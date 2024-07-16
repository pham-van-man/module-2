package study_case.controller;

import study_case.view.StudentService;
import study_case.view.TeacherService;

import java.util.Scanner;

public class MainController {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("Chọn đối tượng quản lý \n" +
                    "1.Student\n" +
                    "2.Teacher \n" +
                    "3.Thoat\n");
            int choose = Integer.parseInt(sc.nextLine());
            switch (choose) {
                case 1:
                    studentMenu();
                    break;
                case 2:
                    teacherMenu();
                    break;
                default:
                    System.exit(0);
            }
        }
    }

    public static void studentMenu() {
        StudentService studentService = new StudentService();
        while (true) {
            System.out.println("Chọn chức năng \n" +
                    "1.Hiển thị\n" +
                    "2.Thêm mới \n" +
                    "3.Xóa\n" +
                    "4.Thoat\n");
            int choose = Integer.parseInt(sc.nextLine());
            switch (choose) {
                case 1:
                    studentService.display();
                    break;
                case 2:
                    studentService.add();
                    break;
                case 3:
                    studentService.delete();
                    break;
                default:
                    return;
            }
        }
    }

    public static void teacherMenu() {
        TeacherService teacherService = new TeacherService();
        while (true) {
            System.out.println("Chọn chức năng \n" +
                    "1.Hiển thị\n" +
                    "2.Thêm mới \n" +
                    "3.Xóa\n" +
                    "4.Thoat\n");
            int choose = Integer.parseInt(sc.nextLine());
            switch (choose) {
                case 1:
                    teacherService.display();
                    break;
                case 2:
                    teacherService.add();
                    break;
                case 3:
                    teacherService.delete();
                    break;
                default:
                    return;
            }
        }
    }
}
