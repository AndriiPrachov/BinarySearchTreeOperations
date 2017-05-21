import java.util.Scanner;

public class Solution {
    static int height (Node root) {
        if (root == null) {
            return 0;
        }
        int left = 0;
        if (root.left != null) {
            left = height(root.left) + 1;
        }
        int right = 0;
        if (root.right != null) {
            right = height(root.right) + 1;
        }

        return Math.max(left, right);
    }

    static void inOrder(Node root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    private static Node insert(Node root, int value) {
        if (root == null) {
            return new Node(value);
        }
        if (value <= root.data) {
            root.left = insert(root.left, value);
        } else {
            root.right = insert(root.right, value);
        }
        return root;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while (t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
//        int height = height(root);
//        System.out.println(height);
//        inOrder(root);
//        System.out.println();

        BSTIterator bstIterator = new BSTIterator(root);
        while (bstIterator.hasNext()) {
            System.out.print(bstIterator.next() + " ");
        }
    }


}