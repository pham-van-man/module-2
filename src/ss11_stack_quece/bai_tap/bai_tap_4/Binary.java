package ss11_stack_quece.bai_tap.bai_tap_4;

import java.util.Stack;

public class Binary {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        int number = 30;
        StringBuilder result = new StringBuilder();
        while (number > 0) {
            stack.push(number % 2);
            number = number / 2;
        }
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }
        System.out.println(result);
    }
}
