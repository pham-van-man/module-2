package ss11_stack_quece.bai_tap.bai_tap_1;

import java.util.Stack;

public class WStack {
    public static void main(String[] args) {
        String string = "Pham Van Man";
        StringBuilder reverseString = new StringBuilder();
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < string.length(); i++) {
            char ch = string.charAt(i);
            stack.push(String.valueOf(ch));
        }

        for (int i = 0; i < string.length(); i++) {
            reverseString.append(stack.pop());
        }
        System.out.println(reverseString);
    }
}
