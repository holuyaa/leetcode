package com.leetcode.medium;

public class Q0238 {
    public int[] productExceptSelf(int[] numbers) {
        int totalProduct = 1;
        int numberOfZero = 0;
        int indexOfZero = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 0) {
                numberOfZero++;
                indexOfZero = i;
            }
            else totalProduct *= numbers[i];
        }

        final int[] answer = new int[numbers.length];
        if (numberOfZero == 1) answer[indexOfZero] = totalProduct;
        else if (numberOfZero == 0) {
            for (int i = 0; i < numbers.length; i++) answer[i] = totalProduct / numbers[i];
        }

        return answer;
    }

    public int[] productExceptSelf1(int[] numbers) {
        final int n = numbers.length;
        final int[] answer = new int[n];
        answer[0] = 1;
        for (int i = 1; i < n; i++) {
            answer[i] = answer[i - 1] * numbers[i - 1];
        }
        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            answer[i] *= right;
            right *= numbers[i];
        }
        return answer;
    }
}
