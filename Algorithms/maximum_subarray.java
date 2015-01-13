/*
Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
the contiguous subarray [4,−1,2,1] has the largest sum = 6.
*/
// Solution 1: DP
// time: O(n)
public class Solution {
    public int maxSubArray(int[] A) {
        if (A == null || A.length == 0) return 0;
        int tempSum = A[0];
        int sum = A[0];
        int size = A.length;
        for (int i = 1; i < size; i++) {
            tempSum = Math.max(tempSum + A[i], A[i]);
            sum = Math.max(tempSum, sum);
        }
        return sum;
    }
}

// Solution 2: DP with array
public class Solution {
    public int maxSubArray(int[] A) {
        if (A == null || A.length == 0) return 0;
        int size = A.length;
        int sum[] = new int[size];
        sum[0] = A[0];
        int maxSum = A[0];

        for (int i = 1; i < size; i++) {
            sum[i] = Math.max(sum[i - 1] + A[i], A[i]);
            maxSum = Math.max(sum[i], maxSum);
        }
        return maxSum;
    }
}

// Solution 2: divide and conquer
