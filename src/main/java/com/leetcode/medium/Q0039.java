package com.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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

        for (int i = last; i < candidates.length; i++) {
            if (target < sum + candidates[i]) break;
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

    public List<List<Integer>> combinationSum1(int[] candidates, int target) {
        final List<List<Integer>> result = new ArrayList<>();
        combinationSum(candidates, target, 0, 0, new ArrayList<>(), result);
        return result;
    }

    private void combinationSum(int[] candidates, int target,
                                int sum, int last,
                                List<Integer> tmp, List<List<Integer>> result) {
        if (sum == target) {
            result.add(new ArrayList<>(tmp));
            return;
        }

        for (int i = last; i < candidates.length; i++) {
            if (target < sum + candidates[i]) continue;
            tmp.add(candidates[i]);
            combinationSum(candidates, target, sum + candidates[i], i, tmp, result);
            tmp.remove(tmp.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        final List<List<List<Integer>>> dp = new ArrayList<>();

        for (int i = 1; i <= target; i++) {
            final List<List<Integer>> newList = new ArrayList<>();
            for (int j = 0; j < candidates.length && candidates[j] <= i; j++) {
                if (i == candidates[j]) newList.add(List.of(candidates[j]));
                else {
                    for (List<Integer> l : dp.get(i - candidates[j] - 1)) {
                        if (candidates[j] <= l.get(0)) {
                            final List<Integer> cl = new ArrayList<>();
                            cl.add(candidates[j]);
                            cl.addAll(l);
                            newList.add(cl);
                        }
                    }
                }
            }
            dp.add(newList);
        }
        return dp.get(target - 1);
    }

    public List<List<Integer>> combinationSum3(int[] candidates, int target) {
        final List<List<List<Integer>>> dp = new ArrayList<>(target + 1);
        for (int i = 0; i < target + 1; i++) {
            dp.add(new ArrayList<>());
        }
        dp.get(0).add(Collections.emptyList());

        for (int c : candidates) {
            for (int t = c; t < target + 1; t++) {
                for (List<Integer> l : dp.get(t - c)) {
                    final List<Integer> cl = new ArrayList<>(l);
                    cl.add(c);
                    dp.get(t).add(cl);
                }
            }
        }

        return dp.get(target);
    }
}
