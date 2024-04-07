package DAY_02;

import java.util.*;

class node {
  int data;
  node left;
  node right;

  node(int n) {
    data = n;
    left = null;
    right = null;
  }
}

class ZIg_Zac {
  static void zig(node root){
    if(root==null){
      return;
    }
    Stack<node> cl = new Stack<>();
    Stack<node> nl = new Stack<>();
    boolean lr=true;
    cl.push(root);
    
    while(!cl.isEmpty()){
      node cur = cl.pop();
      System.out.print(cur.data + " ");
      if(lr){
        if(cur.left != null){
          nl.push(cur.left);
        }
        if(cur.right != null){
          nl.push(cur.right);
        }
      }
      else{
        if(cur.right != null){
          nl.push(cur.right);
        }
        if(cur.left != null){
          nl.push(cur.left);
        }
      }
      if(cl.isEmpty()){
        lr =! lr;
        Stack<node> temp = cl;
        cl = nl;
        nl = temp;
      }
  }
  }

  static node build(String s[]) {
    if (s[0] == "N" || s.length == 0) {
      return null;
    }
    Queue<node> q = new LinkedList<>();
    node root = new node(Integer.parseInt(s[0]));
    q.add(root);
    int i = 1;
    while (!q.isEmpty() && i < s.length) {
      node cur = q.poll();
      String curval = s[i];
      if (!curval.equals("N")) {
        cur.left = new node(Integer.parseInt(curval));
        q.add(cur.left);
      }
      i++;
      if (i >= s.length) {
        break;
      }
      curval = s[i];
      if (!curval.equals("N")) {
        cur.right = new node(Integer.parseInt(curval));
        q.add(cur.right);
      }
      i++;
    }
    return root;
  }

    public static void main(String[] args) {
      Scanner sw = new Scanner(System.in);
      String s[] = sw.nextLine().split(" ");
      node root = build(s);
      
      zig(root);

      sw.close();
    }
}

