package ss7_abstract_class_interface.thuc_hanh.thuc_hanh_2;

import ss6_ke_thua.thu_hanh.he_cac_doi_tuong_hinh_hoc.Circle;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ComparableCircle[] circles = new ComparableCircle[3];
        circles[0] = new ComparableCircle(3.6);
        circles[1] = new ComparableCircle();
        circles[2] = new ComparableCircle("indigo", false, 3.5);

        System.out.println("Pre-sorted:");
        for (ComparableCircle circle : circles) {
            System.out.println(circle);
        }
        Arrays.sort(circles);
        System.out.println("After-sorted:");
        for (ComparableCircle circle : circles) {
            System.out.println(circle);
        }
    }
}

class ComparableCircle extends Circle implements Comparable<ComparableCircle> {
    public ComparableCircle() {
    }

    public ComparableCircle(double radius) {
        super(radius);
    }

    public ComparableCircle(String color, boolean filled, double radius) {
        super(color, filled, radius);
    }

    @Override
    public int compareTo(ComparableCircle o) {
        if (getRadius() > o.getRadius()) return 1;
        else if (getRadius() < o.getRadius()) return -1;
        else return 0;
    }
}
