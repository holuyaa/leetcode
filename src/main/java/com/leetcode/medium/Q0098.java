package com.leetcode.medium;

import com.leetcode.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
public class Q0098 {

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode node, long min, long max) {
        if (node == null) return true;
        if (max <= node.val || node.val <= min) return false;
        return isValidBST(node.left, min, node.val) && isValidBST(node.right, node.val, max);
    }

    public boolean isValidBST1(TreeNode root) {
        final TreeNode[] prev = new TreeNode[1];
        return isValidBST1(root, prev);
    }

    private boolean isValidBST1(TreeNode node, TreeNode[] prev) {
        if (node == null) return true;
        if (!isValidBST1(node.left, prev)) return false;
        if (prev[0] != null && node.val <= prev[0].val) return false;
        prev[0] = node;
        return isValidBST1(node.right, prev);
    }

    public boolean isValidBST2(TreeNode root) {
        final Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode curr = root;
        TreeNode prev = null;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            if (prev != null && curr.val <= prev.val) return false;
            prev = curr;
            curr = curr.right;
        }
        return true;
    }
}
