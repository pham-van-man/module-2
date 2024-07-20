package ss12_java_collection_framework.bai_tap.bai_tap_3;

public class BinarySearchTreeTest {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.root = new Node(50);
        bst.root.left = new Node(30);
        bst.root.right = new Node(70);
        bst.root.left.left = new Node(20);
        bst.root.left.right = new Node(40);
        bst.root.right.left = new Node(60);
        bst.root.right.right = new Node(80);
        System.out.println("Inorder traversal of BST:");
        bst.inorder(bst.root); // Output: 20 30 40 50 60 70 80
        System.out.println();
        bst.deleteNode(20);
        System.out.println("Inorder traversal after deleting 20:");
        bst.inorder(bst.root); // Output: 30 40 50 60 70 80
        System.out.println();
        bst.deleteNode(30);
        System.out.println("Inorder traversal after deleting 30:");
        bst.inorder(bst.root); // Output: 40 50 60 70 80
        System.out.println();
        bst.deleteNode(50);
        System.out.println("Inorder traversal after deleting 50:");
        bst.inorder(bst.root); // Output: 40 60 70 80
    }
}
