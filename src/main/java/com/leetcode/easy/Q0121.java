package com.leetcode.easy;

public class Q0121 {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int price : prices) {
            minPrice = Math.min(minPrice, price);
            maxProfit = Math.max(maxProfit, price - minPrice);
        }
        return maxProfit;
    }

    public int maxProfit1(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
                continue;
            }
            maxProfit = Math.max(maxProfit, price - minPrice);
        }
        return maxProfit;
    }

    public int maxProfit2(int[] prices) {
        int minPrice = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            final int price = prices[i];
            if (price < minPrice) {
                minPrice = price;
                continue;
            }
            maxProfit = Math.max(maxProfit, price - minPrice);
        }
        return maxProfit;
    }
}
