package ss2_vong_lap_trong_java.bai_tap;

public class HienThi20SoNguyenToDauTien {
    public static void main(String[] args) {
        byte soLuongSoNguyenTo = 0;
        int motSo = 0;
        while (soLuongSoNguyenTo < 20) {
            if (kiemTraSoNguyenTo(motSo)) {
                System.out.println(motSo);
                soLuongSoNguyenTo++;
            }
            motSo++;
        }
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
