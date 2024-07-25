package ss19_string_regex.bai_tap.bai_tap_2;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("^\\([0-9]{2}\\)-\\(0[0-9]{9}\\)$");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập số điện thoại");
        String input = scanner.nextLine();
        Matcher matcher = pattern.matcher(input);
        if (matcher.matches()) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
