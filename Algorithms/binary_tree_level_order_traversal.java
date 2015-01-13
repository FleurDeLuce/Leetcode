/*
Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]
confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.
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
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (root == null) return res;
        levelRecur(1, root, res);
        return res;
    }
    
    public void levelRecur(int level, TreeNode root, ArrayList<ArrayList<Integer>> res) {
        if (root == null) return;
        
        ArrayList<Integer> curLevel = new ArrayList<Integer>();
        // check if this level has already exist  
        if (level <= res.size()) curLevel = res.get(level - 1);
        else res.add(curLevel);
        curLevel.add(root.val);
        
        levelRecur(level + 1, root.left, res);
        levelRecur(level + 1, root.right, res);
    }
}