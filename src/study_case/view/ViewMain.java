package study_case.view;

import study_case.controller.controller_instructor.ControllerInstructor;
import study_case.controller.controller_student.ControllerStudent;

import java.util.Scanner;

public class ViewMain {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("Chọn đối tượng quản lý \n" +
                    "1.Student\n" +
                    "2.Teacher \n" +
                    "3.Thoát\n");
            int choose = Integer.parseInt(sc.nextLine());
            switch (choose) {
                case 1:
                    ControllerStudent.studentMenu();
                    break;
                case 2:
                    ControllerInstructor.teacherMenu();
                    break;
                case 3:
                    System.exit(0);
                default:
                    System.out.println("Lựa chọn không hợp lệ");
            }
        }
    }
}
