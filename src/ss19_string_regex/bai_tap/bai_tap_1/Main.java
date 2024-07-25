package ss19_string_regex.bai_tap.bai_tap_1;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Pattern regex = Pattern.compile("^[CAP][0-9]{4}[GHIK]$");
        System.out.println("Nhập tên lớp");
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        Matcher matcher = regex.matcher(s);
        if (matcher.matches()) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
