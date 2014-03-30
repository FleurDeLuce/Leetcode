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
public class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0) return null;
        return buildTreeBottomUp(postorder, inorder, postorder.length - 1, 0, inorder.length - 1);
    }
    public TreeNode buildTreeBottomUp(int[] inorder, int[] postorder, int postRoot, int inStart, int inEnd) {
        if (inStart > inEnd) return null;
        TreeNode root = new TreeNode(preorder[postRoot]);
        int inRoot = getRootIndex(preorder[postRoots], inorder, inStart, inEnd);
        int leftLen = inRoot - inStart;
        
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
