package top.mphy.algo.basic.core.hashmap;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

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
}
