package introduction_to_java.bai_tap_3;

import java.util.Scanner;

public class DocSoThanhChu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số cần đọc: ");
        int number = scanner.nextInt();
        if (number < 0 || number >= 1000) {
            System.out.println("Out of ability");
        } else if (number < 10) {
            System.out.println(readNumbersLessThan10(number));
        } else if (number < 20) {
            System.out.println(readNumbersFrom10To20(number));
        } else if (number < 100) {
            System.out.println(readNumbersGreaterThan20(number));
        } else {
            System.out.println(readNumbersGreaterThan100(number));
        }
    }

    private static String readNumbersLessThan10(int number) {
        switch (number) {
            case 0:
                return "zero";
            case 1:
                return "one";
            case 2:
                return "two";
            case 3:
                return "three";
            case 4:
                return "four";
            case 5:
                return "five";
            case 6:
                return "six";
            case 7:
                return "seven";
            case 8:
                return "eight";
            case 9:
                return "nine";
            default:
                return "";
        }
    }

    private static String readNumbersFrom10To20(int number) {
        switch (number) {
            case 10:
                return "ten";
            case 11:
                return "eleven";
            case 12:
                return "twelve";
            case 13:
                return "thirteen";
            case 14:
                return "fourteen";
            case 15:
                return "fifteen";
            case 16:
                return "sixteen";
            case 17:
                return "seventeen";
            case 18:
                return "eighteen";
            case 19:
                return "nineteen";
            default:
                return "";
        }
    }

    private static String readNumbersGreaterThan20(int number) {
        int first = number / 10;
        int last = number % 10;
        String result = "";
        switch (first) {
            case 2:
                result = "twenty";
                break;
            case 3:
                result = "thirty";
                break;
            case 4:
                result = "forty";
                break;
            case 5:
                result = "fifty";
                break;
            case 6:
                result = "sixty";
                break;
            case 7:
                result = "seventy";
                break;
            case 8:
                result = "eighty";
                break;
            case 9:
                result = "ninety";
                break;
        }
        if (last != 0) {
            result += " " + readNumbersLessThan10(last);
        }
        return result;
    }

    private static String readNumbersGreaterThan100(int number) {
        int fist = number / 100;
        int last = number % 100;
        String result = readNumbersLessThan10(fist) + " hundred";
        if (last != 0) {
            if (last < 10) {
                result += " and " + readNumbersLessThan10(last);
            } else if (last < 20) {
                result += " and " + readNumbersFrom10To20(last);
            } else {
                result += " and " + readNumbersGreaterThan20(last);
            }
        }
        return result;
    }
}
