/*
	Remove Nth Node From End of List 
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
        ListNode newhead = new ListNode(0);
        newhead.next = head;
        ListNode slow = newhead; ListNode fast = head;
        while(n > 0){
            fast = fast.next;
            n--;
        }
        
        //ListNode pslow = newhead;
        while(fast != null){
            fast=fast.next;
            slow = slow.next;
            //pslow = pslow.next;
        }
        //pslow.next = pslow.next.next;
        slow.next = slow.next.next;
        
        return newhead.next;
        
    }
}
