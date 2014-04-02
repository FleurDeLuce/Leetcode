/*
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete at most two transactions.

Note:
You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
*/
// Time complexity: O(n), Space complexity: O(n)
// Algorithm: DP
public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int num = prices.length;
        int[] left = new int[num];
        int[] right = new int[num];
        int profit = 0;
        
        // left to right, one transaction max
        // from left to right, since we sell after buy, until this day,
        // only lowest buying price is known so far
        int min = prices[0];
        for (int i = 1; i < num; i++) {
        	// compared to previous i - 1 days, we'll check if bringing in ith day could raise the profit
        	// if raised, then updates the profit until ith day;
        	// otherwise, the profit remains the one until (i - 1)th day
        	left[i] = Math.max(left[i - 1], prices[i] - min);
        	// update the min price for future transaction
        	min = Math.min(min, prices[i]);
        }
        
        // right to left, one transaction max
        // from right to left, since we sell after buy, until this day,
        // only highest selling price is known so far
        int max = prices[num - 1];
        for (int i = num - 2; i >= 0; i--) {
        	// compared to i - 1, check if bringing (i - 2)th day
        	right[i] = Math.max(right[i + 1], max - prices[i]);
        	max = Math.max(max, prices[i]);          
        }
        
        // combine and get the max profit
        for (int i = 0; i < num - 1; i++) {
            profit = Math.max(profit, left[i] + right[i]);
        }
        return profit;
    }
}