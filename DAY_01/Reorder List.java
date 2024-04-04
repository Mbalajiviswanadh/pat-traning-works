package DAY_01;

import java.util.Scanner;
 class Reorder_ll {
    Node head;
    static class Node {
        int data;
        Node next;
        Node(int d)
        {
            data = d;
            next = null;
        }
    }
    public static Reorder_ll insert(Reorder_ll list, int data)
    {
        Node new_node = new Node(data);

        if (list.head == null) {
            list.head = new_node;
        }
        else {
            Node last = list.head;
            while (last.next != null) {
                last = last.next;
            }
            last.next = new_node;
        }
        return list;
    }
    public static void printList(Reorder_ll list)
    {
        Node currNode = list.head;
        System.out.print("LinkedList: ");
        while (currNode != null) {
            System.out.print(currNode.data + " ");
            currNode = currNode.next;
        }
    }
    public static Reorder_ll reverse(Reorder_ll ll){
        Node curr  = ll.head;
        Node prev = null;
        Node next = null;
        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        ll.head = prev;
        return ll;
    }
    public static void  reorder(Reorder_ll ll, int n){
        Reorder_ll llorg = new Reorder_ll();
        Node cur = ll.head;
        while(cur!=null){
            insert(llorg,cur.data);
            cur=cur.next;
        }
        reverse(ll);
        Reorder_ll res = new Reorder_ll();
        Node revh = ll.head;
        Node curr = llorg.head;
        while(curr!=null){
            insert(res,revh.data);
            insert(res,curr.data);
            curr = curr.next;
            revh = revh.next;
        }
        Node abc = res.head;
        for(int j= 0;j<n;j++){

            System.out.print(abc.data +" ");
            abc = abc.next;
        }
    }
    public static void main(String[] args)
    {
        Reorder_ll list = new Reorder_ll();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String str = sc.nextLine();
        String arr [] = str.split(" ");
        for (int i=0;i<n;i++){
            insert(list,Integer.parseInt(arr[i]));
        }
        reorder(list,n);
    }
}


/*
 * import java.util.Scanner;
public class Main {
    Node head;
    static class Node {
        int data;
        Node next;
        Node(int d)
        {
            data = d;
            next = null;
        }
    }
    public static Main insert(Main list, int data)
    {
        Node new_node = new Node(data);

        if (list.head == null) {
            list.head = new_node;
        }
        else {
            Node last = list.head;
            while (last.next != null) {
                last = last.next;
            }
            last.next = new_node;
        }
        return list;
    }
    public static void printList(Main list)
    {
        Node currNode = list.head;
        System.out.print("LinkedList: ");
        while (currNode != null) {
            System.out.print(currNode.data + " ");
            currNode = currNode.next;
        }
    }
    public static Main reverse(Main ll){
        Node curr  = ll.head;
        Node prev = null;
        Node next = null;
        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        ll.head = prev;
        return ll;
    }
    public static void  reorder(Main ll, int n){
        Main llorg = new Main();
        Node cur = ll.head;
        while(cur!=null){
            insert(llorg,cur.data);
            cur=cur.next;
        }
        reverse(ll);
        Main res = new Main();
        Node revh = ll.head;
        Node curr = llorg.head;
        while(curr!=null){
            insert(res,revh.data);
            insert(res,curr.data);
            curr = curr.next;
            revh = revh.next;
        }
        Node abc = res.head;
        for(int j= 0;j<n;j++){

            System.out.print(abc.data +" ");
            abc = abc.next;
        }
    }
    public static void main(String[] args)
    {
        Main list = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String str = sc.nextLine();
        String arr [] = str.split(" ");
        for (int i=0;i<n;i++){
            insert(list,Integer.parseInt(arr[i]));
        }
        reorder(list,n);
    }
}

 */