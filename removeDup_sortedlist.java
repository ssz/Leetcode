/*
    Remove Duplicates from Sorted List
    
    Given a sorted linked list, delete all duplicates such that each element appear only once.
    For example,
    Given 1->1->2, return 1->2.
    Given 1->1->2->3->3, return 1->2->3.
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
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null) return null;
        ListNode result=new ListNode(head.val); 
        ListNode tracking=result;
        ListNode curr=head;
        curr=curr.next;
        while(curr!= null){
            if(tracking.val == curr.val){
                // pass this node
            }else{
                // add this node
                tracking.next = new ListNode(curr.val);
                tracking = tracking.next;
            }
            curr = curr.next;
        }
        return result;
    }
}

//time limit error
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null) return null;
        ListNode nodup=new ListNode(0); nodup.next=head;
        ListNode temp=head;
        while(temp.next!=null){
            ListNode tempNext=temp.next;
            if(tempNext.next==null) return nodup.next;
            if(tempNext.val==temp.val) tempNext=tempNext.next;
            else temp.next=temp;
        }
        return nodup.next;
    }
}