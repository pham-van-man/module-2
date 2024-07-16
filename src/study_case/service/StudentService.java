package study_case.service;

import study_case.model.Member;
import study_case.model.Student;
import study_case.repository.IRStudent;
import study_case.repository.RStudent;

import java.util.List;
import java.util.Scanner;

public class StudentService implements IStudentService {
    private static IRStudent rstudent = new RStudent();
    List<Member> listStudent = rstudent.findAllStudents();
    private Scanner sc = new Scanner(System.in);

    @Override
    public void display() {
        for (Member student : listStudent) {
            System.out.println(student);
        }
    }

    @Override
    public void add() {
        System.out.println("Nhập ID");
        int id = Integer.parseInt(sc.nextLine());
        System.out.println("Nhập tên");
        String name = sc.nextLine();
        Member student = new Student(id, name);
        listStudent.add(student);
        System.out.println("Thêm mới thành công");
    }

    @Override
    public void delete() {
        System.out.println("Nhập ID cần xóa");
        int id = Integer.parseInt(sc.nextLine());
        boolean flag = false;
        for (Member student : listStudent) {
            if (student.getId() == id) {
                listStudent.remove(student);
                flag = true;
                break;
            }
        }
        if (flag) {
            System.out.println("Đã xóa thành công");
        } else {
            System.out.println("Không tìm thấy ID");
        }
    }
}
