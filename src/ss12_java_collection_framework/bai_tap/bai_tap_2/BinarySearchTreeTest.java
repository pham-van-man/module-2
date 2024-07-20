package ss12_java_collection_framework.bai_tap.bai_tap_2;

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
        System.out.println("Postorder traversal of BST is:");
        bst.printPostorder(); // Output: 20 40 30 60 80 70 50
    }
}
