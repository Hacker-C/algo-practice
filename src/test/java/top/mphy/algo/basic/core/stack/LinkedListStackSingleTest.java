package top.mphy.algo.basic.core.stack;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LinkedListStackSingleTest {

    @Test
    void testLinkedListStackOperations() {
        LinkedListStack<Integer> intStack = new LinkedListStack<>();
        LinkedListStack<String> stringStack = new LinkedListStack<>();
        LinkedListStack<Object> objectStack = new LinkedListStack<>();
        LinkedListStack<Integer> nullStack = new LinkedListStack<>();

        // Integer Stack Tests
        assertTrue(intStack.isEmpty());
        assertEquals(0, intStack.size());
        assertNull(intStack.peek());
        assertNull(intStack.pop());

        intStack.push(1);
        assertFalse(intStack.isEmpty());
        assertEquals(1, intStack.size());
        assertEquals(1, intStack.peek());

        intStack.push(2);
        assertEquals(2, intStack.peek());
        assertEquals(2, intStack.size());

        assertEquals(2, intStack.pop());
        assertEquals(1, intStack.peek());
        assertEquals(1, intStack.size());

        assertEquals(1, intStack.pop());
        assertTrue(intStack.isEmpty());
        assertEquals(0, intStack.size());
        assertNull(intStack.pop());

        // String Stack Tests
        assertTrue(stringStack.isEmpty());
        assertNull(stringStack.peek());

        stringStack.push("apple");
        assertEquals("apple", stringStack.peek());

        stringStack.push("banana");
        assertEquals("banana", stringStack.peek());

        assertEquals("banana", stringStack.pop());
        assertEquals("apple", stringStack.peek());

        assertEquals("apple", stringStack.pop());
        assertTrue(stringStack.isEmpty());
        assertNull(stringStack.pop());

        // Object Stack Tests
        Object obj1 = new Object();
        Object obj2 = new Object();
        objectStack.push(obj1);
        objectStack.push(obj2);

        assertEquals(obj2, objectStack.peek());
        assertEquals(obj2, objectStack.pop());
        assertEquals(obj1, objectStack.pop());
        assertTrue(objectStack.isEmpty());

        // Multiple Pushes and Pops
        for (int i = 0; i < 10; i++) {
            intStack.push(i);
        }

        assertEquals(10, intStack.size());

        for (int i = 9; i >= 0; i--) {
            assertEquals(i, intStack.pop());
        }

        assertTrue(intStack.isEmpty());

        // Null Value tests
        nullStack.push(null);
        assertNull(nullStack.peek());
        assertNull(nullStack.pop());
        assertTrue(nullStack.isEmpty());

        nullStack.push(1);
        nullStack.push(null);
        assertEquals(null, nullStack.pop());
        assertEquals(1, nullStack.pop());
        assertTrue(nullStack.isEmpty());

    }
}
