package mang_va_phuong_thuc_trong_java.bai_tap;

import java.util.Scanner;

public class TinhTongCacSoOCotXacDinh {
    public static void main(String[] args) {
        int[][] prime = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        Scanner sc = new Scanner(System.in);
        byte col;
        do {
            System.out.println("Tinh tong co cot thu:");
            col = sc.nextByte();
            if (col > prime.length - 1 || col < 0) {
                System.out.println("Khong co cot nay");
            }
        } while (col > prime.length - 1 || col < 0);
        System.out.println("Tong cua cot thu " + col + " la " + sumCol(col, prime));
    }

    public static int sumCol(byte col, int[][] matrix) {
        int sum = 0;
        for (int i = 0; i < matrix[col].length; i++) {
            sum += matrix[col][i];
        }
        return sum;
    }
}
