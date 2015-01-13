/*
Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]
 */

// Solution
// Time complexity: O(n), Space complexity: O(n)
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
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (root == null) return res;

        Stack<TreeNode> curLevel = new Stack<TreeNode>();
        Stack<TreeNode> nextLevel = new Stack<TreeNode>();
        // according to stack, the second level (children of first level) should be right to left
        // thus the pushing order to stack of first level should be left to right
        Boolean leftToRight = true;
        curLevel.push(root);

        // when swap next and current level finishes, start from a unempty new current level nodes collection
        while (!curLevel.isEmpty()) {
        	ArrayList<Integer> curLevelResult = new ArrayList<Integer>();
        	// for each level, traverse until nodes run out
	        while (!curLevel.isEmpty()) {
	        	// we use stack to store children of each visited node, since the children of an earlier node 
	        	// are visited later than those of the following node in the same level
	        	//ArrayList<Integer> curLevelResult = new ArrayList<Integer>();
	        	TreeNode curNode = curLevel.pop();
	        	curLevelResult.add(curNode.val);

	        	if (curNode != null) {
	        		if (leftToRight) {
	        			if (curNode.left != null) nextLevel.push(curNode.left);
	        			if (curNode.right != null) nextLevel.push(curNode.right);
	        		}
	        		else {
	        			if (curNode.right != null) nextLevel.push(curNode.right);
	        			if (curNode.left != null) nextLevel.push(curNode.left);			
	        		}
	        	}
	        }

	        res.add(curLevelResult);
	        // swap current level and next level when current level is empty
    		leftToRight = !leftToRight;
    		Stack<TreeNode> temp = curLevel;
    		curLevel = nextLevel;
    		nextLevel = temp;
        }
        return res;
    }
}