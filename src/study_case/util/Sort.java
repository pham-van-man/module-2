package study_case.util;

import study_case.model.Member;

import java.util.Comparator;
import java.util.LinkedList;

public class Sort {
    private static LinkedList<Member> sortByID(LinkedList<Member> list) {
        LinkedList<Member> listSort = list;
        Comparator<Member> comparator = Comparator
                .comparing(Member::getId)
                .thenComparing(Member::getName);
        list.sort(comparator);
        return listSort;
    }
//
//    public static LinkedList<E> sortByName(LinkedList<E> list) {
//        Comparator<Member> comparator = Comparator
//                .comparing(Member::getName)
//                .thenComparing(Member::getId);
//        list.sort(comparator);
//        return list;
//    }
}
