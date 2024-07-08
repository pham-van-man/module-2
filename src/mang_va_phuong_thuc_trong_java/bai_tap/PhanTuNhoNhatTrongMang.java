package mang_va_phuong_thuc_trong_java.bai_tap;

import java.util.Scanner;

public class PhanTuNhoNhatTrongMang {
    public static void main(String[] args) {
        System.out.println("Nhap so dong:");
        Scanner sc = new Scanner(System.in);
        byte soDong = sc.nextByte();
        System.out.println("Nhap so phan tu trong moi dong");
        byte soPhanTu = sc.nextByte();
        int[][] mangHaiChieu = new int[soDong][soPhanTu];
        for (int i = 0; i < mangHaiChieu.length; i++) {
            for (int j = 0; j < mangHaiChieu[i].length; j++) {
                System.out.println("Nhap phan tu " + i + j);
                mangHaiChieu[i][j] = sc.nextInt();
            }
        }
        int soNhoNhat = mangHaiChieu[0][0];
        for (int i = 0; i < mangHaiChieu.length; i++) {
            for (int j = 0; j < mangHaiChieu[i].length; j++) {
                if (mangHaiChieu[i][j] < soNhoNhat) {
                    soNhoNhat = mangHaiChieu[i][j];
                }
            }
        }
        System.out.println("Phan tu nho nhat trong mang: " + soNhoNhat);
    }
}
