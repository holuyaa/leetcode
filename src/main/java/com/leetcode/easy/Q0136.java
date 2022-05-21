package com.leetcode.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Q0136 {
    public int singleNumber(int[] nums) {
        if (nums.length == 1) return nums[0];

        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i += 2) {
            if (nums[i] == nums[i + 1]) continue;
            if (nums[i + 1] == nums[i + 2]) return nums[i];
            else return nums[i + 1];
        }
        return nums[nums.length - 1];
    }

    public int singleNumber1(int[] nums) {
        if (nums.length == 1) return nums[0];

        final Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) set.remove(num);
            else set.add(num);
        }
        for (int num : set) return num;
        return 0;
    }

    public int singleNumber2(int[] nums) {
        if (nums.length == 1) return nums[0];

        int result = 0;
        for (int num : nums) result ^= num;
        return result;
    }
}
