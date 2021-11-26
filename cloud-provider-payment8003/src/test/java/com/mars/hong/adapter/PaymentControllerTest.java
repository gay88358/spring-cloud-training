package com.mars.hong.adapter;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class PaymentControllerTest {
    // refactor declarative
    private ListNode createNodes() {
        return new ListNode(
                1,
                new ListNode(
                        2,
                        new ListNode(
                                3,
                                new ListNode(
                                        4,
                                        new ListNode(5)
                                )
                        )
                )
        );
    }

    @Test
    public void findNodeByValue() {
        ListNode head = createNodes();

        Solution s = new Solution();
        ListNode result = s.findNode(head, 4);
        assertEquals(4, result.val);
        assertEquals(5, result.next.val);
    }
    //  1 2 3 4 5
    @Test
    public void disconnectNodeBeforeLeft() {
        ListNode head = createNodes();

        Solution s = new Solution();
        ListNode firstHead = s.disconnectNodeBeforeLeft(head, 3);

        assertEquals(1, firstHead.val);
        assertEquals(2, firstHead.next.val);
        assertNull(firstHead.next.next);
    }
    // 1 2 3 4 5
    @Test
    public void disconnectNodeAfterRight() {
        ListNode head = createNodes();

        Solution s = new Solution();
        ListNode lastHead = s.disconnectNodeAfterRight(head, 3);

        assertEquals(4, lastHead.val);
        assertEquals(5, lastHead.next.val);
        assertNull(lastHead.next.next);
    }

    // 1 2 3 4 5
    @Test
    public void reverseNodes() {
        ListNode head = createNodes();

        Solution s = new Solution();
        ListNode result = s.reverse(head);

        assertEquals(5, result.val);
        assertEquals(4, result.next.val);
        assertEquals(3, result.next.next.val);
        assertEquals(2, result.next.next.next.val);
        assertEquals(1, result.next.next.next.next.val);
        assertNull(result.next.next.next.next.next);
    }

    @Test
    public void findNode() {
        // 1 2 3 4 5
        ListNode head = createNodes();
        Solution s = new Solution();

        assertEquals(1, s.findNode(head, 1).val);
        assertEquals(3, s.findNode(head, 3).val);
        assertEquals(5, s.findNode(head, 5).val);
    }
    @Test
    public void lastNode() {
        Solution s = new Solution();

        assertEquals(1, s.lastNode(new ListNode(1)).val);
        assertEquals(2, s.lastNode(new ListNode(1, new ListNode(2))).val);
        assertEquals(4, s.lastNode(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))))).val);
    }

    @Test
    public void reverseBetweenWholeRange() {
        ListNode head = createNodes();

        Solution s = new Solution();
        ListNode result = s.reverseBetween(head, 1, 5);

        assertEquals(5, result.val);
        assertEquals(4, result.next.val);
        assertEquals(3, result.next.next.val);
        assertEquals(2, result.next.next.next.val);
        assertEquals(1, result.next.next.next.next.val);
    }

    // 1 2 3 4 5
    @Test
    public void reverseBetweenWithinRange() {
        ListNode head = createNodes();

        Solution s = new Solution();
        ListNode result = s.reverseBetween(head, 2, 4);

        assertEquals(1, result.val);
        assertEquals(4, result.next.val);
        assertEquals(3, result.next.next.val);
        assertEquals(2, result.next.next.next.val);
        assertEquals(5, result.next.next.next.next.val);
    }

    // 1 2 3 4 5
    @Test
    public void reverseBetweenLeftRange() {
        ListNode head = createNodes();

        Solution s = new Solution();
        ListNode result = s.reverseBetween(head, 1, 3);

        assertEquals(3, result.val);
        assertEquals(2, result.next.val);
        assertEquals(1, result.next.next.val);
        assertEquals(4, result.next.next.next.val);
        assertEquals(5, result.next.next.next.next.val);
    }

    // 1 2 3 4 5
    @Test
    public void reverseBetweenRightRange() {
        ListNode head = createNodes();

        Solution s = new Solution();
        ListNode result = s.reverseBetween(head, 3, 5);

        assertEquals(1, result.val);
        assertEquals(2, result.next.val);
        assertEquals(5, result.next.next.val);
        assertEquals(4, result.next.next.next.val);
        assertEquals(3, result.next.next.next.next.val);
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    class Solution {
        // robust implementation
        private ListNode lastNode(ListNode head) {
            if (head.next == null) { // one node
                return head;
            }
            ListNode current = head;
            ListNode previous = null;
            while (current != null) {
                previous = current;
                current = current.next;
            }
            return previous;
        }
        // find better implementation
        public ListNode reverseBetween(ListNode head, int leftPosition, int rightPosition) {
            boolean wantToReverse = leftPosition != rightPosition;
            if (isSingleNode(head) || !wantToReverse) {
                return head;
            }

            ListNode leftNode = findNode(head, leftPosition);
            ListNode firstNode = disconnectNodeBeforeLeft(head, leftPosition);
            ListNode lastNode = disconnectNodeAfterRight(leftNode, rightPosition - leftPosition + 1);
            leftNode = reverse(leftNode);
            if (firstNode == null) {
                lastNode(leftNode).next = lastNode;
                return leftNode;
            } else {
                lastNode(firstNode).next = leftNode;
                lastNode(leftNode).next = lastNode;
            }
            return firstNode;
        }

        private boolean isSingleNode(ListNode head) {
            return head.next == null;
        }

        private ListNode findNode(ListNode head, int leftPosition) {
            ListNode current = head;
            int count = 1;
            while (current != null) {
                if (count++ == leftPosition) {
                    return current;
                }
                current = current.next;
            }
            throw new RuntimeException("Given value is not found !!!");
        }

        private ListNode disconnectNodeBeforeLeft(ListNode head, int leftPosition) {
            ListNode current = head;
            ListNode previous = null;
            int count = 1;
            while (current != null) {
                if (count++ == leftPosition) {
                    break;
                }
                previous = current;
                current = current.next;
            }
            if (previous == null) { // disconnect first node
                return null;
            }

            previous.next = null;
            return head;
        }

        private ListNode disconnectNodeAfterRight(ListNode head, int rightPosition) {
            ListNode current = head;
            int count = 1;
            while (current != null) {
                if (count++ == rightPosition) {
                    break;
                }
                current = current.next;
            }
            if (current == null) {
                throw new RuntimeException();
            }
            ListNode result = current.next;
            current.next = null;
            return result;
        }

        public ListNode reverse(ListNode listNode) {
            ListNode current = listNode;
            ListNode previous = null;
            while (current != null) {
                ListNode temp = current.next;
                current.next = previous;
                previous = current;
                current = temp;
            }
            return previous;
        }
    }
}