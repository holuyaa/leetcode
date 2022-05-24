package com.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

// Definition for a Node.
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

public class Q0138 {
    public Node copyRandomList(Node head) {
        final Map<Node, Node> map = new HashMap<>();

        Node prev = null;
        Node result = null;
        for (Node node = head; node != null; node = node.next) {
            final Node curr = new Node(node.val);
            if (prev != null) prev.next = curr;
            else result = curr;
            prev = curr;
            map.put(node, curr);
        }

        for (Node n1 = head, n2 = result; n1 != null; n1 = n1.next, n2 = n2.next) {
            if (n1.random != null) {
                n2.random = map.get(n1.random);
            }
        }
        return result;
    }
}
