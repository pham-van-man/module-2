package study_case.util;

import java.io.*;
import java.util.LinkedList;

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
        E newObject;
        try (ObjectInputStream data = new ObjectInputStream(new FileInputStream(path))) {
            newObject = (E) data.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return newObject;
    }

    @Override
    public void writerString(LinkedList<String> list, String path, boolean append) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path, append))) {
            for (String content : list) {
                bufferedWriter.write(content + System.lineSeparator());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public LinkedList<String[]> readerString(String path) {
        LinkedList<String[]> list = new LinkedList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] content = line.split(",");
                list.add(content);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
}