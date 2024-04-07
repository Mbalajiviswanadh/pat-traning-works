package DAY_02;

import java.util.*;

class Flatten_BT {
    static class Node {
        int data;
        Node left;
        Node right;
        Node(int d) {
            data = d;
        }
    }

    static void flatten(Node root) {
        if (root == null) return;
        Node cur = root;
        while (cur != null) {
            if (cur.left != null) {
                Node rightmost = cur.left;
                while (rightmost.right != null) {
                    rightmost = rightmost.right;
                }
                rightmost.right = cur.right;
                cur.right = cur.left;
                cur.left = null;
            }
            cur = cur.right;
        }
    }

    static Node build(String[] s) {
        if (s[0].equals("N") || s.length == 0)
            return null;

        Queue<Node> q = new LinkedList<>();
        Node root = new Node(Integer.parseInt(s[0]));
        q.add(root);
        int i = 1;
        while (!q.isEmpty() && i < s.length) {
            Node curr = q.poll();
            String curval = s[i];
            if (!curval.equals("N")) {
                curr.left = new Node(Integer.parseInt(curval));
                q.add(curr.left);
            }
            i++;
            if (i >= s.length)
                break;
            curval = s[i];
            if (!curval.equals("N")) {
                curr.right = new Node(Integer.parseInt(curval));
                q.add(curr.right);
            }
            i++;
        }
        return root;
    }

    static void print(Node root) {
        while (root != null) {
            System.out.print(root.data + " ");
            root = root.right;
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        Node root = build(s);
        flatten(root);
        print(root);
        sc.close();
    }

}
