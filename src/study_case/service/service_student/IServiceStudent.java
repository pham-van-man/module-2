package study_case.service.service_student;

import study_case.model.Student;

import java.util.LinkedList;

public interface IServiceStudent {
    LinkedList<Student> findAll();

    void add(Student student);

    Student delete(int id);

    void update(int index, Student student);

    boolean isEmpty(int id);

    int getIndex(int id);

    void updateData();
}
