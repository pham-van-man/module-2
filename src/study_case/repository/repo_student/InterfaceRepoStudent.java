package study_case.repository.repo_student;

import study_case.model.Student;

import java.util.LinkedList;

public interface InterfaceRepoStudent {
    LinkedList<Student> findAllData();

    void saveData(Student student);

    Student deleteData(int id);
}
