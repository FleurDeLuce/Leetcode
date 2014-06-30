/*
Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.

Note: You may not slant the container.
*/

/*
Solution: two pointer
Time complexity: O(n), Space complexity: O(1)
Ref: http://www.cnblogs.com/remlostime/archive/2012/10/29/2745018.html
*/

public class Solution {
    public int maxArea(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        int num = height.length;
        int left = 0;
        int right = num - 1;
        int volume = 0;
        int maxVolume = 0;

        // starting from the widest range of all vertical bars, then shrink the width of container considering the shorter bar height
        while (left < right) {
            volume = Math.min(height[left], height[right]) * (right - left);
            maxVolume = Math.max(maxVolume, volume);
            // left and right pointers only move when we find a bar taller than both of the two
            // Greedy algorithm here
            // now left bar is the bottleneck, if moves the right one left to shrink, it does nothing but reduce the size
            if (height[left] <= height[right]) {
                left++;
            }
            else {
                right--;
            }
        }
        return maxVolume;
    }
}