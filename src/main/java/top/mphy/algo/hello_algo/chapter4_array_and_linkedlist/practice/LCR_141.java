package top.mphy.algo.hello_algo.chapter4_array_and_linkedlist.practice;

public class LCR_141 {
    public ListNode trainningPlan(ListNode head) {
        ListNode cur = head, pre = null;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }
}
