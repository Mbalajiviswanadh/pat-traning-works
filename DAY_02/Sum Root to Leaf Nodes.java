package DAY_02;
import java.util.Scanner;


class Sum_rootToLeaf {
    static class TreeNode {
        int val;
        TreeNode left, right;
    
        public TreeNode(int val) {
            this.val = val;
        }
    }
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
    
        private static TreeNode buildTree(String[] values, int index) {
            if (index >= values.length || values[index].equals("N")) {
                return null;
            }
            TreeNode node = new TreeNode(Integer.parseInt(values[index]));
            node.left = buildTree(values, 2 * index + 1);
            node.right = buildTree(values, 2 * index + 2);
            return node;
        }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        TreeNode root = buildTree(input.split(" "), 0);
        Sum_rootToLeaf sumRootToLeaf = new Sum_rootToLeaf();
        int result = sumRootToLeaf.sumNumbers(root);
        System.out.println(result);
    }
}