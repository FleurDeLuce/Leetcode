/*
Given a binary tree, find the maximum path sum.

The path may start and end at any node in the tree.

For example:
Given the below binary tree,

       1
      / \
     2   3
Return 6.
 */

// Solution1: recursion + parameter passed by array 
// Time complexity: O(), Space complexity: O()
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
    public int maxPathSum(TreeNode root) {
        int maxSum[] = {Integer.MIN_VALUE};
        findPathSum(root, maxSum);
        return maxSum[0];
    }
    
    public int findPathSum(TreeNode root, int[] maxSum) {
    	if (root == null) return 0;

    	int leftSum = findPathSum(root.left, maxSum);
    	int rightSum = findPathSum(root.right, maxSum);
    	int acrossSum = root.val + leftSum + rightSum;
    	// through root node, the max sum returned to the parent of root when recursively calling
    	// ie. the sum must include the parent of root
    	// a counterexample is here: http://blog.csdn.net/worldwindjp/article/details/18953987
    	int pathSum = Math.max(root.val, Math.max(root.val + leftSum, root.val + rightSum));
    	// the max value could not through the parent
    	maxSum[0] = Math.max(maxSum[0], Math.max(pathSum, acrossSum));
    	return pathSum;
    }
}

// Solution2: recursion + global variable
public class Solution {
    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        findPathSum(root);
        return maxSum;
    }
    
    public int findPathSum(TreeNode root) {
    	if (root == null) return 0;

    	int leftSum = findPathSum(root.left);
    	int rightSum = findPathSum(root.right);
    	int acrossSum = root.val + leftSum + rightSum;
    	// through root node, the max sum returned to the parent of root when recursively calling
    	// ie. the sum must include the parent of root
    	// a counterexample is here: http://blog.csdn.net/worldwindjp/article/details/18953987
    	int pathSum = Math.max(root.val, Math.max(root.val + leftSum, root.val + rightSum));
    	// the max value could not through the parent
    	maxSum = Math.max(maxSum, Math.max(pathSum, acrossSum));
    	return pathSum;
    }
}