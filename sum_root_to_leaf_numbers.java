/*
Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

An example is the root-to-leaf path 1->2->3 which represents the number 123.

Find the total sum of all root-to-leaf numbers.

For example,

    1
   / \
  2   3
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.

Return the sum = 12 + 13 = 25.
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
    int res = 0;
    public void pathSum(int curPathSum, TreeNode root) {
        int curSum = curPathSum * 10 + root.val;  
        if (root.left != null) {
            pathSum(curSum, root.left);
        }
        if (root.right != null) {
            pathSum(curSum, root.right);
        }
        if (root.left == null && root.right == null) {
            // arrives at leaf node, adds path sum to res
            res += curSum;
        }
    }
    
    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        pathSum(0, root);
        return res;
    }
}