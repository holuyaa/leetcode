package com.leetcode.medium;

import com.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

class Q0236Test {

    private static final Integer[][] TESTCASES = new Integer[][]{
            {3, 5, 1, 6, 2, 0, 8, null, null, 7, 4},
            {3, 5, 1, 6, 2, 0, 8, null, null, 7, 4},
            {1, 2},
    };

    private static final int[] P = new int[]{
            5,
            5,
            1,
    };

    private static final int[] Q = new int[]{
            1,
            4,
            2,
    };

    private static final int[] EXPECTED = new int[]{
            3,
            5,
            1,
    };

    private static TreeNode treeOf(Integer[] array, Map<Integer, TreeNode> map) {
        if (array == null || array.length == 0) return null;
        return createTree(array, map, 0);
    }

    private static TreeNode createTree(Integer[] array, Map<Integer, TreeNode> map, int index) {
        if (array.length <= index || array[index] == null) return null;
        final TreeNode node = new TreeNode(array[index]);
        map.put(array[index], node);
        final int leftIndex = (index * 2) + 1;
        final int rightIndex = leftIndex + 1;
        node.left = createTree(array, map, leftIndex);
        node.right = createTree(array, map, rightIndex);
        return node;
    }

    @Test
    void lowestCommonAncestor() {
        final Q0236 q = new Q0236();
        for (int i = 0; i < TESTCASES.length; i++) {
            final Map<Integer, TreeNode> map = new HashMap<>();
            final TreeNode actual = q.lowestCommonAncestor(treeOf(TESTCASES[i], map), map.get(P[i]), map.get(Q[i]));
            assertThat(actual, notNullValue());
            System.out.println("" + actual.val);
            assertThat(actual.val, is(EXPECTED[i]));
        }
    }
}