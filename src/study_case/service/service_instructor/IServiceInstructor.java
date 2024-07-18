package study_case.service.service_instructor;

import study_case.model.Instructor;

import java.util.LinkedList;

public interface IServiceInstructor {
    LinkedList<Instructor> findAll();

    void add(Instructor instructor);

    Instructor delete(int id);

    void update(int index, Instructor instructor);

    boolean isEmpty(int id);

    int getIndex(int id);
}
