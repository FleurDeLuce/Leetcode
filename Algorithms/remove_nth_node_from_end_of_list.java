/*
Given a linked list, remove the nth node from the end of list and return its head.

For example,

   Given linked list: 1->2->3->4->5, and n = 2.

   After removing the second node from the end, the linked list becomes 1->2->3->5.
Note:
Given n will always be valid.
Try to do this in one pass.
*/

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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if(head == null) return null;
        ListNode p1 = head, p2 = head;
        
        for(int i = 0; i < n; i++)
        {
            p2 = p2.next;
        }
        
        // remove head node
        if(p2 == null)
        {
            head = head.next;
            return head;
        }
        
        while(p2.next != null)
		{
			p1 = p1.next;
			p2 = p2.next;
		}
		p1.next = p1.next.next;
		return head;
        
    }
}
