package study_case.controller;

import study_case.service.IStudentService;
import study_case.service.StudentService;
import study_case.view.VStudent;

import java.util.Scanner;

public class CTLStudent {
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
                    break;
                default:
                    System.exit(0);
                    break;
            }
        }
    }

    public static void studentMenu() {
        IStudentService studentService = new StudentService();
        while (true) {
            System.out.println("Chọn chức năng \n" +
                    "1.Hiển thị\n" +
                    "2.Thêm mới \n" +
                    "3.Xóa\n" +
                    "4.Thoat\n");
            int choose = Integer.parseInt(sc.nextLine());
            switch (choose) {
                case 1:
                    VStudent.displayListStudent();
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
}
