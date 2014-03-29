/*
Given preorder and inorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.
*/

// Here we only use inoder traversal to determine the size of left and right child tree of current node!
// the left_size elements after root in preorder traversal are the nodes in the left child tree
// thus if current root has left child (left_size > 0) root of left child tree is preorder[index_of_current_root + 1]
// the right_size elements after 1+left_size elements in preorder traversal are the nodes in the right child tree
// thus if current root has right child (right_size > 0) root of right child tree is preorder[index_of_current_root + left_size + 1]

//http://www.geeksforgeeks.org/construct-tree-from-given-inorder-and-preorder-traversal/


//Solution 1
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// Time Complexity: O(n), n numbers in the traversal array
// Space Complexity: O(logn), construct tree by level, left-right children pair each level
public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0) return null;
        return buildTreeBottomUp(preorder, inorder, 0, 0, preorder.length - 1);
    }
    
    public TreeNode buildTreeBottomUp(int[] preorder, int[] inorder, int preRoot, int inStart, int inEnd) {
        // preRoot is the index of current root in preorder array
        if (inStart > inEnd) return null;
        TreeNode root = new TreeNode(preorder[preRoot]);
        int inRoot = getRootIndex(preorder[preRoot], inorder, inStart, inEnd);
        int leftLen = inRoot - inStart;
        if (inRoot > inStart) root.left = buildTreeBottomUp(preorder, inorder, preRoot + 1, inStart, inRoot - 1);
        if (inRoot < inEnd) root.right = buildTreeBottomUp(preorder, inorder, preRoot + leftLen + 1, inRoot + 1, inEnd);
        return root;
    }
    
    public int getRootIndex(int val, int[] inorder, int start, int end) { 
        int index = 0;
        for (int i = start; i <= end; i++) {
            // Assume that duplicates do not exist in the tree.
            if (inorder[i] == val) {
                index = i;
                break;
            }
        }
        return index;
    }
}
// Solution 2
public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0) return null;
        return buildTreeBottomUp(preorder, inorder, 0, 0, preorder.length);
    }
    
    public TreeNode buildTreeBottomUp(int[] preorder, int[] inorder, int preRoot, int inStart, int inEnd) {// inStart and inEnd are indices in inorder-seq
    // here preRoot is the index of current root in preorder traversal
        if (inStart > inEnd) return null;
        TreeNode root = new TreeNode(preorder[preRoot]);
        int inRoot = getRootIndex(preorder[preRoot], inorder, inStart, inEnd);
        if (inRoot > inStart) root.left = buildTreeBottomUp(preorder, inorder, preRoot + 1, inStart, inRoot);
        if (inRoot + 1 < inEnd) root.right = buildTreeBottomUp(preorder, inorder, preRoot + inRoot - inStart + 1, inRoot + 1, inEnd);
        return root;
    }
    
    public int getRootIndex(int val, int[] inorder, int start, int end) { // use start and end to narrow down search scope
        int index = 0;
        for (int i = start; i < end; i++) {
            // Assume that duplicates do not exist in the tree.
            if (inorder[i] == val) index = i;
        }
        return index;
    }
}

// Solution 3
public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int preLength = preorder.length;
        int inLength = inorder.length;
        return buildTree(preorder, 0, preLength-1, inorder, 0, inLength-1);
    }
    
    public TreeNode buildTree(int[] pre, int preStart, int preEnd, int[] in, int inStart, int inEnd){
        if(inStart > inEnd) return null;
        int rootVal = pre[preStart];
        int rootIndex = 0;
        
        for(int i = inStart; i <= inEnd; i++){
            if(in[i] == rootVal){
                rootIndex = i;
                break;
            }
        }
        
        int len = rootIndex - inStart;
        TreeNode root = new TreeNode(rootVal);
        root.left = buildTree(pre, preStart+1, preStart+len, in, inStart, rootIndex-1);
        root.right = buildTree(pre, preStart+len+1, preEnd, in, rootIndex+1, inEnd);
       
        return root;
    }
}