package ss7_abstract_class_interface.bai_tap.bai_trap_2;

public class Main {
    public static void main(String[] args) {
        Shape[] shapeList = new Shape[3];
        shapeList[0] = new Circle();
        shapeList[1] = new Rectangle();
        shapeList[2] = new Square();
        for (Shape shape : shapeList) {
            System.out.println(shape.getArea());
            if (shape instanceof Colorable) {
                ((Colorable) shape).howToColor();
            }
        }
    }
}
