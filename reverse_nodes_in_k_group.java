/*
Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

You may not alter the values in the nodes, only nodes itself may be changed.

Only constant memory is allowed.

For example,
Given this linked list: 1->2->3->4->5

For k = 2, you should return: 2->1->4->3->5

For k = 3, you should return: 3->2->1->4->5
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

// Solution 1
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k < 2) {
        	return head;
        }
        ListNode prev = new ListNode(0);
        prev.next = head;
        head = prev;
        
        // first reach to the end of current group of k
        ListNode cur = prev.next;
        while (cur != null) {
        	int nodeCounter = 0;
        	while (nodeCounter < k - 1 && cur != null) {
		    	cur = cur.next;
		    	nodeCounter++;
		    }

		    // reverse current group of k, end to start
		    ListNode temp = new ListNode(0);
        	if (cur != null) {
	        	nodeCounter = 0;
	        	cur = prev.next;
	        	while (nodeCounter < k - 1) {
	        		temp = cur.next;
	        		cur.next = temp.next;
	        		// temp.next = cur;
	        		temp.next = prev.next;
	        		prev.next = temp;
	        		nodeCounter++;
	        	}
	        	prev = cur;
	        	cur = prev.next;
        	}
        }
        return head.next;
    }
}

// Solution 2
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k < 2) {
        	return head;
        }
        ListNode iter = new ListNode(0);
        iter = head;
    }

    public void reverse(ListNode prev, ListNode cur) {

    }
}
