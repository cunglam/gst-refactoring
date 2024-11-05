package com.gst.leetcode;

public class Solution4 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int m = nums1.length, n = nums2.length;
        int start = 0, end = m;
        while (start <= end) {
            int partitionA = (start + end) / 2;
            int partitionB = (m + n + 1) / 2 - partitionA;

            int maxLeftA = partitionA == 0 ? Integer.MIN_VALUE : nums1[partitionA - 1];
            int minRightA = partitionA == m ? Integer.MAX_VALUE : nums1[partitionA];

            int maxLeftB = partitionB == 0 ? Integer.MIN_VALUE : nums2[partitionB - 1];
            int minRightB = partitionB == n ? Integer.MAX_VALUE : nums2[partitionB];

            if (maxLeftA <= minRightB && maxLeftB <= minRightA) {
                if ((m + n) % 2 == 0) {
                    return (Math.max(maxLeftA, maxLeftB) + Math.min(minRightA, minRightB)) / 2.0;
                } else {
                    return Math.max(maxLeftA, maxLeftB);
                }
            } else if (maxLeftA > minRightB) {
                end = partitionA - 1;
            } else {
                start = partitionA + 1;
            }
        }
        throw new IllegalArgumentException();
    }

    public static void main(String[] args) {
        Solution4 medianFinder = new Solution4();

        // Test case 1
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        System.out.println("Median is: " + medianFinder.findMedianSortedArrays(nums1, nums2)); // Output: 2.0

        // Test case 2
        int[] nums3 = {1, 2};
        int[] nums4 = {3, 4};
        System.out.println("Median is: " + medianFinder.findMedianSortedArrays(nums3, nums4)); // Output: 2.5

        // Test case 3
        int[] nums5 = {0, 0};
        int[] nums6 = {0, 0};
        System.out.println("Median is: " + medianFinder.findMedianSortedArrays(nums5, nums6)); // Output: 0.0

        // Test case 4
        int[] nums7 = {};
        int[] nums8 = {1};
        System.out.println("Median is: " + medianFinder.findMedianSortedArrays(nums7, nums8)); // Output: 1.0

        // Test case 5
        int[] nums9 = {2};
        int[] nums10 = {};
        System.out.println("Median is: " + medianFinder.findMedianSortedArrays(nums9, nums10)); // Output: 2.0
    }
}
