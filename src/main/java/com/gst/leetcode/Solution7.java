package com.gst.leetcode;

public class Solution7 {

    public int reverse(int x) {
        long reversed = 0; // Sử dụng long để xử lý tràn

        while (x != 0) {
            // Lấy chữ số cuối
            int digit = x % 10;
            reversed = reversed * 10 + digit;
            x /= 10; // Loại bỏ chữ số cuối khỏi x
        }

        // Kiểm tra tràn
        if (reversed < Integer.MIN_VALUE || reversed > Integer.MAX_VALUE) {
            return 0;
        }

        return (int) reversed; // Chuyển đổi lại về int trước khi trả về
    }

    public static void main(String[] args) {
        Solution7 ri = new Solution7();

        System.out.println(ri.reverse(123));          // Kết quả: 321
        System.out.println(ri.reverse(-123));         // Kết quả: -321
        System.out.println(ri.reverse(120));           // Kết quả: 21
        System.out.println(ri.reverse(0));             // Kết quả: 0
        System.out.println(ri.reverse(1534236469));   // Kết quả: 0 (tràn)
    }
}
