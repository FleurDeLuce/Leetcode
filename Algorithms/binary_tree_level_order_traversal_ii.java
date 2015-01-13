/*
Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its bottom-up level order traversal as:
[
  [15,7]
  [9,20],
  [3],
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
// recurive 
public class Solution {
    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (root == null) return res;
        levelBottomRecur(1, root, res);
        Collections.reverse(res);
        return res;
    }
    
    public void levelBottomRecur(int level, TreeNode root, ArrayList<ArrayList<Integer>> res) {
        if (root == null) return;
        
        ArrayList<Integer> curLevel = new ArrayList<Integer>();
        if (level <= res.size()) curLevel = res.get(level - 1);
        else res.add(curLevel);
        curLevel.add(root.val);
        
        levelBottomRecur(level + 1, root.left, res);
        levelBottomRecur(level + 1, root.right, res);
    }
}

// iterative