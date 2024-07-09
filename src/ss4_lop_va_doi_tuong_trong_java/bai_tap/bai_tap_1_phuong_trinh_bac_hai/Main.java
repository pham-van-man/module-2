package ss4_lop_va_doi_tuong_trong_java.bai_tap.bai_tap_1_phuong_trinh_bac_hai;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Chuong trinh tinh phuong trinh bat hai");
        System.out.println("Nhap gia tri cho a");
        Scanner sc = new Scanner(System.in);
        double a = sc.nextDouble();
        System.out.println("Nhap gia tri cho b");
        double b = sc.nextDouble();
        System.out.println("Nhap gia tri cho c");
        double c = sc.nextDouble();
        PhuongTrinhBatHai phuongTrinhBatHai = new PhuongTrinhBatHai(a, b, c);
        System.out.println(phuongTrinhBatHai.getDelta());
        if (phuongTrinhBatHai.getDelta() > 0) {
            System.out.println("Phuong trinh co hai nghiem la: " + phuongTrinhBatHai.getRoot1() + " va\n" + phuongTrinhBatHai.getRoot2());
        } else if (phuongTrinhBatHai.getDelta() == 0) {
            System.out.println("Phuong trinh co nghiem Kep la: " + " +- " + phuongTrinhBatHai.getRoot1());
        } else {
            System.out.println("Phuong trinh vo nghiem");
        }
    }
}

class PhuongTrinhBatHai {
    private double a, b, c;

    public PhuongTrinhBatHai(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }

    public double getDelta() {
        return (Math.pow(this.b, 2)) - (4 * this.a * this.c);
    }

    public double getRoot1() {
        return ((-this.b) + Math.sqrt(Math.pow(this.b, 2) - 4 * this.a * this.c)) / (2 * this.a);
    }

    public double getRoot2() {
        return ((-this.b) - Math.sqrt(Math.pow(this.b, 2) - 4 * this.a * this.c)) / (2 * this.a);
    }
}

