package ss15_xu_li_ngoai_le_va_debug.bai_tap;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập vào 3 cạnh của một tam giác");
        double a = Double.parseDouble(sc.nextLine());
        double b = Double.parseDouble(sc.nextLine());
        double c = Double.parseDouble(sc.nextLine());
        try {
            check(a, b, c);
        } catch (IllegalTriangleException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void check(double a, double b, double c) {
        if (a < 0 || b < 0 || c < 0) {
            throw new IllegalTriangleException("Dữ liệu không hợp lệ");
        } else if (a + b < c || b + c < a || c + a < b) {
            throw new IllegalTriangleException("Dữ liệu không hợp lệ");
        }
    }
}
