package ss12_java_collection_framework.bai_tap.bai_tap_2;

public class BinarySearchTree {
    Node root;

    // Hàm duyệt cây theo thứ tự postorder
    void printPostorder(Node node) {
        if (node == null)
            return;
        // Bước 1: Duyệt cây con bên trái
        printPostorder(node.left);
        // Bước 2: Duyệt cây con bên phải
        printPostorder(node.right);
        // Bước 3: Truy cập nút gốc
        System.out.print(node.data + " ");
    }

    // Phương thức để bắt đầu duyệt từ nút gốc
    void printPostorder() {
        printPostorder(root);
    }
}

