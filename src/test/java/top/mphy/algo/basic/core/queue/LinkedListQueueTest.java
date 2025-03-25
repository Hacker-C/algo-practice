package top.mphy.algo.basic.core.queue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LinkedListQueueTest {

    private LinkedListQueue<Integer> intQueue;
    private LinkedListQueue<String> stringQueue;
    private LinkedListQueue<Object> objectQueue;

    @BeforeEach
    void setUp() {
        intQueue = new LinkedListQueue<>();
        stringQueue = new LinkedListQueue<>();
        objectQueue = new LinkedListQueue<>();
    }

    @Test
    void testPushAndPopInteger() {
        intQueue.push(1);
        intQueue.push(2);
        intQueue.push(3);

        assertEquals(1, intQueue.pop());
        assertEquals(2, intQueue.pop());
        assertEquals(3, intQueue.pop());
        assertTrue(intQueue.isEmpty());
    }

    @Test
    void testPushAndPopString() {
        stringQueue.push("apple");
        stringQueue.push("banana");
        stringQueue.push("cherry");

        assertEquals("apple", stringQueue.pop());
        assertEquals("banana", stringQueue.pop());
        assertEquals("cherry", stringQueue.pop());
        assertTrue(stringQueue.isEmpty());
    }

    @Test
    void testPushAndPopObject() {
        Object obj1 = new Object();
        Object obj2 = new Object();
        objectQueue.push(obj1);
        objectQueue.push(obj2);

        assertEquals(obj1, objectQueue.pop());
        assertEquals(obj2, objectQueue.pop());
        assertTrue(objectQueue.isEmpty());
    }

    @Test
    void testPeekInteger() {
        assertThrows(UnsupportedOperationException.class, () -> intQueue.peek());

        intQueue.push(1);
        assertEquals(1, intQueue.peek());

        intQueue.push(2);
        assertEquals(1, intQueue.peek());

        intQueue.pop();
        assertEquals(2, intQueue.peek());
    }

    @Test
    void testPeekString() {
        assertThrows(UnsupportedOperationException.class, () -> stringQueue.peek());

        stringQueue.push("test");
        assertEquals("test", stringQueue.peek());

        stringQueue.push("test2");
        assertEquals("test", stringQueue.peek());

        stringQueue.pop();
        assertEquals("test2", stringQueue.peek());
    }

    @Test
    void testPeekObject() {
        assertThrows(UnsupportedOperationException.class, () -> objectQueue.peek());

        Object obj = new Object();
        objectQueue.push(obj);

        assertEquals(obj, objectQueue.peek());
    }

    @Test
    void testSize() {
        assertEquals(0, intQueue.size());

        intQueue.push(1);
        assertEquals(1, intQueue.size());

        intQueue.push(2);
        assertEquals(2, intQueue.size());

        intQueue.pop();
        assertEquals(1, intQueue.size());

        intQueue.pop();
        assertEquals(0, intQueue.size());
    }

    @Test
    void testIsEmpty() {
        assertTrue(intQueue.isEmpty());

        intQueue.push(1);
        assertFalse(intQueue.isEmpty());

        intQueue.pop();
        assertTrue(intQueue.isEmpty());
    }

    @Test
    void testMultiplePushesAndPops() {
        for (int i = 0; i < 10; i++) {
            intQueue.push(i);
        }

        assertEquals(10, intQueue.size());

        for (int i = 0; i < 10; i++) {
            assertEquals(i, intQueue.pop());
        }

        assertEquals(0, intQueue.size());
        assertTrue(intQueue.isEmpty());
    }

    @Test
    void testPopEmptyQueueThrowsException() {
        assertThrows(UnsupportedOperationException.class, () -> intQueue.pop());
    }

    @Test
    void testPeekEmptyQueueThrowsException() {
        assertThrows(UnsupportedOperationException.class, () -> intQueue.peek());
    }

    @Test
    void testPushAndPopNullValues() {
        LinkedListQueue<Integer> nullQueue = new LinkedListQueue<>();
        nullQueue.push(null);
        assertNull(nullQueue.peek());
        assertNull(nullQueue.pop());
        assertTrue(nullQueue.isEmpty());

        nullQueue.push(1);
        nullQueue.push(null);
        assertEquals(1, nullQueue.pop());
        assertNull(nullQueue.pop());
        assertTrue(nullQueue.isEmpty());
    }
}