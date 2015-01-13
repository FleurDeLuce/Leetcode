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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;       
        
        ListNode head = new ListNode(0);
        ListNode tail = head;
        int carry = 0;
        while (true) {
            carry += l1 == null ? 0 : l1.val;
            carry += l2 == null ? 0 : l2.val;
            l1 = l1 == null? null : l1.next;
            l2 = l2 == null? null : l2.next;
            tail.val = carry % 10;
            carry /= 10;
            if (l1 == null && l2 == null && carry == 0) break;
            tail.next = new ListNode(0);
            tail = tail.next;
        } 
        return head;
    }
}