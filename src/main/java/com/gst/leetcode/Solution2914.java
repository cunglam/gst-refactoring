package com.gst.leetcode;

public class Solution2914 {

    public static int minChanges(String s) {
        int changes = 0;
        for (int i = 0; i + 1 < s.length(); i+=2) {
            if (s.charAt(i)!= s.charAt(i+1)) {
                changes++;
            }
        }
        return changes;
    }


    public static void main(String[] args) {
        String s = "1001010";
        System.out.println("Số thay đổi tối thiểu cần thiết: " + minChanges(s));
    }
}
