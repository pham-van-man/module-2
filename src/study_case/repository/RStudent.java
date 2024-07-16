package study_case.repository;

import study_case.model.Member;
import study_case.model.Student;
import java.util.LinkedList;
import java.util.List;

public class RStudent implements IRStudent {
    private static List<Member> students = new LinkedList<>();

    static {
        Student student1 = new Student(01, "Pham Van Man");
        students.add(student1);
    }

    @Override
    public List<Member> findAllStudents() {
        return students;
    }
}
