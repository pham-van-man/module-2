package study_case.repository.repo_instructor;

import study_case.model.Instructor;

import java.util.LinkedList;

public interface IRepoInstructor {
    LinkedList<Instructor> findAll();

    void save(Instructor instructor);

    Instructor delete(int id);

    void update(int index, Instructor instructor);

    boolean isEmpty(int id);

    int getIndex(int id);

    void updateData();
}
