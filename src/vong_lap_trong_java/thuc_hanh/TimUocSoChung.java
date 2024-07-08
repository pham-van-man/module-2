package vong_lap_trong_java.thuc_hanh;

public class TimUocSoChung {
    public static void main(String[] args) {
        byte soA = 36;
        byte soB = 16;
        System.out.println(timUocSoChung(soA, soB));
    }

    public static byte timUocSoChung(byte soA, byte soB) {
        if (soA > soB) {
            byte soC = soA;
            soA = soB;
            soB = soC;
        }
        for (byte i = soA; i >= 1; i--) {
            if (soA % i == 0 && soB % i == 0) {
                return i;
            }
        }
        return 1;
    }
}
