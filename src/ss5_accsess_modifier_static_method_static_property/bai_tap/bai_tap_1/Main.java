package ss5_accsess_modifier_static_method_static_property.bai_tap.bai_tap_1;

public class Main {
    public static void main(String[] args) {
        TestCircle circle = new TestCircle();
        System.out.println(circle.getArea());
    }
}

class TestCircle {
    private double radius;
    private String color;

    public TestCircle() {
        this.radius = 1.0;
        this.color = "Red";
    }

    public TestCircle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getArea() {
        return Math.pow((radius), 2) * Math.PI;
    }

}

