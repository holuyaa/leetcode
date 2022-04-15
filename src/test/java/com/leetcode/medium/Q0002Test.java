package com.leetcode.medium;

import com.leetcode.ListNode;
import com.leetcode.Nodes;
import org.junit.jupiter.api.Test;

import java.util.function.BiFunction;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Q0002Test {

    private static final int[][] TESTCASES = new int[][]{
            {2, 4, 3},
            {5, 6, 4},
            {0},
            {0},
            {9, 9, 9, 9, 9, 9, 9},
            {9, 9, 9, 9},
            {9},
            {1, 9, 9, 9, 9, 9, 9, 9, 9, 9},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
            {5, 6, 4}
    };

    private static final String[] EXPECTED = new String[]{
            "[7,0,8]",
            "[0]",
            "[8,9,9,9,0,0,0,1]",
            "[0,0,0,0,0,0,0,0,0,0,1]",
            "[6,6,4,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1]"
    };

    @Test
    void addTwoNumbers() {
        final Q0002 q = new Q0002();
        addTwoNumbers(q::addTwoNumbers);
    }

    @Test
    void addTwoNumbers2() {
        final Q0002 q = new Q0002();
        addTwoNumbers(q::addTwoNumbers2);
    }

    private void addTwoNumbers(BiFunction<ListNode, ListNode, ListNode> func) {
        final ListNode[] nodes = createListNode();
        for (int i = 0; i < nodes.length; i += 2) {
            final ListNode l1 = nodes[i];
            final ListNode l2 = nodes[i + 1];
            final String actual = func.apply(l1, l2).toString();
            assertEquals(EXPECTED[i / 2], actual);
            System.out.println(actual);
        }
    }

    private ListNode[] createListNode() {
        final ListNode[] result = new ListNode[TESTCASES.length];
        for (int i = 0; i < TESTCASES.length; i++) {
            result[i] = Nodes.listOf(TESTCASES[i]);
        }
        return result;
    }

}