package study_case.view;

import study_case.controller.ControllerInstructor;
import study_case.controller.ControllerStudent;
import study_case.util.Validate;

public class ViewMain {

    public static void main(String[] args) {
        while (true) {
            System.out.println("Chọn đối tượng quản lý \n" +
                    "1.Student\n" +
                    "2.Teacher \n" +
                    "3.Thoát\n");
            int choose = Validate.getIntInput("Nhập lựa chọn");
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
