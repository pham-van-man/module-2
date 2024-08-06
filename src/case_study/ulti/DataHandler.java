package case_study.ulti;

public interface DataHandler {
    <E> void writerObject(E object, String path);

    <E> E readerObject(String path);
}
