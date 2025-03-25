package top.mphy.algo.hello_algo.chapter4_array_and_linkedlist.practice;

public class LCR_140 {
    public ListNode trainingPlan(ListNode head, int cnt) {
        ListNode cur = head;
        while (cnt-- > 0 && cur != null) {
            cur = cur.next;
        }
        ListNode res = head;
        while (cur != null) {
            res = res.next;
            cur = cur.next;
        }
        return res;
    }
}
