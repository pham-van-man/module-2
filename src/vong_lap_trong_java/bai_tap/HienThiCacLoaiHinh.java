package vong_lap_trong_java.bai_tap;

import java.util.Scanner;

public class HienThiCacLoaiHinh {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        byte luaChon = -1;
        while (luaChon != 0) {
            System.out.println("Menu");
            System.out.println("1. ve hinh tam giac vuong duoi");
            System.out.println("2. ve hinh tam giac vuong tren");
            System.out.println("3. ve hinh chu nhat");
            System.out.println("0. thoat");
            luaChon = sc.nextByte();
            hienThiHinhAnh(luaChon);
        }
    }

    public static void hienThiHinhAnh(byte luaChon) {
        switch (luaChon) {
            case 1:
                System.out.println("ve hinh tam giac vuong duoi");
                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < i + 1; j++) {
                        System.out.print("*");
                    }
                    System.out.printf("%n");
                }
                break;
            case 2:
                System.out.println("ve hinh tam giac vuong tren");
                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 5 - i; j++) {
                        System.out.print("*");
                    }
                    System.out.printf("%n");
                }
                break;
            case 3:
                System.out.println("ve hinh chu nhat");
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 7; j++) {
                        System.out.print("*");
                    }
                    System.out.printf("%n");
                }
                break;
            case 0:
                System.exit(0);
            default:
                System.out.println("khong co lua chon nay!");
        }
    }
}
