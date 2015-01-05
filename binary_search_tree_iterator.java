/*
 Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.
 
 Calling next() will return the next smallest number in the BST.
 
 Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
 */

// Solution
// Time complexity: O(1), Space complexity: O(log(n))
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
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

public class BSTIterator {
    // Recursive BST in-order traversal 
    // Use a stack to store the path from root to leftmost child through the parents
    public Stack<TreeNode> stack = new Stack<TreeNode>();
    
    public BSTIterator(TreeNode root) {
        pushLeft(root);
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }
    
    /** @return the next smallest number */
    public int next() {
        TreeNode node = stack.pop();
        pushLeft(node.right);
        return node.val;
    }
    
    public void pushLeft(TreeNode node) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 
 */