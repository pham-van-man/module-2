package ss9_automated_testing_tdd.bai_tap.bai_tap_2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TriangleClassifierTest {
    @Test
    public void test0() {
        byte a = 2;
        byte b = 2;
        byte c = 2;
        String expected = "tam giac dieu";
        String actual = TriangleClassifier.triangleClassification(a, b, c);
        assertEquals(expected, actual);
    }

    @Test
    public void test1() {
        byte a = 2;
        byte b = 2;
        byte c = 3;
        String expected = "tam giac can";
        String actual = TriangleClassifier.triangleClassification(a, b, c);
        assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        byte a = 3;
        byte b = 4;
        byte c = 5;
        String expected = "tam giac thuong";
        String actual = TriangleClassifier.triangleClassification(a, b, c);
        assertEquals(expected, actual);
    }

    @Test
    public void test3() {
        byte a = 8;
        byte b = 2;
        byte c = 3;
        String expected = "khong phai tam giac";
        String actual = TriangleClassifier.triangleClassification(a, b, c);
        assertEquals(expected, actual);
    }

    @Test
    public void test4() {
        byte a = -1;
        byte b = 2;
        byte c = 1;
        String expected = "khong phai tam giac";
        String actual = TriangleClassifier.triangleClassification(a, b, c);
        assertEquals(expected, actual);
    }

    @Test
    public void test5() {
        byte a = 0;
        byte b = 1;
        byte c = 1;
        String expected = "khong phai tam giac";
        String actual = TriangleClassifier.triangleClassification(a, b, c);
        assertEquals(expected, actual);
    }
}
