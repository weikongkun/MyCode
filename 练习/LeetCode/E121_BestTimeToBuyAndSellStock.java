package com.leetCode;

public class E121_BestTimeToBuyAndSellStock {
	public static void main(String[] args) {
		int[] prices = {7, 1, 5, 3, 6, 4};
		System.out.println(maxProfit(prices));
	}
	public static int maxProfit(int[] prices) {
		if (prices.length == 0) return 0;
        int min = prices[0];
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
        	if (prices[i] <= min) min = prices[i];
        	else {
        		profit = Math.max(prices[i] - min, profit);
        	}
        }
        return profit;
    }
}
