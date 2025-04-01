package top.mphy.algo.leetcode.chapter5_stack_and_queue.practice;

import top.mphy.algo.leetcode.common.Node;

import java.util.HashMap;

/**
 * 138. 随机链表的复制
 * https://leetcode.cn/problems/copy-list-with-random-pointer/description/
 */
public class LeetCode_138 {
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        Node pre = new Node(0);

        HashMap<Node, Node> map = new HashMap<>();

        Node cur1 = head, cur2 = pre;
        while (cur1 != null) {
            Node copy = new Node(cur1.val);
            cur2.next = copy;

            map.put(cur1, copy);

            cur1 = cur1.next;
            cur2 = copy;
        }

        Node cur3 = head, cur4 = pre.next;
        while (cur3 != null) {
            if (cur3.random != null) {
                cur4.random = map.get(cur3.random);
            }
            cur3 = cur3.next;
            cur4 = cur4.next;
        }

        return pre.next;
    }
}
