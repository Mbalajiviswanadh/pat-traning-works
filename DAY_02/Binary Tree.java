package DAY_02;
import java.util.*;
class treeNode{
    int data;
    treeNode left,right;
    treeNode(int n){
        this.data=n;
    }

    public static void inorder(treeNode curr){
        if(curr==null){
            return;
        }
        inorder(curr.left);
        System.out.print(curr.data+" ");
        inorder(curr.right);
    }
    
}



class demo{
    public static void main(String[] args) {
        treeNode root=new treeNode(1);
        root.left=new treeNode(5);
        root.right=new treeNode(6);
        root.left.left=new treeNode(2);
        root.left.right=new treeNode(7);
        root.right.left=new treeNode(8);
        root.right.right=new treeNode(9);
        

        root.inorder(root);
    }
}


