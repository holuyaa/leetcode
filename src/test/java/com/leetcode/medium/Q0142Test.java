package com.leetcode.medium;

import com.leetcode.ListNode;
import org.junit.jupiter.api.Test;

import java.util.function.Function;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class Q0142Test {

    private static final int[][] TESTCASES = new int[][]{
            {-1, -7, 7, -4, 19, 6, -9, -5, -2, -5},
            {3, 2, 0, -4},
            {1, 2},
            {1},
            {},
    };

    private static final int[] POS = new int[]{
            6,
            1,
            0,
            -1,
            -1,
    };

    private static final Integer[] EXPECTED = new Integer[]{
            -9,
            2,
            1,
            null,
            null,
    };

    private static ListNode listOf(int[] array, int pos) {
        if (array == null || array.length == 0) return null;
        final ListNode root = new ListNode(array[0]);
        ListNode next = root;
        ListNode posNode = pos == 0 ? root : null;
        for (int i = 1; i < array.length; i++) {
            next.next = new ListNode(array[i]);
            if (i == pos) posNode = next.next;
            next = next.next;
        }
        next.next = posNode;
        return root;
    }

    @Test
    void detectCycle() {
        final Q0142 q = new Q0142();
        detectCycle(q::detectCycle);
    }

    @Test
    void detectCycle1() {
        final Q0142 q = new Q0142();
        detectCycle(q::detectCycle1);
    }

    void detectCycle(Function<ListNode, ListNode> func) {
        for (int i = 0; i < TESTCASES.length; i++) {
            final ListNode head = listOf(TESTCASES[i], POS[i]);
            final ListNode actual = func.apply(head);
            System.out.println(actual == null ? null : actual.val);
            assertThat(actual == null ? null : actual.val, is(EXPECTED[i]));
        }
    }
}