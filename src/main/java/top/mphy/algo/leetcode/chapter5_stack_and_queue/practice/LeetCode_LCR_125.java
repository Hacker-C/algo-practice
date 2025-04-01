package top.mphy.algo.leetcode.chapter5_stack_and_queue.practice;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * LCR 125. 图书整理 II
 * https://leetcode.cn/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof/description/
 */
public class LeetCode_LCR_125 {
    class CQueue {

        private Deque<Integer> stack1, stack2;

        public CQueue() {
            stack1 = new ArrayDeque<>();
            stack2 =  new ArrayDeque<>();
        }

        public void appendTail(int value) {
            stack1.addLast(value);
        }

        public int deleteHead() {
            if (!stack2.isEmpty()) {
                return stack2.removeFirst();
            }
            if (stack1.isEmpty()) return -1;
            while (!stack1.isEmpty()) {
                stack2.addLast(stack1.removeFirst());
            }
            return stack2.removeFirst();
        }
    }
}
