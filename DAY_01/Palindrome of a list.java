package DAY_01;

import java.util.*;


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

    public boolean isPalindrome() {
        Node fast = head;
        Node slow = head;
        Stack<Integer> stack = new Stack<>();

        while (fast != null && fast.next != null) {
            stack.push(slow.data);
            slow = slow.next;
            fast = fast.next.next;
        }

        // If the size is odd, move the slow pointer one step forward
        if (fast != null) {
            slow = slow.next;
        }

        while (slow != null) {
            int top = stack.pop();
            if (top != slow.data) {
                return false;
            }
            slow = slow.next;
        }
        return true;
    }

    public static void main(String[] args) {
        Main m1 = new Main();
        Scanner sc = new Scanner(System.in);
        
        int size = sc.nextInt(); 
        for (int i = 0; i < size; i++) {
            int num = sc.nextInt(); 
            m1.addNode(num);
        }
        
        boolean result = m1.isPalindrome();
        System.out.println(result);
    }
}
