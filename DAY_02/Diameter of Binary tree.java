package DAY_02;
import java.util.*;
class Node {
    int data;
    Node left, right;

    public Node(int data) {
        this.data = data;
        left = right = null;
    }
}
class Diameter_BT {
    Node root;
    int height(Node node) {
        if (node == null)
            return 0;
        else {
            int leftHeight = height(node.left);
            int rightHeight = height(node.right);
            return 1 + Math.max(leftHeight, rightHeight);
        }
    }
    int diameter(Node root) {
        if (root == null)
            return 0;
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        int leftDiameter = diameter(root.left);
        int rightDiameter = diameter(root.right);
        return Math.max(leftHeight + rightHeight + 1, Math.max(leftDiameter, rightDiameter));
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Diameter_BT tree = new Diameter_BT();
        while (true) {
            int data = scanner.nextInt();
            if (data == -1)
                break;
            tree.root = insert(tree.root, data);
        }

        System.out.println("Diameter of the given binary tree is " + tree.diameter(tree.root));
        scanner.close();
    }
    static Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        }
        if (data < root.data) {
            root.left = insert(root.left, data);
        } else if (data > root.data) {
            root.right = insert(root.right, data);
        }
        return root;
    }
}