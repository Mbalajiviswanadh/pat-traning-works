package DAY_01;

import java.util.Scanner;

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class Rotate_list {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read elements to be added in the list until -1 occurs
        Node head = null;
        Node tail = null;
        int data;
        while ((data = scanner.nextInt()) != -1) {
            Node newNode = new Node(data);
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        // Read the number of rotations
        int rotations = scanner.nextInt();

        // Print the given linked list
        System.out.println("Given linked list:");
        printList(head);

        // Rotate the linked list to the left
        head = rotateLinkedList(head, rotations);

        // Print the rotated linked list
        System.out.println("Rotated Linked list:");
        printList(head);

        scanner.close();
    }

    // Method to rotate the given linked list by 'rotations' positions to the left
    public static Node rotateLinkedList(Node head, int rotations) {
        if (head == null || rotations <= 0) {
            return head;
        }

        // Find the length of the linked list
        int length = 1;
        Node current = head;
        while (current.next != null) {
            current = current.next;
            length++;
        }

        // Calculate the effective rotations
        rotations = rotations % length;

        if (rotations == 0) {
            return head;
        }

        // Traverse to the node just before the new head after rotation
        current = head;
        for (int i = 0; i < rotations - 1; i++) {
            current = current.next;
        }

        // Update the pointers
        Node newHead = current.next;
        current.next = null;
        current = newHead;
        while (current.next != null) {
            current = current.next;
        }
        current.next = head;

        return newHead;
    }

    // Method to print the linked list
    public static void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }
}


