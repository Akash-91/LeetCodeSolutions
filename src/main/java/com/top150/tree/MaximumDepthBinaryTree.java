package com.top150.tree;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class MaximumDepthBinaryTree {

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(9);
        root1.right = new TreeNode(20);
        root1.right.left = new TreeNode(15);
        root1.right.right = new TreeNode(7);


        int depth1 = maxDepth(root1);
        System.out.println("Example 1 - Depth: " + depth1); // Output: 3

        // Example 2
        TreeNode root2 = new TreeNode(1);
        root2.right = new TreeNode(2);

        int depth2 = maxDepth(root2);
        System.out.println("Example 2 - Depth: " + depth2); // Output: 2
    }

    Integer[] root = {3, 9, 20, null, null, 15, 7};

    public static int maxDepth(TreeNode root) {
        // Base case: if the root is null, the depth is 0
        if (root == null) {
            return 0;
        }

        // Recursively calculate the depth of the left and right subtrees
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        // Return the maximum depth of the left and right subtrees, plus 1 for the current node
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
