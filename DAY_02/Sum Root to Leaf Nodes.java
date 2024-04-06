package DAY_02;
import java.util.*;


class Sum_rootToLeaf {
    static class TreeNode {
        int val;
        TreeNode left, right;
    
        public TreeNode(int val) {
            this.val = val;
        }
    }
    static TreeNode root;
    public int sumNumbers(TreeNode root) {
        return sumNumbersHelper(root, "");
    }

    private int sumNumbersHelper(TreeNode node, String currentSum) {
        if (node == null) {
            return 0;
        }
        currentSum += node.val;
        if (node.left == null && node.right == null) {
            return Integer.parseInt(currentSum);
        }
        int leftSum = sumNumbersHelper(node.left, currentSum);
        int rightSum = sumNumbersHelper(node.right, currentSum);
        return leftSum + rightSum;
    }
    
        // private static TreeNode buildTree(String[] values, int index) {
        //     if (index >= values.length || values[index].equals("N")) {
        //         return null;
        //     }
        //     TreeNode node = new TreeNode(Integer.parseInt(values[index]));
        //     node.left = buildTree(values, 2 * index + 1);
        //     node.right = buildTree(values, 2 * index + 2);
        //     return node;
        // }

        public TreeNode buildTree(String[] values, Sum_rootToLeaf sumRootToLeaf){
            
        if(values[0].equals("N"))
        return null;

        sumRootToLeaf.root=new TreeNode(Integer.parseInt(values[0]));
        Queue<TreeNode> q= new LinkedList<TreeNode>();
        q.add(sumRootToLeaf.root);
        int i=1;
        while(i<values.length){
            TreeNode curr=q.poll();
            if(!values[i].equals("N")){
                curr.left=new TreeNode(Integer.parseInt(values[i]));
                q.add(curr.left);
            }
            i++;
            if(i>=values.length){
                break;
            }

            if(!values[i].equals("N")){
                curr.right = new TreeNode(Integer.parseInt(values[i]));
                q.add(curr.right);
            }
            i++;
        }
        return sumRootToLeaf.root;
        }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Sum_rootToLeaf sumRootToLeaf = new Sum_rootToLeaf();
        // String input = scanner.nextLine();
        String[] values = scanner.nextLine().split(" ");
        // TreeNode root = buildTree(input.split(" "), 0);
        sumRootToLeaf.buildTree(values, sumRootToLeaf);


        int result = sumRootToLeaf.sumNumbers(root);
        System.out.println(result);
    }
}