package vong_lap_trong_java.thuc_hanh;

import java.util.Scanner;

public class ThietKeMenuChoUngDung {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        byte luaChon = -1;
        while (luaChon != 0) {
            System.out.println("Menu");
            System.out.println("1. ve hinh tam giac");
            System.out.println("2. ve hinh vuong");
            System.out.println("3. ve hinh chu nhat");
            System.out.println("0. thoat");
            luaChon = sc.nextByte();
            hienThiHinhAnh(luaChon);
        }
    }

    public static void hienThiHinhAnh(byte luaChon) {
        switch (luaChon) {
            case 1:
                System.out.println("ve hinh tam giac");
                System.out.println("******");
                System.out.println("*****");
                System.out.println("****");
                System.out.println("***");
                System.out.println("**");
                System.out.println("*");
                break;
            case 2:
                System.out.println("ve hinh vuong");
                System.out.println("* * * * * *");
                System.out.println("* * * * * *");
                System.out.println("* * * * * *");
                System.out.println("* * * * * *");
                System.out.println("* * * * * *");
                System.out.println("* * * * * *");
                break;
            case 3:
                System.out.println("ve hinh chu nhat");
                System.out.println("* * * * * *");
                System.out.println("* * * * * *");
                System.out.println("* * * * * *");
                break;
            case 0:
                System.exit(0);
            default:
                System.out.println("khong co lua chon nay!");
        }
    }
}
