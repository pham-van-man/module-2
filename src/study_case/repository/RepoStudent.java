package study_case.repository;

import study_case.model.Student;
import study_case.util.IDataHandler;

import java.util.Comparator;
import java.util.LinkedList;

public class RepoStudent implements IRepoStudent {
    private static final String PATH = "src/study_case/data/student.ser";
    private IDataHandler dataHandler;

    public RepoStudent(IDataHandler dataHandler) {
        this.dataHandler = dataHandler;
    }

    @Override
    public LinkedList<Student> findAll() {
        LinkedList<Student> list = dataHandler.readerObject(PATH);
        return list;
    }

    @Override
    public void save(Student student) {
        LinkedList<Student> list = findAll();
        list.add(student);
        dataHandler.writerObject(list, PATH);
    }

    @Override
    public Student delete(int id) {
        LinkedList<Student> list = findAll();
        for (Student student : list) {
            if (student.getId() == id) {
                list.remove(student);
                dataHandler.writerObject(list, PATH);
                return student;
            }
        }
        return null;
    }

    @Override
    public void update(int index, Student student) {
        LinkedList<Student> list = findAll();
        list.set(index, student);
        dataHandler.writerObject(list, PATH);
    }

    @Override
    public boolean isEmpty(int id) {
        LinkedList<Student> list = findAll();
        for (Student student : list) {
            if (student.getId() == id) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int getIndex(int id) {
        LinkedList<Student> list = findAll();
        for (Student student : list) {
            if (student.getId() == id) {
                return list.indexOf(student);
            }
        }
        return -1;
    }

    @Override
    public void sortByID() {
        Comparator<Student> comparator = Comparator
                .comparing(Student::getId)
                .thenComparing(Student::getName);
        LinkedList<Student> list = findAll();
        list.sort(comparator);
        dataHandler.writerObject(list, PATH);
    }

    @Override
    public void sortByName() {
        Comparator<Student> comparator = Comparator
                .comparing(Student::getName)
                .thenComparing(Student::getId);
        LinkedList<Student> list = findAll();
        list.sort(comparator);
        dataHandler.writerObject(list, PATH);
    }
}
