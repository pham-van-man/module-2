package study_case.repository;

import java.util.LinkedList;

public interface IRepo<E> {
    LinkedList<E> findAll();

    void save(E element);

    E delete(int id);

    void update(int index, E element);

    boolean isEmpty(int id);

    int getIndex(int id);

    void sortByID();

    void sortByName();
}
