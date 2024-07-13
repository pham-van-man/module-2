package ss9_automated_testing_tdd.bai_tap.bai_tap_1;

public class NextDayCalculator {
    public static byte nextDay(byte day, byte month, short year) {
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                if (day < 0 || day > 31) {
                    throw new UnsupportedOperationException();
                }
                if (day == 31) {
                    return 1;
                }
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                if (day < 0 || day > 30) {
                    throw new UnsupportedOperationException();
                }
                if (day == 30) {
                    return 1;
                }
                break;
            case 2:
                if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
                    if (day < 0 || day > 29) {
                        throw new UnsupportedOperationException();
                    }
                    if (day == 29) {
                        return 1;
                    }
                }
                if (day < 0 || day > 28) {
                    throw new UnsupportedOperationException();
                }
                if (day == 28) {
                    return 1;
                }
                break;
            default:
                throw new UnsupportedOperationException();
        }
        return ++day;
    }
}
