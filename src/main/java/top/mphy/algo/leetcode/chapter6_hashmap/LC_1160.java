package top.mphy.algo.leetcode.chapter6_hashmap;

import java.util.Map;

/**
 * 1160. 拼写单词
 * https://leetcode.cn/problems/find-words-that-can-be-formed-by-characters/description/
 *
 * @author MurphyChen
 * @since 2025/4/5 0:18
 */
public class LC_1160 {
    class Solution {

        private static final char START = 'a';

        public int countCharacters(String[] words, String chars) {
            int res = 0;
            int[] arr = new int[26];
            chars.chars().forEach(c -> {
                arr[c - START]++;
            });
            for (String word : words) {
                int[] map = arr.clone();
                boolean flag = true;
                for (char w : word.toCharArray()) {
                    int index = w - START;
                    if (map[index] <= 0) {
                        flag = false;
                        break;
                    } else {
                        map[index]--;
                    }
                }
                if (flag) {
                    res += word.length();
                }
            }
            return res;
        }
    }
}
