/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode fast=head;
        ListNode slow=head;

        while(slow!=null && fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }

        ListNode revHead=reverse(slow);
        slow=head;

        while(slow!=null && revHead!=null){
            if(slow.val!=revHead.val)return false;
            slow=slow.next;
            revHead=revHead.next;
        }
        return true;

    }

    private ListNode reverse(ListNode head){
        ListNode prev=null;
        ListNode curr=head;


        while(curr!=null){
            ListNode currNext=curr.next;
            curr.next=prev;
            prev=curr;
            curr=currNext;
        }
        return prev;
    }
}