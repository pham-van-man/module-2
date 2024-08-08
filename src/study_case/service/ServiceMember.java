package study_case.service;

import java.util.LinkedList;

public interface ServiceMember<E> {
    LinkedList<E> findAll();

    void add(E element);

    E delete(int id);

    void update(int index, E element);

    boolean isEmpty(int id);

    int getIndex(int id);

    void sortByID();

    void sortByName();
}
