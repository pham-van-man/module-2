package mang_va_phuong_thuc_trong_java.bai_tap;

public class TongDuongCheo {
    public static void main(String[] args) {
        int[][] prime = {{1, 2, 3}, {2, 3, 4}, {3, 5, 6}};
        System.out.println("Tong duong cheo: " + tongDuongCheo(prime));
    }

    public static int tongDuongCheo(int[][] prime) {
        int sum = 0;
        for (int i = 0; i < prime.length; i++) {
            sum += prime[i][i];
        }
        for (int i = 0; i < prime.length; i++) {
            sum += prime[i][prime.length - 1 - i];
        }
        return sum;
    }
}
