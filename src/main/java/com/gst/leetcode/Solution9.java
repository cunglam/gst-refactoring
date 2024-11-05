package com.gst.leetcode;

public class Solution9 {
    public boolean isPalindrome(int x) {
        // Negative numbers and numbers ending with 0 (except for 0 itself) are not palindromes
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int reversed = 0;
        while (x > reversed) {
            reversed = reversed * 10 + x % 10; // Append last digit of x to reversed
            x /= 10; // Remove last digit from x
        }

        // When the length is odd, we can get rid of the middle digit by reversed / 10
        return x == reversed || x == reversed / 10;
    }

    public static void main(String[] args) {
        Solution9 palindromeChecker = new Solution9();

        System.out.println(palindromeChecker.isPalindrome(121));   // Output: true
        System.out.println(palindromeChecker.isPalindrome(-121));  // Output: false
        System.out.println(palindromeChecker.isPalindrome(10));    // Output: false
        System.out.println(palindromeChecker.isPalindrome(12321)); // Output: true
    }
}
