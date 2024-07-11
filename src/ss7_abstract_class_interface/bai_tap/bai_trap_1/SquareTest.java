package ss7_abstract_class_interface.bai_tap.bai_trap_1;

public class SquareTest {
    public static void main(String[] args) {
        Square square = new Square();
        System.out.println(square);
        square.resize( Math.floor(Math.random() * 100 + 1));
        System.out.println(square);
        square.resize(Math.floor(Math.random() * 100 + 1));
        System.out.println(square);
    }
}
