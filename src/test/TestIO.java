package test;

import java.io.*;

public class TestIO {
    public static void main(String[] args) {
        Student student = new Student("Pham Van Man", 22);
        Student studentFromFile;
        try (BufferedReader fileReader = new BufferedReader(new FileReader("testReader.csv"));
             BufferedWriter fileWriter = new BufferedWriter(new FileWriter("testWriter.csv"))
        ) {
            String contentFromObject = student.getName() + "," + student.getAge();
//            String contentFromObject = student.getContent();
            fileWriter.write(contentFromObject + System.lineSeparator());
//            studentFromFile = Student.getStudent(fileReader.readLine());
            String[] contentFromFile = fileReader.readLine().split(",");
            studentFromFile = new Student(contentFromFile[0], Integer.parseInt(contentFromFile[1]));
        } catch (IOException _) {
        }
    }
}
