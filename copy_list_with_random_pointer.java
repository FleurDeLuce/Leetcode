/*
A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

Return a deep copy of the list.
*/
/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) return head;
        
        RandomListNode iter = head;
        // scan-1: create a copy of each old node and insert it after each old one
        while (iter != null) {
            RandomListNode node = new RandomListNode(iter.label);
            node.random = null;
            node.next = iter.next;
            iter.next = node;
            iter = node.next;
        }
        
        // scan-2: copy the random pointer
        iter = head;
        while (iter != null) {
            if (iter.random != null) iter.next.random = iter.random.next;
            iter = iter.next.next;
        }
        
        // break the two lists
        iter = head;
        RandomListNode copyHead = head.next;
        RandomListNode copyIter = iter.next;
        while (iter != null) {
            // restore the original list
            iter.next = iter.next.next;
            iter = iter.next;
            
            // restore the new copied list
            // the next of last node in copied linked list is null
            if (copyIter.next != null) copyIter.next = copyIter.next.next;
            copyIter = copyIter.next;
        }
        return copyHead;
    }
}