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
    public ListNode oddEvenList(ListNode head) {
        if (head == null)
            return head;
        ListNode odd = head;
        ListNode evenHead = head.next;
        ListNode even = head.next;
        int i = 1;

        while (even != null && even.next != null) {

            if (i % 2 != 0) {
                odd.next = even.next;
                odd = odd.next;
            } else {
                even.next = odd.next;
                even = even.next;
            }
            i++;

        }
        odd.next = evenHead;
        return head;
    }
}