package ss1_introduction_to_java.bai_tap_2;

import java.util.Scanner;

public class ChuyenDoiTien {
    public static void main(String[] args) {
        double rate = 23000;
        System.out.println("nhap vao so tien USD muon chuyen sang VND");
        Scanner sc = new Scanner(System.in);
        double usd = sc.nextDouble();
        double vnd = usd * rate;
        System.out.println("vnd = " + vnd);
    }
}
