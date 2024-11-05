package com.gst.leetcode;

public class Solution8 {

    public int myAtoi(String s) {
        int index = 0, sign = 1, total = 0;
        int n = s.length();

        // Bước 1: Bỏ qua khoảng trắng ở đầu
        while (index < n && s.charAt(index) == ' ') {
            index++;
        }

        // Bước 2: Kiểm tra dấu
        if (index < n) {
            char signChar = s.charAt(index);
            if (signChar == '-') {
                sign = -1;
                index++;
            } else if (signChar == '+') {
                index++;
            }
        }

        // Bước 3: Chuyển đổi các chữ số
        while (index < n) {
            char digitChar = s.charAt(index);
            if (digitChar < '0' || digitChar > '9') break; // Ngừng lại khi gặp ký tự không phải chữ số

            int digit = digitChar - '0';

            // Bước 4: Kiểm tra tràn
            if (total > (Integer.MAX_VALUE - digit) / 10) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            total = total * 10 + digit;
            index++;
        }

        return total * sign; // Áp dụng dấu và trả về kết quả
    }

    public static void main(String[] args) {
        Solution8 atoi = new Solution8();

        System.out.println(atoi.myAtoi("42"));                 // Kết quả: 42
        System.out.println(atoi.myAtoi("   -42"));             // Kết quả: -42
        System.out.println(atoi.myAtoi("4193 with words"));    // Kết quả: 4193
        System.out.println(atoi.myAtoi("words and 987"));      // Kết quả: 0
        System.out.println(atoi.myAtoi("-91283472332"));       // Kết quả: -2147483648
    }
}
