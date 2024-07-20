package study_case.repository.repo_student;

import study_case.model.Student;

import java.util.LinkedList;

public interface IRepoStudent {
    LinkedList<Student> findAll();

    void save(Student student);

    Student delete(int id);

    void update(int index, Student student);

    boolean isEmpty(int id);

    int getIndex(int id);

    void updateData();
}
