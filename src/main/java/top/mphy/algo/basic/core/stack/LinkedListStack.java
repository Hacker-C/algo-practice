package top.mphy.algo.basic.core.stack;

import top.mphy.algo.basic.core.linkedlist.ListNode;

public class LinkedListStack<E> {
    private ListNode<E> head;
    private int size = 0;

    public void push(E e) {
        ListNode<E> node = new ListNode<>(e);
        node.next = head;
        head = node;
        size++;
    }

    public E pop() {
        if (size == 0 || head == null) {
            return null;
        }
        E res = head.value;
        head = head.next;
        size--;
        return res;
    }

    public E peek() {
        if (head == null) {
            return null;
        }
        return head.value;
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }
}
