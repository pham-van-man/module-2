package ss11_stack_quece.bai_tap.bai_tap_5;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Palindrome {
    public static void main(String[] args) {
        String palindrome = "Able was I ere I saw Elba";
        Queue<Character> queue = new LinkedList<>();
        Stack<Character> stack = new Stack<>();
        palindrome = palindrome.toLowerCase();
        System.out.println(palindrome);

        for (int i = 0; i < palindrome.length(); i++) {
            char ch = palindrome.charAt(i);
            queue.add(ch);
            stack.push(ch);
        }

        boolean isPalindrome = true;
        while (!queue.isEmpty()) {
            if (!queue.remove().equals(stack.pop())) {
                isPalindrome = false;
                break;
            }
        }

        if (isPalindrome) {
            System.out.println("The string is a palindrome.");
        } else {
            System.out.println("The string is not a palindrome.");
        }
    }
}