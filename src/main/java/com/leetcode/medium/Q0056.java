package com.leetcode.medium;

import java.util.*;

public class Q0056 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        final List<int[]> result = new ArrayList<>();
        int[] newInterval = new int[]{intervals[0][0], intervals[0][1]};

        for (int[] interval : intervals) {
            if (newInterval[0] <= interval[0] && interval[0] <= newInterval[1]) {
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            } else {
                result.add(newInterval);
                newInterval = new int[]{interval[0], interval[1]};
            }
        }
        result.add(newInterval);
        return result.toArray(new int[result.size()][]);
    }

    public int[][] merge1(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        final List<int[]> result = new ArrayList<>(intervals.length);
        int[] newInterval = intervals[0];
        result.add(newInterval);
        for (int[] interval : intervals) {
            if (interval[0] <= newInterval[1]) {
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            } else {
                newInterval = interval;
                result.add(newInterval);
            }
        }
        return result.toArray(new int[result.size()][]);
    }

    public int[][] merge2(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        final LinkedList<int[]> result = new LinkedList<>();
        for (int[] interval : intervals) {
            if (result.isEmpty() || result.getLast()[1] < interval[0]) {
                result.add(interval);
            } else {
                result.getLast()[1] = Math.max(result.getLast()[1], interval[1]);
            }
        }
        return result.toArray(new int[result.size()][]);
    }

    public int[][] merge3(int[][] intervals) {
        final int n = intervals.length;
        final int[] starts = new int[n];
        final int[] ends = new int[n];
        for (int i = 0; i < n; i++) {
            starts[i] = intervals[i][0];
            ends[i] = intervals[i][1];
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        final List<int[]> result = new ArrayList<>();
        int start = 0;
        for (int i = 1; i < n; i++) {
            if (ends[i - 1] < starts[i]) {
                result.add(new int[]{starts[start], ends[i - 1]});
                start = i;
            }
        }
        result.add(new int[]{starts[start], ends[n - 1]});
        return result.toArray(new int[result.size()][]);
    }
}
