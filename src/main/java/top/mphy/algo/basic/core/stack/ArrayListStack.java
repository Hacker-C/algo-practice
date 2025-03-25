package top.mphy.algo.basic.core.stack;

import java.util.ArrayList;

public class ArrayListStack<E> {

    private final ArrayList<E> stack = new ArrayList<>();

    public void push(E e) {
        stack.add(e);
    }

    public E pop() {
        if (isEmpty()) {
            throw new UnsupportedOperationException("Stack is empty!");
        }
        E res = stack.get(size() - 1);
        stack.remove(size() - 1);
        return res;
    }

    public E peek() {
        if (isEmpty()) {
            throw new UnsupportedOperationException("Stack is empty!");
        }
        return stack.get(size() - 1);
    }

    public int size() {
        return stack.size();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }
}
