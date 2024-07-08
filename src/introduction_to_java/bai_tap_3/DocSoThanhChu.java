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
            System.out.println(readSingleDigit(number));
        } else if (number < 20) {
            System.out.println(readTeen(number));
        } else if (number < 100) {
            System.out.println(readTens(number));
        } else {
            System.out.println(readHundreds(number));
        }
        scanner.close();
    }

    private static String readSingleDigit(int number) {
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

    private static String readTeen(int number) {
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

    private static String readTens(int number) {
        int tens = number / 10;
        int ones = number % 10;
        String result = "";
        switch (tens) {
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
        if (ones != 0) {
            result += " " + readSingleDigit(ones);
        }
        return result;
    }

    private static String readHundreds(int number) {
        int hundreds = number / 100;
        int remainder = number % 100;
        String result = readSingleDigit(hundreds) + " hundred";
        if (remainder != 0) {
            if (remainder < 10) {
                result += " and " + readSingleDigit(remainder);
            } else if (remainder < 20) {
                result += " and " + readTeen(remainder);
            } else {
                result += " and " + readTens(remainder);
            }
        }
        return result;
    }
}
