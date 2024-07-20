package ss12_java_collection_framework.bai_tap.bai_tap_3;

public class BinarySearchTree {
    Node root;

    // Hàm tìm nút có giá trị nhỏ nhất trong cây
    Node minValueNode(Node node) {
        Node current = node;
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }

    // Hàm xoá một phần tử khỏi BST
    Node deleteNode(Node root, int key) {
        // Nếu cây rỗng, trả về null
        if (root == null) return root;
        // Tìm nút cần xóa
        if (key < root.data) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.data) {
            root.right = deleteNode(root.right, key);
        } else {
            // Nút cần xóa tìm thấy
            // Nút không có con
            if (root.left == null && root.right == null) {
                return null;
            }
            // Nút có một con
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }
            // Nút có hai con
            // Tìm phần tử thay thế (nút nhỏ nhất trong cây con phải)
            Node temp = minValueNode(root.right);
            root.data = temp.data;
            root.right = deleteNode(root.right, temp.data);
        }
        return root;
    }

    // Phương thức để bắt đầu xóa từ nút gốc
    void deleteNode(int key) {
        root = deleteNode(root, key);
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
