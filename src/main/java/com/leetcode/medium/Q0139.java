package com.leetcode.medium;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Q0139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        final Set<String> set = new HashSet<>(wordDict);
        final boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        for (int end = 1; end <= s.length(); end++) {
            for (int start = 0; start < end; start++) {
                if (dp[start] && set.contains(s.substring(start, end))) {
                    dp[end] = true;
                    break;
                }
            }
        }

        return dp[s.length()];
    }
}
