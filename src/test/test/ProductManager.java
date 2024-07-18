package test.test;

import java.util.LinkedList;
import java.util.List;

public class ProductManager {
    private static List<Product> listProduct = new LinkedList<>();
    static {
        Product p1 = new Product();
        Product p2 = new Product();
    }
    public static void addProduct(Product p) {
        listProduct.add(p);
    }
    public static void removeProduct(Product p) {
        listProduct.remove(p);
    }
}
