package com.leetcode.easy;

import org.junit.jupiter.api.Test;

import java.util.function.ToIntFunction;

import static com.leetcode.easy.Q0104.TreeNode;
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

    private static TreeNode createTree(Integer[] testcase) {
        if (testcase.length == 0) return null;
        return createTree(testcase, 0);
    }

    private static TreeNode createTree(Integer[] testcase, int index) {
        final TreeNode node = new TreeNode(testcase[index]);
        final int leftIndex = (index * 2) + 1;
        final int rightIndex = leftIndex + 1;
        if (leftIndex < testcase.length && testcase[leftIndex] != null) {
            node.left = createTree(testcase, leftIndex);
        }
        if (rightIndex < testcase.length && testcase[rightIndex] != null) {
            node.right = createTree(testcase, leftIndex + 1);
        }
        return node;
    }

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
            final TreeNode root = createTree(TESTCASES[i]);
            final int actual = func.applyAsInt(root);
            assertEquals(EXPECTED[i], actual);
            System.out.println(actual);
        }
    }
}