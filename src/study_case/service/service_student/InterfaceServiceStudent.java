package study_case.service.service_student;

import study_case.model.Student;

import java.util.LinkedList;

public interface InterfaceServiceStudent {
    LinkedList<Student> findAll();

    void add(Student student);

    Student delete(int id);
}
