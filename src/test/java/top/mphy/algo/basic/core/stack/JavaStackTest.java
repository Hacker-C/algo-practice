package top.mphy.algo.basic.core.stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class JavaStackTest {
    @Test
    void test() {
        // 队列：Queue 接口，ArrayDeque 实现
        Queue<Integer> queue1 = new ArrayDeque<>(List.of(1,2,3));
        queue1.offer(5);
        queue1.add(4);
        queue1.poll();
        queue1.remove();
        queue1.peek();
        queue1.element();
        System.out.println(queue1);

        // 队列：Queue 接口，LinkedList 实现
        Queue<Integer> queue2 = new LinkedList<>(List.of(1,2,3));
        queue2.offer(5);
        queue2.add(4);
        queue2.poll();
        queue2.remove();
        queue2.peek();
        queue2.element();

        // 栈：Deque 接口，ArrayDeque 实现
        Deque<Number> stack1 = new ArrayDeque<>();
        stack1.push(1);
        stack1.pop();
        stack1.peek();
        stack1.size();
        stack1.isEmpty();

        // 栈：Deque 接口，LinkedList 实现
        Deque<Number> stack2 = new LinkedList<>();
        stack2.push(1);
        stack2.pop();
        stack2.peek();
        stack2.size();
        stack2.isEmpty();
    }
}
