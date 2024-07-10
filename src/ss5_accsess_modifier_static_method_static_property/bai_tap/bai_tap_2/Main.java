package ss5_accsess_modifier_static_method_static_property.bai_tap.bai_tap_2;

public class Main {
    public static void main(String[] args) {
        Test student = new Test();
        student.setClasses("C0524I1");
        student.setName("Pham Van Man");
    }
}

class Test {
    private String name;
    private String classes;

    public Test() {
        this.name = "John";
        this.classes = "C02";
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }
}