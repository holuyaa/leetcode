package com.leetcode.medium;

import com.leetcode.TreeNode;

public class Q0114 {
    public void flatten(TreeNode root) {
        TreeNode cur = root;
        while (cur != null) {
            if (cur.left != null) {
                TreeNode last = cur.left;
                while (last.right != null) last = last.right;
                last.right = cur.right;
                cur.right = cur.left;
                cur.left = null;
            }
            cur = cur.right;
        }
    }
}
