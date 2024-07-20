package ss12_java_collection_framework.bai_tap.bai_tap_5;

public class BinarySearchTree {
    Node root;

    // Hàm tìm kiếm một phần tử trong BST
    boolean search(Node root, int key) {
        // Nếu cây rỗng hoặc tìm thấy phần tử
        if (root == null || root.data == key)
            return root != null;
        // Nếu phần tử nhỏ hơn giá trị nút hiện tại, tìm kiếm bên trái
        if (key < root.data)
            return search(root.left, key);
        // Nếu phần tử lớn hơn giá trị nút hiện tại, tìm kiếm bên phải
        return search(root.right, key);
    }

    // Phương thức để bắt đầu tìm kiếm từ nút gốc
    boolean search(int key) {
        return search(root, key);
    }

    // Hàm in cây theo thứ tự inorder để kiểm tra
    void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }
}
