package study_case.util;

import java.util.LinkedList;

public interface DataHandler {
    <E> void writerObject(E object, String path);

    <E> E readerObject(String path);

    void writerString(LinkedList<String> list, String path, boolean append);

    LinkedList<String[]> readerString(String path);
}
