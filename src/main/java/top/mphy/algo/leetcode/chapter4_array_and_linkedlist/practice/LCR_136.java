package top.mphy.algo.leetcode.chapter4_array_and_linkedlist.practice;

public class LCR_136 {
    public ListNode deleteNode(ListNode head, int val) {
        if (head == null) return null;
        if (head.val == val) return head.next;
        ListNode prev = new ListNode(0, head);
        ListNode cur = head;
        while (cur != null) {
            if (cur.val == val) {
                prev.next = cur.next;
                return head;
            }
            cur = cur.next;
            prev = prev.next;
        }
        return null;
    }
}
