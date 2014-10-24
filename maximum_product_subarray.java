/*
Find the contiguous subarray within an array (containing at least one number) which has the largest product.

For example, given the array [2,3,-2,4],
the contiguous subarray [2,3] has the largest product = 6.
 */

// Solution
// Time complexity: O(n), Space complexity: O(1)
public class Solution {
    public int maxProduct(int[] A) {
        if (A == null || A.length == 0) 
            return 0;
        if (A.length == 1)
            return A[0];
        
        int maxLocal = 0;
        int minLocal = 0;
        int max = 0;
        int len = A.length;
        for (int i = 0; i < len; i++) {
            int temp = maxLocal;
            maxLocal = Math.max(Math.max(temp * A[i], A[i]), minLocal * A[i]);
            minLocal = Math.min(Math.min(temp * A[i], A[i]), minLocal * A[i]);
            max = Math.max(maxLocal, max);
        }
        return max;
    }
}