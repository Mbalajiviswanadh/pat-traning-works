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

    }

}


// import java.util.*;

// class treeNode {
//     int data;
//     treeNode left;
//     treeNode right;

//     treeNode(int n) {
//         this.data = n;
//         this.left=null;
//         this.right=null;
//     }
// }

// class tree {

//     treeNode root;

//     public static  List<Integer> rightView(treeNode root){
//         List<Integer> rightView = new ArrayList<>();
//         if(root==null){
//             return rightView;
//         }


//         Queue<treeNode> q =new LinkedList<>();

//         q.add(root);
//         while(!q.isEmpty()){
//             int size=q.size();
//             for(int i=0;i<size;i++){
//                 treeNode node=q.poll();
//                 if(i==size-1){
//                     rightView.add(node.data);
//                 }
//                 if(node.left!=null){
//                     q.add(node.left);
//                 }
//                 if(node.right!=null){
//                     q.add(node.right);
//                 }
//             }
//         }
//         return rightView;
// }

// class demo {
//     static treeNode buildtree(String str[],tree t){
//         if(str[0]=="N"){
//             return null;
//         }
//         t.root =new treeNode(Integer.parseInt(str[0]));
//         Queue<treeNode> q=new LinkedList<treeNode>();
//         q.add(t.root);
//         int i=1;
//         while(i < str.length){
//             treeNode cur = q.poll();
//             if(!str[i].equals("N")){
//                 cur.left = new treeNode(Integer.parseInt(str[i]));
//                 q.add(cur.left);
//             }
//             i++;
//             if(i >= str.length)
//                 break;
//             if(!str[i].equals("N")){
//                 cur.right = new treeNode(Integer.parseInt(str[i]));
//                 q.add(cur.right);
//             }
//             i++;
//         }
//         return t.root;
//     }
//     public static void main(String[] args) {
        
        
//         tree t = new tree();
//         Scanner sc= new Scanner(System.in);
//         System.out.println("Build tree");
//         String[]  strtree= sc.nextLine().split(" ");

//         buildtree(strtree,t);
//     }
// }
// }


