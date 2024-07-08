package mang_va_phuong_thuc_trong_java.thuc_hanh;

import java.util.Scanner;

public class TimGiaTriTrongMang {
    public static void main(String[] args) {
        String[] hocSinh = {"Christian", "Michael", "Camila", "Sienna", "Tanya", "Connor", "Zachariah", "Mallory", "Zoe", "Emily"};
        System.out.println("Nhap ten can tiem kiem");
        Scanner sc = new Scanner(System.in);
        String tenCanTim = sc.nextLine();
        if (timGiaTriTrongMang(tenCanTim, hocSinh)) {
            System.out.println(tenCanTim + " la hoc sinh thu " + timViTriTrongMang(tenCanTim, hocSinh) + " cua chung toi");
        } else {
            System.out.println(tenCanTim + " khong phai la hoc sinh cua chung toi");
        }
    }

    public static boolean timGiaTriTrongMang(String giaTriCanTim, String[] mangCanTim) {
        for (int i = 0; i < mangCanTim.length; i++) {
            if (mangCanTim[i].equals(giaTriCanTim)) {
                return true;
            }
        }
        return false;
    }

    public static byte timViTriTrongMang(String viTriCanTim, String[] mangCanTim) {
        for (int i = 0; i < mangCanTim.length; i++) {
            if (mangCanTim[i].equals(viTriCanTim)) {
                return (byte) (i + 1);
            }
        }
        return -1;
    }
}
