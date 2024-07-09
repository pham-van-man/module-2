package ss2_vong_lap_trong_java.thuc_hanh;

import java.util.Scanner;

public class TinhTienLaiChoVay {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("nhập số tiền muốn vây:");
        float soTienMuonVay = sc.nextFloat();
        System.out.println("bạn muốn trả nợ trong bao lâu (tháng):");
        byte soThangTraNo = sc.nextByte();
        System.out.println(tinhTienLaiChoVay(soTienMuonVay, soThangTraNo));
    }

    public static double tinhTienLaiChoVay(float soTien, byte soThang) {
        float tienLai = 0;
        for (int i = 0; i < soThang; i++) {
            tienLai += soTien * (((float) 5.5 / (float) 100 / (float) 12)) * (float) soThang;
        }
        return tienLai;
    }
}
