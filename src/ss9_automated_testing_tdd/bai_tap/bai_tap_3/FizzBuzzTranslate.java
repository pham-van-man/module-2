package ss9_automated_testing_tdd.bai_tap.bai_tap_3;

public class FizzBuzzTranslate {
    public static String traslate(int n) {
        if (n < 0 || n > 100) {
            throw new UnsupportedOperationException();
        } else if (n == 0) {
            return getWordNumber((n + "").charAt(0));
        } else if (n % 3 == 0 && n % 5 == 0) {
            return "FizzBuzz";
        } else if (n % 3 == 0) {
            return "Fizz";
        } else if (n % 5 == 0) {
            return "Buzz";
        } else if ((n + "").contains("3")) {
            return "Fizz";
        } else if ((n + "").contains("5")) {
            return "Buzz";
        } else if ((n + "").length() == 2) {
            return getWordNumber((n + "").charAt(0)) + " " + getWordNumber((n + "").charAt(1));
        } else {
            return getWordNumber((n + "").charAt(0));
        }
    }

    private static String getWordNumber(char n) {
        return switch (n) {
            case '0' -> "khong";
            case '1' -> "mot";
            case '2' -> "hai";
            case '3' -> "ba";
            case '4' -> "bon";
            case '5' -> "nam";
            case '6' -> "sau";
            case '7' -> "bay";
            case '8' -> "tam";
            case '9' -> "chin";
            default -> throw new UnsupportedOperationException();
        };
    }
}
