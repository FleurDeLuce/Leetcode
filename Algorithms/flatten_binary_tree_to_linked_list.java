/*
Given a binary tree, flatten it to a linked list in-place.

For example,
Given

         1
        / \
       2   5
      / \   \
     3   4   6
The flattened tree should look like:
   1
    \
     2
      \
       3
        \
         4
          \
           5
            \
             6
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
// Solution 1: recursive
// Time complexity: O(n), Space complexity: O(logn)
public class Solution {
    public void flatten(TreeNode root) {
        recurFlatten(root, null);
    }

    // Java method paramete is pass by reference
    public TreeNode recurFlatten(TreeNode root, TreeNode tail) {
        if (root == null) {
            return tail;
        }
        root.right = recurFlatten(root.left, recurFlatten(root.right, tail));
        root.left = null;
        return root;
    }
}


// Solution 2: recursive
public class Solution {
    public void flatten(TreeNode root) {
        TreeNode node = new TreeNode();
        recurFlatten(root, node);
    }

    // Java method paramete is pass by reference
    public TreeNode recurFlatten(TreeNode root, TreeNode node) {
        if (root == null) {
            return;
        }
        recurFlatten(root.right, node);
        recurFlatten(root.leftm node);

        root.right = node;
        node = root;
        root.left = null;
    }
}


        // move left subtree as root's right subtree, then move original right subtree as original left subtree's right subtree
        // method above would require the storage of original right subtree, thus we process right subtree first for conveniences
        if (root.left != null) {
            // original right subtree set as the right subtree of the original left subtree
            // find the rightmost node
            while ()
        }
        //


// Solution 3: iterative
public class Solution {
    public void flatten(TreeNode root) {
        TreeNode node = new TreeNode();
        recurFlatten(root, node);
    }

    // Java method paramete is pass by reference
    public TreeNode recurFlatten(TreeNode root, TreeNode node) {
        if (root == null) {
            return;
        }
        while (root != null){
            
        }
}
