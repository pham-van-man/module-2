package study_case.service.service_instructor;

import study_case.model.Instructor;
import study_case.repository.repo_instructor.InterfaceRepoInstructor;
import study_case.repository.repo_instructor.RepoInstructor;

import java.util.LinkedList;

public class ServiceInstructor implements InterfaceServiceInstructor {
    private static InterfaceRepoInstructor rInstructor = new RepoInstructor();

    @Override
    public LinkedList<Instructor> findAll() {
        return rInstructor.findAllData();
    }

    @Override
    public void add(Instructor instructor) {
        rInstructor.saveData(instructor);
    }

    @Override
    public Instructor delete(int id) {
        return rInstructor.deleteData(id);
    }
}
