package study_case.repository.repo_instructor;

import study_case.model.Instructor;

import java.util.LinkedList;

public class RepoInstructor implements IRepoInstructor {
    private static LinkedList<Instructor> listInstructor = new LinkedList<>();

    static {
        Instructor instructor1 = new Instructor(01, "Nguyen Thanh Cong", 0, "0123456789", "abcxyz@gmail.com", "abcxyz");
        listInstructor.add(instructor1);
    }

    @Override
    public LinkedList<Instructor> findAll() {
        return listInstructor;
    }

    @Override
    public void save(Instructor instructor) {
        listInstructor.add(instructor);
    }

    @Override
    public Instructor delete(int id) {
        for (Instructor instructor : listInstructor) {
            if (instructor.getId() == id) {
                listInstructor.remove(instructor);
                return instructor;
            }
        }
        return null;
    }

    @Override
    public void update(int index, Instructor instructor) {
        listInstructor.set(index, instructor);
    }
}
