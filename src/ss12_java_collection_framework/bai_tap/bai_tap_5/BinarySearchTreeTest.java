package ss12_java_collection_framework.bai_tap.bai_tap_5;

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
        int keyToSearch = 40;
        if (bst.search(keyToSearch)) {
            System.out.println(keyToSearch + " found in the BST.");
        } else {
            System.out.println(keyToSearch + " not found in the BST.");
        }
    }
}
