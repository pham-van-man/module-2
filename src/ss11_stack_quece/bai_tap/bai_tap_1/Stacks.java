package ss11_stack_quece.bai_tap.bai_tap_1;

import java.util.Arrays;
import java.util.Stack;

public class Stacks {
    public static void main(String[] args) {
        int[] arrayInt = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        Stack<Integer> stack = new Stack<>();
        for (int j : arrayInt) {
            stack.push(j);
        }
        for (int i = 0; i < arrayInt.length; i++) {
            arrayInt[i] = stack.pop();
        }
        System.out.println(Arrays.toString(arrayInt));
    }
}