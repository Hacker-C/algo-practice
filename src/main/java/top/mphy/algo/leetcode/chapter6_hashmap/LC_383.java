package top.mphy.algo.leetcode.chapter6_hashmap;

import java.util.Map;

/**
 * 383. 赎金信
 * https://leetcode.cn/problems/ransom-note/description/
 *
 * @author MurphyChen
 * @since 2025/4/4 23:29
 */
public class LC_383 {
    class Solution {

        private static final char A = 'a';

        public boolean canConstruct(String ransomNote, String magazine) {
            int[] arr = new int[26];
            for (char c : ransomNote.toCharArray()) {
                arr[c - A]++;
            }
            for (char c : magazine.toCharArray()) {
                arr[c - A]--;
            }
            for (int n : arr) {
                if (n > 0) {
                    return false;
                }
            }
            return true;
        }
    }
}
