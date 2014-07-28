/*
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.

For example, 
Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.


The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped. 
 */

// Solution
// Time complexity: O(n), Space complexity: O(n)
public class Solution {
    public int trap(int[] A) {
        if (A == null || A.length < 2) return 0;
        int sumWater = 0;
        int size = A.length;
        int[] maxLeft = new int[size];
        int[] maxRight = new int[size];

        maxLeft[0] = A[0];
        maxRight[size - 1] = A[size - 1];
        for (int i = 1; i < size; i++) {
            maxLeft[i] = Math.max(maxLeft[i - 1], A[i - 1]);
            maxRight[size - i - 1] = Math.max(maxRight[size - i], A[size - i - 1]); 
        }

        for (int i = 0; i < size; i++) {
            int diffWater = Math.min(maxLeft[i], maxRight[i]) - A[i];
            sumWater += diffWater > 0 ? diffWater : 0; 
        }
        return sumWater;
    }
}