/*
    Insertion Sort List
    Sort a linked list using insertion sort.
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
    public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode newhead = new ListNode(Integer.MIN_VALUE);
        newhead.next = head;
        ListNode begin = head.next;
        head.next = null; // cut the list, in case of infinite loop.
        while(begin != null){
            ListNode tem = newhead;
            while(tem.next != null){
                if(tem.next.val < begin.val){
                    tem = tem.next;
                }else{
                    break;
                }
            }
            
            if(tem.next == begin){
                // tem.val < begin.val, do not need to change position.
                tem.next = begin;
                begin = begin. next;
            }else{
                // change position (tem.next and begin)
                ListNode node = begin.next;
                begin.next = tem.next;
                tem.next = begin;
                begin = node;
            }
        }
        return newhead.next;
    }
}