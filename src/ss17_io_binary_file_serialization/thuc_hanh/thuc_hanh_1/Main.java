package ss17_io_binary_file_serialization.thuc_hanh.thuc_hanh_1;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

public class Main {
    private static void copyFileUsingJava7Files(File source, File dest) {
        try {
            Files.copy(source.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException _) {
        }
    }

    private static void copyFileUsingStream(File source, File dest) {
        try (FileInputStream fileInput = new FileInputStream(source); FileOutputStream fileOutput = new FileOutputStream(dest)) {
            byte[] buffer = new byte[1024];
            int length;
            while ((length = fileInput.read(buffer)) > 0) {
                fileOutput.write(buffer, 0, length);
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
        copyFileUsingJava7Files(sourceFile, destFile);
        copyFileUsingStream(sourceFile, destFile);
        System.out.println("Copy completed");
    }
}
