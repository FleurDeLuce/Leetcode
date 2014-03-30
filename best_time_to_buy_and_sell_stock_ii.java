/*
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times). However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
*/
// Time Complexity: O(n)
// Algorithm: greedy
// Solution: accrue profit by each day
public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        boolean rise = true;
        int profit = 0;
        int len = prices.length;
        // when stock starts to fall the next day, then sell it now
        // when stock starts to raise, then buy on today
        // equivalent to restart from the beginning, starting price set as today's after last selling transaction
        for (int i = 1; i < len; i++) {
            if (prices[i] >= prices[i - 1]) profit += prices[i] - prices[i - 1];
        }
        return profit;
    }
}

// Solution: accrue profit by the end of ascending sequence 
public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        boolean rise = true;
        int buyDay = prices[0];
        int profit = 0;
        int len = prices.length;
        for (int i = 1; i < len; i++) {
            if (prices[i] < prices[i - 1]) {
                if (prices[i-1] > buyDay) profit += prices[i - 1] - buyDay;
                buyDay = prices[i];
            }
        }
        if (prices[len-1] > buyDay) profit += prices[len-1]-buyDay;
        return profit;
    }
}