package com.leetcode.medium;

import java.util.*;

public class Q0128 {

    public int longestConsecutive(int[] numbers) {
        if (numbers.length == 0) return 0;

        Arrays.sort(numbers);

        int max = 1;
        int curr = 1;
        for (int i = 1; i < numbers.length; i++) {
            final int prev = numbers[i - 1];
            if (prev == numbers[i]) continue;
            if (prev + 1 == numbers[i]) curr++;
            else {
                max = Math.max(max, curr);
                curr = 1;
            }
        }
        return Math.max(max, curr);
    }

    public int longestConsecutive1(int[] numbers) {
        if (numbers.length == 0) return 0;
        int max = 0;
        final Map<Integer, int[]> map = new HashMap<>();
        for (int num : numbers) {
            if (!map.containsKey(num)) {
                final int[] prev = map.get(num - 1);
                final int[] next = map.get(num + 1);
                int[] curr = prev;
                if (prev != null && next != null) {
                    prev[1] = next[1];
                    for (int i = next[0]; i <= next[1]; i++) map.put(i, prev);
                } else if (prev != null) prev[1] = num;
                else if (next != null) {
                    next[0] = num;
                    curr = next;
                } else curr = new int[]{num, num};
                map.put(num, curr);
                max = Math.max(max, curr[1] - curr[0] + 1);
            }
        }
        return max;
    }

    public int longestConsecutive2(int[] numbers) {
        if (numbers.length == 0) return 0;

        final Set<Integer> set = new HashSet<>();
        for (int num : numbers) set.add(num);

        int max = 0;
        for (int num : set) {
            if (set.contains(num - 1)) continue;
            int curr = num;
            int length = 0;
            while (set.contains(curr++)) length++;
            max = Math.max(max, length);
        }

        return max;
    }

    public int longestConsecutive3(int[] numbers) {
        if (numbers.length == 0) return 0;

        final Map<Integer, Integer> map = new HashMap<>();
        for (int num : numbers) {
            if (!map.containsKey(num)) map.put(num, null);
        }

        int max = 0;
        for (int num : map.keySet()) {
            if (map.containsKey(num - 1)) continue;
            int curr = num;
            int length = 0;
            while (map.containsKey(curr++)) length++;
            max = Math.max(max, length);
        }

        return max;
    }

    public int longestConsecutive4(int[] numbers) {
        if (numbers.length == 0) return 0;
        int max = 0;
        final Map<Integer, Integer> map = new HashMap<>();
        for (int num : numbers) {
            if (map.containsKey(num)) continue;

            final int prev = map.getOrDefault(num - 1, 0);
            final int next = map.getOrDefault(num + 1, 0);
            final int sum = prev + next + 1;
            max = Math.max(max, sum);

            map.put(num, sum);
            map.put(num - prev, sum);
            map.put(num + next, sum);
        }
        return max;
    }
}
