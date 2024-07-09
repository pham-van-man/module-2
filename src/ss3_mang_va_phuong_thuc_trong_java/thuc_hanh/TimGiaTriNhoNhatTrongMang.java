package ss3_mang_va_phuong_thuc_trong_java.thuc_hanh;

import java.util.Arrays;
import java.util.Scanner;

public class TimGiaTriNhoNhatTrongMang {
    public static void main(String[] args) {
        System.out.println("Nhap vao so phan tu trong mang:");
        Scanner sc = new Scanner(System.in);
        byte soPhanTu;
        do {
            soPhanTu = sc.nextByte();
            if (soPhanTu < 1 || soPhanTu > 20) {
                System.out.println("So phan tu trong mang phai lon hon 0");
            }
        } while (soPhanTu < 1 || soPhanTu > 20);
        int[] mangMoi = taoMang(soPhanTu);
        System.out.println("Mang vua nhap: " + Arrays.toString(mangMoi));
        System.out.println("Gia tri nho nhat trong mang la " + mangMoi[timGiaTriNhoNhat(mangMoi)] + " o vi tri so " + timGiaTriNhoNhat(mangMoi));
    }

    public static int[] taoMang(byte soPhanTu) {
        Scanner sc = new Scanner(System.in);
        int[] mangMoi = new int[soPhanTu];
        for (int i = 0; i < soPhanTu; i++) {
            System.out.println("Nhap phan tu thu " + i + ":");
            mangMoi[i] = sc.nextInt();
        }
        return mangMoi;
    }

    public static byte timGiaTriNhoNhat(int[] mang) {
        int giaTriNhoNhat = mang[0];
        byte viTri = 0;
        for (byte i = 0; i < mang.length; i++) {
            if (mang[i] < giaTriNhoNhat) {
                giaTriNhoNhat = mang[i];
                viTri = i;
            }
        }
        return viTri;
    }
}
