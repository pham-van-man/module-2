package ss1_introduction_to_java.bai_tap_1;

import java.util.Scanner;

public class DuaRaLoiChao {
    public static void main(String[] args) {
        System.out.println("Enter your name: ");
        Scanner scanner = new Scanner(System.in);
        double name = scanner.nextFloat();
        System.out.println("Hello: " + name);
    }
}
