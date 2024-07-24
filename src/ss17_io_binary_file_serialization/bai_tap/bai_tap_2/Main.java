package ss17_io_binary_file_serialization.bai_tap.bai_tap_2;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

public class Main {
    public static void copyFileJava7(File sourceFile, File destFile) {
        if (!sourceFile.exists()) {
            System.out.println("Tệp không tồn tại");
        }
        if (!destFile.exists()) {
            System.out.println("Tệp bị thay thế");
        }
        try {
            Files.copy(sourceFile.toPath(), destFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException _) {
        }
    }

    public static void copyFile(File sourceFile, File destFile) {
        if (!sourceFile.exists()) {
            System.out.println("Tệp không tồn tại");
        }
        if (!destFile.exists()) {
            System.out.println("Tệp bị thay thế");
        }
        try (FileInputStream readerFile = new FileInputStream(sourceFile); FileOutputStream writerFile = new FileOutputStream(destFile)) {
            byte[] buffer = new byte[1024];
            int length;
            while ((length = readerFile.read(buffer)) > 0) {
                writerFile.write(buffer, 0, length);
            }
        } catch (IOException _) {
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Nhập đường dẫn");
        String sourcePath = in.nextLine();
        System.out.println("Nhập đường dẫn đích");
        String destPath = in.nextLine();
        File sourceFile = new File(sourcePath);
        File destFile = new File(destPath);
        copyFileJava7(sourceFile, destFile);
        copyFile(sourceFile, destFile);
        System.out.println("Sao chép thành công");
    }
}
