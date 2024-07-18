package ss12_java_collection_framework.bai_tap.bai_tap_1;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class ProductManager {
    private static List<Product> listProduct = new LinkedList<>();
    private static int id;
    static Scanner scanner = new Scanner(System.in);

    public void add() {
        System.out.println("Nhập tên sản phẩm");
        String name = scanner.nextLine();
        System.out.println("Nhập giá sản phẩm");
        int price = Integer.parseInt(scanner.nextLine());
        Product product = new Product(id, name, price);
        listProduct.add(product);
        id = listProduct.size();
    }

    public void edit() {
        System.out.println("Nhập ID sản phẩm muốn chỉnh sửa");
        int id = Integer.parseInt(scanner.nextLine());
        if (id < 0 || id > listProduct.size() - 1) {
            System.out.println("Chỉnh sửa thất bại");
        } else {
            System.out.println("Nhập tên sản phẩm");
            String name = scanner.nextLine();
            System.out.println("Nhập giá sản phẩm");
            int price = Integer.parseInt(scanner.nextLine());
            Product product = new Product(id, name, price);
            listProduct.set(id, product);
        }
    }

    public void remove() {
        System.out.println("Nhập ID sản phảm muốn xóa");
        int id = Integer.parseInt(scanner.nextLine());
        if (id < 0 || id > listProduct.size() - 1) {
            System.out.println("Chỉnh sửa thất bại");
        } else {
            listProduct.remove(id);
            this.id = listProduct.size();
            System.out.println("Xóa thành công");
        }
    }

    public void display() {
        for (Product product : listProduct) {
            System.out.println(product);
        }
    }

    public void search() {
        System.out.println("Nhập ID cần tìm");
        int id = Integer.parseInt(scanner.nextLine());
        if (id < 0 || id > listProduct.size() - 1) {
            System.out.println("Tìm kiếm thất bại");
        } else {
            System.out.println(listProduct.get(id));
        }
    }

    public static void main(String[] args) {
        ProductManager productManager = new ProductManager();
        do {
            System.out.println("Quản lý sản phẩm");
            System.out.println(
                    "1. Hiển thị sản phẩm " + "\n" +
                            "2. Thêm sản phẩm" + "\n" +
                            "3. Xóa sản phẩm" + "\n" +
                            "4. Chỉnh sửa sản phẩm" + "\n" +
                            "5. Tìm sản phẩm" + "\n" +
                            "6. Thoát");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    productManager.display();
                    break;
                case 2:
                    productManager.add();
                    break;
                case 3:
                    productManager.remove();
                    break;
                case 4:
                    productManager.edit();
                    break;
                case 5:
                    productManager.search();
                    break;
                case 6:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Lựa chọn thất bại");
                    break;
            }
        } while (true);
    }
}
