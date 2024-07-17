package study_case.model;

public class Student extends Member {
    public Student() {
    }

    public Student(int id, String name) {
        super(id, name);
    }

    public Student(int id, String name, int age) {
        super(id, name, age);
    }

    public Student(String phoneNumber, int age, String name, int id) {
        super(phoneNumber, age, name, id);
    }

    public Student(int id, String name, int age, String phoneNumber, String email) {
        super(id, name, age, phoneNumber, email);
    }

    public Student(int id, String name, int age, String phoneNumber, String email, String address) {
        super(id, name, age, phoneNumber, email, address);
    }
}
