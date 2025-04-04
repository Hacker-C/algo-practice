package top.mphy.algo.leetcode.chapter6_hashmap;

import java.util.*;
import java.util.stream.Collectors;

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

    class Solution2 {
        public boolean isAnagram(String s, String t) {
            if (s.length() != t.length()) {
                return false;
            }
            Map<Character, Integer> map = new HashMap<>();
            for (char c : s.toCharArray()) {
                if (map.containsKey(c)) {
                    map.put(c, map.get(c) + 1);
                } else {
                    map.put(c, 1);
                }
            }
            for (char c : t.toCharArray()) {
                if (!map.containsKey(c) || map.get(c) <= 0) {
                    return false;
                }
                map.put(c, map.get(c) - 1);
            }
            for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                if (entry.getValue() != 0) {
                    return false;
                }
            }
            return true;
        }
    }

    class Solution3 {
        public boolean isAnagram(String s, String t) {
            if (s.length() != t.length()) {
                return false;
            }
            String sortedS = getSorted(s);
            String sortedT = getSorted(t);
            return sortedS.equals(sortedT);
        }

        private String getSorted(String s) {
            return s.chars()
                    .sorted()
                    .mapToObj(e -> (char) e)
                    .map(String::valueOf)
                    .collect(Collectors.joining());
        }
    }

    private static final char A = 'a';

    class Solution4 {
        public boolean isAnagram(String s, String t) {
            int[] arr = new int[26];
            for (char c : s.toCharArray()) {
                arr[c - A]++;
            }
            for (char c : t.toCharArray()) {
                arr[c - A]--;
            }
            for (int n : arr) {
                if (n != 0) {
                    return false;
                }
            }
            return true;
        }
    }
}
