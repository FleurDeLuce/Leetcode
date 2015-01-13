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
    public boolean isMirror(TreeNode left, TreeNode right) {
        if (left == null) return right == null;
        if (right == null) return false;
        if (left.val != right.val) return false;
        return (isMirror(left.left, right.right))&&(isMirror(left.right, right.left));
    }
    
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        if ((root.left == null && root.right != null) 
          || (root.right == null && root.left != null)) 
          return false;
        return isMirror(root.left, root.right);
    }
}