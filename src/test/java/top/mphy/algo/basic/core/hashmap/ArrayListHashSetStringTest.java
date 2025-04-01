package top.mphy.algo.basic.core.hashmap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * ArrayListHashSetStringTest
 *
 * @author MurphyChen
 * @since 2025/4/2 0:03
 */
@DisplayName("ArrayListHashSet<String> Tests")
class ArrayListHashSetStringTest {

    private ArrayListHashSet<String> set;

    @BeforeEach
    void setUp() {
        set = new ArrayListHashSet<>();
    }

    @Test
    @DisplayName("New String set should be empty")
    void testNewSetIsEmpty() {
        assertEquals(0, set.size(), "Initial size should be 0");
        assertTrue(set.isEmpty(), "Initial set should be empty");
    }

    // --- Add Tests ---
    @Test
    @DisplayName("Add single String increases size")
    void testAdd_SingleString_IncreasesSize() {
        set.add("hello");
        assertEquals(1, set.size());
        assertFalse(set.isEmpty());
    }

    @Test
    @DisplayName("Add multiple different Strings increases size correctly")
    void testAdd_MultipleStrings_CorrectSize() {
        set.add("one");
        set.add("two");
        set.add(""); // Empty string is valid
        assertEquals(3, set.size());
    }

    @Test
    @DisplayName("Add duplicate String does not change size")
    void testAdd_DuplicateString_SizeUnchanged() {
        set.add("abc");
        set.add("def");
        assertEquals(2, set.size());
        set.add("abc"); // Add duplicate
        assertEquals(2, set.size());
    }

    @Test
    @DisplayName("Add null String throws IllegalArgumentException")
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
    @DisplayName("Remove existing String decreases size")
    void testRemove_ExistingString_DecreasesSize() {
        set.add("remove_me");
        set.add("keep_me");
        assertEquals(2, set.size());

        set.remove("remove_me");
        assertEquals(1, set.size());

        set.remove("keep_me");
        assertEquals(0, set.size());
        assertTrue(set.isEmpty());
    }

    @Test
    @DisplayName("Remove non-existing String does not change size")
    void testRemove_NonExistingString_SizeUnchanged() {
        set.add("present");
        assertEquals(1, set.size());

        set.remove("absent"); // String not in the set
        assertEquals(1, set.size());
    }

    @Test
    @DisplayName("Remove from empty String set does not change size")
    void testRemove_FromEmptySet_SizeRemainsZero() {
        assertTrue(set.isEmpty());
        set.remove("anything");
        assertEquals(0, set.size());
        assertTrue(set.isEmpty());
    }

    @Test
    @DisplayName("Remove null String throws IllegalArgumentException")
    void testRemove_Null_ThrowsIllegalArgumentException() {
        set.add("test"); // Ensure set is not empty
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> set.remove(null),
                "Removing null should throw IllegalArgumentException"
        );
        assertEquals("Element type must be Integer、String or Boolean", exception.getMessage());
    }


    // --- Clear Tests ---
    @Test
    @DisplayName("Clear non-empty String set makes it empty")
    void testClear_NonEmptySet_BecomesEmpty() {
        set.add("clear");
        set.add("this");
        assertFalse(set.isEmpty());
        assertEquals(2, set.size());

        set.clear();

        assertTrue(set.isEmpty());
        assertEquals(0, set.size());
    }

    @Test
    @DisplayName("Clear empty String set remains empty")
    void testClear_EmptySet_RemainsEmpty() {
        assertTrue(set.isEmpty());
        set.clear();
        assertTrue(set.isEmpty());
        assertEquals(0, set.size());
    }

    // --- Size/IsEmpty Combined ---
    @Test
    @DisplayName("Size and isEmpty reflect String set state correctly")
    void testSizeAndIsEmpty_StringOperations() {
        assertTrue(set.isEmpty());
        assertEquals(0, set.size());
        set.add("alpha");
        assertFalse(set.isEmpty());
        assertEquals(1, set.size());
        set.add("beta");
        assertEquals(2, set.size());
        set.add("alpha"); // Duplicate
        assertEquals(2, set.size());
        set.remove("beta");
        assertEquals(1, set.size());
        assertFalse(set.isEmpty());
        set.clear();
        assertTrue(set.isEmpty());
        assertEquals(0, set.size());
    }
}
