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







public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;

        // get list length for starting and ending indices to build BST
        // int size = 0;
        // ListNode iter = head;
        // while (iter != null) {
        //     size++;
        //     iter = iter.next;
        // }
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

