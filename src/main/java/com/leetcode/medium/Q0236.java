package com.leetcode.medium;

import com.leetcode.TreeNode;

import java.util.*;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
public class Q0236 {
    private TreeNode result;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        helper(root, p, q);
        return result;
    }

    private boolean helper(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null) return false;
        final int left = helper(node.left, p, q) ? 1 : 0;
        final int right = helper(node.right, p, q) ? 1 : 0;
        final int mid = (node == p || node == q) ? 1 : 0;
        if (left + right + mid >= 2) {
            result = node;
            return true;
        }
        return (left + right + mid) > 0;
    }

    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        final Map<TreeNode, TreeNode> parent = new HashMap<>();
        final Deque<TreeNode> stack = new ArrayDeque<>();

        parent.put(root, null);
        stack.push(root);

        while (!parent.containsKey(p) || !parent.containsKey(q)) {
            final TreeNode node = stack.pop();
            if (node.left != null) {
                parent.put(node.left, node);
                stack.push(node.left);
            }
            if (node.right != null) {
                parent.put(node.right, node);
                stack.push(node.right);
            }
        }

        final Set<TreeNode> ancestors = new HashSet<>();
        while (p != null) {
            ancestors.add(p);
            p = parent.get(p);
        }

        while (!ancestors.contains(q)) q = parent.get(q);

        return q;
    }

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        final TreeNode left = lowestCommonAncestor2(root.left, p, q);
        final TreeNode right = lowestCommonAncestor2(root.right, p, q);
        if (left == null) return right;
        else if (right == null) return left;
        return root;
    }

    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode p, TreeNode q) {
        final Map<TreeNode, TreeNode> parent = new HashMap<>();
        final Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                if (curr.left != null) parent.put(curr.left, curr);
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            if (curr.right != null) parent.put(curr.right, curr);
            curr = curr.right;
        }

        final Set<TreeNode> ancestors = new HashSet<>();
        while (p != null) {
            ancestors.add(p);
            p = parent.get(p);
        }

        while (!ancestors.contains(q)) q = parent.get(q);

        return q;
    }
}
