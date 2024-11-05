package com.gst.leetcode;

public class Solution796 {

    public boolean rotateString(String s, String goal) {

        if (s.length() != goal.length()) {
            return false;
        }

        String doubleS = s + s;
        return doubleS.contains(goal);

    }

    public static void main(String[] args) {
        Solution796 solution796 = new Solution796();
        System.out.println(solution796.rotateString("abcde", "bcdea"));
        System.out.println(solution796.rotateString("abcde", "abced"));
    }
}
