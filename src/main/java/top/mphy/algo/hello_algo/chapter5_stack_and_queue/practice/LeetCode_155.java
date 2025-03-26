package top.mphy.algo.hello_algo.chapter5_stack_and_queue.practice;

import java.util.*;

/**
 * 155. 最小栈
 * https://leetcode.cn/problems/min-stack/description/
 */
public class LeetCode_155 {
    class MinStack {

        private final Deque<Integer> stack = new ArrayDeque<>();

        private final Deque<Integer> min_stack = new ArrayDeque<>(List.of(Integer.MAX_VALUE));


        public MinStack() {
        }

        public void push(int val) {
            stack.push(val);
            min_stack.push(Math.min(val, min_stack.peek()));
        }

        public void pop() {
            stack.pop();
            min_stack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return min_stack.peek();
        }
    }
}
