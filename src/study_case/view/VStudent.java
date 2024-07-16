package study_case.view;

import study_case.service.IStudentService;
import study_case.service.StudentService;

public class VStudent {
    public static void displayListStudent() {
        IStudentService studentService = new StudentService();
        studentService.display();
    }
}
