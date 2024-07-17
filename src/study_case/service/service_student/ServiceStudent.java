package study_case.service.service_student;

import study_case.model.Student;
import study_case.repository.repo_student.InterfaceRepoStudent;
import study_case.repository.repo_student.RepoStudent;

import java.util.LinkedList;

public class ServiceStudent implements InterfaceServiceStudent {
    private static InterfaceRepoStudent rStudent = new RepoStudent();

    @Override
    public LinkedList<Student> findAll() {
        return rStudent.findAllData();
    }

    @Override
    public void add(Student student) {
        rStudent.saveData(student);
    }

    @Override
    public Student delete(int id) {
        return rStudent.deleteData(id);
    }
}
