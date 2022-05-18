package com.leetcode.medium;

import com.leetcode.Nodes;
import com.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.function.Consumer;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class Q0114Test {

    private static final Integer[][] TESTCASES = new Integer[][]{
            {1, 2, 5, 3, 4, null, 6},
            {},
            {0},
    };

    private static final Integer[][] EXPECTED = new Integer[][]{
            {1, null, 2, null, 3, null, 4, null, 5, null, 6},
            {},
            {0},
    };

    @Test
    void flatten() {
        final Q0114 q = new Q0114();
        flatten(q::flatten);
    }

    @Test
    void flatten1() {
        final Q0114 q = new Q0114();
        flatten(q::flatten1);
    }

    private void flatten(Consumer<TreeNode> func) {
        for (int i = 0; i < TESTCASES.length; i++) {
            final TreeNode node = Nodes.treeOf(TESTCASES[i]);
            func.accept(node);
            final Integer[] actual = toArray(node);
            assertArrayEquals(EXPECTED[i], actual);
        }
    }

    private Integer[] toArray(TreeNode root) {
        if (root == null) return new Integer[0];
        int count = 0;
        TreeNode curr = root;
        while (curr != null) {
            count += 2;
            curr = curr.right;
        }
        count--;

        final Integer[] result = new Integer[count];

        curr = root;
        for (int i = 0; i < count ; i += 2) {
            result[i] = curr.val;
            curr = curr.right;
        }
        return result;
    }
}