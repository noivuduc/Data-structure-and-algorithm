package leetcode.algorithm;

/**
 * Given a linked list, remove the n-th node from the end of list and return its head.
 *
 * Example:
 *
 * Given linked list: 1->2->3->4->5, and n = 2.
 *                                i
 *                          j
 *                          1->2
 *
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 * Note:
 *
 * Given n will always be valid.
 */
public class RemoveNthNodeFromLinkedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
//        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(4);
//        head.next.next.next.next = new ListNode(5);
        System.out.println(head);
        ListNode result = removeNthFromEnd(head, 1);
        System.out.println(result);
    }
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        /**
         * Solution is using 2 pointers technique, 1st point will increase 1 by 1,
         * 2nd point will run when the 1st pointer reach n.
         */
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        for (int i = 1; i<= n + 1; i++) {
            first = first.next;
        }
        while (first != null) {
            second = second.next;
            first = first.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }
}
