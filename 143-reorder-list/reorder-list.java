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
    public void reorderList(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode h2 = slow.next;
        ListNode h1 = head;
        slow.next = null;
        h2 = reverse(h2);

        while (h2 != null) {
            ListNode tmp = h1.next;
            ListNode tmp2 = h2.next;
            h1.next = h2;
            h2.next = tmp;
            h1 = tmp;
            h2 = tmp2;
        }

    }

    public ListNode reverse(ListNode node) {

        ListNode prev = null;
        ListNode curr = node;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
}