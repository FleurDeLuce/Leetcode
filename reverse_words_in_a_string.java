/*
There are N children standing in a line. Each child is assigned a rating value.

You are giving candies to these children subjected to the following requirements:

Each child must have at least one candy.
Children with a higher rating get more candies than their neighbors.
What is the minimum candies you must give?
*/

public class Solution {
    public int candy(int[] ratings) {
        int numChildren = ratings.length;
        int[] candies = new int[numChildren];
        int sumCandies = 0;
        
        for (int i = 0; i < numChildren; i++) candies[i] = 1;
        // smaller element changes first, then the larger changes accordingly
        // the changing order is the same as the iteration order, left to right in the first scan
        // thus in the first scan, left element is always smaller
        for (int i = 0; i < numChildren - 1; i++) {
            if (ratings[i + 1] > ratings[i]) candies[i + 1] = candies[i] + 1;
        }
        // likewise, in the second scan, right element is always smaller
        for (int i = numChildren - 1; i > 0; i--) {
            if (ratings[i - 1] > ratings[i] && candies[i - 1] <= candies[i]) candies[i - 1] = candies[i] + 1;
            sumCandies += candies[i];
        }
        return sumCandies + candies[0];
    }
}
