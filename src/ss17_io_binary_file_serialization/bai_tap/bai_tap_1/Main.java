package ss17_io_binary_file_serialization.bai_tap.bai_tap_1;

import java.io.*;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        LinkedList<Product> listProduct = new LinkedList<>();
        listProduct.add(new Product("210", "Mobile", 1000, "Trung Quốc", "Điện thoại di động"));
        listProduct.add(new Product("220", "MobilePro", 1200, "Trung Quốc", "Điện thoại di động"));
        listProduct.add(new Product("230", "MobileProMax", 1900, "Trung Quốc", "Điện thoại di động"));
        listProduct.add(new Product("240", "MobileX", 800, "Trung Quốc", "Điện thoại di động"));
        try (ObjectOutputStream writeFile = new ObjectOutputStream(new FileOutputStream("product.txt"))) {
            writeFile.writeObject(listProduct);
        } catch (IOException _) {
        }
        LinkedList<Product> listProductFromFile = new LinkedList<>();
        try (ObjectInputStream readerFile = new ObjectInputStream(new FileInputStream("product.txt"))) {
            listProductFromFile = (LinkedList<Product>) readerFile.readObject();
        } catch (IOException | ClassNotFoundException _) {
        }
        for (Product product : listProductFromFile) {
            System.out.println(product);
        }
    }
}
