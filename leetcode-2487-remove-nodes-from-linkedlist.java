/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        while (current != null) {
            ListNode nextTemp = current.next;
            current.next = prev;
            prev = current;
            current = nextTemp;
        }
        return prev;
    }

    public ListNode removeNodes(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        head = reverseList(head);

        ListNode current = head;
        ListNode prev = head;
        int maxVal = head.val;

        while (current != null) {
            if (current.val >= maxVal) {
                maxVal = current.val;
                prev = current;
                current = current.next;
            } else {
                prev.next = current.next;
                current = current.next;
            }
        }

        head = reverseList(head);

        return head;
    }
}
