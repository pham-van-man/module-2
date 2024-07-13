package ss9_automated_testing_tdd.bai_tap.bai_tap_2;

public class TriangleClassifier {
    public static String triangleClassification(byte a, byte b, byte c) {
        if (a + b > c && a + c > b && b + c > a) {
            if (a == b && b == c) {
                return "tam giac dieu";
            } else if (a == b || b == c || c == a) {
                return "tam giac can";
            } else {
                return "tam giac thuong";
            }
        } else {
            return "khong phai tam giac";
        }
    }
}
