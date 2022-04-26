package com.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q0039 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        final List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        combinationSum(candidates, target, 0, 0, 0, new int[target / candidates[0]], result);
        return result;
    }

    private void combinationSum(int[] candidates, int target,
                                int sum, int pos, int last,
                                int[] tmp, List<List<Integer>> result) {
        if (sum == target) {
            result.add(convertArrayToList(tmp));
            return;
        }

        if (target < sum) return;
        if (tmp.length == pos) return;

        for (int i = last; i < candidates.length; i++) {
            tmp[pos] = candidates[i];
            combinationSum(candidates, target, sum + candidates[i], pos + 1, i, tmp, result);
            tmp[pos] = 0;
        }
    }

    private List<Integer> convertArrayToList(int[] array) {
        final List<Integer> list = new ArrayList<>();
        for (int item : array) {
            if (item == 0) break;
            list.add(item);
        }
        return list;
    }
}
