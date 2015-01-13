/*
Given a singly linked list L: L0→L1→…→Ln-1→Ln,
reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

You must do this in-place without altering the nodes' values.

For example,
Given {1,2,3,4}, reorder it to {1,4,2,3}.
*/
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public void reorderList(ListNode head) {
        if (head == null) return;
        
        ListNode fast = head, slow = head;
        while (fast != null) { // When you access fast.next, make sure fast != null
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
                slow = slow.next;
            }
        }
        // split the list into two sublists
        // slow is the last pointer of the first sublist
        ListNode p1 = head, p2 = slow.next;
        slow.next = null;
        
        // reverse second sublist
        ListNode curNode = p2, nextNode = null, loopNode = null; // initiallize before use
        if (curNode != null) { // Consider a list of only one node, p2 can be null.
            nextNode = curNode.next;
            curNode.next = null;// seal the end of reversed list
        }
        while (nextNode != null) {
            loopNode = nextNode.next; // If entered the loop, nextNode != null, so we can access nextNode.next
            nextNode.next = curNode;
            curNode = nextNode;
            nextNode = loopNode;
        }
        p2 = curNode;
        
        // merge two sublists
        while (p1 != null && p2 != null) {
            ListNode temp1 = p1.next;
            ListNode temp2 = p2.next;
            p1.next = p2;
            p2.next = temp1;
            p1 = temp1;
            p2 = temp2;
        }
    }
}


 /*
public class Solution {
    public void reorderList(ListNode head) {
        if (head == null) return;
        
        ListNode fast = head, slow = head;
        while (fast != null) {
            if (fast != null) fast = fast.next.next;
            else break;
            slow = slow.next;
        }
        // split the list into two sublists
        // slow is the last pointer of the first sublist
        ListNode p1 = head, p2 = slow.next;
        slow.next = null;
        
        // reverse second sublist
        ListNode curNode, nextNode, loopNode;
        curNode = p2;
        nextNode = p2.next;
        p2.next = null;
        while (nextNode != null) {
            loopNode = nextNode.next;
            nextNode.next = curNode;
            
            curNode = nextNode;
            nextNode = loopNode;
        }
        p2 = curNode;
        
        ListNode p = p1;
        ListNode q = p2;
        // merge two sublists
        while (p1 != null && p2 != null) {
            ListNode temp1 = p1.next;
            ListNode temp2 = p2.next;
            p1.next = p2;
            p2.next = temp1;
            p1 = temp1;
            p2 = temp2;
        }
    }
}
*/