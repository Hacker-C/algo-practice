package top.mphy.algo.leetcode.chapter4_array_and_linkedlist.practice;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

public class LeetCode_LCR139_Test {
    @Test
    void testTrainingPlan() {
        assertArrayEquals(
                new int[]{1, 3, 5, 4, 2},
                new LeetCode_LCR139().trainingPlan(new int[]{1, 2, 3, 4, 5})
        );
    }
}
