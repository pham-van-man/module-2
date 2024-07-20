package ss13_thuat_toan_tim_kiem.bai_tap.bai_tap_1;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String string = sc.nextLine();
        Stack<Character> stringMax = new Stack<>();
        for (int i = 0; i < string.length(); i++) {
            Stack<Character> list = new Stack<>();
            list.add(string.charAt(i));
            for (int j = i + 1; j < string.length(); j++) {
                if (string.charAt(j) > list.peek()) {
                    list.add(string.charAt(j));
                }
            }
            if (list.size() > stringMax.size()) {
                stringMax = (Stack<Character>) list.clone();
            }
        }
        stringMax.stream().forEach(System.out::print);
    }
}
//2 vòng lặp lồng nhau là n^2
//một list là n
//tổng tốn O(n^2) thời gian và O(n) không gian