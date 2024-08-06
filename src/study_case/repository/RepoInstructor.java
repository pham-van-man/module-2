package study_case.repository;

import study_case.model.Instructor;
import study_case.util.IDataHandler;

import java.util.Comparator;
import java.util.LinkedList;

public class RepoInstructor implements IRepoInstructor {
    private static final String PATH = "src/study_case/data/instructor.ser";
    private final IDataHandler dataHandler;

    public RepoInstructor(IDataHandler dataHandler) {
        this.dataHandler = dataHandler;
    }

    @Override
    public LinkedList<Instructor> findAll() {
        return dataHandler.readerObject(PATH);
    }

    @Override
    public void save(Instructor instructor) {
        LinkedList<Instructor> list = findAll();
        list.add(instructor);
        dataHandler.writerObject(list, PATH);
    }

    @Override
    public Instructor delete(int id) {
        LinkedList<Instructor> list = findAll();
        for (Instructor instructor : list) {
            if (instructor.getId() == id) {
                list.remove(instructor);
                dataHandler.writerObject(list, PATH);
                return instructor;
            }
        }
        return null;
    }

    @Override
    public void update(int index, Instructor instructor) {
        LinkedList<Instructor> list = findAll();
        list.set(index, instructor);
        dataHandler.writerObject(list, PATH);
    }

    @Override
    public boolean isEmpty(int id) {
        LinkedList<Instructor> list = findAll();
        for (Instructor instructor : list) {
            if (instructor.getId() == id) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int getIndex(int id) {
        LinkedList<Instructor> list = findAll();
        for (Instructor instructors : list) {
            if (instructors.getId() == id) {
                return list.indexOf(instructors);
            }
        }
        return -1;
    }

    @Override
    public void sortByID() {
        Comparator<Instructor> comparator = Comparator
                .comparing(Instructor::getId)
                .thenComparing(Instructor::getName);
        LinkedList<Instructor> list = findAll();
        list.sort(comparator);
        dataHandler.writerObject(list, PATH);
    }

    @Override
    public void sortByName() {
        Comparator<Instructor> comparator = Comparator
                .comparing(Instructor::getName)
                .thenComparing(Instructor::getId);
        LinkedList<Instructor> list = findAll();
        list.sort(comparator);
        dataHandler.writerObject(list, PATH);
    }
}
