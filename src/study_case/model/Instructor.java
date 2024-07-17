package study_case.model;

public class Instructor extends Member {
    public Instructor() {
    }

    public Instructor(int id, String name) {
        super(id, name);
    }

    public Instructor(int id, String name, int age) {
        super(id, name, age);
    }

    public Instructor(String phoneNumber, int age, String name, int id) {
        super(phoneNumber, age, name, id);
    }

    public Instructor(int id, String name, int age, String phoneNumber, String email) {
        super(id, name, age, phoneNumber, email);
    }

    public Instructor(int id, String name, int age, String phoneNumber, String email, String address) {
        super(id, name, age, phoneNumber, email, address);
    }
}
