package com.leetcode.medium;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class Q0138Test {
    private static final Integer[][][] TESTCASES = new Integer[][][]{
            {{7, null}, {13, 0}, {11, 4}, {10, 2}, {1, 0}},
            {{1, 1}, {2, 1}},
            {{3, null}, {3, 0}, {3, null}},
    };

    @Test
    void copyRandomList() {
        final Q0138 q = new Q0138();
        copyRandomList(q::copyRandomList);
    }

    @Test
    void copyRandomList1() {
        final Q0138 q = new Q0138();
        copyRandomList(q::copyRandomList1);
    }

    private void copyRandomList(Function<Node, Node> func) {
        for (Integer[][] testcase : TESTCASES) {
            final Node expected = toNode(testcase);
            final Node actual = func.apply(expected);
            System.out.println(actual);
            assertThat(toArray(actual), is(testcase));
        }
    }

    private Node toNode(Integer[][] array) {
        final int size = array.length;
        final Node[] nodes = new Node[size];
        for (int i = 0; i < size; i++) nodes[i] = new Node(array[i][0]);
        for (int i = 0; i < size; i++) {
            nodes[i].next = i + 1 < size ? nodes[i + 1] : null;
            nodes[i].random = array[i][1] != null ? nodes[array[i][1]] : null;
        }
        return nodes[0];
    }

    private Integer[][] toArray(Node head) {
        int count = 0;
        for (Node next = head; next != null; next = next.next) count++;

        final Map<Node, Integer> map = new HashMap<>();
        int i = 0;
        for (Node node = head; node != null; node = node.next) map.put(node, i++);
        final Integer[][] result = new Integer[count][2];
        i = 0;
        for (Node node = head; node != null; node = node.next) {
            result[i][0] = node.val;
            result[i][1] = map.get(node.random);
            i++;
        }
        return result;
    }
}