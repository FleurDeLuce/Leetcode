/*
Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
return
[
   [5,4,11,2],
   [5,8,4,5]
]
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
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {     
        if (root == null || sum < 0) return null;
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        getPath(root, sum, res, new ArrayList<Integer>());
        return res;
    }
    
    public ArrayList<ArrayList<Integer>> getPath(TreeNode root, int sum, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> path) {
        if (root == null) return;
        path.add(root.val);
        sum -= root.val;
        if (sum == 0 && root.left == null && root.right == null) res.add(path);
        else {
        	getPath(root.left, sum, res, path);
        	getPath(root.right, sum, res, path);
        }
        path.remove(path.size() - 1);
    }
}