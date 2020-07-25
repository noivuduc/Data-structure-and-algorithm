package leetcode.algorithm;

import java.util.HashMap;

public class CopyListwithRandomPointer {
    public static void main(String[] args) {
        CopyListwithRandomPointer cp = new CopyListwithRandomPointer();
        Node node = new Node(7);
        node.next = new Node(13);
        node.next.next = new Node(11);
        node.next.next.next = new Node(10);
        node.next.next.next.next = new Node(1);
        node.next.random = node;
        node.next.next.random = node.next.next.next.next;
        node.next.next.next.random = node.next.next;
        node.next.next.next.next.random = node;

        CopyListwithRandomPointer copyListwithRandomPointer = new CopyListwithRandomPointer();
        System.out.print(copyListwithRandomPointer.solution(node));
    }
    public Node solution(Node head) {
        HashMap<Node, Node> map = new HashMap<>();
        Node current = head;
        while(current != null) {
            map.put(current, new Node(current.val));
            current = current.next;
        }
        current = head;
        while (current != null) {
            map.get(current).random = map.get(current.random);
            map.get(current).next = map.get(current.next);
            current = current.next;
        }
        return map.get(head);
    }
    // 7 -> 13 -> 11->10 -> 1
}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
