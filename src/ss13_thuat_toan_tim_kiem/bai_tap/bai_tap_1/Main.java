package ss13_thuat_toan_tim_kiem.bai_tap.bai_tap_1;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        System.out.print("Nhập chuỗi");
        Scanner sc = new Scanner(System.in);
        String string = sc.nextLine();
        Stack<Character> stringMax = new Stack<>();
        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            Stack<Character> list = new Stack<>();
            list.add(c);
            for (int j = i + 1; j < string.length(); j++) {
                char c2 = string.charAt(j);
                if (string.charAt(j) > list.peek()) {
                    list.add(c2);
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