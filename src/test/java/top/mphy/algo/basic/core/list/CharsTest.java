package top.mphy.algo.basic.core.list;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * CharsTest
 *
 * @author MurphyChen
 * @since 2025/4/4 19:59
 */
public class CharsTest {
    @Test
    void test() {
        String s = "abcsjdhkfkldf";
        String sorted = s.chars()
                .sorted()
                .mapToObj(c -> (char) c)
                .map(String::valueOf)
                .collect(Collectors.joining());
        System.out.println(sorted);
    }
}
