package study_case.repository.repo_student;

import study_case.model.Student;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.LinkedList;

public class RepoStudent implements IRepoStudent {
    private static LinkedList<Student> listStudents;

    static {
        try {
            ObjectInputStream data = new ObjectInputStream(new FileInputStream("list_student.ser"));
            listStudents = (LinkedList<Student>) data.readObject();
        } catch (ClassNotFoundException | IOException e) {
            throw new RuntimeException(e);
        }
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
