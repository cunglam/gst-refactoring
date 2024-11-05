package com.gst.leetcode;

import java.util.HashMap;

public class Solution1 {

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if (hashMap.containsKey(complement)) {
                Integer newIntHashMap = hashMap.get(complement);
                return new int[]{newIntHashMap, i};
            }

            hashMap.put(nums[i], i);
        }
        throw new IllegalArgumentException("IllegalArgumentException");
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();

        int[] nums = {2, 7, 11, 15};
        int target = 17;

        int[] result = solution1.twoSum(nums, target);

        System.out.println("Kết quả: [" + result[0] + ", " + result[1] + "]");
    }
}
