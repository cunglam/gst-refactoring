package com.gst.leetcode;

public class Solution10 {

    public boolean isMatch(String s, String p) {
        int sLen = s.length();
        int pLen = p.length();

        // Create a DP table
        boolean[][] dp = new boolean[sLen + 1][pLen + 1];
        dp[0][0] = true; // Both string and pattern are empty

        // Handle patterns like a*, a*b*, a*b*c* (zero occurrences)
        for (int j = 1; j <= pLen; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }

        // Fill the DP table
        for (int i = 1; i <= sLen; i++) {
            for (int j = 1; j <= pLen; j++) {
                char currentChar = p.charAt(j - 1);

                if (currentChar == s.charAt(i - 1) || currentChar == '.') {
                    dp[i][j] = dp[i - 1][j - 1]; // Match single character or '.'
                } else if (currentChar == '*') {
                    dp[i][j] = dp[i][j - 2] ||
                            (dp[i - 1][j] && (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.'));
                }
            }
        }

        return dp[sLen][pLen];
    }

    public static void main(String[] args) {
        Solution10 regexMatcher = new Solution10();

        System.out.println(regexMatcher.isMatch("aa", "a"));        // Output: false
        System.out.println(regexMatcher.isMatch("aa", "a*"));      // Output: true
        System.out.println(regexMatcher.isMatch("ab", ".*"));      // Output: true
        System.out.println(regexMatcher.isMatch("aab", "c*a*b"));  // Output: true
        System.out.println(regexMatcher.isMatch("mississippi", "mis*is*p*.")); // Output: false
    }
}
