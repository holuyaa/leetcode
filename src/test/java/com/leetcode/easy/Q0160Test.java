package com.leetcode.easy;

import com.leetcode.ListNode;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import java.util.function.BiFunction;

import static org.hamcrest.MatcherAssert.assertThat;

class Q0160Test {

    private static final int[] EXPECTED = new int[]{
            8,
            2,
            0,
    };

    private static final int[][] ARRAYS_A = new int[][]{
            {4, 1, 8, 4, 5},
            {1, 9, 1, 2, 4},
            {2, 6, 4},
    };

    private static final int[][] ARRAYS_B = new int[][]{
            {5, 6, 1, 8, 4, 5},
            {3, 2, 4},
            {1, 5},
    };

    private static final int[][] SKIPS = new int[][]{
            {2, 3},
            {3, 1},
            {3, 2},
    };

    @Test
    void getIntersectionNode() {
        final Q0160 q = new Q0160();
        getIntersectionNode(q::getIntersectionNode);
    }

    @Test
    void getIntersectionNode1() {
        final Q0160 q = new Q0160();
        getIntersectionNode(q::getIntersectionNode1);
    }

    @Test
    void getIntersectionNode2() {
        final Q0160 q = new Q0160();
        getIntersectionNode(q::getIntersectionNode2);
    }

    @Test
    void getIntersectionNode3() {
        final Q0160 q = new Q0160();
        getIntersectionNode(q::getIntersectionNode3);
    }

    private void getIntersectionNode(BiFunction<ListNode, ListNode, ListNode> func) {
        for (int i = 0; i < EXPECTED.length; i++) {
            final ListNode[] heads = createNodes(ARRAYS_A[i], ARRAYS_B[i], SKIPS[i][0], SKIPS[i][1]);
            final ListNode actual = func.apply(heads[0].next, heads[1].next);
            System.out.println(actual == null ? 0 : actual.val);
            assertThat(actual == null ? 0 : actual.val, Matchers.is(EXPECTED[i]));
        }
    }

    private ListNode[] createNodes(int[] arrayA, int[] arrayB, int skipA, int skipB) {
        final ListNode[] heads = new ListNode[]{
                new ListNode(),
                new ListNode(),
        };

        int count = 0;
        ListNode common = null;
        ListNode prev = heads[0];
        for (int num : arrayA) {
            final ListNode node = new ListNode(num);
            prev.next = node;
            prev = node;
            if (count++ == skipA) common = node;
        }

        count = 0;
        prev = heads[1];
        for (int num : arrayB) {
            if (count == skipB) {
                prev.next = common;
                break;
            }
            final ListNode node = new ListNode(num);
            prev.next = node;
            prev = node;
            count++;
        }

        return heads;
    }
}