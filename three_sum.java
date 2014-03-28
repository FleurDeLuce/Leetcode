/*
Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
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
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (num == null || num.length < 3) return res;
        Arrays.sort(num);
        int target = 0;
        int len = num.length;
        for (int i = 0; i < len - 2; i++) {
            int l = i + 1;
            int r = len - 1;
            
            target = 0 - num[i];
            while (l < r) {
                if (num[l] + num[r] == target) {
                    ArrayList<Integer> solution = new ArrayList<Integer>();
                    solution.add(num[i]);
                    solution.add(num[l]);
                    solution.add(num[r]);
                    res.add(solution);
                    while (l < r && num[l + 1] == num[l]) l++;
                    while (l < r && num[r - 1] == num[r]) r--;
                    while (i < len - 1 && num[i] == num[i + 1]) i++;
                    l++;
                    r--;
                }
                else if (num[l] + num[r] < target) l++;
                else r--;
            }
        }
        return res;
    }
}