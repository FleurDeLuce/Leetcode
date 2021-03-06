/*
Given a binary tree

    struct TreeLinkNode {
      TreeLinkNode *left;
      TreeLinkNode *right;
      TreeLinkNode *next;
    }
Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

Note:

You may only use constant extra space.
You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
For example,
Given the following perfect binary tree,
         1
       /  \
      2    3
     / \  / \
    4  5  6  7
After calling your function, the tree should look like:
         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \  / \
    4->5->6->7 -> NULL
*/
    /**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
// recursive 1
public class Solution {
    public void connect(TreeLinkNode root) {
        if (root == null) return;
        connectRecur(root, null);
    }
    
    public void connectRecur(TreeLinkNode root, TreeLinkNode sibling) {
        if (root == null) return;
        else root.next = sibling;
        
        connectRecur(root.left, root.right);
        if (sibling != null) connectRecur(root.right, sibling.left);
        else connectRecur(root.right, null);
    }
}

// recursive 2
public class Solution {
    public void connect(TreeLinkNode root) {
        if(root == null){
            return;
        }
        
        if(root.left != null){
            root.left.next = root.right;
        }
        if(root.right != null){
            root.right.next = root.next==null ? null : root.next.left;
        }
        
        connect(root.left);
        connect(root.right);
    }
}