package top.mphy.algo.hello_algo.chapter2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import top.mphy.algo.hello_algo.chapter2_complexity.IterationAnRecursion;

public class IterationAnRecursionTest {
    @Test
    void testFib() {
        Assertions.assertEquals(0, IterationAnRecursion.fib(1));
        Assertions.assertEquals(1, IterationAnRecursion.fib(2));
        Assertions.assertEquals(1, IterationAnRecursion.fib(3));
        Assertions.assertEquals(2, IterationAnRecursion.fib(4));
        Assertions.assertEquals(3, IterationAnRecursion.fib(5));
        Assertions.assertEquals(5, IterationAnRecursion.fib(6));
        Assertions.assertEquals(8, IterationAnRecursion.fib(7));
        Assertions.assertEquals(13, IterationAnRecursion.fib(8));
        Assertions.assertEquals(4181, IterationAnRecursion.fib(20));
    }

    @Test
    void testTailRecur() {
        Assertions.assertEquals(0, IterationAnRecursion.tailRecur(0, 0));
        Assertions.assertEquals(1, IterationAnRecursion.tailRecur(1, 0));
        Assertions.assertEquals(6, IterationAnRecursion.tailRecur(3, 0));
        Assertions.assertEquals(15, IterationAnRecursion.tailRecur(5, 0));
        Assertions.assertEquals(55, IterationAnRecursion.tailRecur(10, 0));
        Assertions.assertEquals(1275, IterationAnRecursion.tailRecur(50, 0));
        Assertions.assertEquals(5050, IterationAnRecursion.tailRecur(100, 0));
    }
}
