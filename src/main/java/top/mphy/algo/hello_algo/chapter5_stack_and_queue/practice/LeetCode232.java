package top.mphy.algo.hello_algo.chapter5_stack_and_queue.practice;

import java.util.Stack;

/**
 * 232. 用栈实现队列
 * https://leetcode.cn/problems/implement-queue-using-stacks/description/
 */
public class LeetCode232 {
    class MyQueue {

        private Stack<Integer> tear;

        private Stack<Integer> head;

        public MyQueue() {
            tear = new Stack<>();
            head = new Stack<>();
        }

        public void push(int x) {
            tear.push(x);
        }

        public int pop() {
            if (!head.empty()) {
                return head.pop();
            }
            while (!tear.empty()) {
                head.push(tear.pop());
            }
            return head.pop();
        }

        public int peek() {
            int res = pop();
            head.push(res);
            return res;
        }

        public boolean empty() {
            return head.empty() && tear.empty();
        }
    }
}
