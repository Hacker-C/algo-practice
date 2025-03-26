package top.mphy.algo.hello_algo.chapter5_stack_and_queue.practice;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 946. 验证栈序列
 * https://leetcode.cn/problems/validate-stack-sequences/description/
 */
public class LeetCode_946 {
    class Solution {
        public boolean validateStackSequences(int[] pushed, int[] popped) {
            Deque<Integer> stack = new ArrayDeque<>();
            int i = 0;
            for (int e : pushed) {
                stack.push(e);
                while (!stack.isEmpty()) {
                    if (popped[i] == stack.peek()) {
                        stack.pop();
                        i++;
                    } else {
                        break;
                    }
                }
            }
            return stack.isEmpty();
        }
    }
}
