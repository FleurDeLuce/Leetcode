/*
Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
*/
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int balancedHeight(TreeNode root) {
        if (root == null) return 0;
        int left = balancedHeight(root.left);
        int right = balancedHeight(root.right);
        // left or right subtree is unbalanced
        if (left == -1 || right == -1) return -1;
        if (Math.abs(left - right) > 1) return -1;
        else return Math.max(left, right) + 1;
    }
    
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        if (balancedHeight(root) == -1) return false;
        else return true;
    }
}