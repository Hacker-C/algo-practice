package top.mphy.algo.basic.core.hashmap;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import javax.naming.OperationNotSupportedException;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayListHashMapTest {

    // --- Tests for Integer Keys ---
    @Nested
    @DisplayName("Tests with Integer Keys")
    class IntegerKeyTests {
        private ArrayListHashMap<Integer, String> map;

        @BeforeEach
        void setUp() {
            map = new ArrayListHashMap<>();
        }

        @Test
        @DisplayName("Put and Get single Integer key")
        void testPutAndGet_SingleIntegerKey() {
            map.put(1, "One");
            assertEquals("One", map.get(1));
        }

        @Test
        @DisplayName("Get non-existent Integer key returns null")
        void testGet_NonExistentIntegerKey() {
            assertNull(map.get(99));
        }

        @Test
        @DisplayName("Put multiple Integer keys and Get them")
        void testPutAndGet_MultipleIntegerKeys() {
            map.put(5, "Five");
            map.put(105, "One Hundred Five"); // Hashes to the same bucket as 5
            map.put(10, "Ten");

            // Because of overwrite collision handling:
            // get(5) should now return the value for 105
            assertEquals("One Hundred Five", map.get(5), "Getting key 5 should return value for 105 due to hash collision overwrite");
            assertEquals("One Hundred Five", map.get(105));
            assertEquals("Ten", map.get(10));
        }

        @Test
        @DisplayName("Put overwrites existing Integer key")
        void testPut_OverwriteIntegerKey() {
            map.put(7, "Seven");
            assertEquals("Seven", map.get(7));
            map.put(7, "Sieben"); // Overwrite
            assertEquals("Sieben", map.get(7));
        }

        @Test
        @DisplayName("Remove existing Integer key")
        void testRemove_ExistingIntegerKey() {
            map.put(8, "Eight");
            assertEquals("Eight", map.get(8));
            assertDoesNotThrow(() -> map.remove(8));
            assertNull(map.get(8), "Key 8 should be removed");
        }

        @Test
        @DisplayName("Remove non-existent Integer key")
        void testRemove_NonExistentIntegerKey() {
            assertNull(map.get(9));
            assertDoesNotThrow(() -> map.remove(9)); // Should not throw
            assertNull(map.get(9), "Key 9 should still be null");
        }

        @Test
        @DisplayName("Remove key causing collision overwrite")
        void testRemove_CollisionOverwriteIntegerKey() {
            map.put(3, "Three");
            map.put(103, "One Hundred Three"); // Overwrites bucket for key 3

            assertEquals("One Hundred Three", map.get(3)); // Key 3 now points to 103's value
            assertEquals("One Hundred Three", map.get(103));

            // Remove key 103 (which is currently in the bucket for hash(3))
            assertDoesNotThrow(() -> map.remove(103));

            assertNull(map.get(103), "Key 103 should be removed");
            assertNull(map.get(3), "Getting key 3 should now return null as bucket is cleared");
        }
    }

    // --- Tests for String Keys ---
    @Nested
    @DisplayName("Tests with String Keys")
    class StringKeyTests {
        private ArrayListHashMap<String, Integer> map;

        @BeforeEach
        void setUp() {
            map = new ArrayListHashMap<>();
        }

        @Test
        @DisplayName("Put and Get single String key")
        void testPutAndGet_SingleStringKey() {
            map.put("apple", 1);
            assertEquals(1, map.get("apple"));
        }

        @Test
        @DisplayName("Get non-existent String key returns null")
        void testGet_NonExistentStringKey() {
            assertNull(map.get("banana"));
        }

        @Test
        @DisplayName("Put multiple String keys and Get them")
        void testPutAndGet_MultipleStringKeys() {
            map.put("apple", 10);
            map.put("banana", 20);
            map.put("Aa", 30); // Hashes to 12
            map.put("BB", 40); // Hashes to 12 (collision)

            assertEquals(10, map.get("apple"));
            assertEquals(20, map.get("banana"));
            // Because of overwrite collision handling:
            assertEquals(40, map.get("Aa"), "Getting key 'Aa' should return value for 'BB' due to hash collision overwrite");
            assertEquals(40, map.get("BB"));
        }

        @Test
        @DisplayName("Put overwrites existing String key")
        void testPut_OverwriteStringKey() {
            map.put("key", 100);
            assertEquals(100, map.get("key"));
            map.put("key", 200); // Overwrite
            assertEquals(200, map.get("key"));
        }

        @Test
        @DisplayName("Put overwrites null String key")
        void testPut_OverwriteNullStringKey() {
            map.put(null, 55);
            assertEquals(55, map.get(null));
            map.put(null, 66); // Overwrite
            assertEquals(66, map.get(null));
        }

        @Test
        @DisplayName("Remove String key throws OperationNotSupportedException")
        void testRemove_StringKey_ThrowsException() {
            map.put("test", 1);
            OperationNotSupportedException exception = assertThrows(
                    OperationNotSupportedException.class,
                    () -> map.remove("test"),
                    "Remove with String key should throw OperationNotSupportedException"
            );
            assertEquals("only support int for key", exception.getMessage());
            // Verify element was not actually removed
            assertEquals(1, map.get("test"));
        }

        @Test
        @DisplayName("Remove null String key throws OperationNotSupportedException")
        void testRemove_NullStringKey_ThrowsException() {
            map.put(null, 1);
            OperationNotSupportedException exception = assertThrows(
                    OperationNotSupportedException.class,
                    () -> map.remove(null),
                    "Remove with null key should throw OperationNotSupportedException"
            );
            assertEquals("only support int for key", exception.getMessage());
            // Verify element was not actually removed
            assertEquals(1, map.get(null));
        }
    }

    // --- Tests for General Functionality (Key/Value Sets, forEach) ---
    @Nested
    @DisplayName("General Functionality Tests")
    class GeneralFunctionalityTests {
        private ArrayListHashMap<Integer, String> map;

        @BeforeEach
        void setUp() {
            map = new ArrayListHashMap<>();
        }

        @Test
        @DisplayName("keySet on empty map")
        void testKeySet_EmptyMap() {
            assertTrue(map.keySet().isEmpty());
        }

        @Test
        @DisplayName("keySet returns all added keys")
        void testKeySet_PopulatedMap() {
            map.put(1, "A");
            map.put(101, "B"); // Overwrites bucket for key 1
            map.put(2, "C");

            List<Integer> expectedKeys = Arrays.asList(101, 2); // Key 1 is overwritten by 101
            List<Integer> actualKeys = map.keySet();

            assertEquals(expectedKeys.size(), actualKeys.size());
            assertTrue(actualKeys.containsAll(expectedKeys));
            assertTrue(expectedKeys.containsAll(actualKeys)); // Order may vary depending on hash iteration
        }

        @Test
        @DisplayName("keySet after remove")
        void testKeySet_AfterRemove() {
            map.put(1, "A");
            map.put(2, "C");
            assertDoesNotThrow(() -> map.remove(1));

            List<Integer> expectedKeys = List.of(2);
            List<Integer> actualKeys = map.keySet();

            assertEquals(expectedKeys, actualKeys); // Order should be predictable here
        }

        @Test
        @DisplayName("valueSet on empty map")
        void testValueSet_EmptyMap() {
            assertTrue(map.valueSet().isEmpty());
        }

        @Test
        @DisplayName("valueSet returns all added values")
        void testValueSet_PopulatedMap() {
            map.put(1, "A");
            map.put(101, "B"); // Overwrites bucket for key 1
            map.put(2, "C");
            map.put(3, "B"); // Duplicate value

            List<String> expectedValues = Arrays.asList("B", "C", "B"); // Value "A" from key 1 is overwritten by "B" from 101
            List<String> actualValues = map.valueSet();

            // Order depends on hash iteration, check contents and size
            assertEquals(expectedValues.size(), actualValues.size());
            assertTrue(actualValues.containsAll(expectedValues));
            // Need to account for duplicates if using containsAll on sets
            Map<String, Long> expectedCounts = new HashMap<>();
            expectedValues.forEach(v -> expectedCounts.put(v, expectedCounts.getOrDefault(v, 0L) + 1));
            Map<String, Long> actualCounts = new HashMap<>();
            actualValues.forEach(v -> actualCounts.put(v, actualCounts.getOrDefault(v, 0L) + 1));
            assertEquals(expectedCounts, actualCounts);

        }

        @Test
        @DisplayName("valueSet after remove")
        void testValueSet_AfterRemove() {
            map.put(1, "A");
            map.put(2, "C");
            assertDoesNotThrow(() -> map.remove(1));

            List<String> expectedValues = List.of("C");
            List<String> actualValues = map.valueSet();

            assertEquals(expectedValues, actualValues);
        }

        @Test
        @DisplayName("forEach on empty map")
        void testForEach_EmptyMap() {
            List<Integer> keys = new ArrayList<>();
            map.forEach((k, v) -> keys.add(k));
            assertTrue(keys.isEmpty());
        }

        @Test
        @DisplayName("forEach iterates over all elements")
        void testForEach_PopulatedMap() {
            map.put(1, "A");
            map.put(101, "B"); // Overwrites key 1's bucket
            map.put(2, "C");

            Map<Integer, String> collected = new HashMap<>();
            map.forEach(collected::put);

            Map<Integer, String> expected = new HashMap<>();
            expected.put(101, "B");
            expected.put(2, "C");

            assertEquals(expected, collected);
        }
    }

    // --- Tests for Unsupported Key Types ---
    @Nested
    @DisplayName("Unsupported Key Type Tests")
    class UnsupportedKeyTypeTests {
        private ArrayListHashMap<Double, String> map;

        @BeforeEach
        void setUp() {
            map = new ArrayListHashMap<>();
        }

        @Test
        @DisplayName("Put with unsupported key type does nothing")
        void testPut_UnsupportedKeyType() {
            map.put(1.5, "Double");
            assertTrue(map.keySet().isEmpty(), "Map should be empty after putting unsupported key type");
            assertTrue(map.valueSet().isEmpty());
        }

        @Test
        @DisplayName("Get with unsupported key type returns null")
        void testGet_UnsupportedKeyType() {
            // Put something valid first to ensure map isn't just empty
            ArrayListHashMap<Integer, String> intMap = new ArrayListHashMap<>();
            intMap.put(1, "One");

            // Now test the Double map
            assertNull(map.get(2.5), "Getting unsupported key type should return null");
        }

        @Test
        @DisplayName("Remove with unsupported key type throws OperationNotSupportedException")
        void testRemove_UnsupportedKeyType() {
            // Note: The exception is thrown before the type check in getHash happens
            OperationNotSupportedException exception = assertThrows(
                    OperationNotSupportedException.class,
                    () -> map.remove(3.14),
                    "Remove with unsupported key type should throw OperationNotSupportedException"
            );
            assertEquals("only support int for key", exception.getMessage());
        }
    }

    // --- Optional: Direct Hash Function Tests ---
    @Nested
    @DisplayName("Hash Function Tests")
    class HashFunctionTests {
        // Need an instance to call the non-static hashFunc(String)
        // Even though it doesn't depend on instance state, it's not static
        private ArrayListHashMap<String, Integer> map = new ArrayListHashMap<>();
    }
}