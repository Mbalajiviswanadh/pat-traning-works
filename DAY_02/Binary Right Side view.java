package DAY_02;

import java.util.*;

class Node {
    int data;
    Node left, right;

    public Node(int d) {
        this.data = d;
    }
}

class Tree {
    Node root;

    void rightView(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        rightviewUtil(root, 0, result);
        for (int val : result) {
            System.out.print(val + " ");
        }
    }

    void rightviewUtil(Node node, int level, ArrayList<Integer> result) {
        if (node == null) {

            return;
        }
        if (result.size() == level) {
            result.add(node.data);
        }
        rightviewUtil(node.right, level + 1, result);
        rightviewUtil(node.left, level + 1, result);

    }

    void insert(String[] str) {
        Queue<Node> q = new LinkedList<>();
        root = new Node(Integer.parseInt(str[0]));
        q.offer(root);
        int i = 1;
        int n = str.length;
        while (i < n && !q.isEmpty()) {
            Node curr = q.poll();
            if (!str[i].equals("N")) {
                curr.left = new Node(Integer.parseInt(str[i]));
                q.offer(curr.left);
            }
            i++;
            if (i >= n) {
                break;
            }
            if (!str[i].equals("N")) {
                curr.right = new Node(Integer.parseInt(str[i]));
                q.offer(curr.right);
            }
            i++;

        }
    }
}

 class Binary_right_view {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] in = sc.nextLine().split(" ");
        Tree t = new Tree();
        t.insert(in);
        t.rightView(t.root);
        sc.close();
    }

}

