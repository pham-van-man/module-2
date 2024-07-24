package ss17_io_binary_file_serialization.thuc_hanh.thuc_hanh_2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Vũ Kiều Anh", "Hà Nội"));
        students.add(new Student(2, "Nguyễn Minh Quân", "Hà Nội"));
        students.add(new Student(3, "Đặng Huy Hoà", "Đà Nẵng"));
        students.add(new Student(4, "Nguyễn Khánh Tùng", "Hà Nội"));
        students.add(new Student(5, "Nguyễn Khắc Nhật", "Hà Nội"));
        writeToFile("student.txt", students);
        List<Student> studentDataFromFile = readDataFromFile("student.txt");
        for (Student student : studentDataFromFile) {
            System.out.println(student);
        }
    }

    public static void writeToFile(String path, List<Student> students) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(path))) {
            outputStream.writeObject(students);
        } catch (IOException _) {
        }
    }

    public static List<Student> readDataFromFile(String path) {
        List<Student> students = new ArrayList<>();
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(path))) {
            students = (List<Student>) inputStream.readObject();
        } catch (Exception _) {
        }
        return students;
    }
}
