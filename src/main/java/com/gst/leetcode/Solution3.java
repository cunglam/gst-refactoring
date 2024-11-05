package com.gst.leetcode;

import java.util.HashSet;
import java.util.Set;

public class Solution3 {

    public int lengthOfLongestSubstring(String s) {

        if (s == null || s.isEmpty()) {
            return 0;
        }

        int start = 0, end = 0, maxLength = 0;
        Set<Character> uniqueCharacters = new HashSet<>();

        while (end < s.length()) {
            if (uniqueCharacters.add(s.charAt(end))) {
                maxLength = Math.max(maxLength, uniqueCharacters.size());
                end++;
            } else {
                uniqueCharacters.remove(s.charAt(start));
                start++;
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        Solution3 solution = new Solution3();
        String testString = "abcdabcbb";
        System.out.println("Length of longest substring: " + solution.lengthOfLongestSubstring(testString));
    }
}
