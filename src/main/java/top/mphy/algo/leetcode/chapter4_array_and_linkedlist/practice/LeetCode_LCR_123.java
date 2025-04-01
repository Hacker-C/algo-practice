package top.mphy.algo.leetcode.chapter4_array_and_linkedlist.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LeetCode_LCR_123 {
    public int[] reverseBookList(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            list.add(cur.val);
            cur = cur.next;
        }
        int[] res = new int[list.size()];
        int j = 0;
        for (int i = list.size() - 1; i >= 0; i--) {
            res[j++] = list.get(i);
        }
        return res;
    }

    public int[] reverseBookList2(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode cur = head;
        while (cur != null) {
            stack.push(cur.val);
            cur = cur.next;
        }
        int[] res = new int[stack.size()];
        int i = 0;
        while (!stack.isEmpty()) {
            res[i++] = stack.pop();
        }
        return res;
    }
}

