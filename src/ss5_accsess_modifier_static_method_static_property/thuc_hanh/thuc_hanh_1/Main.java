package ss5_accsess_modifier_static_method_static_property.thuc_hanh.thuc_hanh_1;

public class Main {
    public static void main(String args[]) {
        Student.change();
        Student s1 = new Student(111, "Hoang");
        s1.display();
        Student s2 = new Student(222, "Khanh");
        s2.display();
        Student s3 = new Student(333, "Nam");
        s1.change();
        s1.display();
        s2.display();
        s3.display();
    }
}

class Student {
    private int rollno;
    private String name;
    private static String college = "BBDIT";
    private static String namer = "Pham Van Man";
    private static int age = 18;

    Student(int r, String n) {
        rollno = r;
        name = n;
        age++;
    }

    static void change() {
        college = "CODEGYM";
    }

    void change(String names) {
        college = names;
    }

    void display() {
        System.out.println(rollno + " " + name + " " + college + " " + age);
    }
}
