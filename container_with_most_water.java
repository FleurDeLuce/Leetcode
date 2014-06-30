/*
Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.

Note: You may not slant the container.
*/

/*
Time complexity: O(n)
Space complexity: O(1)
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

        while (left < right) {
            volume = Math.min(height[left], height[right]) * (right - left);
            maxVolume = Math.max(maxVolume, volume);
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