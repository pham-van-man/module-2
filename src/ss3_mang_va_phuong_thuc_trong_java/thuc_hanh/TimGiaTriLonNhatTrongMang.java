package ss3_mang_va_phuong_thuc_trong_java.thuc_hanh;

import java.util.Arrays;
import java.util.Scanner;

public class TimGiaTriLonNhatTrongMang {
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
        System.out.println("Gia tri lon nhat trong mang la " + timGiaTriLonNhatTrongMang(mangMoi) + " o vi tri so " + timViTriTrongMang(timGiaTriLonNhatTrongMang(mangMoi), mangMoi));
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

    public static int timGiaTriLonNhatTrongMang(int[] mang) {
        int giaTriLonNhatTrongMang = mang[0];
        for (int i = 1; i < mang.length; i++) {
            if (mang[i] > giaTriLonNhatTrongMang) {
                giaTriLonNhatTrongMang = mang[i];
            }
        }
        return giaTriLonNhatTrongMang;
    }

    public static byte timViTriTrongMang(int giaTri, int[] mang) {
        for (int i = 0; i < mang.length; i++) {
            if (mang[i] == giaTri) {
                return (byte) i;
            }
        }
        return -1;
    }
}
