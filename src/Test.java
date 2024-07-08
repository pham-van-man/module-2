import java.util.Arrays;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        System.out.println("Nhap vao so dong:");
        Scanner sc = new Scanner(System.in);
        byte soDong = sc.nextByte();
        System.out.println("Nhap vao so phan tu:");
        byte phanTu = sc.nextByte();
        int[][] mangMoi = taoMang(soDong, phanTu);
        System.out.println("Mang vua nhap vao: \n" + Arrays.deepToString(mangMoi));
    }

    public static int[][] taoMang(byte soDong, byte soPhanTu) {
        int[][] mangMoi;
        Scanner sc = new Scanner(System.in);
        mangMoi = new int[soDong][soPhanTu];
        for (int i = 0; i < soDong; i++) {
            for (int j = 0; j < soPhanTu; j++) {
                System.out.println("Nhap phan tu vi tri " + i + j + ":");
                mangMoi[i][j] = sc.nextInt();
            }
        }
        return mangMoi;
    }
    Test(){
    }
}
