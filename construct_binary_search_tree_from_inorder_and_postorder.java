/*
Given inorder and postorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (postorder == null || inorder == null || postorder.length == 0 || inorder.length == 0) return null;
        return buildTreeBottomUp(postorder, inorder, postorder.length - 1, 0, inorder.length - 1);
    }
    public TreeNode buildTreeBottomUp(int[] postorder, int[] inorder, int postRoot, int inStart, int inEnd) {
        if (inStart > inEnd) return null;
        TreeNode root = new TreeNode(postorder[postRoot]);
        int inRoot = getRootIndex(postorder[postRoot], inorder, inStart, inEnd);
        int rightLen = inEnd - inRoot;
        if (inRoot > inStart) root.left = buildTreeBottomUp(postorder, inorder, postRoot - rightLen - 1, inStart, inRoot - 1);
        if (inRoot < inEnd) root.right = buildTreeBottomUp(postorder, inorder, postRoot - 1, inRoot + 1, inEnd);
        return root;
    }
    
    public int getRootIndex(int val, int[] inorder, int start, int end) { 
        int index = 0;
        for (int i = start; i <= end; i++) {
            // Assume that duplicates do not exist in the tree.
            if (inorder[i] == val) {
                index = i;
                break;
            }
        }
        return index;
    }
}