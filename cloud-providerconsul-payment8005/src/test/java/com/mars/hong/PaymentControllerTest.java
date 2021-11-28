package com.mars.hong;

import org.junit.Test;

public class PaymentControllerTest {

    private static class ListNode {
        private int value;
        private ListNode next;

        public ListNode(int value, ListNode next) {
            this.value = value;
            this.next = next;
        }

        public ListNode(int value) {
            this.value = value;
        }

        public int getValue() {
            return this.value;
        }

        public ListNode next() {
            return next;
        }

        public void print() {
            System.out.print(this.value + " ");
            if (this.next != null) {
                this.next.print();
            }
        }
    }

    @Test
    public void reverse_linked_list() {
        ListNode head = new ListNode(0, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4)))));
        Solution s = new Solution();
        s.left = head;

        s.reverse(head, 1, 5);

        head.print();
        System.out.println(head);
    }

    private static class Solution {
        ListNode left;
        void reverse(ListNode right, int start, int end) {
            if (end == 1) {
                return;
            }

            ListNode nextRight = right.next;
            if (start > 1) {
                left = left.next;
            }

            reverse(nextRight, start - 1 , end - 1);
            // terminate
            if (nextRight == left || nextRight.next == left) {
                return;
            }
            // swap
            int temp = nextRight.value;
            nextRight.value = left.value;
            left.value = temp;

            left = left.next;
        }

    }
}