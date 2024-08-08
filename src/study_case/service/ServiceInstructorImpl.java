package study_case.service;

import study_case.model.Instructor;
import study_case.repository.RepositoryInstructor;
import study_case.repository.RepositoryInstructorImpl;
import study_case.util.DataHandlerImpl;

import java.util.LinkedList;

public class ServiceInstructorImpl implements ServiceInstructor {
    private static RepositoryInstructor repo = new RepositoryInstructorImpl(new DataHandlerImpl());

    @Override
    public LinkedList<Instructor> findAll() {
        return repo.findAll();
    }

    @Override
    public void add(Instructor instructor) {
        repo.save(instructor);
    }

    @Override
    public Instructor delete(int id) {
        return repo.delete(id);
    }

    @Override
    public void update(int index, Instructor instructor) {
        repo.update(index, instructor);
    }

    @Override
    public boolean isEmpty(int id) {
        return repo.isEmpty(id);
    }

    @Override
    public int getIndex(int id) {
        return repo.getIndex(id);
    }

    @Override
    public void sortByID() {
        repo.sortByID();
    }

    @Override
    public void sortByName() {
        repo.sortByName();
    }
}
