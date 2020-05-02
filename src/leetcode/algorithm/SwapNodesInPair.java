package leetcode.algorithm;

import org.w3c.dom.NodeList;

/**
 * Given a linked list, swap every two adjacent nodes and return its head.
 * <p>
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 * <p>
 * <p>
 * <p>
 * Example:
 * <p>
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 */
public class SwapNodesInPair {
    public ListNode swapPairs(ListNode head) {
        ListNode tempHead = head;
        while (tempHead != null && tempHead.next != null) {
            int data = tempHead.next.val;
            tempHead.next.val = tempHead.val;
            tempHead.val = data;
            tempHead = tempHead.next.next;
        }
        return head;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
