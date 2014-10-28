/*
 Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 
 (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 
 Find the minimum element.
 
 You may assume no duplicate exists in the array.
 */

// Solution
// Time complexity: O(log(n)), Space complexity: O(1)
public class Solution {
    public int findMin(int[] num) {
        if (num == null || num.length == 0)
            return 0;
        if (num.length == 1)
            return num[0];
        
        int size = num.length;
        int left = 0;
        int right = size - 1;
        int min = num[0];
        while (left < right) {
            int mid = (left + right) / 2;
            // min is between left and mid, thus shrink the right pointer
            if (num[left] > num[mid]) {
                min = Math.min(min, num[mid]);
                right = mid - 1;
            }
            // min is between mid and right
            else {
                min = Math.min(min, num[left]);
                left = mid + 1;
            }
        }
        // at last, the remaining two elements, num[left] and num[right] not compared to mid before
        min = Math.min(num[left], min);
        min = Math.min(num[right], min);
        return min;
    }
}
