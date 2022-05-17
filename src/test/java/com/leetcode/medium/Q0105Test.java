package com.leetcode.medium;

import com.leetcode.Nodes;
import com.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.function.BiFunction;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class Q0105Test {

    private static final int[][] TESTCASES = new int[][]{
            {3, 9, 20, 15, 7},
            {9, 3, 15, 20, 7},
            {-1},
            {-1},
            {1, 2, 3},
            {3, 2, 1},
            {1, 2},
            {1, 2},
    };

    private static final Integer[][] EXPECTED = new Integer[][]{
            {3, 9, 20, null, null, 15, 7},
            {-1},
            {1, 2, null, 3},
            {1, null, 2},
    };

    @Test
    void buildTree() {
        final Q0105 q = new Q0105();
        buildTree(q::buildTree);
    }

    @Test
    void buildTree1() {
        final Q0105 q = new Q0105();
        buildTree(q::buildTree1);
    }

    private void buildTree(BiFunction<int[], int[], TreeNode> func) {
        for (int i = 0; i < TESTCASES.length; i += 2) {
            final TreeNode actual = func.apply(TESTCASES[i], TESTCASES[i + 1]);
            System.out.println(Arrays.toString(Nodes.toArray(actual)));
            assertArrayEquals(EXPECTED[i / 2], Nodes.toArray(actual));
        }
    }
}