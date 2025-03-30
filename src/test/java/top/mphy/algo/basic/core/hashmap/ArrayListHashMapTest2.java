package top.mphy.algo.basic.core.hashmap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.naming.OperationNotSupportedException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayListHashMapTest2 {
    private ArrayListHashMap<Integer, String> intMap;
    private ArrayListHashMap<String, Integer> strMap;

    @BeforeEach
    void setUp() {
        intMap = new ArrayListHashMap<>();
        strMap = new ArrayListHashMap<>();
    }

    @Test
    void testPutAndGetIntegerKey() {
        intMap.put(1, "One");
        intMap.put(2, "Two");
        assertEquals("One", intMap.get(1));
        assertEquals("Two", intMap.get(2));
        assertNull(intMap.get(3));
    }

    @Test
    void testPutAndGetStringKey() {
        strMap.put("A", 100);
        strMap.put("B", 200);
        assertEquals(100, strMap.get("A"));
        assertEquals(200, strMap.get("B"));
        assertNull(strMap.get("C"));
    }

    @Test
    void testOverrideValue() {
        intMap.put(1, "One");
        intMap.put(1, "Uno");
        assertEquals("Uno", intMap.get(1));
    }

    @Test
    void testRemoveIntegerKey() throws OperationNotSupportedException {
        intMap.put(1, "One");
        intMap.remove(1);
        assertNull(intMap.get(1));
    }

    @Test
    void testRemoveUnsupportedStringKey() {
        strMap.put("A", 100);
        assertThrows(OperationNotSupportedException.class, () -> strMap.remove("A"));
    }

    @Test
    void testKeySet() {
        intMap.put(1, "One");
        intMap.put(2, "Two");
        List<Integer> keys = intMap.keySet();
        assertTrue(keys.containsAll(List.of(1, 2)));
        assertEquals(2, keys.size());
    }

    @Test
    void testValueSet() {
        intMap.put(1, "One");
        intMap.put(2, "Two");
        List<String> values = intMap.valueSet();
        assertTrue(values.containsAll(List.of("One", "Two")));
        assertEquals(2, values.size());
    }

    @Test
    void testForEach() {
        intMap.put(1, "One");
        intMap.put(2, "Two");
        StringBuilder sb = new StringBuilder();
        intMap.forEach((k, v) -> sb.append(k).append("-").append(v).append(","));
        List<String> entries = List.of(sb.toString().split(","));
        assertTrue(entries.containsAll(List.of("1-One", "2-Two")));
    }
}
