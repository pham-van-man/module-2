package ss16_io_text_file.bai_tap.bai_tap_1;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập đường dẫn nguồn");
        String inPut = sc.nextLine();
        System.out.println("Nhập đường đẫn đích");
        String outPut = sc.nextLine();
        File fileInPut = new File(inPut);
        File fileOutPut = new File(outPut);
        if (!fileInPut.exists()) {
            System.out.println("Lỗi dữ liệu");
        }
        if (fileOutPut.exists()) {
            System.out.println("Xóa dữ liệu");
        }
        try (FileReader reader = new FileReader(fileInPut);
             FileWriter writer = new FileWriter(fileOutPut)) {
            int characterCount = 0;
            int ch;
            while ((ch = reader.read()) != -1) {
                writer.write(ch);
                characterCount++;
            }
            System.out.println("Sao chép thành công " + characterCount + " Kí tự");
        }
    }
}
