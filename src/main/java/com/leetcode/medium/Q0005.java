package com.leetcode.medium;

public class Q0005 {
    public String longestPalindrome(String s) {
        String max = s.substring(0, 1);
        final int n = s.length();
        for (int i = 1; i < n; i++) {
            for (int j = 0; i + j < n; j++) {
                if (isPalindrome(s, j, j + i)) {
                    if (max.length() < i + 1) {
                        max = s.substring(j, j + i + 1);
                    }
                }
            }
        }
        return max;
    }

    private boolean isPalindrome(String s, int start, int end) {
        if (start == end) return true;
        for (int i = start, j = end; i <= j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) return false;
        }
        return true;
    }

    public String longestPalindrome2(String s) {
        int start = 0;
        int maxLen = 1;
        final int n = s.length();
        final boolean[][] palindrome = new boolean[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                if (i == j) palindrome[i][j] = true;
                else if (s.charAt(i) == s.charAt(j)) {
                    if (j - i == 1 || (i + 1 < n && j > 0 && palindrome[i + 1][j - 1])) {
                        palindrome[i][j] = true;
                        if (maxLen < (j - i) + 1) {
                            start = i;
                            maxLen = (j - i) + 1;
                        }
                    }
                } else palindrome[i][j] = false;
            }
        }
        return s.substring(start, start + maxLen);
    }

    public String longestPalindrome3(String s) {
        final int n = s.length();
        int start = 0;
        int maxLen = 1;
        final boolean[][] palindrome = new boolean[n][n];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (i == j) palindrome[i][j] = true;
                else if (s.charAt(i) == s.charAt(j)) {
                    if (j - i == 1 || (i + 1 < n && palindrome[i + 1][j - 1])) {
                        palindrome[i][j] = true;
                        if (maxLen < (j - i) + 1) {
                            start = i;
                            maxLen = (j - i) + 1;
                        }
                    }
                } else palindrome[i][j] = false;
            }
        }
        return s.substring(start, start + maxLen);
    }
}
