/*
Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

For example:
Given array A = [2,3,1,1,4]

The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)
*/
// Solution 1: greedy algorithm
// time: O(n), space: O(1)
public class Solution {
    public int jump(int[] A) {
        if (A == null || A.length == 0) return 0;
        if (A.length == 1) return 0;
        
        int size = A.length;
        int step = 0;
        int left = 0;
        int right = 0;
        int maxDist = 0;
        
        while (right < size - 1) {
            step++;
            for (int i = left; i <= right; i++) {
                int next = A[i] + i;
                if (next >= size) return step;
                if (next > maxDist) maxDist = next;
            }
            left = right;
            right = maxDist;
        }
        return step;
    }
}
