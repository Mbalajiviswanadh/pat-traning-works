package DAY_01;

import java.util.*;



 class Main {
    class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public int size;
    public Node head = null;
    public Node tail = null;

    public void addNode(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public void isPalindrome() {
        Node current = head;
        boolean flag = true;
        int mid = (size % 2 == 0) ? (size / 2) : ((size + 1) / 2);
        for (int i = 1; i < mid; i++) {
            current = current.next;
        }
        Node revHead = reverselist(current.next);
        while (head != null && revHead != null) {
            if (head.data != revHead.data) {
                flag = false;
                break;
            }
            head = head.next;
            revHead = revHead.next;
        }
        if (flag) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }

    public Node reverselist(Node temp) {
        Node current = temp;
        Node prevNode = null;
        Node nextNode = null;
        while (current != null) {
            nextNode = current.next;
            current.next = prevNode;
            prevNode = current;
            current = nextNode;
        }
        return prevNode;
    }

    public static void main(String[] args) {
        Main m1 = new Main();
        Scanner sc = new Scanner(System.in);
        
        int size = sc.nextInt(); // Read the size of the sequence
        for (int i = 0; i < size; i++) {
            int num = sc.nextInt(); // Read each integer in the sequence
            m1.addNode(num);
        }
        
        m1.isPalindrome();
    }
}
