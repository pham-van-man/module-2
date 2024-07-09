package ss3_mang_va_phuong_thuc_trong_java.bai_tap;

import java.util.Arrays;
import java.util.Scanner;

public class ThemPhanTuVaoMang {
    public static void main(String[] args) {
        int[] mangSoNguyen = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        System.out.println("Nhap phan tu muon chen vao mang:");
        Scanner sc = new Scanner(System.in);
        int phanTu = sc.nextInt();
        byte viTri;
        do {
            System.out.println("Nhap vi tri muon chen:");
            viTri = sc.nextByte();
            if (viTri > mangSoNguyen.length - 1 || viTri < 0) {
                System.out.println("Khong the chen vao vi tri nay:");
            }
        } while (viTri > mangSoNguyen.length - 1 || viTri < 0);
        chenPhanTuMoi(phanTu, viTri, mangSoNguyen);
        System.out.println("Mang so nguyen sau khi chen phan tu" + phanTu + " : " + Arrays.toString(mangSoNguyen));
    }

    public static void chenPhanTuMoi(int phanTu, byte viTri, int[] mangSoNguyen) {
        mangSoNguyen[viTri] = phanTu;
    }
}
