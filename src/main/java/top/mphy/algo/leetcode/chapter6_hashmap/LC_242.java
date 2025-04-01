package top.mphy.algo.leetcode.chapter6_hashmap;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * 242. 有效的字母异位词
 * https://leetcode.cn/problems/valid-anagram/description/
 *
 * @author MurphyChen
 * @since 2025/4/2 0:48
 */
public class LC_242 {
    class Solution {
        public boolean isAnagram(String s, String t) {
            if (s.length() != t.length()) {
                return false;
            }
            Map<String, Integer> map1 = new HashMap<>();
            Map<String, Integer> map2 = new HashMap<>();
            count(map1, s);
            count(map2, t);
            for (Map.Entry<String, Integer> e : map1.entrySet()) {
                String k = e.getKey();
                if (!map2.containsKey(k)) {
                    return false;
                }
                if (!Objects.equals(map2.get(k), map1.get(k))) {
                    return false;
                }
            }
            return true;
        }

        void count(Map<String, Integer> map, String str) {
            for (String s : str.split("")) {
                map.put(s, map.getOrDefault(s, 0) + 1);
            }
        }
    }
}
