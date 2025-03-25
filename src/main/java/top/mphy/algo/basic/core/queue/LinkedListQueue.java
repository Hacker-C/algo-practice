package top.mphy.algo.basic.core.queue;

import top.mphy.algo.basic.core.linkedlist.ListNode;

public class LinkedListQueue<E> {

    private ListNode<E> head, tail;

    private int size = 0;

    /**
     * 入队
     * @param e
     */
    public void push(E e) {
        if (head == null || tail == null) {
            head = new ListNode<>(e);
            tail = head;
        } else {
            ListNode<E> node = new ListNode<>(e);
            tail.next = node;
            tail = node;
        }
        size++;
    }

    /**
     * 出队
     * @return
     */
    public E pop() {
        ListNode<E> cur = head;
        if (head == null || tail == null) {
            throw new UnsupportedOperationException("Queue is empty!");
        }
        E res = head.value;
        head = head.next;
        size--;
        return res;
    }

    /**
     * 获取队首元素
     * @return
     */
    public E peek() {
        if (head == null) {
            throw new UnsupportedOperationException("Queue is empty!");
        }
        return head.value;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }
}
