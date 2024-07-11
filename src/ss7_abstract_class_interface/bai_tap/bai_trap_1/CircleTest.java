package ss7_abstract_class_interface.bai_tap.bai_trap_1;

public class CircleTest {
    public static void main(String[] args) {
        Circle circle = new Circle();
        System.out.println(circle);
        circle.resize(Math.floor(Math.random() * 100 + 1));
        System.out.println(circle);
        circle = new Circle(3.5);
        System.out.println(circle);
        circle.resize(Math.floor(Math.random() * 100 + 1));
        System.out.println(circle);
        circle = new Circle(3.5, "indigo", false);
        System.out.println(circle);
        circle.resize(Math.floor(Math.random() * 100 + 1));
        System.out.println(circle);
    }
}