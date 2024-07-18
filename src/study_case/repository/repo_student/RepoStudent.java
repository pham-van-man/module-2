package study_case.repository.repo_student;

import study_case.model.Student;

import java.util.LinkedList;

public class RepoStudent implements IRepoStudent {
    private static LinkedList<Student> listStudents = new LinkedList<>();
    private static int idStudent;

    static {
        Student student1 = new Student(idStudent, "Pham Van Man", 22, "0123456789", "phamvanman@gmail.com", "TT-Huế");
        listStudents.add(student1);
    }

    @Override
    public LinkedList<Student> findAll() {
        return listStudents;
    }

    @Override
    public void save(Student student) {
        listStudents.add(student);
    }

    @Override
    public Student delete(int id) {
        for (Student student : listStudents) {
            if (student.getId() == id) {
                listStudents.remove(student);
                return student;
            }
        }
        return null;
    }

    @Override
    public void update(int index, Student student) {
        listStudents.set(index, student);
    }

    @Override
    public boolean isEmpty(int id) {
        for (Student student : listStudents) {
            if (student.getId() == id) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int getIndex(int id) {
        for (Student student : listStudents) {
            if (student.getId() == id) {
                return listStudents.indexOf(student);
            }
        }
        return -1;
    }
}
