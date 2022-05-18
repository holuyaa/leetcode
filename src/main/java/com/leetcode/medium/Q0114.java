package com.leetcode.medium;

import com.leetcode.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class Q0114 {

    private TreeNode prev;
    public void flatten(TreeNode root) {
        prev = null;
        helper(root);
    }

    private void helper(TreeNode node) {
        if (node == null) return;
        if (prev != null) {
            prev.left = null;
            prev.right = node;
        }
        prev = node;
        final TreeNode right = node.right;
        helper(node.left);
        helper(right);
    }

    public void flatten1(TreeNode root) {
        prev = null;
        helper1(root);
    }

    private void helper1(TreeNode node) {
        if (node == null) return;
        helper1(node.right);
        helper1(node.left);
        node.right = prev;
        node.left = null;
        prev = node;
    }

    public void flatten2(TreeNode root) {
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
