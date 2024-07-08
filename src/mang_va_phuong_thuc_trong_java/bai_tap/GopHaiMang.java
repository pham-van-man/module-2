package mang_va_phuong_thuc_trong_java.bai_tap;

import java.util.Arrays;

public class GopHaiMang {
    public static void main(String[] args) {
        int[] soNguyen1 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] soNguyen2 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] soNguyen3 = new int[soNguyen1.length + soNguyen2.length];
        for (int i = 0; i < soNguyen1.length; i++) {
            soNguyen3[i] = soNguyen1[i];
        }
        for (int i = 0; i < soNguyen2.length; i++) {
            soNguyen3[soNguyen1.length + i] = soNguyen2[i];
        }
        System.out.println("Mang moi sau khi gop hai so nguyen: " + Arrays.toString(soNguyen3));
    }
}
