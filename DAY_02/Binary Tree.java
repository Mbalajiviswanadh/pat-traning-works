package DAY_02;
import java.util.*;

class treeNode {
    int data;
    treeNode left, right;

    treeNode(int n) {
        this.data = n;
    }
}

class tree {

    treeNode root;

    // in order traversal
    public void inorder(treeNode curr) {
        if (curr == null) {
            return;
        }
        inorder(curr.left);
        System.out.print(curr.data + " ");
        inorder(curr.right);
    }

    public void levelOrder() {
        Queue<treeNode> q = new LinkedList<treeNode>();

        q.offer(root);
        while (!q.isEmpty()) {
            treeNode curr = q.poll();
            System.out.print(curr.data + " ");
            if (curr.left != null) {
                q.add(curr.left);
            }
            if (curr.right != null) {
                q.add(curr.right);
            }
        }
    }
}

class demo {
    public static void main(String[] args) {
        tree t = new tree();
        t.root = new treeNode(1);
        t.root.left = new treeNode(5);
        t.root.right = new treeNode(6);
        t.root.left.left = new treeNode(2);
        t.root.left.right = new treeNode(7);
        t.root.right.left = new treeNode(8);
        t.root.right.right = new treeNode(9);

        t.inorder(t.root); 
        System.out.println();
        t.levelOrder();
    }
}

