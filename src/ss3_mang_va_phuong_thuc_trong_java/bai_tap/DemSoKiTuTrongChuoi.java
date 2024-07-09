package ss3_mang_va_phuong_thuc_trong_java.bai_tap;

public class DemSoKiTuTrongChuoi {
    public static void main(String[] args) {
        String str = "Pham Van Man";
        char ch = 'a';
        byte count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ch) {
                count++;
            }
        }
        if (count == 0) {
            System.out.println("Khong co ki tu " + ch + " trong chuoi");
        } else {
            System.out.println("Trong chuoi co " + count + "ki tu " + ch + "trong chuoi");
        }
    }
}
