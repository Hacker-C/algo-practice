package top.mphy.algo.basic.core.hashmap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * ArrayListHashSetBooleanTest
 *
 * @author MurphyChen
 * @since 2025/4/2 0:04
 */

@DisplayName("ArrayListHashSet<Boolean> Tests")
class ArrayListHashSetBooleanTest {

    private ArrayListHashSet<Boolean> set;

    @BeforeEach
    void setUp() {
        set = new ArrayListHashSet<>();
    }

    @Test
    @DisplayName("New Boolean set should be empty")
    void testNewSetIsEmpty() {
        assertEquals(0, set.size(), "Initial size should be 0");
        assertTrue(set.isEmpty(), "Initial set should be empty");
    }

    // --- Add Tests ---
    @Test
    @DisplayName("Add single Boolean (true) increases size")
    void testAdd_SingleTrue_IncreasesSize() {
        set.add(true);
        assertEquals(1, set.size());
        assertFalse(set.isEmpty());
    }

    @Test
    @DisplayName("Add single Boolean (false) increases size")
    void testAdd_SingleFalse_IncreasesSize() {
        set.add(false);
        assertEquals(1, set.size());
        assertFalse(set.isEmpty());
    }

    @Test
    @DisplayName("Add both Boolean values increases size to 2")
    void testAdd_BothBooleans_CorrectSize() {
        set.add(true);
        set.add(false);
        assertEquals(2, set.size());
    }

    @Test
    @DisplayName("Add duplicate Boolean does not change size")
    void testAdd_DuplicateBoolean_SizeUnchanged() {
        set.add(true);
        assertEquals(1, set.size());
        set.add(true); // Add duplicate true
        assertEquals(1, set.size());

        set.add(false);
        assertEquals(2, set.size());
        set.add(false); // Add duplicate false
        assertEquals(2, set.size());
        set.add(true); // Add duplicate true again
        assertEquals(2, set.size());
    }

    @Test
    @DisplayName("Add null Boolean throws IllegalArgumentException")
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
    @DisplayName("Remove existing Boolean decreases size")
    void testRemove_ExistingBoolean_DecreasesSize() {
        set.add(true);
        set.add(false);
        assertEquals(2, set.size());

        set.remove(true);
        assertEquals(1, set.size());
        assertFalse(set.isEmpty()); // Still contains false

        set.remove(false);
        assertEquals(0, set.size());
        assertTrue(set.isEmpty());
    }

    @Test
    @DisplayName("Remove non-existing Boolean does not change size")
    void testRemove_NonExistingBoolean_SizeUnchanged() {
        set.add(true);
        assertEquals(1, set.size());

        set.remove(false); // Boolean not in the set
        assertEquals(1, set.size());
    }

    @Test
    @DisplayName("Remove from empty Boolean set does not change size")
    void testRemove_FromEmptySet_SizeRemainsZero() {
        assertTrue(set.isEmpty());
        set.remove(true);
        assertEquals(0, set.size());
        assertTrue(set.isEmpty());
        set.remove(false);
        assertEquals(0, set.size());
        assertTrue(set.isEmpty());
    }

    @Test
    @DisplayName("Remove null Boolean throws IllegalArgumentException")
    void testRemove_Null_ThrowsIllegalArgumentException() {
        set.add(true); // Ensure set is not empty
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> set.remove(null),
                "Removing null should throw IllegalArgumentException"
        );
        assertEquals("Element type must be Integer、String or Boolean", exception.getMessage());
    }


    // --- Clear Tests ---
    @Test
    @DisplayName("Clear non-empty Boolean set makes it empty")
    void testClear_NonEmptySet_BecomesEmpty() {
        set.add(true);
        set.add(false);
        assertFalse(set.isEmpty());
        assertEquals(2, set.size());

        set.clear();

        assertTrue(set.isEmpty());
        assertEquals(0, set.size());
    }

    @Test
    @DisplayName("Clear empty Boolean set remains empty")
    void testClear_EmptySet_RemainsEmpty() {
        assertTrue(set.isEmpty());
        set.clear();
        assertTrue(set.isEmpty());
        assertEquals(0, set.size());
    }

    // --- Size/IsEmpty Combined ---
    @Test
    @DisplayName("Size and isEmpty reflect Boolean set state correctly")
    void testSizeAndIsEmpty_BooleanOperations() {
        assertTrue(set.isEmpty());
        assertEquals(0, set.size());
        set.add(true);
        assertFalse(set.isEmpty());
        assertEquals(1, set.size());
        set.add(false);
        assertEquals(2, set.size());
        set.add(true); // Duplicate
        assertEquals(2, set.size());
        set.remove(false);
        assertEquals(1, set.size());
        assertFalse(set.isEmpty());
        set.clear();
        assertTrue(set.isEmpty());
        assertEquals(0, set.size());
    }
}