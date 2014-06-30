/*
Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

For example:
A = [2,3,1,1,4], return true.

A = [3,2,1,0,4], return false.
*/
// Solution 1: greedy algorithm
// time: O(n), space: O(1)
public class Solution {
    public boolean canJump(int[] A) {
        if (A == null || A.length == 0) return false;
        if (A.length == 1) return true;
        int size = A.length;
        int maxDist = 0;
        
        // i can only reaches maxDist
        for (int i = 0; i <= maxDist && maxDist < size; i++) {
            maxDist = Math.max(maxDist, i + A[i]);
        }
        return maxDist >= size - 1;
    }
}

// Solution 2: DP
