package top.mphy.algo.basic.core.hashmap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Integer Set test
 *
 * @author MurphyChen
 * @since 2025/4/1 23:58
 */

@DisplayName("ArrayListHashSet<Integer> Tests")
class ArrayListHashSetIntegerTest {

    private ArrayListHashSet<Integer> set;

    @BeforeEach
    void setUp() {
        set = new ArrayListHashSet<>();
    }

    @Test
    @DisplayName("New Integer set should be empty")
    void testNewSetIsEmpty() {
        assertEquals(0, set.size(), "Initial size should be 0");
        assertTrue(set.isEmpty(), "Initial set should be empty");
    }

    // --- Add Tests ---
    @Test
    @DisplayName("Add single Integer increases size")
    void testAdd_SingleInteger_IncreasesSize() {
        set.add(123);
        assertEquals(1, set.size());
        assertFalse(set.isEmpty());
    }

    @Test
    @DisplayName("Add multiple different Integers increases size correctly")
    void testAdd_MultipleIntegers_CorrectSize() {
        set.add(1);
        set.add(2);
        set.add(5);
        assertEquals(3, set.size());
    }

    @Test
    @DisplayName("Add duplicate Integer does not change size")
    void testAdd_DuplicateInteger_SizeUnchanged() {
        set.add(100);
        set.add(65);
        assertEquals(2, set.size());
        set.add(65); // Add duplicate
        assertEquals(2, set.size());
    }

    @Test
    @DisplayName("Add null Integer throws IllegalArgumentException")
    void testAdd_Null_ThrowsIllegalArgumentException() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> set.add(null),
                "Adding null should throw IllegalArgumentException"
        );
        assertEquals("Element type must be Integer、String or Boolean", exception.getMessage());
    }


    // --- Remove Tests ---
    @Test
    @DisplayName("Remove existing Integer decreases size")
    void testRemove_ExistingInteger_DecreasesSize() {
        set.add(50);
        set.add(60);
        assertEquals(2, set.size());

        set.remove(50);
        assertEquals(1, set.size());

        set.remove(60);
        assertEquals(0, set.size());
        assertTrue(set.isEmpty());
    }

    @Test
    @DisplayName("Remove non-existing Integer does not change size")
    void testRemove_NonExistingInteger_SizeUnchanged() {
        set.add(10);
        assertEquals(1, set.size());

        set.remove(20); // Integer not in the set
        assertEquals(1, set.size());
    }

    @Test
    @DisplayName("Remove from empty Integer set does not change size")
    void testRemove_FromEmptySet_SizeRemainsZero() {
        assertTrue(set.isEmpty());
        set.remove(123);
        assertEquals(0, set.size());
        assertTrue(set.isEmpty());
    }

    @Test
    @DisplayName("Remove null Integer throws IllegalArgumentException")
    void testRemove_Null_ThrowsIllegalArgumentException() {
        set.add(1); // Ensure set is not empty for this check case
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> set.remove(null),
                "Removing null should throw IllegalArgumentException"
        );
        assertEquals("Element type must be Integer、String or Boolean", exception.getMessage());
    }

    // --- Clear Tests ---
    @Test
    @DisplayName("Clear non-empty Integer set makes it empty")
    void testClear_NonEmptySet_BecomesEmpty() {
        set.add(1);
        set.add(2);
        assertFalse(set.isEmpty());
        assertEquals(2, set.size());

        set.clear();

        assertTrue(set.isEmpty());
        assertEquals(0, set.size());
    }

    @Test
    @DisplayName("Clear empty Integer set remains empty")
    void testClear_EmptySet_RemainsEmpty() {
        assertTrue(set.isEmpty());
        set.clear();
        assertTrue(set.isEmpty());
        assertEquals(0, set.size());
    }

    // --- Size/IsEmpty Combined ---
    @Test
    @DisplayName("Size and isEmpty reflect Integer set state correctly")
    void testSizeAndIsEmpty_IntegerOperations() {
        assertTrue(set.isEmpty());
        assertEquals(0, set.size());
        set.add(10);
        assertFalse(set.isEmpty());
        assertEquals(1, set.size());
        set.add(20);
        assertEquals(2, set.size());
        set.add(10); // Duplicate
        assertEquals(2, set.size());
        set.remove(20);
        assertEquals(1, set.size());
        assertFalse(set.isEmpty());
        set.clear();
        assertTrue(set.isEmpty());
        assertEquals(0, set.size());
    }
}