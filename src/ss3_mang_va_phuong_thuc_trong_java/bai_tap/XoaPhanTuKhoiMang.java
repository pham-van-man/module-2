package ss3_mang_va_phuong_thuc_trong_java.bai_tap;

import java.util.Arrays;
import java.util.Scanner;

public class XoaPhanTuKhoiMang {
    public static void main(String[] args) {
        int[] mangSo = {1, 2, 3, 4, 5, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7};
        System.out.println(Arrays.toString(mangSo));
        System.out.println("Nhap phan tu can xoa khoi mang: ");
        Scanner sc = new Scanner(System.in);
        int phanTu = sc.nextInt();
        xoaPhanTuKhoiMang(phanTu, mangSo);
    }

    public static void xoaPhanTuKhoiMang(int phanTu, int[] mangSo) {
        boolean kiemTra = false;
        for (int i = 0; i < mangSo.length; i++) {
            if (phanTu == mangSo[i]) {
                for (int j = i; j <= mangSo.length - 1; j++) {
                    if (j == mangSo.length - 1) {
                        mangSo[j] = 0;
                        i--;
                        kiemTra = true;
                        break;
                    }
                    mangSo[j] = mangSo[j + 1];
                }
            }
        }
        if (kiemTra) {
            System.out.println("Mang sau khi xoa di phan tu " + phanTu + " " + Arrays.toString(mangSo));
        } else {
            System.out.println("Trong mang khong co phan tu nay");
        }
    }
}
