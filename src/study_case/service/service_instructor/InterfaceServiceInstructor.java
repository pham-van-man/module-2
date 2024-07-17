package study_case.service.service_instructor;

import study_case.model.Instructor;

import java.util.LinkedList;

public interface InterfaceServiceInstructor {
    LinkedList<Instructor> findAll();

    void add(Instructor instructor);

    Instructor delete(int id);
}
