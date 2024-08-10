package bai_tap_lam_them.ulti;


import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class DataHandler {
    public void writerString(List<String> list, String path, boolean append) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path, append))) {
            for (String content : list) {
                bufferedWriter.write(content + System.lineSeparator());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<String[]> readerString(String path) {
        List<String[]> list = new LinkedList<>();
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
