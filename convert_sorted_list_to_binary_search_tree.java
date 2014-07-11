/*
Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.

*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; next = null; }
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
// Solution 1: incorrect
// Time complexity: O(n), Space complexity: O(logn)
public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;

        int length = getListLength(head);
        return buildBST(head, 0, length - 1);
    }

    public int getListLength(ListNode head) {
        int length = 0;
        ListNode iter = head;
        while (iter != null) {
            length++;
            iter = iter.next;
        }
        return length;
    }

    // build up BST bottom-up recursively
    public TreeNode buildBST(ListNode list, int start, int end) {
        if (start > end) return null;

        int mid = start + (end - start) / 2;
        TreeNode leftChild = buildBST(list, start, mid - 1);
        TreeNode parent = new TreeNode(list.val);
        parent.left = leftChild;
        list = list.next;
        parent.right = buildBST(list, mid + 1, end);
        return parent;
    }
}



// Solution 2
// Construct the BST bottom-up by inorder traversal order, ie, the ascending sorted order 
public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        
        int len = getListLength(head);
        return buildBST(head, 0, len-1);
    }
    
    public int getListLength(ListNode head) {
        ListNode iter = head;
        int length = 0;
        while (iter != null) {
            iter = iter.next;
            length++;
        }
        return length;
    }
    
    public TreeNode buildBST(ListNode list, int start, int end){
        if(start > end || start < 0 || end < 0) return null;
        int mid = (start + end)/2;
        TreeNode leftChild = buildBST(list, start, mid - 1);
        TreeNode parent = new TreeNode(list.val);
        parent.left = leftChild;
        // added following
        if(list.next != null){
            list.val = list.next.val;
            list.next = list.next.next;
        }
        parent.right = buildBST(list, mid + 1, end);
        return parent;
    }
}


// Solution 3
public class Solution {
    static ListNode head;
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null)    return null;
        this.head = head;
         
        // get list length
        int len = 0;
        ListNode ln = head;
        while(ln != null){
            len++;
            ln = ln.next;
        }          
        return sortedListToBST(0, len - 1);
    }
     
    // build bottom-to-top
    public TreeNode sortedListToBST(int start, int end) {
        // if finished (root)
        if(start > end) return null;
         
        // get mid val
        int mid = (start + end) / 2;       
        // build left sub tree
        TreeNode left = sortedListToBST(start, mid - 1);
        // build root node
        TreeNode root = new TreeNode(head.val);
        root.left = left;
        // move to next node to build right sub tree
        head = head.next;
        root.right = sortedListToBST(mid + 1, end);
        return root;
    }
}

