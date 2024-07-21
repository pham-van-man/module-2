package ss14_thuat_toan_sap_xep.bai_tap.bai_tap_1;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] intArray = new int[10];
        for (int i = 0; i < intArray.length; i++) {
            intArray[i] = (int) (Math.random() * 10) + 1;
        }
        System.out.println(Arrays.toString(intArray));
        for (int i = 0; i < intArray.length; i++) {
            int temp = intArray[i];
            int index = i;
            for (int j = i-1; j >= 0; j--) {
                if (intArray[j] > temp) {
                    intArray[j+1] = intArray[j];
                    index = j;
                }
            }
            if (index != i) {
                intArray[index] = temp;
            }
        }
        System.out.println(Arrays.toString(intArray));
    }
}
