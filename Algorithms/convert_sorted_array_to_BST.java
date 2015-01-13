/*
Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
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
    public TreeNode sortedArrayToBST(int[] num, int start, int end) {
        if (start > end) return null;
        int mid = (start + end)/2;
        TreeNode node = new TreeNode(num[mid]);
        node.left = sortedArrayToBST(num, start, mid - 1);
        node.right = sortedArrayToBST(num, mid + 1, end);
        return node;
    }
    
    public TreeNode sortedArrayToBST(int[] num) {
        if (num == null || num.length == 0) return null;
        return sortedArrayToBST(num, 0, num.length - 1);
    }
}