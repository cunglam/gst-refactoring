package com.gst.leetcode;

public class Solution2 {

//    class ListNode {
//        int val;
//        ListNode next;
//        ListNode() {}
//        ListNode(int val) { this.val = val; }
//        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
//    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int val1 = (l1 != null) ? l1.val : 0;
            int val2 = (l2 != null) ? l2.val : 0;
            int sum = val1 + val2 + carry;
            carry = sum / 10;
            current.next = new ListNode(sum % 10);
            current = current.next;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        return dummy.next;

    }

    public static void main(String[] args) {
        // Tạo các node cho danh sách liên kết đầu vào l1: 2 -> 4 -> 3 (tương đương số 342)
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        // Tạo các node cho danh sách liên kết đầu vào l2: 5 -> 6 -> 4 (tương đương số 465)
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        // Tạo một instance của Solution để sử dụng hàm addTwoNumbers
        Solution2 solution = new Solution2();
        ListNode result = solution.addTwoNumbers(l1, l2);

        // In ra kết quả
        System.out.print("Kết quả: ");
        printList(result); // Hàm printList sẽ in danh sách kết quả
    }

    public static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val);
            node = node.next;
            if (node != null) System.out.print(" -> ");
        }
        System.out.println();
    }


}
