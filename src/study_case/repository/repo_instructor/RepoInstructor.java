package study_case.repository.repo_instructor;

import study_case.model.Instructor;

import java.util.LinkedList;

public class RepoInstructor implements InterfaceRepoInstructor {
    private static LinkedList<Instructor> listinstructor = new LinkedList<>();

    static {
        Instructor instructor1 = new Instructor(01, "Nguyen Thanh Cong", 0, "0123456789", "abcxyz@gmail.com", "abcxyz");
        listinstructor.add(instructor1);
    }

    @Override
    public LinkedList<Instructor> findAllData() {
        return listinstructor;
    }

    @Override
    public void saveData(Instructor instructor) {
        listinstructor.add(instructor);
    }

    @Override
    public Instructor deleteData(int id) {
        for (Instructor instructor : listinstructor) {
            if (instructor.getId() == id) {
                listinstructor.remove(instructor);
                return instructor;
            }
        }
        return null;
    }
}
