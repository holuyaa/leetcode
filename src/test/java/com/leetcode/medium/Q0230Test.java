package com.leetcode.medium;

import com.leetcode.Nodes;
import com.leetcode.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.function.ToIntBiFunction;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class Q0230Test {

    private static final Integer[][] TESTCASES = new Integer[][]{
            {3, 1, 4, null, 2},
            {5, 3, 6, 2, 4, null, null, 1}
    };

    private static final int[] K = new int[]{
            1,
            3,
    };

    private static final int[] EXPECTED = new int[]{
            1,
            3,
    };

    @Test
    void kthSmallest() {
        final Q0230 q = new Q0230();
        kthSmallest(q::kthSmallest);
    }

    @Test
    void kthSmallest1() {
        final Q0230 q = new Q0230();
        kthSmallest(q::kthSmallest1);
    }

    private void kthSmallest(ToIntBiFunction<TreeNode, Integer> func) {
        for (int i = 0; i < TESTCASES.length; i++) {
            final int actual = func.applyAsInt(Nodes.treeOf(TESTCASES[i]), K[i]);
            System.out.println(actual);
            assertThat(actual, is(EXPECTED[i]));
        }
    }
}