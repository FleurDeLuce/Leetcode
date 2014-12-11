/*
 Given a binary tree where all the right nodes are either leaf nodes with a sibling (a left node that shares the same parent node) or empty, flip it upside down and turn it into a tree where the original right nodes turned into left leaf nodes. Return the new root.
 
 For example:
 Given a binary tree {1,2,3,4,5},
 1
 / \
 2   3
 / \
 4   5
 return the root of the binary tree [4,5,2,#,#,3,1].
 4
 / \
 5   2
 / \
 3   1
 */


// Top-down Solution
// Time complexity: O(), Space complexity: O()





// Bottom-up Solution
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


/* right child -> new left child
   left child -> new root
   root -> new right child
 */
// At each node, assign:
// p.left = parent.right;
// p.right = parent;
public class Solution {
    public TreeNode UpsideDownBinaryTree(TreeNode root) {
        // bottom-up solution
        return bottomUpFlip(root, null);
    }
    
    // p is current node, and new root
    public TreeNode bottomUpFlip(TreeNode p, TreeNode parent) {
        if (p == null)
            return parent;
        TreeNode root = bottomUpFlip(p.left, p);
        p.left = (parent == null) ? parent : parent.right;
        p.right = parent;
        return root;
        
    }
}