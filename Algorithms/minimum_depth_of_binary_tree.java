/*
Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
*/
/*
Thoughts:
Sense of recursion should be came out now.
What is the base case or edge case? Empty tree. What is the minimum depth of an empty tree? 0.
In the recursion step, the passed in TreeNode “root” is been looked at. “root” is not null, which was covered in the base case. Then there are four sub-cases or combinations, if you like:

root is a leaf node. In other word, root.left == null && root.right == null. Return 1 at this case.
root.left == null && root.right != null. Then we just need to recurse on the right, so we return 1 + minDepth(root.right).
root.left != null && root.right == null. Similarly, we return 1 + minDepth(root.left).
root.left != null && root.right != null. This is rather interesting case. We don’t know which branch of the case has shorter path, so we should return the minimum of these two.
In the code, we can actually combine the four cases into two!
*/
//Recursion
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
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left != null && root.right != null) return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
        // if left is null, return min depth of right; otherwise return right
        // left is null doesn't mean root is leaf, but means no leaf on the left side
        else if (root.left == null) return 1+ minDepth(root.right);
        else return 1 + minDepth(root.left);
    }
}
// solution of combining subcases
public class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left != null && root.right != null) return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
        // if left is null, return min depth of right; otherwise return right
        else return 1+ minDepth(root.right) + minDepth(root.left);
    }
}

// wrong 
public class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        else return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }
}

// right
public class Solution {
    public int minDepth(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(root == null){
            return 0;
        }else{
            return depth(root);
        }
    }
    
    private int depth(TreeNode root){
        if (root == null) {
            return Integer.MAX_VALUE;
        } else if (root.left == null && root.right == null) {
            return 1;
        } else {
            return Math.min(depth(root.left), depth(root.right)) + 1;
        }
    }
}