/*
Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

For example,
Given 1->4->3->2->5->2 and x = 3,
return 1->2->2->4->3->5.
*/
/*
Solution: 
Time complexity: O(n), Space complexity: O(1)
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
/*
public class Solution {
    public ListNode partition(ListNode head, int x) {
        if (head == null) {
            return head;
        }
        ListNode iter = head;
        ListNode lessList = new ListNode(0);
        ListNode greaterList = new ListNode(0);
        while (iter != null) {
            if (iter.val < x) {
                lessList.val = iter.val;
                lessList = lessList.next;
            }
            else {
                greaterList.val = iter.val;
                greaterList = greaterList.next;
            }
            iter = iter.next;
        }
        lessList.next = greaterList;
        greaterList.next = null;
        return lessList.next;
    }
}
*/

public class Solution {
    public ListNode partition(ListNode head, int x) {
        if (head == null) {
            return head;
        }
        ListNode lessList = new ListNode(0);
        ListNode greaterList = new ListNode(0);
        ListNode lessEnd = lessList;
        ListNode greaterEnd = greaterList;
        ListNode iter = head;

        while (iter != null) {
            if (iter.val < x) {
                lessEnd.next = iter;
                lessEnd = lessEnd.next;
            }
            else {
                greaterEnd.next = iter;
                greaterEnd = greaterEnd.next;
            }
            iter = iter.next;
        }
        greaterEnd.next = null;
        lessEnd.next = greaterList.next;
        return lessList.next;
    }
}
