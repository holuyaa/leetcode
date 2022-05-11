package com.leetcode.easy;

import com.leetcode.Nodes;
import com.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.function.ToIntFunction;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Q0104Test {

    private static final Integer[][] TESTCASES = new Integer[][]{
            {3, 9, 20, null, null, 15, 7},
            {1, null, 2},
            {}
    };

    private static final int[] EXPECTED = new int[]{
            3, 2, 0
    };

    @Test
    void maxDepth() {
        final Q0104 q = new Q0104();
        maxDepth(q::maxDepth);
    }

    @Test
    void maxDepthBFS() {
        final Q0104 q = new Q0104();
        maxDepth(q::maxDepthBFS);
    }

    private void maxDepth(ToIntFunction<TreeNode> func) {
        for (int i = 0; i < TESTCASES.length; i++) {
            final TreeNode root = Nodes.treeOf(TESTCASES[i]);
            final int actual = func.applyAsInt(root);
            assertEquals(EXPECTED[i], actual);
            System.out.println(actual);
        }
    }
}