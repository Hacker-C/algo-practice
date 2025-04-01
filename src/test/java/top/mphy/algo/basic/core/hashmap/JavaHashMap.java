package top.mphy.algo.basic.core.hashmap;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JavaHashMap {
    @Test
    void test1() {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "one");
        for (HashMap.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
    }

    @Test
    void testTreeMap() {
        TreeMap<Integer, LocalDate> treeMap = new TreeMap<>();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        treeMap.put(4, LocalDate.parse("2024-01-04", format));
        treeMap.put(1, LocalDate.parse("2024-01-01", format));
        treeMap.put(3, LocalDate.parse("2024-01-03", format));
        for (Map.Entry<Integer, LocalDate> entry: treeMap.entrySet()) {
            System.out.println(entry);
        }

        TreeMap<LocalDate, Integer> treeMap2 = new TreeMap<>();
        treeMap2.put(LocalDate.parse("2024-01-04", format), 4);
        treeMap2.put(LocalDate.parse("2024-01-01", format), 1);
        treeMap2.put(LocalDate.parse("2024-01-03", format), 3);
        for (Map.Entry<LocalDate, Integer> entry : treeMap2.entrySet()) {
            System.out.println(entry);
        }

    }

    @Test
    void testHashSet() {
        Set<String> s1 = new TreeSet<>();
        s1.add("8");
        s1.add("1");
        s1.add("4");
        Set<String> s2 = new HashSet<>();
        s2.add("1");
        s2.add("4");
        s2.add("8");
        assertEquals(s1, s2);
        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());

        s2.clear();
    }
}
