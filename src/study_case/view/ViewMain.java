package study_case.view;

import study_case.controller.controller_instructor.ControllerInstructor;
import study_case.controller.controller_instructor.InterfaceControllerInstructor;
import study_case.controller.controller_student.ControllerStudent;
import study_case.controller.controller_student.InterfaceControllerStudent;

import java.util.Scanner;

public class ViewMain {
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
                case 3:
                    System.exit(0);
                default:
                    System.out.println("Khônng có lựa chọn này");
            }
        }
    }

    public static void studentMenu() {
        InterfaceControllerStudent student = new ControllerStudent();
        while (true) {
            System.out.println("Chọn chức năng \n" +
                    "1.Hiển thị\n" +
                    "2.Thêm mới \n" +
                    "3.Xóa\n" +
                    "4.Thoat\n");
            int choose = Integer.parseInt(sc.nextLine());
            switch (choose) {
                case 1:
                    student.display();
                    break;
                case 2:
                    student.add();
                    break;
                case 3:
                    student.delete();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Không có lựa chọn này");
            }
        }
    }

    public static void teacherMenu() {
        InterfaceControllerInstructor instructor = new ControllerInstructor();
        while (true) {
            System.out.println("Chọn chức năng \n" +
                    "1.Hiển thị\n" +
                    "2.Thêm mới \n" +
                    "3.Xóa\n" +
                    "4.Thoat\n");
            int choose = Integer.parseInt(sc.nextLine());
            switch (choose) {
                case 1:
                    instructor.display();
                    break;
                case 2:
                    instructor.add();
                    break;
                case 3:
                    instructor.delete();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Không có lựa chọn này");
            }
        }
    }

}
