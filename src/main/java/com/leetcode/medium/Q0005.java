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

    public String longestPalindrome4(String s) {
        if (s.length() < 2)
            return s;

        String max = s.substring(0, 1);
        for (int i = 0; i < s.length() - 1; i++) {
            String tmp = expand4(s, i, i);
            if (max.length() < tmp.length()) max = tmp;
            tmp = expand4(s, i, i + 1);
            if (max.length() < tmp.length()) max = tmp;
        }
        return max;
    }

    private String expand4(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return s.substring(left + 1, right);
    }

    public String longestPalindrome5(String s) {
        if (s.length() < 2)
            return s;

        int start = 0, maxLen = 0;

        for (int i = 0; i < s.length() - 1; i++) {
            final int len = Math.max(expand5(s, i, i), expand5(s, i, i + 1));
            if (maxLen < len) {
                maxLen = len;
                start = i - ((len - 1) >> 1);
            }
        }
        return s.substring(start, start + maxLen);
    }

    private int expand5(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        return right - left - 1;
    }

    public String longestPalindrome6(String s) {
        final int len = s.length();
        if (len < 2) return s;

        int start = 0;
        int maxLen = 1;
        int left, right;
        for (int i = 0; i < len && len - i > maxLen / 2; ) {
            left = right = i;
            while (right < len - 1 && s.charAt(right) == s.charAt(right + 1)) {
                right++;
            }
            i = right + 1;  // can save time dramatically
            while (left > 0 && right < len - 1 && s.charAt(left - 1) == s.charAt(right + 1)) {
                left--;
                right++;
            }

            if (maxLen < right - left + 1) {
                maxLen = right - left + 1;
                start = left;
            }
        }
        return s.substring(start, start + maxLen);
    }
}
