package ss9_automated_testing_tdd.bai_tap.bai_tap_3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FizzBuzzTranslateTest {
    @Test
    public void test0() {
        int number = 3;
        String expected = "Fizz";
        String actual = FizzBuzzTranslate.traslate(number);
        assertEquals(expected, actual);
    }
    @Test
    public void test1() {
        int number = 5;
        String expected = "Buzz";
        String actual = FizzBuzzTranslate.traslate(number);
        assertEquals(expected, actual);
    }
    @Test
    public void test2() {
        int number = 15;
        String expected = "FizzBuzz";
        String actual = FizzBuzzTranslate.traslate(number);
        assertEquals(expected, actual);
    }
    @Test
    public void test3() {
        int number = 0;
        String expected = "khong";
        String actual = FizzBuzzTranslate.traslate(number);
        assertEquals(expected, actual);
    }
    @Test
    public void test4() {
        int number = 11;
        String expected = "mot mot";
        String actual = FizzBuzzTranslate.traslate(number);
        assertEquals(expected, actual);
    }
    @Test
    public void test5() {
        int number = 13;
        String expected = "Fizz";
        String actual = FizzBuzzTranslate.traslate(number);
        assertEquals(expected, actual);
    }
}
