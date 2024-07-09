package ss3_mang_va_phuong_thuc_trong_java.thuc_hanh;

import java.util.Scanner;

public class DemSoLuongSinhVienDo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int soLuongHocSinh;
        do {
            System.out.print("Nhap so luong hoc sinh:");
            soLuongHocSinh = sc.nextInt();
            if (soLuongHocSinh > 30)
                System.out.println("So luong khong duoc vuot qua 30");
        } while (soLuongHocSinh > 30);
        float[] diemHocSinh = new float[soLuongHocSinh];
        for (int i = 0; i < soLuongHocSinh; i++) {
            System.out.println("Nhap diem cua hoc sinh thu " + (i + 1) + ":");
            diemHocSinh[i] = sc.nextFloat();
        }
        for (int i = 0; i < soLuongHocSinh; i++) {
            if (diemHocSinh[i] >= 5) {
                System.out.println("Hoc sinh thu " + (i + 1) + ":" + diemHocSinh[i]);
            }
        }
    }
}
