/*
Given a binary tree, return the postorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [3,2,1].

Note: Recursive solution is trivial, could you do it iteratively?
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
 // recursion 1
public class Solution {
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (root == null) return res;
        res.addAll(postorderTraversal(root.left));
        res.addAll(postorderTraversal(root.right));
        res.add(root.val);
        return res;
    }
}

// recursion 2
public class Solution {
    public void postorderRecur(ArrayList<Integer> res, TreeNode root) {
        if (root.left != null) postorderRecur(res, root.left);
        if (root.right != null) postorderRecur(res, root.right);
        res.add(root.val);
    }
    
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (root == null) return res;
        postorderRecur(res, root);
        return res;
    }
}

// iteration 
public class Solution {
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (root == null) return res;
        
        Stack<TreeNode> s = new Stack<TreeNode>();
        s.push(root);
        
        TreeNode prev = null;
        while (!s.empty()) {
            TreeNode cur = s.peek();
            // go down the tree.
            // check if current node is leaf, if so, process it and pop stack,
            // otherwise, keep going down
            if (prev == null || prev.left == cur || prev.right == cur) {
                //prev == null is the situation for the root node
                if (cur.left != null) s.push(cur.left);
                else if (cur.right != null) s.push(cur.right);
                else {
                    s.pop();
                    res.add(cur.val);
                }
            }
            //go up the tree from left node    
            //need to check if there is a right child
            //if yes, push it to stack
            //otherwise, process parent and pop stack
            else if (cur.left == prev) {
                if (cur.right != null) s.push(cur.right);
                else {
                    s.pop();
                    res.add(cur.val);
                }
            }
             //go up the tree from right node 
            //after coming back from right node, process parent node and pop stack
            else if (cur.right == prev) {
                s.pop();
                res.add(cur.val);
            }
            prev = cur;
        }
        return res;
    }
}