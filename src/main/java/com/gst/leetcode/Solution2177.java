package com.gst.leetcode;

import java.util.Arrays;

public class Solution2177 {

    // F possible
    //    3x + 3 = num => x = (num-3)/3
    public long[] findThreeConsecutiveIntegers(long num) {
        // Calculate x

        if ((num - 3) % 3 != 0) {
            return new long[0];
        }
        long x = (num - 3) / 3;
        return new long[]{x, x + 1, x + 2};
    }

    public static void main(String[] args) {

        Solution2177 solution2177 = new Solution2177();
        long[] result33 = solution2177.findThreeConsecutiveIntegers(33);
        System.out.println("result33: " + Arrays.toString(result33));
        long[] result4 = solution2177.findThreeConsecutiveIntegers(4);
        System.out.println("result4: " + Arrays.toString(result4));
    }

}
