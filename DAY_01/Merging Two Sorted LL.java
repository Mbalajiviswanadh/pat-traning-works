package DAY_01;

import java.util.*;
class Merge_TwoSortedLL{
    static Node head;


    static class Node{
        Node next;
        int data;


        Node(int data){
            this.data=data;
            this.next=null;
        }
    }


    public static void insertValue(int data){
        Node newNode =new Node(data);

        if(head==null){
            head=newNode;
            return ;
        }

        Node curr=head;
        while(curr.next!=null){
            curr=curr.next;
        }
        curr.next=newNode;
    }

    public static void merged_LL(){
        
    }


    public static void display(){
        if(head==null){
            System.out.println("List is Empty");
            
        }

        Node curr=head;
        while(curr!=null){
            System.out.print(curr.data+" -> ");
            curr=curr.next;
        }
        System.out.println("NULL");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Merge_TwoSortedLL m_ll=new Merge_TwoSortedLL();
        System.out.println("ENter the size of 1st LL :");
        int n1=sc.nextInt();

        System.out.println("ENter the values inside :");
        for(int i=0;i<n1;i++){
            int data=sc.nextInt();
            m_ll.insertValue(data);

        }

        System.out.println("Enter the size of 2nd LL");
        int n2=sc.nextInt();
        for(int i=0;i<n2;i++){
            int data=sc.nextInt();
            m_ll.insertValue(data);

        }

        System.out.println("Taken LL:");
        display();


    }
}