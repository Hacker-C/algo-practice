package top.mphy.algo.hello_algo.chapter2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import top.mphy.algo.hello_algo.chapter2_complexity.TimeComplexity;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

public class TimeComplexityTest {

    @Test
    public void testTotalCellDivisionRecur() {
        assertEquals(0, TimeComplexity.totalDivisionsRecur(0));
        assertEquals(1, TimeComplexity.totalDivisionsRecur(1));
        assertEquals(3, TimeComplexity.totalDivisionsRecur(2));
        assertEquals(7, TimeComplexity.totalDivisionsRecur(3));
        assertEquals(15, TimeComplexity.totalDivisionsRecur(4));
        assertEquals(31, TimeComplexity.totalDivisionsRecur(5));
        assertEquals(1023, TimeComplexity.totalDivisionsRecur(10));
    }

    @Test
    public void testTotalCellDivision() {
        assertEquals(0, TimeComplexity.totalDivisions(0));
        assertEquals(1, TimeComplexity.totalDivisions(1));
        assertEquals(3, TimeComplexity.totalDivisions(2));
        assertEquals(7, TimeComplexity.totalDivisions(3));
        assertEquals(15, TimeComplexity.totalDivisions(4));
        assertEquals(31, TimeComplexity.totalDivisions(5));
        assertEquals(1023, TimeComplexity.totalDivisions(10));
    }


    @ParameterizedTest
    @MethodSource("provideTestCases")
    public void testBubbleSort(int[] input, int[] expected) {
        TimeComplexity.bubbleSort(input);
        assertArrayEquals(expected, input);
    }

    static Stream<Arguments> provideTestCases() {
        return Stream.of(
                Arguments.of(new int[]{1, 2}, new int[]{1, 2}),
                Arguments.of(new int[]{2, 1}, new int[]{1, 2}),
                Arguments.of(new int[]{5, 3, 8, 4, 2}, new int[]{2, 3, 4, 5, 8}),
                Arguments.of(new int[]{}, new int[]{}),
                Arguments.of(new int[]{7}, new int[]{7}),
                Arguments.of(new int[]{9, 9, 9}, new int[]{9, 9, 9}),
                Arguments.of(new int[]{3, -1, 2, 0}, new int[]{-1, 0, 2, 3}),
                Arguments.of(new int[]{5, 1, 4, 2, 8, 5, 2}, new int[]{1, 2, 2, 4, 5, 5, 8}),
                Arguments.of(new int[]{1000, -1000, 500, -500, 0}, new int[]{-1000, -500, 0, 500, 1000}),
                Arguments.of(new int[]{8, 3, 7, 4, 2, 6, 5, 1}, new int[]{1, 2, 3, 4, 5, 6, 7, 8}),
                Arguments.of(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10},
                        new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}),  // 已排序
                Arguments.of(new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1},
                        new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}),  // 逆序
                Arguments.of(new int[]{1, 1, 1, 1, 1, 1, 1, 1}, new int[]{1, 1, 1, 1, 1, 1, 1, 1})  // 全相同
        );
    }

    // 提供测试数据
    static Stream<Arguments> provideFactorialCases() {
        return Stream.of(
                Arguments.of(0, 1),     // 0! = 1
                Arguments.of(1, 1),     // 1! = 1
                Arguments.of(2, 2),     // 2! = 2
                Arguments.of(3, 6),     // 3! = 6
                Arguments.of(4, 24),    // 4! = 24
                Arguments.of(5, 120),   // 5! = 120
                Arguments.of(6, 720),   // 6! = 720
                Arguments.of(7, 5040),  // 7! = 5040
                Arguments.of(8, 40320), // 8! = 40320
                Arguments.of(10, 3628800) // 10! = 3,628,800
        );
    }

    // 参数化测试
    @ParameterizedTest
    @MethodSource("provideFactorialCases")
    void testFactorialRecur(int n, long expected) {
        assertEquals(expected, TimeComplexity.factorialRecur(n));
    }
}
