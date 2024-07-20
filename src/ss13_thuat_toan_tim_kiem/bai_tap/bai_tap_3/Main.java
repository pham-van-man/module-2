package ss13_thuat_toan_tim_kiem.bai_tap.bai_tap_3;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LinkedList<Character> max = new LinkedList<>();
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập chuỗi");
        String string = sc.nextLine();
        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            LinkedList<Character> list = new LinkedList<>();
            list.add(c);
            for (int j = i + 1; j < string.length(); j++) {
                char c2 = string.charAt(j);
                if (c2 > list.peek()) {
                    list.add(c2);
                } else {
                    break;
                }
            }
            if (list.size() > max.size()) {
                max = (LinkedList<Character>) list.clone();
            }
        }
        max.stream().forEach(System.out::println);
    }
}
//2 vòng lặp lồng nhau là n^2
//một list là n
//tổng tốn O(n^2) thời gian và O(n) không gian