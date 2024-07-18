package study_case.service.service_instructor;

import study_case.model.Instructor;
import study_case.repository.repo_instructor.IRepoInstructor;
import study_case.repository.repo_instructor.RepoInstructor;

import java.util.LinkedList;

public class ServiceInstructor implements IServiceInstructor {
    private static IRepoInstructor repoInstructor = new RepoInstructor();

    @Override
    public LinkedList<Instructor> findAll() {
        return repoInstructor.findAll();
    }

    @Override
    public void add(Instructor instructor) {
        repoInstructor.save(instructor);
    }

    @Override
    public Instructor delete(int id) {
        return repoInstructor.delete(id);
    }

    @Override
    public void update(int index, Instructor instructor) {
        repoInstructor.update(index, instructor);
    }
}
