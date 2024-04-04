package DAY_01;

import java.util.*;

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    Node head;

    public LinkedList() {
        this.head = null;
    }

    public void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static LinkedList mergeSortedLists(LinkedList list1, LinkedList list2) {
        LinkedList mergedList = new LinkedList();
        Node current1 = list1.head;
        Node current2 = list2.head;

        while (current1 != null && current2 != null) {
            if (current1.data < current2.data) {
                mergedList.insert(current1.data);
                current1 = current1.next;
            } else {
                mergedList.insert(current2.data);
                current2 = current2.next;
            }
        }

        while (current1 != null) {
            mergedList.insert(current1.data);
            current1 = current1.next;
        }

        while (current2 != null) {
            mergedList.insert(current2.data);
            current2 = current2.next;
        }

        return mergedList;
    }
}

 class Merge_TwosortedLL {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Create and populate first linked list
        LinkedList list1 = new LinkedList();
        System.out.println("Enter the size of the linked list :");
        int n1=sc.nextInt();
        System.out.println("Enter elements for the first linked list:");

        for(int i=0;i<n1;i++){
            int data = sc.nextInt();
            list1.insert(data);
        }

        // Create and populate second linked list
        LinkedList list2 = new LinkedList();
        System.out.println("Enter the size of the linked list :");
        int n2=sc.nextInt();
        System.out.println("Enter elements for the second linked list:");

        for(int i=0;i<n2;i++){
            int data = sc.nextInt();
            list2.insert(data);
        }
    

        System.out.println("List 1:");
        list1.display();
        System.out.println("List 2:");
        list2.display();

        LinkedList mergedList = LinkedList.mergeSortedLists(list1, list2);
        System.out.println("Merged Sorted List:");
        mergedList.display();

        sc.close();
    }
}