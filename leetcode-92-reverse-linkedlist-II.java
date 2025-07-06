class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) {
            return head;
        }

        ListNode temp = new ListNode(0);
        temp.next = head;
        ListNode pre = temp;

        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }

        ListNode current = pre.next;
        ListNode nextNode = null;
        ListNode tail = current;

        ListNode prev = null;
        for (int i = 0; i < right - left + 1; i++) {
            nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }

        pre.next = prev;
        tail.next = current;

        return temp.next;
    }
}
