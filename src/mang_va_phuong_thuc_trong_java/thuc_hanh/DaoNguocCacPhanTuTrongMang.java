package mang_va_phuong_thuc_trong_java.thuc_hanh;

import java.util.Arrays;
import java.util.Scanner;

public class DaoNguocCacPhanTuTrongMang {
    public static void main(String[] args) {
        System.out.println("Nhap vao so phan tu trong mang:");
        Scanner sc = new Scanner(System.in);
        byte soPhanTuTrongMang;
        do {
            soPhanTuTrongMang = sc.nextByte();
            if (soPhanTuTrongMang < 1 || soPhanTuTrongMang > 20) {
                System.out.println("So phan tu trong mang phai lon hon 0.");
            }
        } while (soPhanTuTrongMang < 1 || soPhanTuTrongMang > 20);
        int[] mangMoi = taoMang(soPhanTuTrongMang);
        System.out.println("Mang vua nhap: " + Arrays.toString(mangMoi));
        daoNguocCacPhanTuTrongMang(mangMoi);
        System.out.println("Mang sau khi da nguoc cac gia tri ben trong " + Arrays.toString(mangMoi));
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

    public static void daoNguocCacPhanTuTrongMang(int[] mang) {
        for (int i = 0; i < mang.length / 2; i++) {
            int temp = mang[i];
            mang[i] = mang[mang.length - 1 - i];
            mang[mang.length - 1 - i] = temp;
        }
    }
}
