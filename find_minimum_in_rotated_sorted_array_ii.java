/*
 Follow up for "Find Minimum in Rotated Sorted Array":
 What if duplicates are allowed?
 
 Would this affect the run-time complexity? How and why?
 Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 
 (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 
 Find the minimum element.
 
 The array may contain duplicates.
 */

// Solution
// Time complexity: O(n), Space complexity: O(1)
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
        // make sure that when out of loop, we have two elements to compare to the min
        while (left < right - 1) {
            int mid = (left + right) / 2;
            // min is between left and mid, thus shrink the right pointer
            if (num[left] > num[mid]) {
                min = Math.min(min, num[mid]);
                right = mid - 1;
            }
            // min is between mid and right
            else if (num[left] < num[mid]){
                min = Math.min(min, num[left]);
                left = mid + 1;
            }
            else {
                // left == num[mid], unable to tell which part to drop in binary search,
                // thus move the left element until not equals the middle
                // for the worst case, we need to move n times through the whole array
                left++;
            }
        }
        // at last, the remaining two elements, num[left] and num[right] not compared to mid before
        min = Math.min(num[left], min);
        min = Math.min(num[right], min);
        return min;
    }
}
