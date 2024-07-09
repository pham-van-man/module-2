package ss3_mang_va_phuong_thuc_trong_java.thuc_hanh;

import java.util.Scanner;

public class ChuongTrinhChuyenDoiNhietDo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        byte luaChon;
        short nhietDo;
        do {
            System.out.println("1. Chuyen doi tu C sang F ");
            System.out.println("2. Chuyen doi tu F sang C ");
            System.out.println("3. Thoat ");
            luaChon = sc.nextByte();
            switch (luaChon) {
                case 1:
                    System.out.println("Nhap do C");
                    nhietDo = sc.nextShort();
                    System.out.println(nhietDo + " do C bang " + chuyenDoCSangDoF(nhietDo) + " do F");
                    break;
                case 2:
                    System.out.println("Nhap do F");
                    nhietDo = sc.nextShort();
                    System.out.println(nhietDo + " do F bang " + chuyenDoFSangDoC(nhietDo) + " do C");
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Vui long nhap lai");
                    break;
            }
        } while (luaChon != 3);


    }

    public static float chuyenDoCSangDoF(short DoC) {
        return (float) DoC * ((float) 9 / 5) + 32;
    }

    public static float chuyenDoFSangDoC(short DoF) {
        return (float) (DoF - 32) / 1.8F;
    }
}
