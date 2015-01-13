/*
 Given an integer n, return the number of trailing zeroes in n!.
 
 Note: Your solution should be in logarithmic time complexity.
 */

// Solution
// Time complexity: O(), Space complexity: O()
public class Solution {
    public int trailingZeroes(int n) {
        // count the number of 5, including 5^1, 5^2, 5^3, ..., 5^n (5^n <= n)
        int zeroCount = 0;
        int factor = 5;
        /*
        while(factor <= n) {
            zeroCount += n / factor;
            factor *= 5;
        }
         */
        
        while (n != 0) {
            zeroCount += n / factor;
            n /= 5;
        }
        return zeroCount;
    }
}



