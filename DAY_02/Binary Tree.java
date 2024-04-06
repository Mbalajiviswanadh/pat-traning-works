package DAY_02;
import java.util.*;


class Binary_tree {
    static class treeNode {
        int data;
        treeNode left, right;
    
        treeNode(int n) {
            this.data = n;

        }
    }
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
    public void preOrder(treeNode curr) {
        if (curr == null) {
            return;
        }
        System.out.print(curr.data + " ");
        preOrder(curr.left);
        preOrder(curr.right);
    }

    public void postOrder(treeNode curr) {
        if (curr == null) {
            return;
        }
        postOrder(curr.left);
        postOrder(curr.right);
        System.out.print(curr.data + " ");
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
    public treeNode buildtree(String str[],Binary_tree t){
        if(str[0].equals("N")){
            return null;
        }
        t.root =new treeNode(Integer.parseInt(str[0]));
        Queue<treeNode> q=new LinkedList<treeNode>();
        q.add(t.root);
        int i=1;
        while(i < str.length){
            treeNode cur = q.poll();
            if(!str[i].equals("N")){
                cur.left = new treeNode(Integer.parseInt(str[i]));
                q.add(cur.left);
            }
            i++;
            if(i >= str.length)
                break;
            if(!str[i].equals("N")){
                cur.right = new treeNode(Integer.parseInt(str[i]));
                q.add(cur.right);
            }
            i++;
        }
        return t.root;
    }

    public static void main(String[] args) {
        

        Binary_tree t = new Binary_tree();
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter values:");
        String[]  strtree= sc.nextLine().split(" ");

        t.buildtree(strtree,t);

        System.out.println("\nInorder:");
        t.inorder(t.root); 
        System.out.println();
        System.out.println("\nPreOrder:");
        t.preOrder(t.root); 
        System.out.println();
        System.out.println("\nPost Order:");
        t.postOrder(t.root); 
        System.out.println();
        System.out.println("\nLevel Order: ");
        t.levelOrder();

        sc.close();
    }
}