package study_case.repository.repo_instructor;

import study_case.model.Instructor;

import java.util.LinkedList;

public interface InterfaceRepoInstructor {
    LinkedList<Instructor> findAllData();

    void saveData(Instructor instructor);

    Instructor deleteData(int id);
}
