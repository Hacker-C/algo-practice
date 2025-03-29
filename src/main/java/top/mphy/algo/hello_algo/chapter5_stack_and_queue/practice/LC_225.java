package top.mphy.algo.hello_algo.chapter5_stack_and_queue.practice;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 225. 用队列实现栈
 * https://leetcode.cn/problems/implement-stack-using-queues/
 */
public class LC_225 {
    class MyStack {

        private Deque<Integer> queue;


        public MyStack() {
            queue = new LinkedList<>();
        }

        public void push(int x) {
            queue.addLast(x);
        }

        public int pop() {
            for (int i = 0; i < queue.size() - 1; i++) {
                queue.addLast(queue.removeFirst());
            }
            return queue.removeFirst();
        }

        public int top() {
            int res = pop();
            queue.addLast(res);
            return res;
        }

        public boolean empty() {
            return queue.isEmpty();
        }
    }
}
