package test.test;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        System.out.println("Hello World");
        int[] intArray = new int[10];
        for (int i = 0; i < intArray.length; i++) {
            intArray[i] = ((int) (Math.random() * 100)) + 1;
        }
        System.out.println(Arrays.toString(intArray));
        for (int i = 1; i < intArray.length; i++) {
            int x = intArray[i];
            int pos = i;
            while (pos > 0 && x < intArray[pos - 1]) {
                intArray[pos] = intArray[pos - 1];
                pos--;
            }
            intArray[pos] = x;
        }
        System.out.println(Arrays.toString(intArray));
    }
}