package com.leetcode.easy;

import com.leetcode.ListNode;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class Q0141Test {

    private static final int[][] TESTCASES = new int[][]{
            {3, 2, 0, -4},
            {1, 2},
            {1},
    };

    private static final int[] POS = new int[]{
            1,
            0,
            -1,
    };

    private static final boolean[] EXPECTED = new boolean[]{
            true,
            true,
            false,
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
    void hasCycle() {
        final Q0141 q = new Q0141();
        for (int i = 0; i < TESTCASES.length; i++) {
            final ListNode head = listOf(TESTCASES[i], POS[i]);
            final boolean actual = q.hasCycle(head);
            System.out.println(actual);
            assertThat(actual, is(EXPECTED[i]));
        }
    }
}