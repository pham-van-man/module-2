package case_study.ulti;

import java.io.*;
import java.util.TreeMap;

public class DataHandlerImpl implements DataHandler {
    @Override
    public <E> void writerObject(E object, String path) {
        try (ObjectOutputStream data = new ObjectOutputStream(new FileOutputStream(path))) {
            data.writeObject(object);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public <E> E readerObject(String path) {
        File file = new File(path);
        E newObject = (E) new TreeMap<>();
        if (file.length() != 0) {
            try (ObjectInputStream data = new ObjectInputStream(new FileInputStream(path))) {
                newObject = (E) data.readObject();
            } catch (IOException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
            return newObject;
        } else {
            return newObject;
        }
    }
}
