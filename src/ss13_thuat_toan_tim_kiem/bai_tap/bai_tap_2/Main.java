package ss13_thuat_toan_tim_kiem.bai_tap.bai_tap_2;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] intArray = new int[10];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < intArray.length; i++) {
            intArray[i] = (int) ((Math.random() * 100) + 1);
        }
//        Arrays.sort(intArray);
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int i : intArray) {
            priorityQueue.add(i);
        }
        for (int i = 0; i < intArray.length; i++) {
            intArray[i] = priorityQueue.poll();
        }
    }

    public static int binarySearch(int[] array, int left, int right, int value) {
        int mid = (left + right) / 2;
        if (left > right) {
            return -1;
        }
        if (array[mid] == value) {
            return mid;
        } else if (array[mid] > value) {
            return binarySearch(array, left, mid - 1, value);
        } else {
            return binarySearch(array, mid + 1, right, value);
        }
    }
}
