/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // exception
        if (l1 == null) 
            return l2;
        if (l2 == null)
            return l1;
        
        ListNode l;
        if (l1.val <= l2.val) {
            l = l1;
            l1 = l1.next;
        } else {
            l = l2;
            l2 = l2.next;
        }
        
        ListNode iter = l;
        while(l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                iter.next = l1;
                l1 = l1.next;
            } 
            else {
                iter.next = l2;
                l2 = l2.next;
            }
            iter = iter.next;
        }
        iter.next = l1 == null?l2:l1;
        return l;
    }
}