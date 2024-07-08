package vong_lap_trong_java.thuc_hanh;

public class KiemTraSoNguyenTo {
    public static void main(String[] args) {
        System.out.println(kiemTraSoNguyenTo(25)); // Kết quả: false
        System.out.println(kiemTraSoNguyenTo(23)); // Kết quả: true
    }

    public static boolean kiemTraSoNguyenTo(int motSo) {
        if (motSo < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(motSo); i++) {
            if (motSo % i == 0) {
                return false;
            }
        }
        return true;
    }
}
