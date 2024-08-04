package study_case.util;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validate {
    private static final Scanner sc = new Scanner(System.in);

    public static int getIntInput(String prompt) {
        int value;
        while (true) {
            try {
                System.out.println(prompt);
                value = Integer.parseInt(sc.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Dữ liệu không hợp lệ");
            }
        }
        return value;
    }

    public static String getStringInput(String prompt) {
        while (true) {
            System.out.println(prompt);
            String value = sc.nextLine().trim();
            if (!value.isEmpty()) {
                value = value.replaceAll("\\s+", " ");
                return value;
            }
            System.out.println("Dữ liệu không hợp lệ");
        }
    }

    public static String getEmailInput(String prompt) {
        while (true) {
            System.out.println(prompt);
            String value = sc.nextLine().trim();
            if (!value.isEmpty()) {
                value = value.replaceAll("\\s+", "");
                Pattern pattern = Pattern.compile("^[A-Za-z0-9]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");
                Matcher matcher = pattern.matcher(value);
                if (matcher.matches()) {
                    return value;
                }
            }
            System.out.println("Dữ liệu không hợp lệ");
        }
    }

    public static String getPhoneNumberInput(String prompt) {
        while (true) {
            System.out.println(prompt);
            String value = sc.nextLine().trim();
            if (!value.isEmpty()) {
                value = value.replaceAll("\\s+", "");
                Pattern pattern = Pattern.compile("^0[0-9]{9}$");
                Matcher matcher = pattern.matcher(value);
                if (matcher.matches()) {
                    return value;
                }
            }
            System.out.println("Dữ liệu không hợp lệ");
        }
    }

    public static int getAgeInput(String prompt) {
        int value;
        while (true) {
            try {
                System.out.println(prompt);
                value = Integer.parseInt(sc.nextLine());
                if (value < 0) {
                    System.out.println("Dữ liệu không hợp lệ");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Dữ liệu không hợp lệ");
            }
        }
        return value;
    }
}
