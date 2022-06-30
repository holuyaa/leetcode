package com.leetcode.medium;

import com.leetcode.TreeNode;

import java.util.Stack;

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
public class Q0230 {

    private int pos = 0;
    private int result = 0;
    public int kthSmallest(TreeNode root, int k) {
        pos = 0;
        helper(root, k);
        return result;
    }

    private void helper(TreeNode root, int k) {
        if (root == null) return;
        helper(root.left, k);
        if (k == ++pos) result = root.val;
        helper(root.right, k);
    }

    public int kthSmallest1(TreeNode root , int k) {
        final Stack<TreeNode> stack = new Stack<>();

        TreeNode curr = root;
        while (true) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            if (--k == 0) return curr.val;
            curr = curr.right;
        }
    }
}
