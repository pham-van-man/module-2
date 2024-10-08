package study_case.service;

import study_case.model.Student;
import study_case.repository.RepositoryStudent;
import study_case.repository.RepositoryStudentImpl;
import study_case.util.DataHandlerImpl;

import java.util.LinkedList;

public class ServiceStudentImpl implements ServiceStudent {
    private static RepositoryStudent repo = new RepositoryStudentImpl(new DataHandlerImpl());

    @Override
    public LinkedList<Student> findAll() {
        return repo.findAll();
    }

    @Override
    public void add(Student student) {
        repo.save(student);
    }

    @Override
    public Student delete(int id) {
        return repo.delete(id);
    }

    @Override
    public void update(int index, Student student) {
        repo.update(index, student);
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
