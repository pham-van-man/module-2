package study_case.repository.repo_instructor;

import study_case.model.Instructor;

import java.util.LinkedList;

public class RepoInstructor implements IRepoInstructor {
    private static LinkedList<Instructor> listInstructor = new LinkedList<>();

    static {
        Instructor instructor1 = new Instructor(0, "Nguyen Thanh Cong", 0, "0123456789", "abcxyz@gmail.com", "abcxyz");
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

    @Override
    public boolean isEmpty(int id) {
        for (Instructor instructor : listInstructor) {
            if (instructor.getId() == id) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int getIndex(int id) {
        for (Instructor instructors : listInstructor) {
            if (instructors.getId() == id) {
                return listInstructor.indexOf(instructors);
            }
        }
        return -1;
    }
}
