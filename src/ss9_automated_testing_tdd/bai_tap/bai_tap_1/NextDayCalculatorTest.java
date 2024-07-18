package ss9_automated_testing_tdd.bai_tap.bai_tap_1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

public class NextDayCalculatorTest {
//    @Test
//    public void test0() {
//        byte day = 1;
//        byte month = 1;
//        short year = 2018;
//        byte expected = 2;
//        byte actual = NextDayCalculator.nextDay(day, month, year);
//        assertEquals(expected, actual);
//    }
//    @Test
//    public void test1() {
//        byte day = 31;
//        byte month = 1;
//        short year = 2018;
//        byte expected = 1;
//        byte actual = NextDayCalculator.nextDay(day, month, year);
//        assertEquals(expected, actual);
//    }
//    @Test
//    public void test2() {
//        byte day = 30;
//        byte month = 4;
//        short year = 2018;
//        byte expected = 1;
//        byte actual = NextDayCalculator.nextDay(day, month, year);
//        assertEquals(expected, actual);
//    }
//    @Test
//    public void test3() {
//        byte day = 28;
//        byte month = 2;
//        short year = 2018;
//        byte expected = 1;
//        byte actual = NextDayCalculator.nextDay(day, month, year);
//        assertEquals(expected, actual);
//    }
//    @Test
//    public void test4() {
//        byte day = 29;
//        byte month = 2;
//        short year = 2020;
//        byte expected = 1;
//        byte actual = NextDayCalculator.nextDay(day, month, year);
//        assertEquals(expected, actual);
//    }
//    @Test
//    public void test5() {
//        byte day = 31;
//        byte month = 12;
//        short year = 2018;
//        byte expected = 1;
//        byte actual = NextDayCalculator.nextDay(day, month, year);
//        assertEquals(expected, actual);
//    }
    @Test
    public void test0() {
        LocalDate date = LocalDate.of(2018, 1, 1);
        LocalDate expected = LocalDate.of(2018, 1, 2);
        LocalDate actual = NextDayCalculator.nextDay(date);
        assertEquals(expected, actual);
    }

    @Test
    public void test1() {
        LocalDate date = LocalDate.of(2018, 1, 31);
        LocalDate expected = LocalDate.of(2018, 2, 1);
        LocalDate actual = NextDayCalculator.nextDay(date);
        assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        LocalDate date = LocalDate.of(2018, 4, 30);
        LocalDate expected = LocalDate.of(2018, 5, 1);
        LocalDate actual = NextDayCalculator.nextDay(date);
        assertEquals(expected, actual);
    }

    @Test
    public void test3() {
        LocalDate date = LocalDate.of(2018, 2, 28);
        LocalDate expected = LocalDate.of(2018, 3, 1);
        LocalDate actual = NextDayCalculator.nextDay(date);
        assertEquals(expected, actual);
    }

    @Test
    public void test4() {
        LocalDate date = LocalDate.of(2020, 2, 29);
        LocalDate expected = LocalDate.of(2020, 3, 1);
        LocalDate actual = NextDayCalculator.nextDay(date);
        assertEquals(expected, actual);
    }

    @Test
    public void test5() {
        LocalDate date = LocalDate.of(2018, 12, 31);
        LocalDate expected = LocalDate.of(2019, 1, 1);
        LocalDate actual = NextDayCalculator.nextDay(date);
        assertEquals(expected, actual);
    }
}
