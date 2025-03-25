package top.mphy.algo.basic.core.stack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ArrayListStackTest {

    private ArrayListStack<Integer> intStack;
    private ArrayListStack<String> stringStack;
    private ArrayListStack<Object> objectStack;

    @BeforeEach
    void setUp() {
        intStack = new ArrayListStack<>();
        stringStack = new ArrayListStack<>();
        objectStack = new ArrayListStack<>();
    }

    @Test
    void testPushAndPopInteger() {
        intStack.push(1);
        intStack.push(2);
        intStack.push(3);

        assertEquals(3, intStack.pop());
        assertEquals(2, intStack.pop());
        assertEquals(1, intStack.pop());
        assertTrue(intStack.isEmpty());
    }

    @Test
    void testPushAndPopString() {
        stringStack.push("apple");
        stringStack.push("banana");
        stringStack.push("cherry");

        assertEquals("cherry", stringStack.pop());
        assertEquals("banana", stringStack.pop());
        assertEquals("apple", stringStack.pop());
        assertTrue(stringStack.isEmpty());
    }

    @Test
    void testPushAndPopObject() {
        Object obj1 = new Object();
        Object obj2 = new Object();
        objectStack.push(obj1);
        objectStack.push(obj2);

        assertEquals(obj2, objectStack.pop());
        assertEquals(obj1, objectStack.pop());
        assertTrue(objectStack.isEmpty());
    }

    @Test
    void testPeekInteger() {
        assertThrows(UnsupportedOperationException.class, () -> intStack.peek());

        intStack.push(1);
        assertEquals(1, intStack.peek());

        intStack.push(2);
        assertEquals(2, intStack.peek());

        intStack.pop();
        assertEquals(1, intStack.peek());
    }

    @Test
    void testPeekString() {
        assertThrows(UnsupportedOperationException.class, () -> stringStack.peek());

        stringStack.push("test");
        assertEquals("test", stringStack.peek());

        stringStack.push("test2");
        assertEquals("test2", stringStack.peek());

        stringStack.pop();
        assertEquals("test", stringStack.peek());
    }

    @Test
    void testPeekObject() {
        assertThrows(UnsupportedOperationException.class, () -> objectStack.peek());

        Object obj = new Object();
        objectStack.push(obj);

        assertEquals(obj, objectStack.peek());
    }

    @Test
    void testSize() {
        assertEquals(0, intStack.size());

        intStack.push(1);
        assertEquals(1, intStack.size());

        intStack.push(2);
        assertEquals(2, intStack.size());

        intStack.pop();
        assertEquals(1, intStack.size());

        intStack.pop();
        assertEquals(0, intStack.size());
    }

    @Test
    void testIsEmpty() {
        assertTrue(intStack.isEmpty());

        intStack.push(1);
        assertFalse(intStack.isEmpty());

        intStack.pop();
        assertTrue(intStack.isEmpty());
    }

    @Test
    void testMultiplePushesAndPops() {
        for (int i = 0; i < 10; i++) {
            intStack.push(i);
        }

        assertEquals(10, intStack.size());

        for (int i = 9; i >= 0; i--) {
            assertEquals(i, intStack.pop());
        }

        assertEquals(0, intStack.size());
        assertTrue(intStack.isEmpty());
    }

    @Test
    void testPopEmptyStackThrowsException() {
        assertThrows(UnsupportedOperationException.class, () -> intStack.pop());
    }

    @Test
    void testPeekEmptyStackThrowsException() {
        assertThrows(UnsupportedOperationException.class, () -> intStack.peek());
    }

    @Test
    void testPushAndPopNullValues() {
        ArrayListStack<Integer> nullStack = new ArrayListStack<>();
        nullStack.push(null);
        assertNull(nullStack.peek());
        assertNull(nullStack.pop());
        assertTrue(nullStack.isEmpty());

        nullStack.push(1);
        nullStack.push(null);
        assertNull(nullStack.pop());
        assertEquals(1, nullStack.pop());
        assertTrue(nullStack.isEmpty());
    }
}