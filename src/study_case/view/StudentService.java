package study_case.view;

import study_case.model.Student;

import java.util.Scanner;

public class StudentService {
    private static final byte QUANTILY_MEMBER_DEFAUL = 8;
    private static Student[] studentList = new Student[QUANTILY_MEMBER_DEFAUL];
    private Scanner sc = new Scanner(System.in);

    static {
        studentList[0] = new Student(1, "chánh1");
        studentList[1] = new Student(2, "chánh2");
        studentList[2] = new Student(2, "chánh3");
    }

    public void display() {
        for (int i = 0; i < studentList.length; i++) {
            if (studentList[i] != null) {
                System.out.println(studentList[i]);
            }
        }
    }

    public void add() {
        System.out.println("Nhập ID");
        int id = Integer.parseInt(sc.nextLine());
        System.out.println("Nhập tên");
        String name = sc.nextLine();
        Student student = new Student(id, name);
        for (int i = 0; i < studentList.length; i++) {
            if (studentList[i] == null) {
                studentList[i] = student;
                break;
            }
        }
    }

    public void delete() {
        System.out.println("Nhập ID cần xóa");
        int id = Integer.parseInt(sc.nextLine());
        boolean flag = false;
        for (int i = 0; i < studentList.length; i++) {
            if (studentList[i] != null) {
                if (studentList[i].getId() == id) {
                    for (int j = i; j < studentList.length - 1; j++) {
                        studentList[j] = studentList[j + 1];
                    }
                    flag = true;
                    studentList[studentList.length - 1] = null;
                    System.out.println("Đã xóa thành công");
                    break;
                }
            } else {
                break;
            }
        }
        if (!flag) {
            System.out.println("Không tìm thấy ID");
        }
    }
}
