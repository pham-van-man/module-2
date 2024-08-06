package test;

public class TestIO {
    public static void main(String[] args) {
//        Student student = new Student("Pham Van Man", 22);
//        Student studentFromFile;
//        try (BufferedReader fileReader = new BufferedReader(new FileReader("testIO.csv"));
//             BufferedWriter fileWriter = new BufferedWriter(new FileWriter("testIO.csv"))
//        ) {
//            String contentFromObject = student.getName() + "," + student.getAge();
//            String contentFromObject = student.getContent();
//            fileWriter.write(contentFromObject + System.lineSeparator());
//            studentFromFile = Student.getStudent(fileReader.readLine());
//            String[] contentFromFile = fileReader.readLine().split(",");
//            studentFromFile = new Student(contentFromFile[0], Integer.parseInt(contentFromFile[1]));
//        } catch (IOException _) {
//        }
//        Student studentFromFile = null;
//        try (BufferedReader fileReader = new BufferedReader(new FileReader("testIO.csv"))
//        ) {
//            fileReader.readLine();
//            while (fileReader.ready()) {
//                System.out.println(fileReader.readLine());
//                String[] contentFromFile = fileReader.readLine().split(",");
//                studentFromFile = new Student(contentFromFile[0], Integer.parseInt(contentFromFile[1]));
//            }
//            String[] contentFromFile = fileReader.readLine().split(",");
//            studentFromFile = new Student(contentFromFile[0], Integer.parseInt(contentFromFile[1]));
//            studentFromFile = Student.getStudent(fileReader.readLine());
//        } catch (IOException _) {
//        }
//        System.out.println(studentFromFile);
//        Student student = new Student("Pham Van Man", 22);
//        List<Student> listStudent = new LinkedList<>();
//        listStudent.add(new Student());
//        listStudent.add(new Student());
//        listStudent.add(new Student());
//        listStudent.add(new Student());
//        listStudent.add(new Student());
//        try (
//                ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("test.csv"));
//                ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("test.csv"))) {
//            objectOutputStream.writeObject(student);
//            objectOutputStream.writeObject(listStudent);
//            student = (Student) objectInputStream.readObject();
//        } catch (IOException _) {
//        }
//        List<Student> list = new LinkedList<>();
//        list.add(new Student());
//        list.add(new Student());
//        list.add(new Student());
//        list.add(new Student());
//        try (BufferedWriter fileWriter = new BufferedWriter(new FileWriter("abc.csv"))) {
//            for (Student student : list) {
//                fileWriter.write(student.toString());
//            }
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
//    }
//        import java.io.FileInputStream;
//        import java.io.IOException;
//        import java.io.ObjectInputStream;
//
//        public class Output {
//            public static void main(String[] args) {
//                try (FileInputStream fileIn = new FileInputStream("students.txt");
//                     ObjectInputStream objectIn = new ObjectInputStream(fileIn)) {
//                    Person person = (Person) objectIn.readObject();
//                    System.out.println("WaterMelon Banana bla bla banana");
//                    System.out.println("Person details: " + person);
//                } catch (IOException | ClassNotFoundException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }
//        String s ="\"";
//        System.out.println(s);
//        String s= "^\\+84-\\d{9}$";
//        Pattern p = Pattern.compile(s);
//        Matcher m = p.matcher("+84-891234567");
//        System.out.println(m.matches());
        System.out.println("Hello, World!");
        // Gọi method để làm sạch console
        System.out.println("Console has been cleared!");
    }
}
