package lop_va_doi_tuong_trong_java.bai_tap.bai_tap_3_xay_dung_lop_fan;

public class Main {
    public static void main(String[] args) {
        Fan fan1 = new Fan();
        fan1.setSpeed(Fan.FAST);
        fan1.setRadius(10);
        fan1.setColor("Yellow");
        fan1.setOn(true);
        System.out.println(fan1.toString());
        Fan fan2 = new Fan();
        fan2.setSpeed(Fan.NORMAL);
        fan2.setRadius(5);
        fan2.setColor("Blue");
        fan2.setOn(false);
        System.out.println(fan2.toString());
    }
}

class Fan {
    public static final byte SLOW = 1;
    public static final byte NORMAL = 2;
    public static final byte FAST = 3;

    private byte speed;
    private boolean on;
    private double radius;
    private String color;

    public Fan() {
        this.speed = SLOW;
        this.on = false;
        this.radius = 5;
        this.color = "Blue";
    }

    public byte getSpeed() {
        return this.speed;
    }

    public void setSpeed(byte speed) {
        this.speed = speed;
    }

    public boolean isOn() {
        return this.on;
    }

    public void setOn(boolean on) {
        if (this.isOn() == on) {
            return;
        }
        this.on = on;
    }

    public double getRadius() {
        return this.radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        if (this.on) {
            return this.speed + " " + this.color + " " + this.radius + " " + "Fan is on";
        } else {
            return this.color + " " + this.radius + " " + "Fan is off";
        }
    }
}
