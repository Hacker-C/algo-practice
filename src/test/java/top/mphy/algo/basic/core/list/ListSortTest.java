package top.mphy.algo.basic.core.list;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class ListSortTest {
    /**
     * 原地排序
     */
    @Test
    void inPlaceSort() {
        // array 默认排序从小到大
        int[] arr = {3,1,2};
        Arrays.sort(arr);
        Assertions.assertArrayEquals(new int[] {1,2,3}, arr);

        // Array 默认排序从小到大
        Integer[] Array = {3, 1, 2};
        Arrays.sort(Array);
        Assertions.assertArrayEquals(new Integer[] {1,2,3}, Array);

        // Array 自定义排序：从大到小排序
        Arrays.sort(Array, (x, y) -> y - x);
        Assertions.assertArrayEquals(new Integer[] {3,2,1}, Array);

        // Array 自定义排序：从大到小排序
        Arrays.sort(Array, Collections.reverseOrder());

        // List 默认排序
        List<Integer> list = new ArrayList<>(Arrays.asList(3, 1, 2));
        Collections.sort(list);
        int[] sortedArray = list.stream().mapToInt(Integer::intValue).toArray();
        Assertions.assertArrayEquals(new int[]{1,2,3}, sortedArray);

        // List 自定义排序：从大到小排序
        list.sort((x, y) -> y - x);
        int[] sortedArray3 = list.stream().mapToInt(Integer::intValue).toArray();
        Assertions.assertArrayEquals(new int[]{3,2,1}, sortedArray3);

        // List 自定义排序：从大到小排序
        List<Integer> list2 = new ArrayList<>(Arrays.asList(3, 1, 2));
        Collections.sort(list2, (x, y) -> y - x);
        int[] sortedArray2 = list2.stream().mapToInt(Integer::intValue).toArray();
        Assertions.assertArrayEquals(new int[]{3,2,1}, sortedArray2);
    }

    /**
     * 非原地排序
     */
    @Test
    void outOfSort() {
        Integer[] list = {3, 1, 2};
        Assertions.assertArrayEquals(
                new Integer[] {1,2,3},
                Arrays.stream(list).sorted().toArray()
        );

        Assertions.assertArrayEquals(
                new Integer[] {1,2,3},
                Stream.of(list).sorted((x, y) -> y - x).toArray()
        );
    }
}
