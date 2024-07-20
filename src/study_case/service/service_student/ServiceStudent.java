package study_case.service.service_student;

import study_case.model.Student;
import study_case.repository.repo_student.IRepoStudent;
import study_case.repository.repo_student.RepoStudent;

import java.util.LinkedList;

public class ServiceStudent implements IServiceStudent {
    private static IRepoStudent repoStudent = new RepoStudent();

    @Override
    public LinkedList<Student> findAll() {
        return repoStudent.findAll();
    }

    @Override
    public void add(Student student) {
        repoStudent.save(student);
    }

    @Override
    public Student delete(int id) {
        return repoStudent.delete(id);
    }

    @Override
    public void update(int index, Student student) {
        repoStudent.update(index, student);
    }

    @Override
    public boolean isEmpty(int id) {
        return repoStudent.isEmpty(id);
    }

    @Override
    public int getIndex(int id) {
        return repoStudent.getIndex(id);
    }

    @Override
    public void updateData() {
        repoStudent.updateData();
    }
}
