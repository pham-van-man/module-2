package ss12_java_collection_framework.bai_tap.bai_tap_4;

public class BinarySearchTree {
    Node root;

    // Hàm duyệt cây theo thứ tự preorder
    void printPreorder(Node node) {
        if (node == null)
            return;
        // Bước 1: Truy cập nút gốc
        System.out.print(node.data + " ");
        // Bước 2: Duyệt cây con bên trái
        printPreorder(node.left);
        // Bước 3: Duyệt cây con bên phải
        printPreorder(node.right);
    }

    // Phương thức để bắt đầu duyệt từ nút gốc
    void printPreorder() {
        printPreorder(root);
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
